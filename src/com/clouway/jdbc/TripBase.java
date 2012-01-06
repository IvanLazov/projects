package com.clouway.jdbc;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface TripBase {

    void save(Trip trip) throws SQLException;

    void update(String egn, String arrivalDate, String departureDate, String city) throws SQLException;

    List<Trip> getAllTrips() throws SQLException;

    List<City> getAllCitiesOrderedByNumberOfVisits() throws SQLException;
}
