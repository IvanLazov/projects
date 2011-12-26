package com.clouway.designpatterns.singleton;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class SingletonTest {

    private Singleton singleton;

    @Before
    public void setUp() {
        singleton = Singleton.getInstance();
    }

    @Test
    public void getTheSameSingletonInstance() {

        Singleton singleton1 = Singleton.getInstance();
        assertEquals(singleton, singleton1);
    }
}
