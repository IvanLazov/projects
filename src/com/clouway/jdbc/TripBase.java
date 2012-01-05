package com.clouway.jdbc;

import java.sql.Date;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface TripBase {

    void save(Trip trip);

    void update(String egn, Date arrivalDate, Date departureDate, String city);

    List<Trip> getAllTrips();

    List<City> getAllCitiesOrderedByNumberOfVisits();
}
