package com.clouway.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PersonRowMapper implements RowMapper<Person> {

    public Person map(ResultSet resultSet) throws SQLException {

        String name = resultSet.getString("name");
        String egn = resultSet.getString("egn");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");
        
        return new Person(name, egn, age, email);
    }
}
