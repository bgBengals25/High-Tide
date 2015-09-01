package com.hightide.highlight.syntax;

import com.hightide.highlight.Highlighter;
import com.hightide.highlight.syntax.theme.Theme;
import com.hightide.ui.EditorArea;

import javax.swing.text.JTextComponent;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by peter on 8/31/15.
 */
public class BashHighlighter implements Highlighter {

    private EditorArea EDITOR_AREA;
    private Theme THEME;

    public BashHighlighter(EditorArea ea, Theme th){

        EDITOR_AREA = ea;
        THEME = th;
        highlight();
    }

    @Override
    public void highlight() {

        Style plaintext = EDITOR_AREA.addStyle("plaintext",null);
        StyleConstants.setForeground(plaintext, THEME.getPLAIN_TEXT_COLOR());

        Style keywordtext = EDITOR_AREA.addStyle("keywordtext",null);
        StyleConstants.setForeground(keywordtext, THEME.getKEYWORD_TEXT_COLOR());

        Style oskeywordtext = EDITOR_AREA.addStyle("oskeywordtext",null);
        StyleConstants.setForeground(oskeywordtext, THEME.getOS_KEYWORD_TEXT_COLOR());

        Style quotetext = EDITOR_AREA.addStyle("quotetext",null);
        StyleConstants.setForeground(quotetext, THEME.getOS_KEYWORD_TEXT_COLOR());

        Style commenttext = EDITOR_AREA.addStyle("commenttext",null);
        StyleConstants.setForeground(commenttext, THEME.getCOMMENT_TEXT_COLOR());

        try {
            FileReader frkw = new FileReader("res/keywords/bash.kw");
            BufferedReader brkw = new BufferedReader(frkw);
            String[] keywords = brkw.readLine().split(" ");
            brkw.close();
            frkw.close();
            FileReader frcmd = new FileReader("res/keywords/bash.cmd");
            BufferedReader brcmd = new BufferedReader(frcmd);
            String[] commands = brcmd.readLine().split(" ");
            brcmd.close();
            frcmd.close();


        } catch (Exception e) {
            System.out.println("Something went wrong:\n"+e.getMessage());
        }

        EDITOR_AREA.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                String contents = EDITOR_AREA.getText();
                String[] contentsSep = contents.split(" ");
                for (int i = 0; i < contentsSep.length; i++) {

                }
            }
        });
    }

    public void removeStyles(StyledDocument sd){
        sd.removeStyle("plaintext");
        sd.removeStyle("keywordtext");
        sd.removeStyle("oskeywordtext");
        sd.removeStyle("quotetext");
        sd.removeStyle("commenttext");
    }
}
