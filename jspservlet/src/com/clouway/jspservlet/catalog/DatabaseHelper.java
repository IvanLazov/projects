package com.clouway.jspservlet.catalog;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseHelper class is used to executes queries against the database
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class DatabaseHelper {
  
  private final MysqlDataSource dataSource = new MysqlDataSource();

  public DatabaseHelper(String database) {

    dataSource.setServerName("localhost");
    dataSource.setDatabaseName(database);
    dataSource.setUser("clouway");
    dataSource.setPassword("clouway.com");
  }
  
  public void executeQuery(String query, Object... params) {

    Connection connection = null;

    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
  
  public String executeQueryResult(String query, Object... params) {
    
    Connection connection = null;
    String result = "";
    
    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        result = resultSet.getString(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }
  
  public <T> List<T> executeQuery(String query, RowMapper<T> rowMapper, Object... params) {

    List<T> result = new ArrayList<T>();
    Connection connection = null;
    
    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);

      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        result.add(rowMapper.map(resultSet));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }

    return result;
  }
  
  private void fillParameters(PreparedStatement preparedStatement, Object... params) {
    
    for(int i = 0; i < params.length; i++) {
      try {
        preparedStatement.setObject(i + 1, params[i]);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
