package com.hightide.highlight.syntax.theme;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;

/**
 * Created by peter on 8/31/15.
 */
public class ThemeLoader {

    private Theme THEME;
    private File themeFile;

    public ThemeLoader(Theme theme){
        THEME = theme;
        themeFile = theme.getTHEME_FILE();
    }

    private void load(){
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(themeFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("font");

            for (int i=0; i< nList.getLength(); i++){

                Node n = nList.item(i);
                Element e = (Element)n;

                if (e.getAttribute("name").equals("plaintext")){
                    if(e.getAttribute("type").equals("normal")){
                        THEME.setPLAIN_TEXT(new Font(e.getAttribute("family"), Font.PLAIN, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("bold")){
                        THEME.setPLAIN_TEXT(new Font(e.getAttribute("family"), Font.BOLD, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("italics")){
                        THEME.setPLAIN_TEXT(new Font(e.getAttribute("family"), Font.ITALIC, Integer.parseInt(e.getAttribute("size"))));
                    }
                    THEME.setPLAIN_TEXT_COLOR(Color.getColor(e.getAttribute("color")));
                }else if (e.getAttribute("name").equals("keywordtext")){
                    if(e.getAttribute("type").equals("normal")){
                        THEME.setKEYWORD_TEXT(new Font(e.getAttribute("family"), Font.PLAIN, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("bold")){
                        THEME.setKEYWORD_TEXT(new Font(e.getAttribute("family"), Font.BOLD, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("italics")){
                        THEME.setKEYWORD_TEXT(new Font(e.getAttribute("family"), Font.ITALIC, Integer.parseInt(e.getAttribute("size"))));
                    }
                    THEME.setKEYWORD_TEXT_COLOR(Color.getColor(e.getAttribute("color")));
                }else if (e.getAttribute("name").equals("oskeywordtext")){
                    if(e.getAttribute("type").equals("normal")){
                        THEME.setOS_KEYWORD_TEXT(new Font(e.getAttribute("family"), Font.PLAIN, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("bold")){
                        THEME.setOS_KEYWORD_TEXT(new Font(e.getAttribute("family"), Font.BOLD, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("italics")){
                        THEME.setOS_KEYWORD_TEXT(new Font(e.getAttribute("family"), Font.ITALIC, Integer.parseInt(e.getAttribute("size"))));
                    }
                    THEME.setOS_KEYWORD_TEXT_COLOR(Color.getColor(e.getAttribute("color")));
                }else if (e.getAttribute("name").equals("quotetext")){
                    if(e.getAttribute("type").equals("normal")){
                        THEME.setQUOTE_TEXT(new Font(e.getAttribute("family"), Font.PLAIN, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("bold")){
                        THEME.setQUOTE_TEXT(new Font(e.getAttribute("family"), Font.BOLD, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("italics")){
                        THEME.setQUOTE_TEXT(new Font(e.getAttribute("family"), Font.ITALIC, Integer.parseInt(e.getAttribute("size"))));
                    }
                    THEME.setQUOTE_TEXT_COLOR((Color.getColor(e.getAttribute("color"))));
                }else if (e.getAttribute("name").equals("comment")){
                    if(e.getAttribute("type").equals("normal")){
                        THEME.setCOMMENT_TEXT(new Font(e.getAttribute("family"), Font.PLAIN, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("bold")){
                        THEME.setCOMMENT_TEXT(new Font(e.getAttribute("family"), Font.BOLD, Integer.parseInt(e.getAttribute("size"))));
                    }else if(e.getAttribute("type").equals("italics")){
                        THEME.setCOMMENT_TEXT(new Font(e.getAttribute("family"), Font.ITALIC, Integer.parseInt(e.getAttribute("size"))));
                    }

                    THEME.setCOMMENT_TEXT_COLOR(Color.getColor(e.getAttribute("color")));
                }
            }

        }catch(Exception e){
            System.out.println("Failed to load theme '"+THEME.getNAME()+"'");
        }
    }
}
