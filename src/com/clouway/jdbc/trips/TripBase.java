package com.clouway.jdbc.trips;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface TripBase {

    void save(Trip trip) throws SQLException; // save trip in data source

    void update(String id, String arrivalDate, String departureDate, String city) throws SQLException; // update trip information

    List<Trip> getAllTrips() throws SQLException; // get all trips from the data source

    List<City> getAllCitiesOrderedByNumberOfVisits() throws SQLException; // return a list of Cities ordered by number of visits
}
