package com.hightide.ui.terminal;

/**
 * Created by peter on 9/1/15.
 */
public interface CommandListener {

    public void commandOutput(String text);

    public void commandCompleted(String cmd, int result);

    public void commandFailed(Exception exp);
}
