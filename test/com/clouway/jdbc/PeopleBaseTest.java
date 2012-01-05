package com.clouway.jdbc;

import org.junit.*;

import java.sql.*;
import java.util.List;

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
    public static void createTables() throws SQLException {

        databaseHelper.connectToDatabase();
        databaseHelper.createTablePerson();
        databaseHelper.createTableTrip();
    }

    @Before
    public void insertData() throws SQLException {

        peopleBase.save(person);
        peopleBase.save(person2);
    }

    @Test
    public void getAllRegisteredPeople() throws SQLException {

        assertEquals(databaseHelper.executeQuery("SELECT * FROM person", personRowMapper), peopleBase.getAllPeople());
    }

    @Test
    public void updatePersonEmail() throws SQLException {

        peopleBase.update("8912271449","darkpain@mail.bg");
        assertEquals("darkpain@mail.bg",peopleBase.getPerson("8912271449").getEmail());
    }

    @Test
    public void showPeopleWhichNameStartsWithLettersIve() throws SQLException {

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
        Trip trip1 = new Trip("8912271449", Date.valueOf("2012-01-10"), Date.valueOf("2012-01-20"), "Paris");
        Trip trip2 = new Trip("8912271450", Date.valueOf("2012-01-15"), Date.valueOf("2012-01-30"), "Paris");
        tripBase.save(trip1);
        tripBase.save(trip2);

        List<Person> people = peopleBase.getAllPeopleInTheSameCityAtTheSameDate(Date.valueOf("2012-01-15"), "Paris");
        assertEquals(person, people.get(0));
        assertEquals(person2, people.get(1));
    }

    @After
    public void deleteData() throws SQLException {

        databaseHelper.executeQuery("DELETE FROM trip");
        databaseHelper.executeQuery("DELETE FROM person");
    }

    @AfterClass
    public static void dropTables() throws SQLException {

        databaseHelper.dropTable("trip");
        databaseHelper.dropTable("person");
        databaseHelper.disconnectFromDatabase();
    }
}
