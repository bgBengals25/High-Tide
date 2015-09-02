package com.hightide.ui.manual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by peter on 9/1/15.
 */
public class JManual {

    private static JTextArea jta;
    private static JScrollPane jsp;

    public static void main(String[] args){
        openManual(null);
    }

    public static void openManual(JComponent c){

        JFrame frame = new JFrame();
        frame.setTitle("High Tide Scripting Editor - Linux Manual");
        frame.setLocationRelativeTo(c);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contents = frame.getContentPane();
        contents.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JLabel manLabel = new JLabel("Search Manual: ");
        northPanel.add(manLabel);
        JTextField jtf = new JTextField();
        jtf.setColumns(20);
        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    search(jtf.getText());
                }
            }
        });
        northPanel.add(jtf);
        JButton jb = new JButton("Search!");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtf.getText().equals("")) {
                    search(jtf.getText());
                }
            }
        });
        northPanel.add(jb);
        contents.add(northPanel, BorderLayout.NORTH);

        jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        jsp = new JScrollPane(jta);
        contents.add(jsp, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static String search(String scmd) {

        try {

            jta.setText(null);
            ProcessBuilder pb = new ProcessBuilder("man", scmd);
            Process p = pb.start();
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;

            while((line = br.readLine()) != null){
                jta.append(line);
                jsp.getViewport().setViewPosition(new Point(0, 0));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
