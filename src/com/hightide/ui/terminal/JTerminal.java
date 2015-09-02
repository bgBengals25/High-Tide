package com.hightide.ui.terminal;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by peter on 9/1/15.
 */
public class JTerminal extends JPanel {

    private final JTextArea jta;

    public JTerminal(){
        super();

        setLayout(new BorderLayout());
        jta = new JTextArea("-- HIGH TIDE SCRIPTING EDITOR VERSION 0.0 --\n");
        jta.setBackground(Color.BLACK);
        jta.setForeground(Color.WHITE);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);
    }

    private void execute(final String command){

        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Process process = new ProcessBuilder(command).start();
                        InputStream is = process.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String line;
                        while (true) {
                            line = br.readLine();
                            if (line != null){
                                jta.append(line);
                            }
                            Thread.sleep(100);
                        }
                    }catch(Exception e){
                        System.out.println("Something went wrong: \n"+e.getMessage());
                    }
                }
            }).start();


        }catch(Exception e){
            System.out.println("Something went wrong: \n"+e.getMessage());
        }
    }

    @SuppressWarnings("unused")
    public void run(File f, String runWith, String options){ //OPTIONS MUST BE BLANK NOT NULL IF NO OPTIONS

        execute(runWith+" "+f.getAbsolutePath()+" "+options);
    }
}
