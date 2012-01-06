package com.clouway.jdbc;

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
     * @param databaseHelper
     */
    public PeopleBaseImpl(DatabaseHelper databaseHelper) {

        this.databaseHelper = databaseHelper;
    }

    /**
     * Save person in Database
     *
     * @param person the person which will be saved in the database
     * @throws SQLException if an error occurs
     */
    public void save(Person person) throws SQLException {

        databaseHelper.executeQuery("INSERT INTO person VALUES(?,?,?,?)", person.getName(), person.getEgn(), person.getAge(), person.getEmail());
    }

    /**
     * Update Person's email address which has given egn
     *
     * @param egn the egn of the Person
     * @param email the new email address of the Person
     * @throws SQLException if an error occurs
     */
    public void update(String egn, String email) throws SQLException {

        databaseHelper.executeQuery("UPDATE person SET email=? WHERE egn=?", email, egn);
    }

    /**
     * Delete person from database using Person's egn
     *
     * @param egn the egn of the Person
     * @throws SQLException if an error occurs
     */
    public void deletePerson(String egn) throws SQLException {

        databaseHelper.executeQuery("DELETE FROM person WHERE egn=?", egn);
    }

    /**
     * Return a Person with given egn
     *
     * @param egn egn of the Person
     * @return a Person from the Database
     * @throws SQLException if an error occurs
     */
    public Person getPerson(String egn) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person WHERE egn=?", new PersonRowMapper(), egn).get(0);
    }

    public List<Person> getAllPeople() throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person", new PersonRowMapper());
    }

    public List<Person> getAllPeopleWhichNameStartsWith(String letters) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person WHERE name LIKE ?", new PersonRowMapper(), letters+"%");
    }

    public List<Person> getAllPeopleInTheSameCityAtTheSameDate(String date, String city) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person LEFT JOIN trip ON person.egn = trip.egn WHERE arrivalDate <= ? AND departureDate >= ? AND city = ?", new PersonRowMapper(), date, date, city);
    }
}
