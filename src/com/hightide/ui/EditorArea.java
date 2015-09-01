package com.hightide.ui;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;

/**
 * Created by peter on 8/30/15.
 */
public class EditorArea extends JTextPane{

    private String path;
    private String content;
    private Boolean saved;
    public static StyledDocument DOC = (StyledDocument) new DefaultStyledDocument();
    private StyledDocument doc;

    public EditorArea(String content, String path, Boolean saved, StyledDocument doc){

        super(doc);
        setText(content);
        this.content = content;
        this.path = path;
        this.saved = saved;
        this.doc = doc;
    }

    public String getPath(){
        return path;
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isSaved() {
        return saved;
    }

    public StyledDocument getDocument() {
        return doc;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }
}
