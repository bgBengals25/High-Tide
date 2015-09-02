package com.hightide.ui.terminal;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by peter on 9/1/15.
 */
public class StreamReader extends Thread{

    private InputStream is;
    private CommandListener listener;

    public StreamReader(CommandListener listener, InputStream is) {
        this.is = is;
        this.listener = listener;
        start();
    }

    @Override
    public void run() {
        try {
            int value = -1;
            while ((value = is.read()) != -1) {
                listener.commandOutput(Character.toString((char) value));
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
