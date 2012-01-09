package com.clouway.jdbc.trips;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface TripBase {

    /**
     * Save trip in database
     *
     * @param trip the Trip to be saved
     * @throws SQLException if an error occurs
     */
    void save(Trip trip) throws SQLException;

    /**
     * Update trip information
     *
     * @param id id of Person
     * @param arrivalDate new arrival date
     * @param departureDate new departure date
     * @param city trip destination
     * @throws SQLException if an error occurs
     */
    void update(String id, String arrivalDate, String departureDate, String city) throws SQLException;

    /**
     * Return a list of all trips from the database
     *
     * @return a list of all trips in the database
     * @throws SQLException if an error occurs
     */
    List<Trip> getAllTrips() throws SQLException;

    /**
     * Return a list of Cities ordered by the number of visits
     *
     * @return a list of Cities ordered by the number of visits
     * @throws SQLException if an error occurs
     */
    List<City> getAllCitiesOrderedByNumberOfVisits() throws SQLException;
}
