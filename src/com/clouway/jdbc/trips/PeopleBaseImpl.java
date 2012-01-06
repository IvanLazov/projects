package com.clouway.jdbc.trips;

import java.sql.*;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PeopleBaseImpl implements PeopleBase {

    private final DatabaseHelper databaseHelper;

    /**
     * Constructor sets the databaseHelper which will execute queries
     *
     * @param databaseHelper the databaseHelper which will be used
     */
    public PeopleBaseImpl(DatabaseHelper databaseHelper) {

        this.databaseHelper = databaseHelper;
    }

    /**
     * Save person into the Database
     *
     * @param person the person which will be saved
     * @throws SQLException if an error occurs
     */
    public void save(Person person) throws SQLException {

        databaseHelper.executeQuery("INSERT INTO person VALUES(?,?,?,?)", person.getName(), person.getId(), person.getAge(), person.getEmail());
    }

    /**
     * Update Person's email address which has given id
     *
     * @param id the id of the Person
     * @param email the new email address of the Person
     * @throws SQLException if an error occurs
     */
    public void update(String id, String email) throws SQLException {

        databaseHelper.executeQuery("UPDATE person SET email=? WHERE id=?", email, id);
    }

    /**
     * Delete person from Database using Person's id
     *
     * @param id the id of the Person
     * @throws SQLException if an error occurs
     */
    public void deletePerson(String id) throws SQLException {

        databaseHelper.executeQuery("DELETE FROM person WHERE id=?", id);
    }

    /**
     * Return a Person with given id
     *
     * @param id id of the Person
     * @return a Person from the Database
     * @throws SQLException if an error occurs
     */
    public Person getPerson(String id) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person WHERE id=?", new PersonRowMapper(), id).get(0);
    }

    /**
     * Return a list of Persons from the Database
     *
     * @return a list of Persons from the Database
     * @throws SQLException if an error occurs
     */
    public List<Person> getAllPeople() throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person", new PersonRowMapper());
    }

    /**
     * Return a list of Persons which name starts with given letters
     *
     * @param letters the letters to be matched in each Person's name
     * @return a list of Persons
     * @throws SQLException if an error occurs
     */
    public List<Person> getAllPeopleWhichNameStartsWith(String letters) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person WHERE name LIKE ?", new PersonRowMapper(), letters+"%");
    }

    /**
     * Return a List of all persons that are at the same city and at the same date
     *
     * @param date the searched date
     * @param city the searched city
     * @return a list of Persons
     * @throws SQLException
     */
    public List<Person> getAllPeopleInTheSameCityAtTheSameDate(String date, String city) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person LEFT JOIN trip ON person.id = trip.id WHERE arrivalDate <= ? AND departureDate >= ? AND city = ?", new PersonRowMapper(), date, date, city);
    }
}
