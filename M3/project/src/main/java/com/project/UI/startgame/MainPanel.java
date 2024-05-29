package com.project.UI.startgame;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import com.project.Saves;
import com.project.UI.util.clips.Clips;
import com.project.UI.util.fonts.Fonts;
import com.project.UI.util.swing_elements.BorderedLabel;
import com.project.UI.util.swing_elements.PFrontpageButton;

public class MainPanel extends JPanel {
    
    Clip clip;
    Image backgroundImage;

    // JPanel 
    PFrontpageButton closeButton;
    PFrontpageButton newGameButton;
    PFrontpageButton continueButton;

    private float opacity = 0.0f;

    public MainPanel(){
        backgroundImage = new ImageIcon(getClass().getResource("/com/project/UI/src/startGIF.gif")).getImage().getScaledInstance(614, 300, Image.SCALE_DEFAULT);
        new Timer(4000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundImage = new ImageIcon(getClass().getResource("/com/project/UI/src/startImage.jpg")).getImage().getScaledInstance(614, 300, Image.SCALE_DEFAULT);
                ((Timer) e.getSource()).stop();
            }
            
        }).start();

        setMusic();

        setLayout(new BorderLayout());

        setElements();
    }

    private void setElements(){

        JPanel buttonPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2d.dispose();
            }
        };

        buttonPanel.setMaximumSize(new Dimension(200,400));
        buttonPanel.setOpaque(false);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            closeButton = new PFrontpageButton("Close game");
            closeButton.setAlignmentX(CENTER_ALIGNMENT);
            newGameButton = new PFrontpageButton("New Game");
            newGameButton.setAlignmentX(CENTER_ALIGNMENT);
            continueButton = new PFrontpageButton("Continue");
            continueButton.setAlignmentX(CENTER_ALIGNMENT);

        buttonPanel.add(newGameButton);
        if(Saves.getInstance().GetSaveCount()>0){
            buttonPanel.add(continueButton);
        }
        buttonPanel.add(closeButton);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        BorderedLabel titleLabel = new BorderedLabel("Civilization");
        titleLabel.setForeground(new Color(255,255,255));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setFont(Fonts.getInstance().rusticFont.deriveFont(Font.BOLD,50));

        new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.03f; 
                if (opacity >= 1.0f) {
                    opacity = 1.0f;
                    ((Timer)e.getSource()).stop(); 
                }
                titleLabel.setForeground(new Color(1f, 0.8f, 0.1f, opacity)); 
            }
        }).start();
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalGlue());
        
        add(centerPanel,BorderLayout.CENTER);
    }

    private void setMusic(){
        Clips.playAudio(Clips.START);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
