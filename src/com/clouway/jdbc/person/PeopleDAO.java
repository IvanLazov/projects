package com.clouway.jdbc.person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface PeopleDAO {

    void save(Person person) throws SQLException;
    void update(Person person, String email) throws SQLException;
    List<Person> getAllPersons() throws SQLException;
}
