package com.hightide.ui.terminal;

/**
 * Created by peter on 9/1/15.
 */
public class AppendTask implements Runnable {

    private Terminal terminal;
    private String text;

    public AppendTask(Terminal textArea, String text) {
        this.terminal = textArea;
        this.text = text;
    }

    @Override
    public void run() {
        terminal.appendText(text);
    }
}
