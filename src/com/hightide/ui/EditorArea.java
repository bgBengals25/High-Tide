package com.hightide.ui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

/**
 * Created by peter on 8/30/15.
 */
public class EditorArea extends JEditorPane{

    private String path;
    private String content;
    private Boolean saved;

    public EditorArea(String content, String path, Boolean saved, String lang){

        this.content = content;
        this.path = path;
        this.saved = saved;

        if(lang.equals("bash")){
        }
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
