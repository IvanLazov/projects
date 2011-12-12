package com.clouway.networkandgui.serverclients;

/**
 * This class save current message that will be displayed
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class MessageEvent {

    private final String message;

    public MessageEvent(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
