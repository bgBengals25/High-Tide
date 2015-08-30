package com.hightide.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        // Set up File Menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem miNew = new JMenuItem("New");
        fileMenu.add(miNew);
        JMenuItem miOpen = new JMenuItem("Open...");
        fileMenu.add(miOpen);
        JMenuItem miClose = new JMenuItem("Close");
        fileMenu.add(miClose);
        fileMenu.addSeparator();
        JMenuItem miSave = new JMenuItem("Save");
        fileMenu.add(miSave);
        JMenuItem miSaveAs = new JMenuItem("Save As...");
        fileMenu.add(miSaveAs);
        fileMenu.addSeparator();
        JMenuItem miExit = new JMenuItem("Exit");
        fileMenu.add(miExit);
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        // Set up Edit Menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        JMenuItem miUndo = new JMenuItem("Undo");
        editMenu.add(miUndo);
        JMenuItem miRedo = new JMenuItem("Redo");
        editMenu.add(miRedo);
        editMenu.addSeparator();
        JMenuItem miCut = new JMenuItem("Cut");
        editMenu.add(miCut);
        JMenuItem miCopy = new JMenuItem("Copy");
        editMenu.add(miCopy);
        JMenuItem miPaste = new JMenuItem("Paste");
        editMenu.add(miPaste);
        editMenu.addSeparator();
        JMenuItem miSelectAll = new JMenuItem("Select All");
        editMenu.add(miSelectAll);
        // Set up Tools Menu
        JMenu toolsMenu = new JMenu("Tools");
        menuBar.add(toolsMenu);
        JMenu RunAs = new JMenu("Run As...");
        JMenuItem miBashScript = new JMenuItem("Bash Script");
        RunAs.add(miBashScript);
        toolsMenu.add(RunAs);
        JMenuItem miSearchManual = new JMenuItem("Search Manual");
        toolsMenu.add(miSearchManual);
        JMenuItem miSearchManualFor = new JMenuItem("Search Manual For...");
        toolsMenu.add(miSearchManualFor);
        toolsMenu.addSeparator();
        JMenuItem miSettings = new JMenuItem("Settings");
        toolsMenu.add(miSettings);



        // Frame set up
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        textArea = new JTextArea();
        container.add(new JScrollPane(textArea), BorderLayout.CENTER);
        // Set up Pop-Up Menu
        final JPopupMenu pup = new JPopupMenu();
        JMenuItem pmiCut = new JMenuItem("Cut");
        pup.add(pmiCut);
        JMenuItem pmiCopy = new JMenuItem("Copy");
        pup.add(pmiCopy);
        JMenuItem pmiPaste = new JMenuItem("Paste");
        pup.add(pmiPaste);
        pup.addSeparator();
        JMenuItem pmiSelectAll = new JMenuItem("Select All");
        pup.add(pmiSelectAll);
        // More Pop-Up Setup
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())
                    pup.show(textArea, e.getX(), e.getY());
            }
        });



        // JToolBar Setup
        JToolBar toolbar = new JToolBar();
        container.add(toolbar, BorderLayout.NORTH);



        // Initialize the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle(WINDOW_INIT_TITLE);
        setVisible(true);
    }
}