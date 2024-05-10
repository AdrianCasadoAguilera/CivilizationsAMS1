package com.project.UI;

import java.awt.*;
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

    private void uploadImages(){ 
        String dir = System.getProperty("user.dir")+"\\project\\src\\main\\java\\com\\project\\UI\\src\\";
        foodIcon = new ImageIcon(new ImageIcon(dir+"resources_food.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        woodIcon = new ImageIcon(new ImageIcon(dir+"resources_wood.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        ironIcon = new ImageIcon(new ImageIcon(dir+"resources_iron.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        manaIcon = new ImageIcon(new ImageIcon(dir+"resources_mana.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
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