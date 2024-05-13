package com.project.UI;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

public class ResourcesMenu extends JPanel {
    // private static ResourcesMenu instance;
    private Model model;

    public JLabel foodLabel;
    public JLabel woodLabel;
    public JLabel ironLabel;
    public JLabel manaLabel;

    private ImageIcon woodIcon;
    private ImageIcon foodIcon;
    private ImageIcon ironIcon;
    private ImageIcon manaIcon;
    private JLabel foodIconLabel;
    private JLabel woodIconLabel;
    private JLabel ironIconLabel;
    private JLabel manaIconLabel;

    private JPanel info;

    public ResourcesMenu(Model model){
        this.model = model;

        info = new JPanel();
        initializeLabels();
        uploadImages();
    }

    private void initializeLabels(){
        foodIconLabel = new JLabel();
        foodLabel = new JLabel();
        woodIconLabel = new JLabel();
        woodLabel = new JLabel();
        ironIconLabel = new JLabel();
        ironLabel = new JLabel();
        manaIconLabel = new JLabel();
        manaLabel = new JLabel();
    }

    private void uploadImages() {
        String resourcesPath = "/com/project/UI/resources_food.png";
        foodIcon = new ImageIcon(new ImageIcon(getClass().getResource(resourcesPath)).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        /*resourcesPath = "/com/project/UI/resources_wood.png";
        woodIcon = new ImageIcon(getClass().getResource(resourcesPath)).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        resourcesPath = "/com/project/UI/resources_iron.png";
        ironIcon = new ImageIcon(getClass().getResource(resourcesPath)).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        resourcesPath = "/com/project/UI/resources_mana.png";
        manaIcon = new ImageIcon(getClass().getResource(resourcesPath)).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);*/
    }
    public void updateResources() {
        foodLabel.setText(String.valueOf(model.food));
        woodLabel.setText(String.valueOf(model.wood));
        ironLabel.setText(String.valueOf(model.iron));
        manaLabel.setText(String.valueOf(model.mana));

        foodIconLabel.setIcon(foodIcon);
        woodIconLabel.setIcon(woodIcon);
        ironIconLabel.setIcon(ironIcon);
        manaIconLabel.setIcon(manaIcon);
        info.add(foodIconLabel);
        info.add(foodLabel);
        info.add(woodIconLabel);
        info.add(woodLabel);
        info.add(ironIconLabel);
        info.add(ironLabel);
        info.add(manaIconLabel);
        info.add(manaLabel);
        add(info);
    }
}