package com.clouway.jdbc.trips;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface PeopleBase {

    /**
     * Save a Person in database
     *
     *
     * @param person Person to be saved in database
     * @throws SQLException if an error occurs
     */
    void save(Person person) throws SQLException;

    /**
     * Update person email address
     *
     * @param id id of Person
     * @param email new email address of the person
     * @throws SQLException if an error occurs
     */
    void update(String id, String email) throws SQLException;

    /**
     * Delete person from database
     *
     * @param id id of Person
     * @throws SQLException if an error occurs
     */
    void deletePerson(String id) throws SQLException;

    /**
     * Return a list of all Persons saved in the database
     *
     * @return a list of all Persons in the database
     * @throws SQLException if an error occurs
     */
    List<Person> getAllPeople() throws SQLException;

    /**
     * Return a list of Persons which name starts with the given letter
     *
     * @param letters the letters with which the name must start
     * @return a list of persons which name starts with the given letter
     * @throws SQLException if an error occurs
     */
    List<Person> getAllPeopleWhichNameStartsWith(String letters) throws SQLException;

    /**
     * Return a list of all Persons which are at the same city at the same time
     *
     * @param date searched date
     * @param city searched city
     * @return a list of all Persons which are at the same city at the same time
     * @throws SQLException if an error occurs
     */
    List<Person> getAllPeopleInTheSameCityAtTheSameDate(String date, String city) throws SQLException;
}
