package com.project.UI.entities;

import com.project.Civilization;
import com.project.Main;
import com.project.UI.*;
import com.project.UI.util.fonts.*;
import com.project.UI.util.swing_elements.PLabel;

import java.awt.Color;
import java.awt.FlowLayout;
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
    }
}
