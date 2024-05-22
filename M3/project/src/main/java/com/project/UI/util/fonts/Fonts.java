package com.project.UI.util.fonts;

import java.awt.Font;
import java.io.File;

public class Fonts {
    private static Fonts instance;

    public Font rusticFont;

    private Fonts(){
        try{
            rusticFont = Font.createFont(Font.TRUETYPE_FONT, new File("./project/src/main/java/com/project/UI/util/fonts/rustic.ttf")).deriveFont(15f);
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
