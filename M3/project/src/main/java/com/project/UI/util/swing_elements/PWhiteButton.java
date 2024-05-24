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

public class PWhiteButton extends JButton {

    private String originalTxt;

    public PWhiteButton(String txt){
        super(txt);

        originalTxt = txt;

        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setForeground(new Color(185,185,185));
        setFont(Fonts.getInstance().rusticFont);
        setBackground(new Color(126,214,108));

        addMouseListener(setHover());
    }

    private MouseAdapter setHover(){
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                // setFont(Fonts.getInstance().rusticFont.deriveFont(Font.BOLD,15));
                setText("> "+originalTxt+" <");
                setForeground(new Color(255,255,255));
                setBorderPainted(false);
            }
            @Override
            public void mouseExited(MouseEvent arg0) {
                // setFont(Fonts.getInstance().rusticFont);
                setText(originalTxt);
                setForeground(new Color(185,185,185));
                setBorderPainted(false);
            }
        };
    }
    
}
