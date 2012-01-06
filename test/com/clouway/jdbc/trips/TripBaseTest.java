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

    private Person person = new Person("Ivan", "8912271449", 22, "darkpain@abv.bg");
    private Person person2 = new Person("Adam", "8510105050", 28, "adam@mail.bg");

    private Trip trip  = new Trip("8912271449", "2012-01-10", "2012-01-20", "Paris");
    private Trip trip2 = new Trip("8510105050", "2012-02-10", "2012-02-15", "Paris");
    private Trip trip3 = new Trip("8510105050", "2012-04-08", "2012-04-15", "New York");

    @BeforeClass
    public static void connect() throws SQLException {

        databaseHelper.connectToDataSource();
    }
    
    @Before
    public void setUp() throws SQLException {
                
        peopleBase.save(person);
        peopleBase.save(person2);
        tripBase.save(trip);
        tripBase.save(trip2);
        tripBase.save(trip3);
    }

    @Test
    public void changeTripArrivalDate() throws SQLException {

        tripBase.update("8912271449", "2012-01-01", "2012-01-20", "Paris");
        assertEquals("2012-01-01", tripBase.getAllTrips().get(0).getArrivalDate());
    }
    
    @Test
    public void getAllTrips() throws SQLException {

        assertEquals(trip, tripBase.getAllTrips().get(0));
        assertEquals(trip2, tripBase.getAllTrips().get(1));
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
}
