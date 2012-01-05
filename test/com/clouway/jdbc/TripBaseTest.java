package com.clouway.jdbc;

import java.sql.*;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TripBaseTest {

    private Statement statement;
    private DatabaseHelper databaseHelper = new DatabaseHelper();
    private TripBase tripBase = new TripBaseImpl(databaseHelper);
    private PeopleBase peopleBase = new PeopleBaseImpl(databaseHelper);

    private Person person = new Person("Ivan", "8912271449", 22, "darkpain@abv.bg");
    private Person person2 = new Person("Krasimir", "8912141449", 22, "555@mail.bg");
    private Trip trip = new Trip("8912271449", Date.valueOf("2012-01-10"), Date.valueOf("2012-01-20"), "Paris");
    private Trip trip2 = new Trip("8912141449", Date.valueOf("2012-02-10"), Date.valueOf("2012-02-15"), "Paris");

    @Before
    public void setUp() throws SQLException {

        databaseHelper.connectToDatabase();
        databaseHelper.createTablePerson();
        databaseHelper.createTableTrip();        
        peopleBase.save(person);
        peopleBase.save(person2);
        tripBase.save(trip);
        tripBase.save(trip2);
        statement = databaseHelper.getConnection().createStatement();
    }

    @Test
    public void saveTripInDatabase() throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT city FROM trip WHERE egn='8912271449'");
        resultSet.next();

        assertEquals("Paris", trip.getCity());
    }

    @Test
    public void changeTripInformation() throws SQLException {

        tripBase.update("8912271449", Date.valueOf("2012-01-14"), Date.valueOf("2012-01-31"), "Paris");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM trip WHERE egn='8912271449'");
        resultSet.next();
        
        assertEquals(Date.valueOf("2012-01-14"), resultSet.getDate("arrivalDate"));
        assertEquals(Date.valueOf("2012-01-31"), resultSet.getDate("departureDate"));
    }
    
    @Test
    public void getAllTrips() throws SQLException {
        
        List<Trip> trips = tripBase.getAllTrips();

        assertEquals(trip, trips.get(0));
        assertEquals(trip2, trips.get(1));
    }

    @Test
    public void showCitiesOrderedByNumberOfVisitors() throws SQLException {

        Person person = new Person("Adio","8903124343",23,"adio@gmail.com");
        Trip trip = new Trip("8903124343", Date.valueOf("2012-01-20"), Date.valueOf("2012-01-30"),"New York");
        peopleBase.save(person);
        tripBase.save(trip);

        List<City> cities = tripBase.getAllCitiesOrderedByNumberOfVisits();

        assertEquals(2, cities.get(0).getNumberOfVisitors());
        assertEquals(1, cities.get(1).getNumberOfVisitors());
    }
    
    @After
    public void tearDown() throws SQLException {

        statement.close();
        databaseHelper.dropTable("trip");
        databaseHelper.dropTable("person");
        databaseHelper.disconnectFromDatabase();
    }
}
