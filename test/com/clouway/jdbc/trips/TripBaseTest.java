package com.clouway.jdbc.trips;

import java.sql.*;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TripBaseTest {

    private static DatabaseHelper databaseHelper = new DatabaseHelper();
    private TripBase tripBase = new TripBaseImpl(databaseHelper);
    private PeopleBase peopleBase = new PeopleBaseImpl(databaseHelper);

    private Person ivan = new Person("Ivan", "8912271449", 22, "darkpain@abv.bg");
    private Person martin = new Person("Martin", "8510105050", 28, "adam@mail.bg");

    private Trip first  = new Trip("8912271449", "2012-01-10", "2012-01-20", "Paris");
    private Trip second = new Trip("8510105050", "2012-02-10", "2012-02-15", "Paris");
    private Trip third = new Trip("8510105050", "2012-04-08", "2012-04-15", "New York");

    @BeforeClass
    public static void connect() throws SQLException {

        databaseHelper.connectToDataSource();
    }

    @Before
    public void saveData() throws SQLException {
      
      savePersons(ivan, martin);
      saveTrips(first, second, third);
    }
    @Test
    public void saveTripInDatabase() throws SQLException {

        assertEquals(first, databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper()).get(0));
        assertEquals(second, databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper()).get(1));
        assertEquals(third, databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper()).get(2));
    }
    
    @Test
    public void changeTripArrivalDate() throws SQLException {

        tripBase.update(ivan.getId(), "2012-11-11", "2012-11-20", "Paris");

        assertEquals("2012-11-11", tripBase.getAllTrips().get(0).getArrivalDate());
        assertEquals("2012-11-20", tripBase.getAllTrips().get(0).getDepartureDate());
        assertEquals(second, tripBase.getAllTrips().get(1));
        assertEquals(third, tripBase.getAllTrips().get(2));
    }
    
    @Test
    public void getAllTrips() throws SQLException {

        assertEquals(first, databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper()).get(0));
        assertEquals(second, databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper()).get(1));
        assertEquals(third, databaseHelper.executeQuery("SELECT * FROM trip", new TripRowMapper()).get(2));
    }

    @Test
    public void showCitiesOrderedByNumberOfVisitors() throws SQLException {

        assertEquals(new City("Paris", 2), tripBase.getAllCitiesOrderedByNumberOfVisits().get(0));
        assertEquals(new City("New York", 1), tripBase.getAllCitiesOrderedByNumberOfVisits().get(1));
    }
    
    @After
    public void deleteData() throws SQLException {

        databaseHelper.executeQuery("DELETE FROM trip");
        databaseHelper.executeQuery("DELETE FROM person");
    }

    @AfterClass
    public static void disconnect() throws SQLException {

        databaseHelper.disconnectFromDataSource();
    }
    
    private void saveTrips(Trip... trips) throws SQLException {
        
        for (Trip aTrip : trips) {
            tripBase.save(aTrip);
        }
    }
    
    private void savePersons(Person... persons) throws SQLException {
        
        for (Person aPerson : persons) {
            
            peopleBase.save(aPerson);
        }
    }
}
