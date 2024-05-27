package com.project.UI.util.swing_elements;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.project.UI.util.fonts.Fonts;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PButton extends JButton {

    public PButton(String txt){
        super(txt);

        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setForeground(new Color(85,85,85));
        setFont(Fonts.getInstance().rusticFont);
        setBackground(new Color(126,214,108));

        addMouseListener(setHover());
    }

    private MouseAdapter setHover(){
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                // setFont(Fonts.getInstance().rusticFont.deriveFont(Font.BOLD,15));
                setForeground(new Color(0,0,0));
                setBorderPainted(false);
            }
            @Override
            public void mouseExited(MouseEvent arg0) {
                // setFont(Fonts.getInstance().rusticFont);
                setForeground(new Color(85,85,85));
                setBorderPainted(false);
            }
        };
    }
    
}
