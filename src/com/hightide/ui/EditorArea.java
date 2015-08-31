package com.hightide.ui;

import javax.swing.*;

/**
 * Created by peter on 8/30/15.
 */
public class EditorArea extends JTextArea{

    private String path;
    private String content;

    public EditorArea(){

        super();
    }

    public EditorArea(String content, String path){

        super(content);
        this.content = content;
        this.path = path;
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

    public void setContent(String content){
        this.content = content;
    }
}
