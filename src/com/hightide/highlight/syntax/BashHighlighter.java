package com.hightide.highlight.syntax;

import com.hightide.highlight.Highlighter;
import com.hightide.highlight.syntax.theme.Theme;
import com.hightide.ui.EditorArea;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
