package com.hightide.ui;

import javax.swing.*;

/**
 * Created by peter on 8/30/15.
 */
public class EditorUI extends JFrame {

    private JTextArea textArea;

    public int WINDOW_WIDTH = 800;
    public int WINDOW_HEIGHT = 600;
    public String WINDOW_INIT_TITLE = "High Tide Scripting Editor";

    public EditorUI(){

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_INIT_TITLE);
        setVisible(true);
    }
}