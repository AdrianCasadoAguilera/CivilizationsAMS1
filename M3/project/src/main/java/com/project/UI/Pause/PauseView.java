package com.project.UI.Pause;

import java.awt.*;

import javax.swing.*;
import com.project.UI.util.swing_elements.*;
import java.awt.Color;
import javax.swing.JLabel;

public class PauseView extends JPanel {
    
    public PWhiteButton resumeButton;
    public PWhiteButton exitButton;

    public PauseView(){
        setLayout(new BorderLayout());

        initComponents();
    }

    private void initComponents(){
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        for (int i = 0; i < 10; i++) {
            contentPanel.add(new JLabel(""), gbc);
            gbc.gridy++;
        }
        resumeButton = new PWhiteButton("Resume");
        resumeButton.setAlignmentX(CENTER_ALIGNMENT);
        
        exitButton = new PWhiteButton("Exit game");
        exitButton.setAlignmentX(CENTER_ALIGNMENT);

        contentPanel.add(resumeButton,gbc);
        gbc.gridy++;
        contentPanel.add(exitButton,gbc);
        for (int i = 0; i < 10; i++) {
            contentPanel.add(new JLabel(""), gbc);
            gbc.gridy++;
        }
        add(contentPanel,BorderLayout.CENTER);
    }
}
