package com.clouway.jdbc.jdbchelper;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DatabaseHelper {

    private MysqlDataSource dataSource;

    public DatabaseHelper() {
        dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("oracle");
        dataSource.setUser("clouway");
        dataSource.setPassword("clouway.com");
    }

    public void executeQuery(String query, String... params) throws SQLException {

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        fillParams(preparedStatement, params);

        preparedStatement.execute();
        connection.close();
    }

    private void fillParams(PreparedStatement preparedStatement, String[] params) throws SQLException {

        for (int i = 0; i < params.length; i++) {
            String param = params[i];
            preparedStatement.setString(i+1,param);
        }
    }

    public<T> List<T> executeQuery(String query, RowMapper<T> rowMapper, String... params) throws SQLException {

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        fillParams(preparedStatement, params);
        
        ResultSet resultSet = preparedStatement.executeQuery(query);

        List<T> results= new ArrayList<T>();

        while (resultSet.next()) {
            results.add(rowMapper.map(resultSet));
        }
        
        connection.close();
        
        return results;
    }
}
