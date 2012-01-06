package com.clouway.jdbc.trips;

import java.sql.*;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TripBaseImpl implements TripBase {

    private final DatabaseHelper databaseHelper;

    /**
     * Constructor set the databaseHelper which will execute queries
     *
     * @param databaseHelper the databaseHelper which will be used
     */
    public TripBaseImpl(DatabaseHelper databaseHelper) {

        this.databaseHelper = databaseHelper;
    }

    /**
     * Save a trip into the Database
     *
     * @param trip the trip which will be saved
     * @throws SQLException if an error occurs
     */
    public void save(Trip trip) throws SQLException {

        databaseHelper.executeQuery("INSERT INTO trip VALUES(?,?,?,?)", trip.getId(), trip.getArrivalDate(), trip.getDepartureDate(), trip.getCity());
    }

    /**
     * Update trip information - arrival date, departure date and city
     *
     * @param id id of the Person
     * @param arrivalDate date of arrival in the city
     * @param departureDate date of departure from the city
     * @param city the city to which you travel
     * @throws SQLException if an error occurs
     */
    public void update(String id, String arrivalDate, String departureDate, String city) throws SQLException {

        databaseHelper.executeQuery("UPDATE trip SET arrivalDate=?, departureDate=?, city=? WHERE id=?", arrivalDate, departureDate, city, id);
    }

    /**
     * Return a list of all trips in the Database
     *
     * @return a list of Trip objects
     * @throws SQLException if an error occurs
     */
    public List<Trip> getAllTrips() throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper());
    }

    /**
     * Return a list of all cities ordered by number of visits
     *
     * @return a list of City objects
     * @throws SQLException if an error occurs
     */
    public List<City> getAllCitiesOrderedByNumberOfVisits() throws SQLException {

        return databaseHelper.executeQuery("SELECT city, COUNT(*) AS numberOfVisitors FROM trip GROUP BY city DESC", new CityRowMapper());
    }
}
