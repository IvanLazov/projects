package com.clouway.networkandgui.downloadagent;

/**
 * This class is used to save the progress for the download
 *
 * Created by Ivan Lazov (darkpain1989@gmail.com)
 */
public class DownloadProgressEvent {

    private final int currentProgress;
    private final int maxProgress;

    public DownloadProgressEvent(int currentProgress, int maxProgress) {

        this.currentProgress = currentProgress;
        this.maxProgress = maxProgress;
    }

    public int getCurrentProgress() {
        return currentProgress;
    }

    public int getMaxProgress() {
        return maxProgress;
    }
}
