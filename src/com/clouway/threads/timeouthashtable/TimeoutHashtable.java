package com.clouway.threads.timeouthashtable;

import java.util.Hashtable;
import java.util.Map;

/**
 * TimeoutHashtable class keep elements for certain time of period
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class TimeoutHashtable {

    private Map<String, Object> elements = new Hashtable<String, Object>();
    private Map<String, Counter> counters = new Hashtable<String, Counter>();
    private int lifeTime; // the time for which the elements will be kept

    public TimeoutHashtable(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    /**
     * Put new key-value and creates a counter for them.
     *
     * @param key name of key
     * @param object value associated with the key
     */
    public void put(String key, Object object) {

        if (!elements.containsKey(key)) {

            Counter counter = new Counter(key, lifeTime, elements, counters);

            elements.put(key, object);
            counters.put(key, counter);

        } else {

            elements.put(key, object);
            counters.get(key).reset();
        }
    }

    /**
     * Returns object by key and resets counter
     *
     * @param key name of key
     * @return the value associated with this key
     */
    public Object get(String key) {

        Object object;

        if (!elements.containsKey(key)) {
            return null;
        } else {

            object = elements.get(key);
            counters.get(key).reset();
        }

        return object;
    }

    /**
     * Remove element by key
     *
     * @param key name of key
     */
    public void remove(String key) {

        if (elements.containsKey(key)) {
            counters.get(key).stopCounting();
        }
    }
}
