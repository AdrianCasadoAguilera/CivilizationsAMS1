package com.project.UI.util.swing_elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

import javax.swing.ImageIcon;

public class PlainButton extends JButton {

    private int cornerRadius = 15; // Radio de las esquinas redondeadas

    public PlainButton(ImageIcon icon) {
        super.setIcon(icon);

        setBackground(new Color(173,216,230));
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false); 
        setContentAreaFilled(false); 

        addMouseListener(setHover());
    }

    private MouseAdapter setHover(){
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                setBackground(new Color(34,113,179));
            }
            @Override
            public void mouseExited(MouseEvent arg0) {
                setBackground(new Color(173,216,230));
            }
            @Override
            public void mousePressed(MouseEvent arg0){
                setBackground(new Color(34,113,179));
            }
            @Override
            public void mouseReleased(MouseEvent arg0){
                setBackground(new Color(173,216,230));
            }
        };
    }    

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No dibujar el borde
    }
}
