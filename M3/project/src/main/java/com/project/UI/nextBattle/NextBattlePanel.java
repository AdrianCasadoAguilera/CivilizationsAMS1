package com.project.UI.nextBattle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.project.UI.util.fonts.Fonts;
import com.project.UI.util.swing_elements.PLabel;

public class NextBattlePanel extends JPanel {

    private Image backgroundImage;
    public JLabel timeToBattleLabel;
    
    public NextBattlePanel(){
        setLayout(new FlowLayout());
        setAlignmentX(CENTER_ALIGNMENT);
        setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.BLACK));
        setBackground(Color.LIGHT_GRAY);

        PLabel title = new PLabel("Next battle in: ");
        title.setAlignmentX(CENTER_ALIGNMENT);
        timeToBattleLabel = new JLabel("000");
        timeToBattleLabel.setFont(Fonts.getInstance().itemsFont);
        timeToBattleLabel.setForeground(Color.WHITE);
        timeToBattleLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        add(title);
        add(timeToBattleLabel);

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
