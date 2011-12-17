package com.clouway.designpatterns.objectpool;

/**
 * Resource class represent object that will be used in the ResourcePool
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Resource {

    private String name;
    
    public Resource(String name) {

        this.name = name;
    }
    
    public String getName() {

        return name;
    }
}
