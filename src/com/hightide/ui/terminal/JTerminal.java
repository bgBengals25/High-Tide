package com.hightide.ui.terminal;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by peter on 9/1/15.
 */
public class JTerminal extends JPanel {

    private JTextArea jta;
    private JScrollPane jsp;

    public JTerminal(){
        super();

        setLayout(new BorderLayout());
        jta = new JTextArea("-- HIGH TIDE SCRIPTING EDITOR VERSION 0.0 --\n");
        jta.setBackground(Color.BLACK);
        jta.setForeground(Color.WHITE);
        jta.setEditable(false);
        jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);
    }

    public void execute(String command){

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(command);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            Boolean more = true;
            while (more == true) {
                s = stdInput.readLine();
                if (s != null) {
                    jta.append(s);
                }else more = false;
            }

            jta.append("\nErrors:\n");

            more = true;
            while (more == true){
                s = stdError.readLine();
                if (s != null) {
                    jta.append(stdError.readLine());
                }else{
                    more = false;
                }
            }
        }catch(Exception e){
            System.out.println("Something went wrong: \n"+e.getMessage());
        }
    }

    public void run(File f, String runWith, String options){ //OPTIONS MUST BE BLANK NOT NULL IF NO OPTIONS

        execute(runWith+" "+f.getAbsolutePath()+" "+options);
    }
}
