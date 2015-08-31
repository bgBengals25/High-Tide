package com.hightide.highlight.syntax.theme;

import java.awt.*;
import java.io.File;

/**
 * Created by peter on 8/31/15.
 */
public class Theme {

    private Font PLAIN_TEXT;
    private Color PLAIN_TEXT_COLOR;
    private Font KEYWORD_TEXT;
    private Color KEYWORD_TEXT_COLOR;
    private Font OS_KEYWORD_TEXT;
    private Color OS_KEYWORD_TEXT_COLOR;
    private Font QUOTE_TEXT;
    private Color QUOTE_TEXT_COLOR;
    private Font COMMENT_TEXT;
    private Color COMMENT_TEXT_COLOR;

    private String NAME;
    private File THEME_FILE;

    public Theme(){NAME=null;THEME_FILE=null;}

    public Theme(String name){
        NAME = name;
        THEME_FILE = null;
        loadTheme();
    }

    public Theme(File themefile){
        NAME = null;
        THEME_FILE = themefile;
    }

    public Theme(String name, File themefile){
        NAME = name;
        THEME_FILE = themefile;
    }

    public void loadTheme(){
        ThemeLoader themeLoader = new ThemeLoader(this);
    }

    public Font getPLAIN_TEXT() {
        return PLAIN_TEXT;
    }

    public Color getPLAIN_TEXT_COLOR() {
        return PLAIN_TEXT_COLOR;
    }

    public Font getKEYWORD_TEXT() {
        return KEYWORD_TEXT;
    }

    public Color getKEYWORD_TEXT_COLOR() {
        return KEYWORD_TEXT_COLOR;
    }

    public Font getOS_KEYWORD_TEXT() {
        return OS_KEYWORD_TEXT;
    }

    public Color getOS_KEYWORD_TEXT_COLOR() {
        return OS_KEYWORD_TEXT_COLOR;
    }

    public Font getQUOTE_TEXT() {
        return QUOTE_TEXT;
    }

    public Color getQUOTE_TEXT_COLOR() {
        return QUOTE_TEXT_COLOR;
    }

    public Font getCOMMENT_TEXT() {
        return COMMENT_TEXT;
    }

    public Color getCOMMENT_TEXT_COLOR() {
        return COMMENT_TEXT_COLOR;
    }

    public String getNAME() {
        return NAME;
    }

    public File getTHEME_FILE() {
        return THEME_FILE;
    }
}
