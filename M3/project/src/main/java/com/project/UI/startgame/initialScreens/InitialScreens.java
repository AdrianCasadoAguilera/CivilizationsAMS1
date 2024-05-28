package com.project.UI.startgame.initialScreens;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

import com.project.UI.util.swing_elements.PButton;
import com.project.UI.util.swing_elements.PLabel;

public class InitialScreens extends JFrame {

    JPanel cards;
    CardLayout cardLayout;
    Image bgImage;

    public InitialScreens(){
        super("Hello dear visitor");
        setResizable(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        bgImage = new ImageIcon(getClass().getResource("/com/project/UI/src/newPlayer.jpeg")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        int answer = setFirstView();
        setSecondView();

        add(cards);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int setFirstView(){
        JPanel firstPanel = new JPanel(new BorderLayout()){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(bgImage, 0, 0, this);
            }
        };

        PLabel initialText = new PLabel("Hi! What are you doing here?"){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25);

                g2.setColor(getBackground());
                g2.fill(roundedRectangle);

                super.paintComponent(g2);
                g2.dispose();
            };
        };
        initialText.setForeground(Color.BLACK);
        initialText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        initialText.setFont(initialText.getFont().deriveFont(initialText.getFont().getSize2D()+7));
        JPanel initialTextPanel = new JPanel();
        initialTextPanel.setOpaque(false);
        initialTextPanel.add(initialText);
        initialTextPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel optionsPanel = new JPanel();
            // optionsPanel.setOpaque(false);
            PButton justWalkingButton = new PButton("I was just going for a walk.");
                justWalkingButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                justWalkingButton.addActionListener(e->{
                    
                });
            PButton dontAskMeButton = new PButton("None of your business.");
                dontAskMeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

            optionsPanel.add(justWalkingButton);
            optionsPanel.add(dontAskMeButton);

        firstPanel.add(initialTextPanel,BorderLayout.NORTH);
        firstPanel.add(optionsPanel,BorderLayout.SOUTH);
        
        cards.add(firstPanel,"1");

        cardLayout.show(cards, "1");
    }

    private void setSecondView(int prev){
        
    }
}
