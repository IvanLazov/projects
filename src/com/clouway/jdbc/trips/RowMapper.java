package com.clouway.jdbc.trips;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface RowMapper<T> {

    /**
     * Return an object of type T from the given ResultSet
     *
     * @param resultSet the ResultSet which we use to create the object
     * @return an object of type T from the given ResultSet
     * @throws SQLException if an error occurs
     */
    T map(ResultSet resultSet) throws SQLException;
}
