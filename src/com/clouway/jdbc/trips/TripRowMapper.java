package com.clouway.jdbc.trips;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TripRowMapper implements RowMapper<Trip> {

    /**
     * Return a new Trip object created from the given ResultSet
     *
     * @param resultSet the set from which the object will get properties
     * @return a new Trip object
     * @throws SQLException if an error occurs
     */
    public Trip map(ResultSet resultSet) throws SQLException {
        
        return new Trip(resultSet.getString("id"), resultSet.getString("arrivalDate"), resultSet.getString("departureDate"), resultSet.getString("city"));
    }
}
