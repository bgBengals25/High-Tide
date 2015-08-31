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
    }

    public Font getPLAIN_TEXT() {
        return PLAIN_TEXT;
    }

    public void setPLAIN_TEXT(Font PLAIN_TEXT) {
        this.PLAIN_TEXT = PLAIN_TEXT;
    }

    public Color getPLAIN_TEXT_COLOR() {
        return PLAIN_TEXT_COLOR;
    }

    public void setPLAIN_TEXT_COLOR(Color PLAIN_TEXT_COLOR) {
        this.PLAIN_TEXT_COLOR = PLAIN_TEXT_COLOR;
    }

    public Color getKEYWORD_TEXT_COLOR() {
        return KEYWORD_TEXT_COLOR;
    }

    public void setKEYWORD_TEXT_COLOR(Color KEYWORD_TEXT_COLOR) {
        this.KEYWORD_TEXT_COLOR = KEYWORD_TEXT_COLOR;
    }

    public Font getKEYWORD_TEXT() {
        return KEYWORD_TEXT;
    }

    public void setKEYWORD_TEXT(Font KEYWORD_TEXT) {
        this.KEYWORD_TEXT = KEYWORD_TEXT;
    }

    public Font getOS_KEYWORD_TEXT() {
        return OS_KEYWORD_TEXT;
    }

    public void setOS_KEYWORD_TEXT(Font OS_KEYWORD_TEXT) {
        this.OS_KEYWORD_TEXT = OS_KEYWORD_TEXT;
    }

    public Color getOS_KEYWORD_TEXT_COLOR() {
        return OS_KEYWORD_TEXT_COLOR;
    }

    public void setOS_KEYWORD_TEXT_COLOR(Color OS_KEYWORD_TEXT_COLOR) {
        this.OS_KEYWORD_TEXT_COLOR = OS_KEYWORD_TEXT_COLOR;
    }

    public Font getQUOTE_TEXT() {
        return QUOTE_TEXT;
    }

    public void setQUOTE_TEXT(Font QUOTE_TEXT) {
        this.QUOTE_TEXT = QUOTE_TEXT;
    }

    public Color getQUOTE_TEXT_COLOR() {
        return QUOTE_TEXT_COLOR;
    }

    public void setQUOTE_TEXT_COLOR(Color QUOTE_TEXT_COLOR) {
        this.QUOTE_TEXT_COLOR = QUOTE_TEXT_COLOR;
    }

    public Color getCOMMENT_TEXT_COLOR() {
        return COMMENT_TEXT_COLOR;
    }

    public void setCOMMENT_TEXT_COLOR(Color COMMENT_TEXT_COLOR) {
        this.COMMENT_TEXT_COLOR = COMMENT_TEXT_COLOR;
    }

    public Font getCOMMENT_TEXT() {
        return COMMENT_TEXT;
    }

    public void setCOMMENT_TEXT(Font COMMENT_TEXT) {
        this.COMMENT_TEXT = COMMENT_TEXT;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public File getTHEME_FILE() {
        return THEME_FILE;
    }

    public void setTHEME_FILE(File THEME_FILE) {
        this.THEME_FILE = THEME_FILE;
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
}
