package com.clouway.testing.service;

import org.junit.Before;
import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JMock.class)
public class ServiceTest {

    Mockery context = new JUnit4Mockery();
    private final Validator validator = context.mock(Validator.class);
    private final Database database = context.mock(Database.class);
    private Service service;

    @Before
    public void setUp() {
        service = new Service();
        service.setDatabase(database);
        service.setValidator(validator);
    }

    @Test
    public void happyPath() {

        context.checking(new Expectations() {{
            oneOf(validator).validateAge("20");
            oneOf(database).saveData("Mike", "20");
        }});

        service.processData("Mike", "20");
    }

    @Test(expected = InvalidAgeException.class)
    public void ageUnderTenIsInvalid() {

        context.checking(new Expectations() {{
            allowing(validator).validateAge("8");
            will(throwException(new InvalidAgeException()));
        }});

        service.processData("Mike", "8");
    }

    @Test(expected = InvalidAgeException.class)
    public void ageAboveOneHundredIsInvalid() {

        context.checking(new Expectations() {{
            allowing(validator).validateAge("120");
            will(throwException(new InvalidAgeException()));
        }});

        service.processData("Mike", "120");
    }

    @Test
    public void userAgeMustBeBiggerThanEighteen() {

        context.checking(new Expectations() {{
            oneOf(database).getData("Mike");
            will(returnValue("20"));
        }});

        assertTrue(service.isUserAdult("Mike"));
    }

    @Test
    public void userAgeMustBeLessThanEighteen() {

        context.checking(new Expectations() {{
            oneOf(database).getData("Mike");
            will(returnValue("10"));
        }});

        assertFalse(service.isUserAdult("Mike"));
    }
}
