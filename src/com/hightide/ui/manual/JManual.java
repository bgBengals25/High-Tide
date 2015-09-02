package com.hightide.ui.manual;

import javax.swing.*;
import java.awt.*;

/**
 * Created by peter on 9/1/15.
 */
public class JManual {

    private static JTextArea jta;

    public static void main(String[] args){
        openManual(null);
    }

    public static void openManual(JComponent c){

        JFrame frame = new JFrame();
        frame.setTitle("High Tide Scripting Editor - Linux Manual");
        frame.setLocationRelativeTo(c);
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contents = frame.getContentPane();
        contents.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JLabel manLabel = new JLabel("Search Manual: ");
        northPanel.add(manLabel);
        JTextField jtf = new JTextField();
        jtf.setColumns(20);
        northPanel.add(jtf);
        JButton jb = new JButton("Search!");
        northPanel.add(jb);
        contents.add(northPanel, BorderLayout.NORTH);

        jta = new JTextArea();

        frame.setVisible(true);
    }

    private String search(String scmd){

        return null;
    }
}
