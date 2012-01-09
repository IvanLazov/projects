package com.clouway.designpatterns.objectpool;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ResourcePoolTest {
    
    private ResourcePool pool;
    private Resource resource;

    @Before
    public void setUp() {

        pool = new ResourcePool(2);
        resource = pool.acquire();
    }
    
    @Test
    public void happyPath() {

        assertNotNull(pool.acquire());
    }

    @Test
    public void acquireTheSameReleasedResource() {

        pool.release(resource);
        Resource actualResource = pool.acquire();
        assertEquals(resource, actualResource);
    }

    @Test
    public void acquireTwoDifferentResources() {

        Resource actualResource = pool.acquire();
        assertNotSame(resource, actualResource);
    }

    @Test(expected = NoAvailableResourcesException.class)
    public void cannotAcquireResource() {

        Resource first = pool.acquire();
        Resource second = pool.acquire();
    }
}
