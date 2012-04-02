package com.clouway.jspservlet.onlinebanking;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DatabaseHelper class is used to connect to the database and execute queries against it
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class DatabaseHelper {

  private final MysqlDataSource dataSource = new MysqlDataSource();

  /**
   * Constructor sets the properties we need to connect and execute queries against the database
   */
  public DatabaseHelper() {
    dataSource.setServerName("localhost");
    dataSource.setDatabaseName("bankdb");
    dataSource.setUser("clouway");
    dataSource.setPassword("clouway.com");
  }

  /**
   * Execute query against the database
   *
   * @param query - the query we will execute
   * @param params - parameters we apply to the query
   */
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

  /**
   * Return a String result from executing query
   *
   * @param query - the query we will execute
   * @param params - parameters we apply to the query
   * @return - String as a result from executing the query
   */
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

  /**
   * Returns an object of type T after executing the query
   *
   * @param query - the query we will execute
   * @param provider - Provider object which creates an object of type T
   * @param params - parameters we apply to the query
   * @param <T> - the type of Object we will return
   * @return - return an object of type T
   */
  public <T> T executeQuery(String query, Provider<T> provider, Object... params) {

    Connection connection = null;
    T returnedObject = null;
    
    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      ResultSet resultSet = preparedStatement.executeQuery();

      while(resultSet.next()) {
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

  /**
   * Fill parameters in the preparedStatement used in the query
   *
   * @param preparedStatement - preparedStatement in which we set parameters
   * @param params - parameters we apply to the preparedStatement
   * @throws SQLException - if an error occurs
   */
  private void fillParameters(PreparedStatement preparedStatement, Object[] params) throws SQLException {

    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i + 1, params[i]);
    }
  }
}
