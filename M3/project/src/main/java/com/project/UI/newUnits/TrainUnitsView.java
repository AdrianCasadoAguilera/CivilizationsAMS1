package com.project.UI.newUnits;

import com.project.UI.resources.*;
import com.project.UI.util.swing_elements.*;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class TrainUnitsView extends JPanel {

    public PButton returnButton;

    private ImageIcon swordsmanIcon;
    public RedButton swordsmanButton;
    private ImageIcon spearmanIcon;
    public RedButton spearmanButton;
    private ImageIcon crossbowIcon;
    public RedButton crossbowButton;
    private ImageIcon cannonIcon;
    public RedButton cannonButton;
 
    public TrainUnitsView(){
        setLayout(new BorderLayout());

        initNorth();
        initOptions();
        initButtons();
    }

    private void initNorth(){
        add(new ResourcesPanel(),BorderLayout.NORTH);
    }

    private void initOptions(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel attackUnitsPanel = new JPanel();
        attackUnitsPanel.setLayout(new GridLayout(2,2,20,20));
        attackUnitsPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        initImages();

        swordsmanButton = new RedButton(swordsmanIcon);
        spearmanButton = new RedButton(spearmanIcon);
        crossbowButton = new RedButton(crossbowIcon);
        cannonButton = new RedButton(cannonIcon);

        attackUnitsPanel.add(swordsmanButton);
        attackUnitsPanel.add(spearmanButton);
        attackUnitsPanel.add(crossbowButton);
        attackUnitsPanel.add(cannonButton);

        mainPanel.add(attackUnitsPanel);
        
        add(mainPanel,BorderLayout.CENTER);
    }

    private void initImages(){
        String linkString = "/com/project/UI/src/";
        URL link;

        link = getClass().getResource(linkString+"swordsman.png");
        swordsmanIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"spearman.png");
        spearmanIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"crossbow.png");
        crossbowIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"cannon.png");
        cannonIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
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
