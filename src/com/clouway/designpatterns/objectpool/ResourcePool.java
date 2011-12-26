package com.clouway.designpatterns.objectpool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ResourcePool class presents a simple implementation of Object Pool Design Pattern.
 * The class has methods for acquire and release of resources from the pool.
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class ResourcePool {

    private Resource resource;
    private List<Resource> usedResources = new ArrayList<Resource>(); // resources which are currently used
    private List<Resource> unusedResources = new ArrayList<Resource>(); // resources which are not used at the moment
    private final int maximumNumberOfResources; // maximum number of resource in the pool
    private int currentNumberOfResources; // number of current resources in the pool

    /**
     * Constructor creates the ResourcePool by setting the maximum number of resources that can contain
     *
     * @param size number of resources
     */
    public ResourcePool(int size) {

        maximumNumberOfResources = size;
        currentNumberOfResources = 0;
    }

    /**
     * Acquire resources from the pool if available. If there are no available resources, a new one is created,
     * if the creation of the resource will not exceed the size of the pool
     *
     * @return a Resource from the ResourcePool
     */
    public Resource acquire() {

        if (currentNumberOfResources >= maximumNumberOfResources) {

            throw new NoAvailableResourcesException();
        } else {

            Iterator<Resource> it = unusedResources.iterator();

            if (it.hasNext()) {
                resource = it.next();
            } else {
                resource = new Resource();
                usedResources.add(resource);
            }

            currentNumberOfResources++;
            return resource;
        }
    }

    /**
     * Release the acquired resource and returns it to the list of unused resources
     *
     * @param resource the resource which will be released
     */
    public void release(Resource resource) {

        if (usedResources.contains(resource)) {

            usedResources.remove(resource);
            unusedResources.add(resource);
        }
    }
}
