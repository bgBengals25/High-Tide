package com.hightide.highlight;

import com.hightide.highlight.syntax.BashHighlighter;
import com.hightide.highlight.syntax.theme.Theme;
import com.hightide.ui.EditorArea;

/**
 * Created by peter on 8/31/15.
 */
public class HighlightManager {

    public static void bindHighlighter(String hl, EditorArea ea, Theme th){
        if (hl.equals("Bash")){
            BashHighlighter bh = new BashHighlighter(ea, th);
        }
    }
}
