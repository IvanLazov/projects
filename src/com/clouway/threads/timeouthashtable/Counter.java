package com.clouway.threads.timeouthashtable;

import java.util.Map;

/**
 * Counter class is used to support the lifecycle of TimeoutHashtable
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Counter implements Runnable {

    private int counter;
    private String key;
    private boolean stop = false;

    private final int lifeTime; // the time for which the elements will be kept
    private final Map<String, Object> elements;
    private final Map<String, Counter> counters;

    public Counter(String key, int lifeTime, Map<String, Object> elements, Map<String, Counter> counters) {

        this.key = key;
        this.lifeTime = lifeTime;
        this.elements = elements;
        this.counters = counters;
        startCounting();
    }

    public void run() {

        while (counter < lifeTime) {
            if (!stop) {
                try {
                    Thread.sleep(1000);
                    counter++;
                    System.out.println(Thread.currentThread().getName() + " holds: " + elements.get(key).toString() + ", counter: " + counter);
                } catch (InterruptedException e) {
                    return;
                }
            } else {
                counter = lifeTime + 1;
            }
        }

        elements.remove(key);
        counters.remove(key);
    }

    /**
     * Reset counter value
     */
    public void reset() {
        counter = 0;
    }

    /**
     * Start counting process
     */
    private void startCounting() {
        new Thread(this).start();
    }

    /**
     * Stop counting process
     */
    public void stopCounting() {
        stop = true;
    }
}
