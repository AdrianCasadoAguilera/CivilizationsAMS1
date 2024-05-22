package com.project.UI.util.swing_elements;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class BorderedLabel extends JLabel {

    public BorderedLabel(String text) {
        super(text);
        setFont(new Font("Serif", Font.BOLD, 50));
        setForeground(Color.WHITE); // Color del texto
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        String text = getText();
        Font font = getFont();
        FontRenderContext frc = g2d.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, text);
        Shape textShape = gv.getOutline();

        // Centrar el texto
        Rectangle bounds = textShape.getBounds();
        int x = (getWidth() - bounds.width) / 2;
        int y = (getHeight() - bounds.height) / 2 + bounds.height;

        // Dibujar el borde negro
        g2d.translate(x, y);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2.5f));
        g2d.draw(textShape);

        // Dibujar el texto blanco
        g2d.setColor(getForeground());
        g2d.fill(textShape);

        g2d.dispose();
    }
}
