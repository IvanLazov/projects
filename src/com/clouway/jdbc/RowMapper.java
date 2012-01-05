package com.clouway.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface RowMapper<T> {

    T map(ResultSet resultSet) throws SQLException;
}
