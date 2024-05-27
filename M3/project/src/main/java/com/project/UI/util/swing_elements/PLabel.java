package com.project.UI.util.swing_elements;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import com.project.UI.util.fonts.*;

public class PLabel extends JLabel {
    

    public PLabel(String txt){
        super(txt);
        Font font = Fonts.getInstance().rusticFont;
        font.deriveFont(35f);
        setForeground(Color.WHITE);
        setFont(font);
    }
}
