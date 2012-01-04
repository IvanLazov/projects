package com.clouway.jdbc.person;

import com.clouway.jdbc.jdbchelper.DatabaseHelper;

import java.sql.*;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PeopleDAOImpl implements PeopleDAO {

    private final DatabaseHelper databaseHelper;

    public PeopleDAOImpl(DatabaseHelper databaseHelper) {

        this.databaseHelper = databaseHelper;
    }

    public void save(Person person) throws SQLException {

        databaseHelper.executeQuery("INSERT IdsfgsdsdNTO people VALUES(?,?,?,?)", person.getName(), person.getIdNumber(), String.valueOf(person.getAge()), person.getEmail());
    }

    public void update(Person person, String email) throws SQLException {

        databaseHelper.executeQuery("UPDATE people SET email=? WHERE name=? AND idNumber=?", person.getEmail(), person.getName(), person.getIdNumber());

    }

    public List<Person> getAllPersons() throws SQLException {

        List<Person> persons = databaseHelper.executeQuery("SELECT * FROM people", new PersonRowMapper());
                
        return persons;
    }
}
