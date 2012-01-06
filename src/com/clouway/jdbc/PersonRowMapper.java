package com.clouway.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PersonRowMapper implements RowMapper<Person> {

    public Person map(ResultSet resultSet) throws SQLException {
        
        return new Person(resultSet.getString("name"), resultSet.getString("id"), resultSet.getInt("age"), resultSet.getString("email"));
    }
}
