package com.project.UI.newBuilding;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;

import com.project.Variables;
import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.PButton;
import com.project.UI.util.swing_elements.PlainButton;

public class NewBuildingView extends JPanel {
    
    public PButton returnButton;

    public PlainButton smithyButton;
    public PlainButton carpentryButton;
    public PlainButton farmButton;
    public PlainButton magicTowerButton;
    public PlainButton churchButton;

    public NewBuildingView(){
        setLayout(new BorderLayout());

        initNorth();
        initOptions();
        initButtons();
    }

    private void initNorth(){
        add(new ResourcesPanel(),BorderLayout.NORTH);
    }

    private void initOptions(){
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(3,2,20,20));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        String foodImageHtml = getClass().getResource("/com/project/UI/src/resources_food.png").toString();
        String woodImageHtml = getClass().getResource("/com/project/UI/src/resources_wood.png").toString();
        String ironImageHtml = getClass().getResource("/com/project/UI/src/resources_iron.png").toString();
        String manaImageHtml = getClass().getResource("/com/project/UI/src/resources_mana.png").toString();

        // Smithy
        URL smithyURL = getClass().getResource("/com/project/UI/src/smithy_icon.png");
        ImageIcon smithyIcon = new ImageIcon(new ImageIcon(smithyURL).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        smithyButton = new PlainButton(smithyIcon);
        String toolTipSmithy =    "<html><b>Smithy</b><br><table>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + foodImageHtml + "'/></td><td>"+Variables.FOOD_COST_SMITHY+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + woodImageHtml + "'/></td><td>"+Variables.WOOD_COST_SMITHY+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + ironImageHtml + "'/></td><td>"+Variables.IRON_COST_SMITHY+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + manaImageHtml + "'/></td><td>"+0+"</td>" +
                                "</tr>" +
                                "</table></html>";
        smithyButton.setToolTipText(toolTipSmithy);

        // Carpentry
        URL carpentryURL = getClass().getResource("/com/project/UI/src/carpentry_icon.png");
        ImageIcon carpentryIcon = new ImageIcon(new ImageIcon(carpentryURL).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        carpentryButton = new PlainButton(carpentryIcon);
        String toolTipCarpentry =    "<html><b>Carpentry</b><br><table>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + foodImageHtml + "'/></td><td>"+Variables.FOOD_COST_CARPENTRY+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + woodImageHtml + "'/></td><td>"+Variables.WOOD_COST_CARPENTRY+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + ironImageHtml + "'/></td><td>"+Variables.IRON_COST_CARPENTRY+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + manaImageHtml + "'/></td><td>"+0+"</td>" +
                                "</tr>" +
                                "</table></html>";
        carpentryButton.setToolTipText(toolTipCarpentry);

        // Farm
        URL farmURL = getClass().getResource("/com/project/UI/src/farm_icon.png");
        ImageIcon farmIcon = new ImageIcon(new ImageIcon(farmURL).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        farmButton = new PlainButton(farmIcon);
        String toolTipFarm =    "<html><b>Farm</b><br><table>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + foodImageHtml + "'/></td><td>"+Variables.FOOD_COST_FARM+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + woodImageHtml + "'/></td><td>"+Variables.WOOD_COST_FARM+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + ironImageHtml + "'/></td><td>"+Variables.IRON_COST_FARM+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + manaImageHtml + "'/></td><td>"+0+"</td>" +
                                "</tr>" +
                                "</table></html>";
        farmButton.setToolTipText(toolTipFarm);

        // Magic Tower
        URL magicTowerURL = getClass().getResource("/com/project/UI/src/magic_tower_icon.png");
        ImageIcon magicTowerIcon = new ImageIcon(new ImageIcon(magicTowerURL).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        magicTowerButton = new PlainButton(magicTowerIcon);
        String toolTipMagicTower =    "<html><b>Magic Tower</b><br><table>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + foodImageHtml + "'/></td><td>"+Variables.WOOD_COST_MAGICTOWER+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + woodImageHtml + "'/></td><td>"+Variables.WOOD_COST_MAGICTOWER+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + ironImageHtml + "'/></td><td>"+Variables.IRON_COST_MAGICTOWER+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + manaImageHtml + "'/></td><td>"+0+"</td>" +
                                "</tr>" +
                                "</table></html>";
        magicTowerButton.setToolTipText(toolTipMagicTower);

        // Church
        URL churchURL = getClass().getResource("/com/project/UI/src/church_icon.png");
        ImageIcon churchIcon = new ImageIcon(new ImageIcon(churchURL).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        churchButton = new PlainButton(churchIcon);
        String toolTipChurch =    "<html><b>Church</b><br><table>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + foodImageHtml + "'/></td><td>"+Variables.FOOD_COST_CHURCH+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + woodImageHtml + "'/></td><td>"+Variables.WOOD_COST_CHURCH+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + ironImageHtml + "'/></td><td>"+Variables.IRON_COST_CHURCH+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + manaImageHtml + "'/></td><td>"+Variables.MANA_COST_CHURCH+"</td>" +
                                "</tr>" +
                                "</table></html>";
        churchButton.setToolTipText(toolTipChurch);

        optionsPanel.add(smithyButton);
        optionsPanel.add(carpentryButton);
        optionsPanel.add(farmButton);
        optionsPanel.add(magicTowerButton);
        optionsPanel.add(churchButton);

        add(optionsPanel,BorderLayout.CENTER);
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
