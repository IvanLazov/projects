package com.clouway.jspservlet.onlinebanking;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AccountProvider class is used to create an Account object
 *
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class AccountProvider implements Provider<Account> {

  /**
   * Return an Account object from a ResultSet
   *
   * @param resultSet - the resultSet from which we will take the parameters we need to create an Account object
   * @return - new Account object
   * @throws SQLException
   */
  public Account get(ResultSet resultSet) throws SQLException {

    return new Account(
      Integer.parseInt(resultSet.getString("accountId")),
      Integer.parseInt(resultSet.getString("userId")),
      Double.parseDouble(resultSet.getString("balance"))
    );
  }
}
