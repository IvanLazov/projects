package com.clouway.jdbc.trips;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseHelper class is used to connect/disconnect to given data source
 * and execute queries to it
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DatabaseHelper {

    private MysqlDataSource dataSource;
    private Connection connection;

    /**
     * Constructors defines the data source to which we will connect
     */
    public DatabaseHelper() {

        dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("oracle");
        dataSource.setUser("clouway");
        dataSource.setPassword("clouway.com");
    }

    /**
     * Connect to the data source
     *
     * @throws SQLException if an error occurs
     */
    public void connectToDataSource() throws SQLException {

        connection = dataSource.getConnection();
    }

    /**
     * Disconnect from the data source
     *
     * @throws SQLException if an error occurs
     */
    public void disconnectFromDataSource() throws SQLException {

        if (connection != null) {
            connection.close();
        }
    }

    /**
     * Execute query with given parameters
     *
     * @param query the query to be executed
     * @param params parameters which will be used in the query
     * @throws SQLException if an error occurs
     */
    public void executeQuery(String query, Object... params) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        fillParameters(preparedStatement, params);
        preparedStatement.executeUpdate();
    }

    /**
     * Execute query which returns a List of objects of type T
     *
     * @param query the query to be executed
     * @param rowMapper the RowMapper object which will created object of type T
     * @param params parameters which will be used in the query
     * @param <T> the type of the returned objects
     * @return a List of type T
     * @throws SQLException if an error occurs
     */
    public <T> List<T> executeQuery(String query, RowMapper<T> rowMapper, Object... params) throws SQLException {

        List<T> results = new ArrayList<T>();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        fillParameters(preparedStatement, params);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            results.add(rowMapper.map(resultSet));
        }
        return results;
    }

    /**
     * Set parameters for the preparedStatement
     *
     * @param preparedStatement used to set the parameters for the query
     * @param params parameters which will be used in the query
     * @throws SQLException if an error occurs
     */
    private void fillParameters(PreparedStatement preparedStatement, Object[] params) throws SQLException {

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
    }
}
