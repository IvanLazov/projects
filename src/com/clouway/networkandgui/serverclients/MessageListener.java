package com.clouway.networkandgui.serverclients;

/**
 * This interface is used to display new messages to the display
 * of the server of client
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface MessageListener {

    public void onDisplayMessage(MessageEvent event);
}
