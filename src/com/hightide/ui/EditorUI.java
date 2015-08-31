package com.hightide.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Created by peter on 8/30/15.
 */
public class EditorUI extends JFrame {

    //private JTextArea textArea;
    private JTabbedPane tabbedPane;
    private JPopupMenu pup;

    public int WINDOW_WIDTH = 800;
    public int WINDOW_HEIGHT = 600;
    public String WINDOW_INIT_TITLE = "High Tide Scripting Editor";

    public EditorUI(){

        // Set up Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        // Set up File Menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem miNew = new JMenuItem("New");
        miNew.addActionListener(new EditorEventListener());
        fileMenu.add(miNew);
        JMenuItem miOpen = new JMenuItem("Open...");
        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openFile();
            }
        });
        fileMenu.add(miOpen);
        JMenuItem miClose = new JMenuItem("Close");
        miClose.addActionListener(new EditorEventListener());
        fileMenu.add(miClose);
        fileMenu.addSeparator();
        JMenuItem miSave = new JMenuItem("Save");
        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveSelectedTab();
            }
        });
        fileMenu.add(miSave);
        JMenuItem miSaveAs = new JMenuItem("Save As...");
        miSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveSelectedTabAs();
            }
        });
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
        JMenuItem miCut = new JMenuItem("Cut");
        editMenu.add(miCut);
        JMenuItem miCopy = new JMenuItem("Copy");
        editMenu.add(miCopy);
        JMenuItem miPaste = new JMenuItem("Paste");
        editMenu.add(miPaste);
        editMenu.addSeparator();
        JMenuItem miSelectAll = new JMenuItem("Select All");
        miSelectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectAll();
            }
        });
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



        // Set up JTabbedPane
        tabbedPane = new JTabbedPane();
        container.add(tabbedPane, BorderLayout.CENTER);



        //textArea = new JTextArea();
        //container.add(new JScrollPane(textArea), BorderLayout.CENTER);
        // Set up Pop-Up Menu
        pup = new JPopupMenu();
        JMenuItem pmiCut = new JMenuItem("Cut");
        pup.add(pmiCut);
        JMenuItem pmiCopy = new JMenuItem("Copy");
        pup.add(pmiCopy);
        JMenuItem pmiPaste = new JMenuItem("Paste");
        pup.add(pmiPaste);
        pup.addSeparator();
        JMenuItem pmiSelectAll = new JMenuItem("Select All");
        pmiSelectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectAll();
            }
        });
        pup.add(pmiSelectAll);
        // More Pop-Up Setup
        /*textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())
                    pup.show(textArea, e.getX(), e.getY());
            }
        });*/



        // JToolBar Setup
        JToolBar toolbar = new JToolBar();
        container.add(toolbar, BorderLayout.NORTH);
        JButton newButton = new JButton(new ImageIcon("res/drop29.png"));
        newButton.setToolTipText("New Tab");
        newButton.addActionListener(new EditorEventListener());
        toolbar.add(newButton);
        JButton closeButton = new JButton(new ImageIcon("res/cross105.png"));
        closeButton.setToolTipText("Close Current Tab");
        closeButton.addActionListener(new EditorEventListener());
        toolbar.add(closeButton);
        toolbar.addSeparator();
        JButton saveButton = new JButton(new ImageIcon("res/anchor39.png"));
        saveButton.setToolTipText("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveSelectedTab();
            }
        });
        toolbar.add(saveButton);
        JButton openButton = new JButton(new ImageIcon("res/padlock48.png"));
        openButton.setToolTipText("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                openFile();
            }
        });
        toolbar.add(openButton);
        toolbar.addSeparator();
        JButton runButton = new JButton(new ImageIcon("res/playbutton.png"));
        runButton.setToolTipText("Run Script!");
        toolbar.add(runButton);



        // Initialize the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle(WINDOW_INIT_TITLE);
        setVisible(true);
    }


    public void selectAll(){

        JViewport viewport = ((JScrollPane)tabbedPane.getSelectedComponent()).getViewport();
        EditorArea ea = (EditorArea)viewport.getView();
        ea.requestFocusInWindow();
        ea.selectAll();
    }



    public final void addEditorTab(String title, String content, String path){

        final EditorArea editor = new EditorArea(content, path);
        editor.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())
                    pup.show(editor, e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger())
                    pup.show(editor, e.getX(), e.getY());
            }
        });

        tabbedPane.addTab(title, new JScrollPane(editor));
    }



    public void removeSelectedEditorTab(){

        int selectedTabIndex = tabbedPane.getSelectedIndex();
        tabbedPane.removeTabAt(selectedTabIndex);
    }



    public void saveSelectedTab(){

        try {
            JViewport viewport = ((JScrollPane)tabbedPane.getSelectedComponent()).getViewport();
            EditorArea ea = (EditorArea)viewport.getView();
            System.out.println(ea.getPath());
            if (ea.getPath() == null) {
                saveSelectedTabAs();
            }else{
                PrintWriter writer = new PrintWriter(ea.getPath(), "UTF-8");
                String[] lines = ea.getText().split("\\n");
                for (int i=0; i<lines.length; i++)
                    writer.println(lines[i]);
                writer.flush();
                writer.close();
            }
        }catch(Exception e){
            System.out.println("Something went wrong:\n"+e.getMessage());
        }
    }



    public void saveSelectedTabAs(){

        try {
            JViewport viewport = ((JScrollPane)tabbedPane.getSelectedComponent()).getViewport();
            EditorArea ea = (EditorArea)viewport.getView();
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("Save As...");
            int userSelection = jfc.showSaveDialog(this);
            if (userSelection == jfc.APPROVE_OPTION)
                ea.setPath(jfc.getSelectedFile().getAbsolutePath());
                tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), jfc.getSelectedFile().getName());
            saveSelectedTab();
        }catch(Exception e){
            System.out.println("Something went wrong:\n"+e.getMessage());
        }
    }



    public void openFile(){
        try{
            String data = "Failed to Load File!!!";
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Open...");
            int userSelection = fileChooser.showOpenDialog(this);
            if (userSelection == fileChooser.APPROVE_OPTION){
                BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                try {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();

                    while (line != null) {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                    data = sb.toString();
                } finally {
                    br.close();
                    addEditorTab(fileChooser.getSelectedFile().getName(), data, fileChooser.getSelectedFile().getPath());
                }
            }
        }catch(Exception e){
            System.out.println("Something went wrong:\n"+e.getMessage());
        }
    }



    private class EditorEventListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            Object source = actionEvent.getSource();

            if (source instanceof JMenuItem){

                if (actionEvent.getActionCommand() == "New"){
                    addEditorTab("Untitled", null, null);
                }else if (actionEvent.getActionCommand() == "Close") {
                    removeSelectedEditorTab();
                }else if (actionEvent.getActionCommand() == "Save"){

                }
            }
            else if (source instanceof JButton){

                if (((JButton)actionEvent.getSource()).getToolTipText() == "New Tab") {
                    addEditorTab("Untitled", null, null);
                }else if (((JButton)actionEvent.getSource()).getToolTipText() == "Close Current Tab"){
                    removeSelectedEditorTab();
                }
            }


        }
    }
}