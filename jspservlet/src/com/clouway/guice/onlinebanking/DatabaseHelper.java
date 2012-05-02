package com.clouway.guice.onlinebanking;

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

  public DatabaseHelper() {
    dataSource.setServerName("localhost");
    dataSource.setDatabaseName("bankdb");
    dataSource.setUser("clouway");
    dataSource.setPassword("clouway.com");
  }

  public void executeTransaction(String query, Object... params) {

    Connection connection = null;

    try {
      connection = getConnection();
      setAutoCommit(connection, false);
      executePreparedStatement(connection, query, params);
      commit(connection);
    } catch (UnexecutedPreparedStatementException e) {
      rollBack(connection);
    } finally {
      try {
        setAutoCommit(connection, true);
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public void executeQuery(String query, Object... params) {

    Connection connection = getConnection();
    executePreparedStatement(connection, query, params);

    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String executeQueryResult(String query, Object... params) {

    Connection connection = getConnection();
    String result = "";

    try {
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
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return result;
  }

  public <T> T executeQuery(String query, Provider<T> provider, Object... params) {

    Connection connection = getConnection();
    T returnedObject = null;

    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        returnedObject = provider.get(resultSet);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return returnedObject;
  }

  private Connection getConnection() {

    try {
      return dataSource.getConnection();
    } catch (SQLException e) {
      throw new ConnectionErrorException(e);
    }
  }

  private void setAutoCommit(Connection connection, boolean commit) {

    try {
      connection.setAutoCommit(commit);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void executePreparedStatement(Connection connection, String query, Object... params) {

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      fillParameters(preparedStatement, params);
      preparedStatement.execute();
    } catch (SQLException e) {
      if (e.getErrorCode() == 1062) {
        throw new DuplicateEntryException();
      } else {
        throw new UnexecutedPreparedStatementException();
      }
    }
  }

  private void commit(Connection connection) {
    try {
      connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void rollBack(Connection connection) {
    try {
      connection.rollback();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void fillParameters(PreparedStatement preparedStatement, Object[] params) throws SQLException {
    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i + 1, params[i]);
    }
  }
}
