package com.clouway.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TripBaseImpl implements TripBase {

    private final DatabaseHelper databaseHelper;

    public TripBaseImpl(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void save(Trip trip) {

        try {
            PreparedStatement preparedStatement = databaseHelper.getConnection().prepareStatement("INSERT INTO trip VALUES(?,?,?,?)");
            preparedStatement.setString(1, trip.getEgn());
            preparedStatement.setDate(2, trip.getArrivalDate());
            preparedStatement.setDate(3, trip.getDepartureDate());
            preparedStatement.setString(4, trip.getCity());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String egn, Date arrivalDate, Date departureDate, String city) {
        
        try {
            PreparedStatement preparedStatement = databaseHelper.getConnection().prepareStatement("UPDATE trip SET arrivalDate=?, departureDate=?, city=? WHERE egn=?");
            preparedStatement.setDate(1, arrivalDate);
            preparedStatement.setDate(2, departureDate);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, egn);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Trip> getAllTrips() {

        List<Trip> trips = new ArrayList<Trip>();
        
        try {

            PreparedStatement preparedStatement = databaseHelper.getConnection().prepareStatement("SELECT * FROM trip");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                
                String egn = resultSet.getString("egn");
                Date arrivalDate = resultSet.getDate("arrivalDate");
                Date departureDate = resultSet.getDate("departureDate");
                String city = resultSet.getString("city");
                trips.add(new Trip(egn, arrivalDate, departureDate, city));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trips;
    }

    public List<City> getAllCitiesOrderedByNumberOfVisits() {

        List<City> cities = new ArrayList<City>();
        
        try {
            PreparedStatement preparedStatement = databaseHelper.getConnection().prepareStatement("SELECT city, COUNT(*) AS numberOfVisitors FROM trip GROUP BY city DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                
                String name = resultSet.getString("city");
                int numberOfVisitors = resultSet.getInt("numberOfVisitors");
                cities.add(new City(name, numberOfVisitors));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return cities;
    }
}
