package com.clouway.jdbc.trips;

import org.junit.*;

import java.sql.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PeopleBaseTest {

    private static DatabaseHelper databaseHelper = new DatabaseHelper();
    private PeopleBase peopleBase = new PeopleBaseImpl(databaseHelper);
    private PersonRowMapper personRowMapper = new PersonRowMapper();

    private Person person = new Person("Ivan", "8912271449", 22, "darkpain@abv.bg");
    private Person person2 = new Person("Ivelin", "8912271450", 29, "ivelin@mail.bg");

    @BeforeClass
    public static void connect() throws SQLException {

        databaseHelper.connectToDataSource();
    }

    @Before
    public void saveData() throws SQLException {

        peopleBase.save(person);
        peopleBase.save(person2);
    }

    @Test
    public void showAllPeople() throws SQLException {

        assertEquals(databaseHelper.executeQuery("SELECT * FROM person", personRowMapper), peopleBase.getAllPeople());
    }

    @Test
    public void updatePersonEmail() throws SQLException {

        peopleBase.update("8912271449","darkpain@mail.bg");
        assertEquals("darkpain@mail.bg", peopleBase.getPerson("8912271449").getEmail());
    }

    @Test
    public void showPeopleWhichNameStartsWithLetters() throws SQLException {

        assertEquals(person2, peopleBase.getAllPeopleWhichNameStartsWith("Ive").get(0));
    }

    @Test
    public void deletePersonFromDatabase() throws SQLException {
        
        peopleBase.deletePerson("8912271450");
        assertEquals(person, peopleBase.getAllPeople().get(0));
    }

    @Test
    public void showAllPeopleInTheSameCityAtTheSameTime() throws SQLException {

        TripBase tripBase = new TripBaseImpl(databaseHelper);
        Trip firstTrip = new Trip("8912271449", "2012-01-10", "2012-01-20", "Paris");
        Trip secondTrip = new Trip("8912271450", "2012-01-15", "2012-01-30", "Paris");
        tripBase.save(firstTrip);
        tripBase.save(secondTrip);

        assertEquals(person, peopleBase.getAllPeopleInTheSameCityAtTheSameDate("2012-01-15", "Paris").get(0));
        assertEquals(person2, peopleBase.getAllPeopleInTheSameCityAtTheSameDate("2012-01-15", "Paris").get(1));
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
