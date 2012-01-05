package com.clouway.jdbc;

import java.sql.*;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PeopleBaseImpl implements PeopleBase {

    private final DatabaseHelper databaseHelper;

    public PeopleBaseImpl(DatabaseHelper databaseHelper) {

        this.databaseHelper = databaseHelper;
    }

    public void save(Person person) throws SQLException {

        databaseHelper.executeQuery("INSERT INTO person VALUES(?,?,?,?)", person.getName(), person.getEgn(), person.getAge(), person.getEmail());
    }

    public void update(String egn, String email) throws SQLException {

        databaseHelper.executeQuery("UPDATE person SET email=? WHERE egn=?", email, egn);
    }

    public void deletePerson(String egn) throws SQLException {

        databaseHelper.executeQuery("DELETE FROM person WHERE egn=?", egn);
    }

    public Person getPerson(String egn) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person WHERE egn=?", new PersonRowMapper(), egn).get(0);
    }

    public List<Person> getAllPeople() throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person", new PersonRowMapper());
    }

    public List<Person> getAllPeopleWhichNameStartsWith(String letters) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person WHERE name LIKE ?", new PersonRowMapper(), letters+"%");
    }

    public List<Person> getAllPeopleInTheSameCityAtTheSameDate(Date date, String city) throws SQLException {

        return databaseHelper.executeQuery("SELECT * FROM person LEFT JOIN trip ON person.egn = trip.egn WHERE arrivalDate <= ? AND departureDate >= ? AND city = ?", new PersonRowMapper(), date, date, city);
    }
}
