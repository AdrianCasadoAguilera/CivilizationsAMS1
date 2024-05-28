package com.project.UI.entities;

import com.project.Civilization;
import com.project.Main;
import com.project.UI.*;
import com.project.UI.util.fonts.*;
import com.project.UI.util.swing_elements.PLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
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

        PLabel titleLabel = new PLabel(Main.saves.GetSaveNames()[Main.ActiveSave]+"'s Civilization");
        titleLabel.setForeground(Color.BLACK);
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
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        smithyIconLabel.setIcon(icon);

        carpentryIconLabel = new JLabel();
        link = getClass().getResource(linkString+"carpentry_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        carpentryIconLabel.setIcon(icon);

        farmIconLabel = new JLabel();
        link = getClass().getResource(linkString+"farm_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        farmIconLabel.setIcon(icon);

        magicTowerIconLabel = new JLabel();
        link = getClass().getResource(linkString+"magic_tower_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        magicTowerIconLabel.setIcon(icon);

        churchIconLabel = new JLabel();
        link = getClass().getResource(linkString+"church_icon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        churchIconLabel.setIcon(icon);

        swordsmanIconLabel = new JLabel();
        link = getClass().getResource(linkString+"swordsman.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        swordsmanIconLabel.setIcon(icon);

        spearmanIconLabel = new JLabel();
        link = getClass().getResource(linkString+"spearman.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        spearmanIconLabel.setIcon(icon);

        crossbowIconLabel = new JLabel();
        link = getClass().getResource(linkString+"crossbow.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        crossbowIconLabel.setIcon(icon);

        cannonIconLabel = new JLabel();
        link = getClass().getResource(linkString+"cannon.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        cannonIconLabel.setIcon(icon);
        
        arrowTowerIconLabel = new JLabel();
        link = getClass().getResource(linkString+"arrow_tower.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        arrowTowerIconLabel.setIcon(icon);

        catapultIconLabel = new JLabel();
        link = getClass().getResource(linkString+"catapult.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        catapultIconLabel.setIcon(icon);

        rocketLauncherIconLabel = new JLabel();
        link = getClass().getResource(linkString+"rocket_launcher.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        rocketLauncherIconLabel.setIcon(icon);

        magicianIconLabel = new JLabel();
        link = getClass().getResource(linkString+"magician.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        magicianIconLabel.setIcon(icon);

        priestIconLabel = new JLabel();
        link = getClass().getResource(linkString+"priest.png");
        icon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        priestIconLabel.setIcon(icon);
    }

    private void initBuildings(){
        JPanel buildingsPanel = new JPanel();

        buildingsPanel.add(smithyIconLabel);
            smithyQuantity = new JLabel("0");
            smithyQuantity.setFont(Fonts.getInstance().itemsFont);
        buildingsPanel.add(smithyQuantity);

        buildingsPanel.add(carpentryIconLabel);
            carpentryQuantity = new JLabel("0");
            carpentryQuantity.setFont(Fonts.getInstance().itemsFont);
        buildingsPanel.add(carpentryQuantity);

        buildingsPanel.add(farmIconLabel);
            farmQuantity = new JLabel("0");
            farmQuantity.setFont(Fonts.getInstance().itemsFont);
        buildingsPanel.add(farmQuantity);

        buildingsPanel.add(magicTowerIconLabel);
            magicTowerQuantity = new JLabel("0");
            magicTowerQuantity.setFont(Fonts.getInstance().itemsFont);
        buildingsPanel.add(magicTowerQuantity);

        buildingsPanel.add(churchIconLabel);
            churchQuantity = new JLabel("0");
            churchQuantity.setFont(Fonts.getInstance().itemsFont);
        buildingsPanel.add(churchQuantity);

        buildingsPanel.setBorder(BorderFactory.createTitledBorder("Buildings"));

        add(buildingsPanel);

        JPanel armyPanel = new JPanel();

        armyPanel.add(swordsmanIconLabel);
            swordsmanQuantity = new JLabel("0");
            swordsmanQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(swordsmanQuantity);

        armyPanel.add(spearmanIconLabel);
            spearmanQuantity = new JLabel("0");
            spearmanQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(spearmanQuantity);

        armyPanel.add(crossbowIconLabel);
            crossbowQuantity = new JLabel("0");
            crossbowQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(crossbowQuantity);

        armyPanel.add(cannonIconLabel);
            cannonQuantity = new JLabel("0");
            cannonQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(cannonQuantity);
        
        armyPanel.add(arrowTowerIconLabel);
            arrowTowerQuantity = new JLabel("0");
            arrowTowerQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(arrowTowerQuantity);

        armyPanel.add(catapultIconLabel);
            catapultQuantity = new JLabel("0");
            catapultQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(catapultQuantity);

        armyPanel.add(rocketLauncherIconLabel);
            rocketLauncherQuantity = new JLabel("0");
            rocketLauncherQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(rocketLauncherQuantity);

        armyPanel.add(magicianIconLabel);
            magicianQuantity = new JLabel("0");
            magicianQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(magicianQuantity);

        armyPanel.add(priestIconLabel);
            priestQuantity = new JLabel("0");
            priestQuantity.setFont(Fonts.getInstance().itemsFont);
        armyPanel.add(priestQuantity);

        armyPanel.setLayout(new GridLayout(3,4));
        armyPanel.setBorder(BorderFactory.createTitledBorder("Your army"));

        add(armyPanel);
    }
}
