package com.clouway.jdbc;

import java.sql.*;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TripBaseImpl implements TripBase {

    private final DatabaseHelper databaseHelper;

    public TripBaseImpl(DatabaseHelper databaseHelper) {

        this.databaseHelper = databaseHelper;
    }

    public void save(Trip trip) throws SQLException {

        databaseHelper.executeQuery("INSERT INTO trip VALUES(?,?,?,?)", trip.getEgn(), trip.getArrivalDate(), trip.getDepartureDate(), trip.getCity());
    }

    public void update(String egn, String arrivalDate, String departureDate, String city) throws SQLException {

        databaseHelper.executeQuery("UPDATE trip SET arrivalDate=?, departureDate=?, city=? WHERE egn=?", arrivalDate, departureDate, city, egn);
    }
    
    public List<Trip> getAllTrips() throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper());
    }

    public List<City> getAllCitiesOrderedByNumberOfVisits() throws SQLException {

        return databaseHelper.executeQuery("SELECT city, COUNT(*) AS numberOfVisitors FROM trip GROUP BY city DESC", new CityRowMapper());
    }
}
