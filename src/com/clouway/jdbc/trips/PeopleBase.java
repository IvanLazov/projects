package com.clouway.jdbc.trips;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface PeopleBase {

    void save(Person person) throws SQLException; // save person in data source

    void update(String id, String email) throws SQLException; // update person email address, must provide valid person id

    void deletePerson(String id) throws SQLException; // delete person from data source

    Person getPerson(String id) throws SQLException; // return person with given id
    
    List<Person> getAllPeople() throws SQLException; // return a List of all Persons saved in the data source

    List<Person> getAllPeopleWhichNameStartsWith(String letters) throws SQLException; // return a List of all Persons which name starts with given letter

    List<Person> getAllPeopleInTheSameCityAtTheSameDate(String date, String city) throws SQLException; // return a List of all Persons which are at the same city at the same time
}
