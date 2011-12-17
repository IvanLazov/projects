package com.clouway.designpatterns.objectpool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ResourcePool class is a pool which contains a fix number of Resource instances.
 * This makes every Resource instances reusable at any time.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ResourcePool {

    private static boolean instanceFlag = false; // monitors creation of ResourcePool instance
    private List<Resource> unusedResources = new ArrayList<Resource>();
    private List<Resource> usedResources = new ArrayList<Resource>();

    /**
     * Constructor fills the ResourcePool with Resource instances
     */
    private ResourcePool() {

        for (int i = 0; i < 10; i++) {

            Resource resource = new Resource("Resource " + i);
            unusedResources.add(resource);
        }
    }

    /**
     * Creates a single instance of ResourcePool
     *
     * @return an instance of ResourcePool
     */
    public static ResourcePool createInstance() {
        
        if (!instanceFlag) {

            instanceFlag = true;
            return new ResourcePool();
        } else {

            return null;
        }
    }

    /**
     * Acquire a free Resource instance from the ResourcePool's unusedResources list
     * If there is no free Resource instance, throws a NoFreeResourcesAvailableException
     *
     * @return a Resource instance
     */
    public Resource acquire() {

        Iterator iterator = unusedResources.iterator();
        
        if (iterator.hasNext()) {

            Resource resource = (Resource) iterator.next();
            unusedResources.remove(resource);
            usedResources.add(resource);
            return resource;

        } else {

            throw new NoFreeResourcesAvailableException();
        }
    }

    /**
     * Release currently used Resource instance and
     * puts it back in the ResourcePool's unusedResources list
     *
     * @param resource the resource that will be released and returned
     */
    public void release(Resource resource) {

        if (usedResources.contains(resource)) {

            usedResources.remove(resource);
            unusedResources.add(resource);
        }
    }
}
