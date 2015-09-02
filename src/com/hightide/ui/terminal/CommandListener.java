package com.hightide.ui.terminal;

/**
 * Created by peter on 9/1/15.
 */
public interface CommandListener {

    void commandOutput(String text);

    void commandCompleted(String cmd, int result);

    void commandFailed(Exception exp);
}
