package com.hightide.ui.terminal;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * Created by peter on 9/1/15.
 */
public class JTerminal extends JPanel implements CommandListener, Terminal{

    private JTextArea textArea;
    private int userInputStart = 0;
    public Command cmd;

    public JTerminal() {

        cmd = new Command(this);

        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(new ProtectedDocumentFilter(this));
        add(new JScrollPane(textArea));

        InputMap im = textArea.getInputMap(WHEN_FOCUSED);
        ActionMap am = textArea.getActionMap();

        final Action oldAction = am.get("insert-break");
        am.put("insert-break", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int range = textArea.getCaretPosition() - userInputStart;
                try {
                    String text = textArea.getText(userInputStart, range).trim();
                    System.out.println("[" + text + "]");
                    userInputStart += range;
                    if (!cmd.isRunning()) {
                        cmd.execute(text);
                    } else {
                        cmd.send(text + "\n");
                    }
                } catch (BadLocationException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                oldAction.actionPerformed(e);
            }
        });

        appendText("--- HIGH TIDE SCRIPT EDITOR VERSION 0.0 ---\n\n");
    }

    @Override
    public void commandOutput(String text) {
        SwingUtilities.invokeLater(new AppendTask(this, text));
    }

    @Override
    public void commandFailed(Exception exp) {
        SwingUtilities.invokeLater(new AppendTask(this, "Command failed - " + exp.getMessage()));
    }

    @Override
    public void commandCompleted(String cmd, int result) {
        appendText("\n> " + cmd + " exited with " + result + "\n");
        appendText("\n");
    }

    protected void updateUserInputPos() {
        int pos = textArea.getCaretPosition();
        textArea.setCaretPosition(textArea.getText().length());
        userInputStart = pos;

    }

    @Override
    public int getUserInputStart() {
        return userInputStart;
    }

    @Override
    public void appendText(String text) {
        textArea.append(text);
        updateUserInputPos();
    }
}
