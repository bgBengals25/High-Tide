package com.hightide.ui;

import javax.swing.*;

/**
 * Created by peter on 8/30/15.
 */
public class EditorArea extends JTextPane{

    private String path;
    private String content;
    private Boolean saved;

    public EditorArea(){

        super();
    }

    public EditorArea(String content, String path, Boolean saved){

        setText(content);
        this.content = content;
        this.path = path;
        this.saved = saved;
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

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }
}
