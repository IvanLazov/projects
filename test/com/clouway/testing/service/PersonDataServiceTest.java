package com.clouway.testing.service;

import org.junit.Before;
import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
@RunWith(JMock.class)
public class PersonDataServiceTest {

    Mockery context = new JUnit4Mockery();
    private PersonDataService personDataService;
    private final Validator validator = context.mock(Validator.class);
    private final Database database = context.mock(Database.class);


    @Before
    public void setUp() {
        personDataService = new PersonDataService(database, validator);
    }

    @Test
    public void happyPath() {

        context.checking(new Expectations() {{
            oneOf(validator).validateAge("20");
            oneOf(database).saveData("Mike", "20");
        }});

        personDataService.personData("Mike", "20");
    }

    @Test(expected = InvalidAgeException.class)
    public void ageUnderTenIsInvalid() {

        context.checking(new Expectations() {{
            allowing(validator).validateAge("8");
            will(throwException(new InvalidAgeException()));
        }});

        personDataService.personData("Mike", "8");
    }

    @Test(expected = InvalidAgeException.class)
    public void ageAboveOneHundredIsInvalid() {

        context.checking(new Expectations() {{
            allowing(validator).validateAge("120");
            will(throwException(new InvalidAgeException()));
        }});

        personDataService.personData("Mike", "120");
    }

    @Test
    public void userIsAdult() {

        context.checking(new Expectations() {{
            oneOf(database).getData("Mike");
            will(returnValue("20"));
        }});

        assertTrue(personDataService.isUserAdult("Mike"));
    }

    @Test
    public void userIsNotAdult() {

        context.checking(new Expectations() {{
            oneOf(database).getData("Mike");
            will(returnValue("10"));
        }});

        assertFalse(personDataService.isUserAdult("Mike"));
    }
}
