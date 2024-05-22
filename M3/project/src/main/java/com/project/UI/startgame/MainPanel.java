package com.project.UI.startgame;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.Border;

import com.project.UI.util.fonts.Fonts;
import com.project.UI.util.swing_elements.BorderedLabel;
import com.project.UI.util.swing_elements.PFrontpageButton;

import oracle.net.aso.f;

public class MainPanel extends JPanel {
    
    Image backgroundImage;

    // JPanel 
    PFrontpageButton closeButton;
    PFrontpageButton newGameButton;

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
        buttonPanel.setOpaque(false);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            closeButton = new PFrontpageButton("Close game");
            closeButton.setAlignmentX(CENTER_ALIGNMENT);
            newGameButton = new PFrontpageButton("New game");
            newGameButton.setAlignmentX(CENTER_ALIGNMENT);

        buttonPanel.add(newGameButton);
        buttonPanel.add(closeButton);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        BorderedLabel titleLabel = new BorderedLabel("Civilization");
        titleLabel.setForeground(new Color(255,255,255));
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setFont(Fonts.getInstance().rusticFont.deriveFont(Font.BOLD,50));

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                opacity += 0.03f; 
                if (opacity >= 1.0f) {
                    opacity = 1.0f;
                    ((Timer)e.getSource()).stop(); 
                }
                titleLabel.setForeground(new Color(1f, 0.8f, 0.1f, opacity)); 
            }
        });
        timer.start();
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalGlue());
        
        add(centerPanel,BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
