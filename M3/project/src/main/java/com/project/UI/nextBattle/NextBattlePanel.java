package com.project.UI.nextBattle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class NextBattlePanel extends JPanel {

    private Image backgroundImage;
    
    public NextBattlePanel(){
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.BLACK));
        setBackground(Color.LIGHT_GRAY);

        initBackgroundImage();
    }

    private void initBackgroundImage(){
        URL backgroundURL = getClass().getResource("/com/project/UI/src/next_battle_background.png");
        backgroundImage = new ImageIcon(backgroundURL).getImage();
    }

    @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                // Dibujar la imagen de fondo
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
}
