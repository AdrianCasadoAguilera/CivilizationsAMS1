package com.project.UI.util.fonts;

import java.awt.Font;
import java.io.File;
import java.net.URL;

public class Fonts {
    private static Fonts instance;

    public Font rusticFont;

    private Fonts(){
        try{
            URL url = getClass().getResource("/com/project/UI/util/fonts/rustic.ttf");
            rusticFont = Font.createFont(Font.TRUETYPE_FONT, new File(url.getPath())).deriveFont(15f);
        }catch(Exception e){
            System.out.println("Error obtaining fonts");
        }
    }

    public static Fonts getInstance(){
        if(instance == null){
            return new Fonts();
        }else{
            return instance;
        }
    }
   
}
