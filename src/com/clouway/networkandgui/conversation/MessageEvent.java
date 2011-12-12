package com.clouway.networkandgui.conversation;

/**
 * This class is used to save one message at a time
 * that will be displayed in the server ot client display area
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class MessageEvent {

    private String message;

    public MessageEvent(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}
