package com.project.UI.util.fonts;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

public class Fonts {
    private static Fonts instance;

    public Font rusticFont;
    public Font rusticTitleFont;
    public Font itemsFont;

    private Fonts() {
        try {
            InputStream is = getClass().getResourceAsStream("/com/project/UI/util/fonts/rustic.ttf");
            rusticFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(15f);
            registerFont(rusticFont);
        } catch (Exception e) {
            System.out.println("Error obtaining rustic.ttf font");
            e.printStackTrace();
        }
        
        try {
            InputStream is = getClass().getResourceAsStream("/com/project/UI/util/fonts/items.ttf");
            itemsFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(25f);
            registerFont(itemsFont);
        } catch (Exception e) {
            System.out.println("Error obtaining items.ttf font");
            e.printStackTrace();
        }
        
        try {
            InputStream is = getClass().getResourceAsStream("/com/project/UI/util/fonts/rustic.ttf");
            rusticTitleFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(35f);
            registerFont(rusticTitleFont);
        } catch (Exception e) {
            System.out.println("Error obtaining rustic.ttf font for title");
            e.printStackTrace();
        }
    }

    private void registerFont(Font font) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
    }

    public static Fonts getInstance() {
        if (instance == null) {
            instance = new Fonts();
        }
        return instance;
    }
}
