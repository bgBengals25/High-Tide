package com.hightide.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by peter on 8/30/15.
 */
public class EditorUI extends JFrame {

    private JTextArea textArea;

    public int WINDOW_WIDTH = 700;
    public int WINDOW_HEIGHT = 450;
    public String WINDOW_INIT_TITLE = "High Tide Scripting Editor";

    public EditorUI(){

        // Set up Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // Set up Menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem miNew = new JMenuItem("New");
        fileMenu.add(miNew);
        JMenuItem miOpen = new JMenuItem("Open");
        fileMenu.add(miOpen);
        JMenuItem miSave = new JMenuItem("Save");
        fileMenu.add(miSave);
        fileMenu.addSeparator();
        JMenuItem miExit = new JMenuItem("Exit");



        // Frame set up
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        textArea = new JTextArea();
        container.add(new JScrollPane(textArea), BorderLayout.CENTER);



        // Initialize the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle(WINDOW_INIT_TITLE);
        setVisible(true);
    }
}