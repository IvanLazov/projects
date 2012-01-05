package com.clouway.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DatabaseHelper {

    private MysqlDataSource dataSource;
    private Connection connection;

    public DatabaseHelper() {

        dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("oracle");
        dataSource.setUser("clouway");
        dataSource.setPassword("clouway.com");
    }

    public Connection getConnection() {

        if (connection != null) {

            return connection;
        }
        return null;
    }

    public void connectToDatabase() throws SQLException {

        connection = dataSource.getConnection();
    }

    public void disconnectFromDatabase() throws SQLException {

        if (connection != null) {
            connection.close();
        }
    }

    public void executeQuery(String query, Object... params) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        fillParameters(preparedStatement, params);
        preparedStatement.executeUpdate();
    }

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

    private void fillParameters(PreparedStatement preparedStatement, Object[] params) throws SQLException {

        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
    }

    public void createTablePerson() {

        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS person" +
                    "(" +
                    "  name VARCHAR(20) NOT NULL," +
                    "  egn CHAR(10) NOT NULL," +
                    "  age INT NOT NULL," +
                    "  email VARCHAR(50) NOT NULL," +
                    "  UNIQUE (egn)" +
                    ") ENGINE = InnoDB;");
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableTrip() {

        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS trip" +
                    "(" +
                    "  egn CHAR(10) NOT NULL," +
                    "  arrivalDate DATE NOT NULL," +
                    "  departureDate DATE NOT NULL," +
                    "  city VARCHAR(50) NOT NULL," +
                    "  FOREIGN KEY (egn) REFERENCES person(egn)" +
                    ") ENGINE = InnoDB;");

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void dropTable(String table) throws SQLException {

        this.executeQuery("DROP TABLE " + table);
    }
}
