package com.clouway.designpatterns.objectpool;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) {

        ResourcePool resourcePool = ResourcePool.createInstance();
        Resource[] resource = new Resource[11];
        
        for (int i = 0; i < resource.length; i++) {
            
            try {

                resource[i] = resourcePool.acquire();
                System.out.println(resource[i].getName());
            } catch (NoFreeResourcesAvailableException exceptionFree) {

                System.out.println("Can't acquire new resource");
            }
        }
        
        System.out.println("Release a resource");
        resourcePool.release(resource[0]);
        
        System.out.println("Acquire resource");
        resource[10] = resourcePool.acquire();
        System.out.println(resource[10].getName());
    }
}
