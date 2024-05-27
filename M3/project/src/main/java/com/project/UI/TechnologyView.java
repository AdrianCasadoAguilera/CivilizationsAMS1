package com.project.UI;

import javax.swing.*;
import java.awt.*;

import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.PButton;
import java.awt.GridLayout;

public class TechnologyView extends JPanel {

    public PButton returnButton;
    public PButton AttackTech;
    public PButton DefenseTech;

    public TechnologyView() {
        setLayout(new BorderLayout());
        initNorth();
        initContent();
        initButtons();
    }

    private void initContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 1));
        AttackTech = new PButton("Attack");
        DefenseTech = new PButton("Defense");
        contentPanel.add(AttackTech);
        contentPanel.add(DefenseTech);
        add(contentPanel, BorderLayout.CENTER);
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
