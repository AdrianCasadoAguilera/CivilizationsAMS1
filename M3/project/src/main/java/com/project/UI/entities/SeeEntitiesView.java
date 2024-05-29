package com.project.UI.entities;

import com.project.Main;
import com.project.UI.util.fonts.*;
import com.project.UI.util.swing_elements.BorderedLabel;
import com.project.UI.util.swing_elements.PLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;

public class SeeEntitiesView extends JPanel {

    public JLabel smithyIconLabel;
    public JLabel smithyQuantity;
    public JLabel carpentryIconLabel;
    public JLabel carpentryQuantity;
    public JLabel farmIconLabel;
    public JLabel farmQuantity;
    public JLabel magicTowerIconLabel;
    public JLabel magicTowerQuantity;
    public JLabel churchIconLabel;
    public JLabel churchQuantity;

    public JLabel swordsmanIconLabel;
    public JLabel swordsmanQuantity;
    public JLabel spearmanIconLabel;
    public JLabel spearmanQuantity;
    public JLabel crossbowIconLabel;
    public JLabel crossbowQuantity;
    public JLabel cannonIconLabel;
    public JLabel cannonQuantity;
    public JLabel arrowTowerIconLabel;
    public JLabel arrowTowerQuantity;
    public JLabel catapultIconLabel;
    public JLabel catapultQuantity;
    public JLabel rocketLauncherIconLabel;
    public JLabel rocketLauncherQuantity;
    public JLabel magicianIconLabel;
    public JLabel magicianQuantity;
    public JLabel priestIconLabel;
    public JLabel priestQuantity;

    public SeeEntitiesView(){
        BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(layout);
        setOpaque(false);

        BorderedLabel titleLabel = new BorderedLabel(Main.saves.GetSaveNames()[Main.ActiveSave]+"'s Civilization"){
            @Override
            public void setFont(Font arg0) {
                super.setFont(arg0.deriveFont(30f));
            }
        };
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        add(titleLabel);

        initComponents();
    }

    private void initComponents(){
        initImages();
        initBuildings();
    }

    private void initImages(){
        String linkString = "/com/project/UI/src/";
        URL link;
        ImageIcon icon;

        smithyIconLabel = new JLabel();
        link = getClass().getResource(linkString+"smithy_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        smithyIconLabel.setIcon(icon);

        carpentryIconLabel = new JLabel();
        link = getClass().getResource(linkString+"carpentry_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        carpentryIconLabel.setIcon(icon);

        farmIconLabel = new JLabel();
        link = getClass().getResource(linkString+"farm_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        farmIconLabel.setIcon(icon);

        magicTowerIconLabel = new JLabel();
        link = getClass().getResource(linkString+"magic_tower_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        magicTowerIconLabel.setIcon(icon);

        churchIconLabel = new JLabel();
        link = getClass().getResource(linkString+"church_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        churchIconLabel.setIcon(icon);

        swordsmanIconLabel = new JLabel();
        link = getClass().getResource(linkString+"swordsman.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        swordsmanIconLabel.setIcon(icon);

        spearmanIconLabel = new JLabel();
        link = getClass().getResource(linkString+"spearman.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        spearmanIconLabel.setIcon(icon);

        crossbowIconLabel = new JLabel();
        link = getClass().getResource(linkString+"crossbow.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        crossbowIconLabel.setIcon(icon);

        cannonIconLabel = new JLabel();
        link = getClass().getResource(linkString+"cannon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        cannonIconLabel.setIcon(icon);
        
        arrowTowerIconLabel = new JLabel();
        link = getClass().getResource(linkString+"arrow_tower.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        arrowTowerIconLabel.setIcon(icon);

        catapultIconLabel = new JLabel();
        link = getClass().getResource(linkString+"catapult.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        catapultIconLabel.setIcon(icon);

        rocketLauncherIconLabel = new JLabel();
        link = getClass().getResource(linkString+"rocket_launcher.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        rocketLauncherIconLabel.setIcon(icon);

        magicianIconLabel = new JLabel();
        link = getClass().getResource(linkString+"magician.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        magicianIconLabel.setIcon(icon);

        priestIconLabel = new JLabel();
        link = getClass().getResource(linkString+"priest.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        priestIconLabel.setIcon(icon);
    }

    private void initBuildings(){
        JPanel buildingsTitledPanel = new JPanel();
        buildingsTitledPanel.setLayout(new BoxLayout(buildingsTitledPanel, BoxLayout.Y_AXIS));
        buildingsTitledPanel.setOpaque(false);

            JPanel buildingsTitle = new JPanel();
            buildingsTitle.setAlignmentX(CENTER_ALIGNMENT);
            buildingsTitle.setOpaque(false);
            buildingsTitle.add(new BorderedLabel("Your buildings"){
                @Override
                public void setFont(Font arg0) {
                    super.setFont(arg0.deriveFont(20f));
                }
            });

            JPanel buildingsPanel = new JPanel();
            buildingsPanel.setBackground(new Color(103, 103, 103, 100));
            buildingsPanel.setOpaque(true);

            buildingsPanel.add(smithyIconLabel);
                smithyQuantity = new JLabel("0");
                smithyQuantity.setForeground(Color.WHITE);
                smithyQuantity.setFont(Fonts.getInstance().itemsFont);
            buildingsPanel.add(smithyQuantity);

            buildingsPanel.add(carpentryIconLabel);
                carpentryQuantity = new JLabel("0");
                carpentryQuantity.setForeground(Color.WHITE);
                carpentryQuantity.setFont(Fonts.getInstance().itemsFont);
            buildingsPanel.add(carpentryQuantity);

            buildingsPanel.add(farmIconLabel);
                farmQuantity = new JLabel("0");
                farmQuantity.setForeground(Color.WHITE);
                farmQuantity.setFont(Fonts.getInstance().itemsFont);
            buildingsPanel.add(farmQuantity);

            buildingsPanel.add(magicTowerIconLabel);
                magicTowerQuantity = new JLabel("0");
                magicTowerQuantity.setForeground(Color.WHITE);
                magicTowerQuantity.setFont(Fonts.getInstance().itemsFont);
            buildingsPanel.add(magicTowerQuantity);

            buildingsPanel.add(churchIconLabel);
                churchQuantity = new JLabel("0");
                churchQuantity.setForeground(Color.WHITE);
                churchQuantity.setFont(Fonts.getInstance().itemsFont);
            buildingsPanel.add(churchQuantity);

        buildingsTitledPanel.add(buildingsTitle);
        buildingsTitledPanel.add(buildingsPanel);

        

        JPanel armyTitledPanel = new JPanel();
        armyTitledPanel.setLayout(new BoxLayout(armyTitledPanel, BoxLayout.Y_AXIS));
        armyTitledPanel.setOpaque(false);

        JPanel armyTitle = new JPanel();
            armyTitle.setOpaque(false);
            armyTitle.setAlignmentX(CENTER_ALIGNMENT);
            armyTitle.add(new BorderedLabel("Your army"){
                @Override
                public void setFont(Font arg0) {
                    super.setFont(arg0.deriveFont(20f));
                }
            });

            JPanel armyPanel = new JPanel();
            armyPanel.setBackground(new Color(103, 103, 103,100));
            armyPanel.setOpaque(true);

            armyPanel.add(swordsmanIconLabel);
                swordsmanQuantity = new JLabel("0");
                swordsmanQuantity.setForeground(Color.WHITE);
                swordsmanQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(swordsmanQuantity);

            armyPanel.add(spearmanIconLabel);
                spearmanQuantity = new JLabel("0");
                spearmanQuantity.setForeground(Color.WHITE);
                spearmanQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(spearmanQuantity);

            armyPanel.add(crossbowIconLabel);
                crossbowQuantity = new JLabel("0");
                crossbowQuantity.setForeground(Color.WHITE);
                crossbowQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(crossbowQuantity);

            armyPanel.add(cannonIconLabel);
                cannonQuantity = new JLabel("0");
                cannonQuantity.setForeground(Color.WHITE);
                cannonQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(cannonQuantity);
            
            armyPanel.add(arrowTowerIconLabel);
                arrowTowerQuantity = new JLabel("0");
                arrowTowerQuantity.setForeground(Color.WHITE);
                arrowTowerQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(arrowTowerQuantity);

            armyPanel.add(catapultIconLabel);
                catapultQuantity = new JLabel("0");
                catapultQuantity.setForeground(Color.WHITE);
                catapultQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(catapultQuantity);

            armyPanel.add(rocketLauncherIconLabel);
                rocketLauncherQuantity = new JLabel("0");
                rocketLauncherQuantity.setForeground(Color.WHITE);
                rocketLauncherQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(rocketLauncherQuantity);

            armyPanel.add(magicianIconLabel);
                magicianQuantity = new JLabel("0");
                magicianQuantity.setForeground(Color.WHITE);
                magicianQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(magicianQuantity);

            armyPanel.add(priestIconLabel);
                priestQuantity = new JLabel("0");
                priestQuantity.setForeground(Color.WHITE);
                priestQuantity.setFont(Fonts.getInstance().itemsFont);
            armyPanel.add(priestQuantity);

            armyPanel.setLayout(new GridLayout(3,4));
        // armyPanel.setBorder(BorderFactory.createTitledBorder("Your army"));
        armyTitledPanel.add(armyTitle);
        armyTitledPanel.add(armyPanel);

        add(buildingsTitledPanel);
        add(armyTitledPanel);
    }
}
