package com.project.UI.Technology;

import javax.swing.*;
import java.awt.*;


import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.PButton;
import com.project.UI.util.swing_elements.PlainButton;
import com.project.*;
public class TechnologyView extends JPanel {

    public PButton returnButton;
    public PlainButton AttackTech;
    public PlainButton DefenseTech;

    public TechnologyView() {
        setLayout(new BorderLayout());
        initNorth();
        initContent();
        initButtons();
    }

    private void initContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        AttackTech = new PlainButton("Attack",new Color(173,216,230));
        contentPanel.add(AttackTech);
        DefenseTech = new PlainButton("Defense",new Color(173,216,230));
        contentPanel.add(DefenseTech);
        add(contentPanel, BorderLayout.CENTER);
        setToolTips();
    }

    public void setToolTips() {
        Civilization civ = Civilization.getInstance();
        
        String foodImageHtml = getClass().getResource("/com/project/UI/src/resources_food.png").toString();
        String woodImageHtml = getClass().getResource("/com/project/UI/src/resources_wood.png").toString();
        String ironImageHtml = getClass().getResource("/com/project/UI/src/resources_iron.png").toString();

        int attackFoodCost = (int)(Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_FOOD_COST *(1.0+Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_FOOD_COST * civ.getTechnologyAttack()/100.0));
        int attackWoodCost = (int)(Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST *(1.0+Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST * civ.getTechnologyAttack()/100.0));
        int attackIronCost = (int)(Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST *(1.0+Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * civ.getTechnologyAttack()/100.0));
        System.out.println(civ.getTechnologyAttack());
        int defenseFoodCost = (int)(Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_FOOD_COST *(1.0+Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_FOOD_COST * civ.getTechnologyDefense()/100.0));
        int defenseWoodCost = (int)(Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST *(1.0+Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST * civ.getTechnologyDefense()/100.0));
        int defenseIronCost = (int)(Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST *(1.0+Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * civ.getTechnologyDefense()/100.0));

        String attackToolTip =    "<html><b>Attack</b><br><table>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + foodImageHtml + "'/></td><td>"+attackFoodCost+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + woodImageHtml + "'/></td><td>"+attackWoodCost+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + ironImageHtml + "'/></td><td>"+attackIronCost+"</td>" +
                                "</tr>" +
                                "</table></html>";
        AttackTech.setToolTipText(attackToolTip);

        String defenseToolTip =    "<html><b>Defense</b><br><table>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + foodImageHtml + "'/></td><td>"+defenseFoodCost+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + woodImageHtml + "'/></td><td>"+defenseWoodCost+"</td>" +
                                "</tr>" +
                                "<tr>" +
                                "<td><img height=20 width=20 src='" + ironImageHtml + "'/></td><td>"+defenseIronCost+"</td>" +
                                "</tr>" +
                                "</table></html>"; 
        DefenseTech.setToolTipText(defenseToolTip);
    }

    private void initButtons(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonsPanel.setBackground(Color.lightGray);
        returnButton = new PButton("Go back");
        buttonsPanel.add(returnButton);

        add(buttonsPanel,BorderLayout.SOUTH);
    }

    private void initNorth(){
        add(new ResourcesPanel(),BorderLayout.NORTH);
    }
}
