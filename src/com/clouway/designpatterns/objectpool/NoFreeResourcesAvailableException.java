package com.clouway.designpatterns.objectpool;

/**
 * Throws this exception if every Resource instance
 * in the ResourcePool is currently used
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class NoFreeResourcesAvailableException extends RuntimeException {
}
