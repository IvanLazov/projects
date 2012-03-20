package com.clouway.jspservlet.onlinebanking.persistance;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
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

  public void executeQuery(String query, Object... params) throws SQLException {

    Connection connection = dataSource.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(query);

    fillParameters(preparedStatement, params);
    // what if fails ??
    preparedStatement.execute();

    // try / catch / finally !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    connection.close();
  }
  
  public String executeQueryResult(String query, String... params) throws SQLException {

    Connection connection = dataSource.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(query);

    fillParameters(preparedStatement, params);

    String result = "";
    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
      result = resultSet.getString(1);
    }

    return result;
  }
  
  private void fillParameters(PreparedStatement preparedStatement, Object[] params) throws SQLException {

    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i + 1, params[i]);
    }
  }
}
