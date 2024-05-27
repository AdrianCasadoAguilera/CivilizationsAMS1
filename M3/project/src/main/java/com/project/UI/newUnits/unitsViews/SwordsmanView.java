package com.project.UI.newUnits.unitsViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;

import com.project.UI.util.swing_elements.PButton;
import com.project.UI.util.swing_elements.PLabel;

public class SwordsmanView extends JPanel {

    public PButton returnButton;

    public SwordsmanView(){
        setLayout(new BorderLayout());

        setTitle();
        initButtons();
    }

    private void setTitle(){
        JPanel titlePanel = new JPanel();
            BoxLayout titleLayout = new BoxLayout(titlePanel, BoxLayout.X_AXIS);
            titlePanel.setLayout(titleLayout);
            titlePanel.setBackground(Color.DARK_GRAY);
            titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JPanel photoPanel = new JPanel();
            photoPanel.setOpaque(false);
                URL link = getClass().getResource("/com/project/UI/src/swordsman.png");
                Icon photoIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                JLabel photoLabel = new JLabel();
                    photoLabel.setIcon(photoIcon);
            photoPanel.add(photoLabel);

            JPanel nameDescPanel = new JPanel();
                nameDescPanel.setOpaque(false);
                BoxLayout nameDescLayout = new BoxLayout(nameDescPanel, BoxLayout.Y_AXIS);
                nameDescPanel.setLayout(nameDescLayout);

                PLabel name = new PLabel("Swordsman");
                name.setFont(name.getFont().deriveFont(50f));
                String descString = "sadijidabsjasdskjpnaib djasdjasnd ja dhasduand asdjasdjasb dasd";
                JLabel description = new JLabel(descString);
                description.setForeground(Color.white);
            nameDescPanel.add(name);
            nameDescPanel.add(description);
        titlePanel.add(photoPanel);
        titlePanel.add(nameDescPanel);

        add(titlePanel,BorderLayout.NORTH);
    }

    private void initButtons(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonsPanel.setBackground(Color.lightGray);
        returnButton = new PButton("Go back");
        buttonsPanel.add(returnButton);

        add(buttonsPanel,BorderLayout.SOUTH);
    }
}
