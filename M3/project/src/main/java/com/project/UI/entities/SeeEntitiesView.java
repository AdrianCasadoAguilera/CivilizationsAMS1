package com.project.UI.entities;

import com.project.UI.*;

import java.awt.Image;
import java.io.File;

import javax.swing.*;

public class SeeEntitiesView extends JPanel {

    JLabel woodImageLabel;
    JLabel woodInfoLabel;
    JLabel foodImageLabel;
    JLabel foodInfoLabel;
    JLabel ironImageLabel;
    JLabel ironInfoLabel;
    JLabel manaImageLabel;    
    JLabel manaInfoLabel;

    public SeeEntitiesView(){
        setLayout(new SpringLayout());

        initComponents();
    }

    private void initComponents(){
        initResources();
    }

    private void initResources(){
        JPanel resourcesPanel = new JPanel();
        woodImageLabel = new JLabel();
            ImageIcon woodImage = new ImageIcon(new ImageIcon(System.getProperty("user.dir").replace("\\","/").replace("/M3","").replace("/project","")+"/M3/project/src/main/java/com/project/UI/src/resources_wood.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            woodImageLabel.setIcon(woodImage);
            woodInfoLabel = new JLabel("Prueba");
        resourcesPanel.add(woodImageLabel);
        resourcesPanel.add(woodInfoLabel);
        foodImageLabel = new JLabel();
            ImageIcon foodImage = new ImageIcon(new ImageIcon(System.getProperty("user.dir").replace("\\","/").replace("/M3","").replace("/project","")+"/M3/project/src/main/java/com/project/UI/src/resources_food.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            foodImageLabel.setIcon(foodImage);
            foodInfoLabel = new JLabel("Prueba");
        resourcesPanel.add(foodImageLabel);
        resourcesPanel.add(foodInfoLabel);

        add(resourcesPanel);
    }
}
