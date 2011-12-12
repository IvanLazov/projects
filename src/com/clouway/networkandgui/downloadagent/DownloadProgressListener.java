package com.clouway.networkandgui.downloadagent;

/**
 * The interface provides a method for listening the downloading progress
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public interface DownloadProgressListener {

    void onProgress(DownloadProgressEvent event);
}
