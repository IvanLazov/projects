package com.clouway.jdbc.person;

import com.clouway.jdbc.jdbchelper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PersonRowMapper implements RowMapper<Person> {
    public Person map(ResultSet resultSet) throws SQLException {

        String name = resultSet.getString("name");
        String idNumber = resultSet.getString("idNumber");
        int age = resultSet.getInt("age");
        String email = resultSet.getString("email");

        return new Person(name, idNumber, age, email);
    }
}
