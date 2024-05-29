package com.project.UI.Technology;

import javax.swing.*;
import java.awt.*;
import java.net.*;


import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.fonts.Fonts;
import com.project.UI.util.swing_elements.PButton;
import com.project.UI.util.swing_elements.PlainButton;

import oracle.net.aso.af;
import oracle.security.o3logon.a;

import com.project.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
public class TechnologyView extends JPanel {

    public PButton returnButton;
    public PlainButton AttackTech;
    public PlainButton DefenseTech;
    public JPanel attackResorcesPanel;
    public JPanel defenseResourcesPanel;

    public TechnologyView() {
        setLayout(new BorderLayout());
        initNorth();
        initContent();
        initButtons();
    }

    private void initContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JPanel attackPanel = new JPanel();
        attackPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        attackResorcesPanel = new JPanel();
        attackResorcesPanel.setLayout(new BoxLayout(attackResorcesPanel, BoxLayout.Y_AXIS));
        attackPanel.add(attackResorcesPanel);

        AttackTech = new PlainButton("Upgrade Attack",new Color(173,216,230));
        AttackTech.setPreferredSize(new Dimension(200, 150));
        AttackTech.setFont(Fonts.getInstance().rusticFont);
        attackPanel.add(AttackTech);
        contentPanel.add(attackPanel);
        
        JPanel defensePanel = new JPanel();
        defensePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
        defenseResourcesPanel = new JPanel();
        defenseResourcesPanel.setLayout(new BoxLayout(defenseResourcesPanel, BoxLayout.Y_AXIS));
        defensePanel.add(defenseResourcesPanel);
        
        DefenseTech = new PlainButton("Upgrade Defense",new Color(173, 216, 230));
        DefenseTech.setPreferredSize(new Dimension(200, 150));
        DefenseTech.setFont(Fonts.getInstance().rusticFont);
        defensePanel.add(DefenseTech);
        contentPanel.add(defensePanel);

        add(contentPanel, BorderLayout.CENTER);
        setResources();
    }

    public void setResources() {
        defenseResourcesPanel.removeAll();
        attackResorcesPanel.removeAll();
        Civilization civ = Civilization.getInstance();
        
        URL foodImageHtml = getClass().getResource("/com/project/UI/src/resources_food.png");
        URL woodImageHtml = getClass().getResource("/com/project/UI/src/resources_wood.png");
        URL ironImageHtml = getClass().getResource("/com/project/UI/src/resources_iron.png");

        int attackFoodCost = (int)(Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_FOOD_COST *(1.0+Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_FOOD_COST * civ.getTechnologyAttack()/100.0));
        int attackWoodCost = (int)(Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_WOOD_COST *(1.0+Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_WOOD_COST * civ.getTechnologyAttack()/100.0));
        int attackIronCost = (int)(Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST *(1.0+Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_IRON_COST * civ.getTechnologyAttack()/100.0));
        System.out.println("dssd");
        int defenseFoodCost = (int)(Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_FOOD_COST *(1.0+Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_FOOD_COST * civ.getTechnologyDefense()/100.0));
        int defenseWoodCost = (int)(Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_WOOD_COST *(1.0+Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_WOOD_COST * civ.getTechnologyDefense()/100.0));
        int defenseIronCost = (int)(Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST *(1.0+Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_IRON_COST * civ.getTechnologyDefense()/100.0));
        
        JPanel afoodPanel = new JPanel();
        JLabel afoodLabel = new JLabel(attackFoodCost + "");
        afoodLabel.setFont(Fonts.getInstance().itemsFont);
        JLabel afoodImage = new JLabel(new ImageIcon(new ImageIcon(foodImageHtml).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        afoodPanel.add(afoodImage);
        afoodPanel.add(afoodLabel);
        attackResorcesPanel.add(afoodPanel);

        JPanel awoodJPanel = new JPanel();
        JLabel awoodLabel = new JLabel(attackWoodCost + "");
        awoodLabel.setFont(Fonts.getInstance().itemsFont);
        JLabel awoodImage = new JLabel(new ImageIcon(new ImageIcon(woodImageHtml).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        awoodJPanel.add(awoodImage);
        awoodJPanel.add(awoodLabel);
        attackResorcesPanel.add(awoodJPanel);

        JPanel airoPanel = new JPanel();
        JLabel aironLabel = new JLabel(attackIronCost + "");
        aironLabel.setFont(Fonts.getInstance().itemsFont);
        JLabel aironImage = new JLabel(new ImageIcon(new ImageIcon(ironImageHtml).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        airoPanel.add(aironImage);
        airoPanel.add(aironLabel);
        attackResorcesPanel.add(airoPanel);

        JPanel dfoodPanel = new JPanel();
        JLabel dfoodLabel = new JLabel(defenseFoodCost + "");
        dfoodLabel.setFont(Fonts.getInstance().itemsFont);
        JLabel dfoodImage = new JLabel(new ImageIcon(new ImageIcon(foodImageHtml).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        dfoodPanel.add(dfoodImage);
        dfoodPanel.add(dfoodLabel);
        defenseResourcesPanel.add(dfoodPanel);

        JPanel dwoodJPanel = new JPanel();
        JLabel dwoodLabel = new JLabel(defenseWoodCost + "");
        dwoodLabel.setFont(Fonts.getInstance().itemsFont);
        JLabel dwoodImage = new JLabel(new ImageIcon(new ImageIcon(woodImageHtml).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        dwoodJPanel.add(dwoodImage);
        dwoodJPanel.add(dwoodLabel);
        defenseResourcesPanel.add(dwoodJPanel);

        JPanel dironPanel = new JPanel();
        JLabel dironLabel = new JLabel(defenseIronCost + "");
        dironLabel.setFont(Fonts.getInstance().itemsFont);
        JLabel dironImage = new JLabel(new ImageIcon(new ImageIcon(ironImageHtml).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        dironPanel.add(dironImage);
        dironPanel.add(dironLabel);
        defenseResourcesPanel.add(dironPanel);

        revalidate();
        repaint();
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
