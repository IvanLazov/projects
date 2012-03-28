package com.clouway.jspservlet.onlinebanking;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ivan Lazov <darkpain1989@gmail.com>
 */
public class AccountProvider implements Provider<Account> {

  public Account get(ResultSet resultSet) throws SQLException {
    return new Account(Integer.parseInt(resultSet.getString("accountId")), Integer.parseInt(resultSet.getString("userId")), Double.parseDouble(resultSet.getString("balance")));
  }
}
