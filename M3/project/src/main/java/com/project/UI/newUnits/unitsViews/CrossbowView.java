package com.project.UI.newUnits.unitsViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;

import com.project.Crossbow;
import com.project.MilitaryUnit;
import com.project.Swordsman;
import com.project.UI.util.fonts.Fonts;
import com.project.UI.util.swing_elements.PButton;
import com.project.UI.util.swing_elements.PLabel;

public class CrossbowView extends JPanel {

    public PButton returnButton;

    public JSpinner amount;
    public PButton createUnit;

    private String unitName = "Crossbow";
    private String descString = "Aiming for the bullseye, but mostly just hitting 'send help' signals.";

    private ImageIcon woodIcon;
    private ImageIcon foodIcon;
    private ImageIcon ironIcon;
    private ImageIcon manaIcon;

    public JLabel armorValue;
    public JLabel damageValue;

    public JLabel foodCost;
    public JLabel woodCost;
    public JLabel ironCost;
    public JLabel manaCost;

    public MilitaryUnit unit = new Swordsman();

    public CrossbowView(){
        setLayout(new BorderLayout());

        setImages();

        setTitle();
        setMainContent();
        initButtons();
    }

    private void setTitle(){
        JPanel titlePanel = new JPanel();
            BoxLayout titleLayout = new BoxLayout(titlePanel, BoxLayout.X_AXIS);
            titlePanel.setLayout(titleLayout);
            titlePanel.setBackground(new Color(213,16,16));
            titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JPanel photoPanel = new JPanel();
            photoPanel.setOpaque(false);
                URL link = getClass().getResource("/com/project/UI/src/"+unitName.toLowerCase()+".png");
                Icon photoIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                JLabel photoLabel = new JLabel();
                    photoLabel.setIcon(photoIcon);
            photoPanel.add(photoLabel);

            JPanel nameDescPanel = new JPanel();
                nameDescPanel.setOpaque(false);
                BoxLayout nameDescLayout = new BoxLayout(nameDescPanel, BoxLayout.Y_AXIS);
                nameDescPanel.setLayout(nameDescLayout);

                PLabel name = new PLabel(unitName);
                name.setFont(name.getFont().deriveFont(50f));
                JLabel description = new JLabel(descString);
                description.setForeground(Color.white);
            nameDescPanel.add(name);
            nameDescPanel.add(description);

        titlePanel.add(photoPanel);
        titlePanel.add(nameDescPanel);

        add(titlePanel,BorderLayout.NORTH);
    }

    private void setMainContent(){

        amount = new JSpinner();
        amount.setMaximumSize(new Dimension(50,50));
        amount.setAlignmentX(CENTER_ALIGNMENT);

        JPanel mainContentPanel = new JPanel();
            BoxLayout mainContentLayout = new BoxLayout(mainContentPanel, BoxLayout.Y_AXIS);
            mainContentPanel.setLayout(mainContentLayout);
            mainContentPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

            JPanel statisticsPanel = new JPanel();
                BoxLayout statisticsLayout = new BoxLayout(statisticsPanel, BoxLayout.Y_AXIS);
                // statisticsPanel.setBorder(BorderFactory.createTitledBorder("Statistics"));
                statisticsPanel.setLayout(statisticsLayout);
                JPanel armorPanel = new JPanel();
                    armorPanel.setLayout(new BoxLayout(armorPanel,BoxLayout.X_AXIS));
                    JLabel armorLabel = new JLabel("BASE ARMOR: ");
                        armorLabel.setFont(Fonts.getInstance().rusticFont);
                    armorValue = new JLabel(String.valueOf(unit.getActualArmor()));
                        armorValue.setFont(Fonts.getInstance().itemsFont);
                armorPanel.add(armorLabel);
                armorPanel.add(armorValue);

                JPanel damagePanel = new JPanel();
                    damagePanel.setLayout(new BoxLayout(damagePanel, BoxLayout.X_AXIS));
                    JLabel damageLabel = new JLabel("BASE DAMAGE: ");
                        damageLabel.setFont(Fonts.getInstance().rusticFont);
                    damageValue = new JLabel(String.valueOf(unit.attack()));
                        damageValue.setFont(Fonts.getInstance().itemsFont);
                damagePanel.add(damageLabel);
                damagePanel.add(damageValue);

                JPanel attackAgainPanel = new JPanel();
                    attackAgainPanel.setLayout(new BoxLayout(attackAgainPanel, BoxLayout.X_AXIS));
                    JLabel attackAgainLabel = new JLabel("CHANCE OF ATTACKING AGAIN: ");
                        attackAgainLabel.setFont(Fonts.getInstance().rusticFont);
                    JLabel attackAgainValue = new JLabel(String.valueOf(unit.getChanceAttackAgain())+"%");
                        attackAgainValue.setFont(Fonts.getInstance().itemsFont);
                attackAgainPanel.add(attackAgainLabel);
                attackAgainPanel.add(attackAgainValue);

                JPanel generateWastePanel = new JPanel();
                    generateWastePanel.setLayout(new BoxLayout(generateWastePanel, BoxLayout.X_AXIS));
                    JLabel generateWasteLabel = new JLabel("CHANCE OF GENERATING WASTE: ");
                        generateWasteLabel.setFont(Fonts.getInstance().rusticFont);
                    JLabel generateWasteValue = new JLabel(String.valueOf(unit.getChanceGeneratinWaste())+"%");
                        generateWasteValue.setFont(Fonts.getInstance().itemsFont);
                generateWastePanel.add(generateWasteLabel);
                generateWastePanel.add(generateWasteValue);

                statisticsPanel.add(armorPanel);
                statisticsPanel.add(damagePanel);
                statisticsPanel.add(attackAgainPanel);
                statisticsPanel.add(generateWastePanel);

            mainContentPanel.add(statisticsPanel);

        mainContentPanel.add(Box.createHorizontalStrut(10));

            JPanel costsPanel = new JPanel();
                BoxLayout costsLayout = new BoxLayout(costsPanel, BoxLayout.X_AXIS);
                // costsPanel.setBorder(BorderFactory.createTitledBorder("Costs"));
                costsPanel.setLayout(costsLayout);
                
                JLabel foodLabel = new JLabel(foodIcon);
                foodCost = new JLabel(String.valueOf(unit.getFoodCost()*(int)amount.getValue()));

                JLabel woodLabel = new JLabel(woodIcon);
                woodCost = new JLabel(String.valueOf(unit.getWoodCost()*(int)amount.getValue()));

                JLabel ironLabel = new JLabel(ironIcon);
                ironCost = new JLabel(String.valueOf(unit.getIronCost()*(int)amount.getValue()));
                
                JLabel manaLabel = new JLabel(manaIcon);
                manaCost = new JLabel(String.valueOf(unit.getManaCost()*(int)amount.getValue()));

                costsPanel.add(foodLabel);
                costsPanel.add(foodCost);
                costsPanel.add(woodLabel);
                costsPanel.add(woodCost);
                costsPanel.add(ironLabel);
                costsPanel.add(ironCost);
                costsPanel.add(manaLabel);
                costsPanel.add(manaCost);

            mainContentPanel.add(costsPanel);

        mainContentPanel.add(Box.createHorizontalStrut(10));

        createUnit = new PButton("Create unit");
        createUnit.setAlignmentX(CENTER_ALIGNMENT);

        mainContentPanel.add(amount);
        mainContentPanel.add(Box.createHorizontalStrut(10));
        mainContentPanel.add(createUnit);

        add(mainContentPanel,BorderLayout.CENTER);
    }

    private void initButtons(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonsPanel.setBackground(Color.lightGray);
        returnButton = new PButton("Go back");
        buttonsPanel.add(returnButton);

        add(buttonsPanel,BorderLayout.SOUTH);
    }

    private void setImages(){
        URL link;
        link = getClass().getResource("/com/project/UI/src/resources_wood.png");
        woodIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        link = getClass().getResource("/com/project/UI/src/resources_food.png");
        foodIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        link = getClass().getResource("/com/project/UI/src/resources_iron.png");
        ironIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        link = getClass().getResource("/com/project/UI/src/resources_mana.png");
        manaIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    }

    public void updateValues(){
        unit = new Crossbow();
        armorValue.setText(String.valueOf(unit.getActualArmor()));
        damageValue.setText(String.valueOf(unit.attack()));
        repaint();
    }

    public void updateCosts(){
        woodCost.setText(String.valueOf(unit.getWoodCost()*(int)amount.getValue()));
        foodCost.setText(String.valueOf(unit.getFoodCost()*(int)amount.getValue()));
        ironCost.setText(String.valueOf(unit.getIronCost()*(int)amount.getValue()));
        manaCost.setText(String.valueOf(unit.getManaCost()*(int)amount.getValue()));
        revalidate();
        repaint();
    }
}
