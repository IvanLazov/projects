package com.clouway.threads.timeouthashtable;

/**
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        TimeoutHashtable timeoutHashtable = new TimeoutHashtable(10);

        timeoutHashtable.put("1", "John");

        Thread.sleep(3000);
        timeoutHashtable.put("2", "Steve");
        timeoutHashtable.remove("1");

        Thread.sleep(2000);
        timeoutHashtable.put("1", "Johnny");

        Thread.sleep(3000);
        timeoutHashtable.get("1");
    }
}
