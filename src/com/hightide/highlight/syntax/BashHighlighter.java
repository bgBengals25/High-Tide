package com.hightide.highlight.syntax;

import com.hightide.highlight.Highlighter;
import com.hightide.highlight.syntax.theme.Theme;
import com.hightide.ui.EditorArea;

import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.PrintWriter;

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

        FileReader fr = new FileReader("res/keywords/bash.kw");

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
                String [] contentsSep = contents.split(" ");
                for(int i=0; i<contentsSep.length; i++){

                }
            }
        });
    }
}
