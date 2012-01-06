package com.clouway.jdbc.trips;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PersonRowMapper implements RowMapper<Person> {

    /**
     * Return a new Person object created from the given ResultSet
     *
     * @param resultSet the set from which the object will get properties
     * @return a new Person object
     * @throws SQLException if an error occurs
     */
    public Person map(ResultSet resultSet) throws SQLException {
        
        return new Person(resultSet.getString("name"), resultSet.getString("id"), resultSet.getInt("age"), resultSet.getString("email"));
    }
}
