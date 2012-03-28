package com.clouway.jspservlet.onlinebanking;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class DatabaseHelper {

  private MysqlDataSource dataSource;

  public DatabaseHelper() {

    dataSource = new MysqlDataSource();
    dataSource.setServerName("localhost");
    dataSource.setDatabaseName("bankdb");
    dataSource.setUser("clouway");
    dataSource.setPassword("clouway.com");
  }

  public void executeQuery(String query, Object... params) {

    Connection connection = null;

    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      preparedStatement.execute();
    } catch (SQLException e) {

      if (e.getErrorCode() == 1062) {
        throw new DuplicateEntryException();
      }

    } finally {

      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  
  public String executeQueryResult(String query, String... params) {

    Connection connection = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    String result = "";

    try {
      connection = dataSource.getConnection();
      preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        result = resultSet.getString(1);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    
    return result;
  }
  
  public <T> T executeQuery(String query, Provider<T> provider, Object... params) {

    Connection connection = null;
    T returnedObject = null;
    
    try {

      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()) {
        System.out.println("while...");
        returnedObject = provider.get(resultSet);
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

    return returnedObject;
  }
  
  
  private void fillParameters(PreparedStatement preparedStatement, Object[] params) throws SQLException {
    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i + 1, params[i]);
    }
  }
}
