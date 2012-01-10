package com.clouway.jdbc.trips;

import org.junit.*;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PeopleBaseTest {

    private static DatabaseHelper databaseHelper = new DatabaseHelper();
    
    private PeopleBase peopleBase = new PeopleBaseImpl(databaseHelper);
    private TripBase tripBase = new TripBaseImpl(databaseHelper);
    private PersonRowMapper personRowMapper = new PersonRowMapper();

    private Person ivan = new Person("Ivan", "8912271449", 22, "ivan@abv.bg");
    private Person ivelin = new Person("Ivelin", "8912271450", 29, "ivelin@mail.bg");
    private Person krasimir = new Person("Krasimir", "8912145555", 22, "krasimir@mail.bg");

    private Trip first = new Trip(ivan.getId(), "2012-01-10", "2012-01-20", "Paris");
    private Trip second = new Trip(ivelin.getId(), "2012-01-17", "2012-01-20", "Paris");
    private Trip third = new Trip(krasimir.getId(), "2012-02-20", "2012-02-28", "Madrid");

    @BeforeClass
    public static void connect() throws SQLException {

        databaseHelper.connectToDataSource();
    }
    
    @Test
    public void savePersonInDatabase() throws SQLException {

        savePersons(ivan, ivelin, krasimir);

        assertEquals(3, databaseHelper.executeQuery("SELECT * FROM person", personRowMapper).size());
    }

    @Test
    public void updatePersonEmail() throws SQLException {

        savePersons(ivan, ivelin);

        peopleBase.update(ivan.getId(), "ivan@gmail.com");

        assertEquals("ivan@gmail.com", databaseHelper.executeQuery("SELECT * FROM person", personRowMapper).get(0).getEmail());
        assertEquals(ivelin.getEmail(), databaseHelper.executeQuery("SELECT * FROM person", personRowMapper).get(1).getEmail());
    }

    @Test
    public void showPeopleWhichNameStartsWithLetterI() throws SQLException {

        savePersons(ivan, ivelin, krasimir);

        assertEquals(ivan, peopleBase.getAllPeopleWhichNameStartsWith("I").get(0));
        assertEquals(ivelin, peopleBase.getAllPeopleWhichNameStartsWith("I").get(1));
    }

    @Test
    public void showPeopleWhichNameStartsWithLettersIve() throws SQLException {
        
        savePersons(ivan, ivelin, krasimir);

        assertEquals(ivelin, peopleBase.getAllPeopleWhichNameStartsWith("Ive").get(0));
    }
    
    @Test
    public void showPeopleWhichNameStartsWithLetterK() throws SQLException {
        
        savePersons(ivan, ivelin, krasimir);

        assertEquals(krasimir, peopleBase.getAllPeopleWhichNameStartsWith("K").get(0));
    }
    
    @Test
    public void showPeopleWhichNameStartsWithEmptyString() throws SQLException {
        
        savePersons(ivan, ivelin, krasimir);

        assertEquals("This will return all saved persons in the database", 3, peopleBase.getAllPeopleWhichNameStartsWith("").size());
    }
    
    @Test
    public void showPeopleWhichNameStartsWithNull() throws SQLException {

        savePersons(ivan, ivelin, krasimir);

        assertEquals("Returns an empty list", new ArrayList<Person>(), peopleBase.getAllPeopleWhichNameStartsWith(null));
    }

    @Test
    public void deletePersonFromDatabase() throws SQLException {

        savePersons(ivan, ivelin, krasimir);

        peopleBase.deletePerson(ivan.getId());

        assertEquals(ivelin, databaseHelper.executeQuery("SELECT * FROM person", personRowMapper).get(1));
        assertEquals(krasimir, databaseHelper.executeQuery("SELECT * FROM person", personRowMapper).get(0));
    }
    
    @Test
    public void showAllPeopleInTheSameCityAtTheSameTime() throws SQLException {
        
        savePersons(ivan, ivelin, krasimir);
        saveTrips(first, second, third);

        assertEquals(ivan, peopleBase.getAllPeopleInTheSameCityAtTheSameDate("2012-01-18", "Paris").get(0));
        assertEquals(ivelin, peopleBase.getAllPeopleInTheSameCityAtTheSameDate("2012-01-18", "Paris").get(1));
    }

    @Test
    public void showAllPeopleInTheSameCityAtTheSameTime2() throws SQLException {
        
        savePersons(ivan, ivelin, krasimir);
        saveTrips(first, second, third);

        assertEquals("No persons are registered for this date & city", 0, peopleBase.getAllPeopleInTheSameCityAtTheSameDate("2012-09-20", "New York").size());
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

    private void savePersons(Person... person) throws SQLException {

        for (Person aPerson : person) {
            peopleBase.save(aPerson);
        }
    }

    private void saveTrips(Trip... trip) throws SQLException {

        for (Trip aTrip : trip) {
            tripBase.save(aTrip);
        }
    }
}
