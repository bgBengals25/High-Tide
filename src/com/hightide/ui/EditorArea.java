package com.hightide.ui;

import javax.swing.*;

/**
 * Created by peter on 8/30/15.
 */
@SuppressWarnings("unused")
class EditorArea extends JEditorPane{

    private String path;
    private String content;
    private Boolean saved;

    @SuppressWarnings("StatementWithEmptyBody")
    public EditorArea(String content, String path, Boolean saved, String type){

        super(type, content);
        this.content = content;
        this.path = path;
        this.saved = saved;

        if(type.equals("application/x-bsh")){
        }

        setText(content);
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
