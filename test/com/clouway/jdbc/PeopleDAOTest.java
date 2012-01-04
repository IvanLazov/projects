package com.clouway.jdbc;

import com.clouway.jdbc.jdbchelper.DatabaseHelper;
import com.clouway.jdbc.jdbchelper.RowMapper;
import com.clouway.jdbc.person.PeopleDAO;
import com.clouway.jdbc.person.PeopleDAOImpl;
import com.clouway.jdbc.person.Person;
import com.clouway.jdbc.person.PersonRowMapper;
import org.junit.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class PeopleDAOTest {
    private Person ivan = new Person("Ivan", "8912271449", 22, "darkpain1989@gmail.bg");
    private DatabaseHelper databaseHelper = new DatabaseHelper();
    private RowMapper<Person> rowMapper = new PersonRowMapper();


    @Test
    public void insertNewPersonInDatabase() throws SQLException {
//
        PeopleDAO peopleDAO = new PeopleDAOImpl(databaseHelper);
        peopleDAO.save(ivan);

        List<Person> personList = databaseHelper.executeQuery("SELECT * FROM people",rowMapper);

        assertEquals(personList.size(), 1);
        assertEquals(ivan.getName(), personList.get(0).getName());
        assertEquals(ivan.getAge(), personList.get(0).getAge());
        assertEquals(ivan.getEmail(), personList.get(0).getEmail());
    }

//    @Test
//    public void updatePersonEmail() throws SQLException {
//
//        PeopleDAO peopleDAO = new PeopleDAOImpl(connection);
//        peopleDAO.save(ivan);
//        peopleDAO.update(ivan, "darkpain@abv.bg");
//
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT email FROM people WHERE name='Ivan'");
//
//        String result = null;
//        if (resultSet.next()) {
//
//            result = resultSet.getString("email");
//        }
//        statement.close();
//        assertEquals("darkpain@abv.bg", result);
//    }
//
//    @Test
//    public void getAllPersons() throws SQLException {
//
//        Person krasimir = new Person("Krasimir", "8912141447", 22, "555@mail.bg");
//        PeopleDAO peopleDAO = new PeopleDAOImpl(connection);
//        peopleDAO.save(ivan);
//        peopleDAO.save(krasimir);
//
//        List<Person> expectedPersons = new ArrayList<Person>();
//        expectedPersons.add(ivan);
//        expectedPersons.add(krasimir);
//
//        List<Person> actualPersons = peopleDAO.getAllPersons();
//        assertEquals(expectedPersons, actualPersons);
//    }
//
//    @Test
//    public void getAllPersonsWhichNameStartsWithI() throws SQLException {
//
//
//    }

    @After
    public void disconnect() throws SQLException {
        databaseHelper.executeQuery("DELETE FROM people");
    }
}
