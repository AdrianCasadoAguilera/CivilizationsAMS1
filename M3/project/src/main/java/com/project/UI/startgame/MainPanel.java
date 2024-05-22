package com.project.UI.startgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MainPanel extends JPanel {
    
    Image backgroundImage;

    JButton closeButton;
    JButton newGameButton;

    public MainPanel(){
        backgroundImage = new ImageIcon(getClass().getResource("/com/project/UI/src/startImage.jpg")).getImage();

        setLayout(new BorderLayout());

        setElements();
    }

    private void setElements(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
            closeButton = new JButton("Close game");
            setButtonStyle(closeButton);
            newGameButton = new JButton("New game");
            setButtonStyle(newGameButton);

        buttonsPanel.add(closeButton);
        buttonsPanel.add(newGameButton);
        
        add(buttonsPanel,BorderLayout.EAST);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void setButtonStyle(JButton button){
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(new Color(0,0,0));
        button.setFont(new Font("Arial",Font.PLAIN,30));
        button.addMouseListener(setHover(button));
    }

    private MouseListener setHover(JButton button){
        return new MouseListener() {
            @Override public void mouseClicked(MouseEvent arg0) {}
            @Override
            public void mouseEntered(MouseEvent arg0) {
                button.setFont(new Font("Arial",Font.BOLD,button.getFont().getSize()));
            }
            @Override
            public void mouseExited(MouseEvent arg0) {
                button.setFont(new Font("Arial",Font.PLAIN,button.getFont().getSize()));
            }
            @Override public void mousePressed(MouseEvent arg0) {}
            @Override public void mouseReleased(MouseEvent arg0) {}
        };
    }
}
