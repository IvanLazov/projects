package com.clouway.jdbc;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface PeopleBase {

    void save(Person person) throws SQLException;

    void update(String user, String email) throws SQLException;

    void deletePerson(String egn) throws SQLException;

    Person getPerson(String egn) throws SQLException;
    
    List<Person> getAllPeople() throws SQLException;

    List<Person> getAllPeopleWhichNameStartsWith(String letters) throws SQLException;

    List<Person> getAllPeopleInTheSameCityAtTheSameDate(Date date, String city) throws SQLException;
}
