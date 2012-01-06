package com.clouway.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TripRowMapper implements RowMapper<Trip> {

    public Trip map(ResultSet resultSet) throws SQLException {
        
        return new Trip(resultSet.getString("id"), resultSet.getString("arrivalDate"), resultSet.getString("departureDate"), resultSet.getString("city"));
    }
}
