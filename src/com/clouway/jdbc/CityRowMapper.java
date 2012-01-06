package com.clouway.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class CityRowMapper implements RowMapper<City> {

    /**
     * Return a new City object created from the given ResultSet
     *
     * @param resultSet the set from which the object will get properties
     * @return a new City object
     * @throws SQLException if an error occurs
     */
    public City map(ResultSet resultSet) throws SQLException {
        
        return new City(resultSet.getString("city"), resultSet.getInt("numberOfVisitors"));
    }
}
