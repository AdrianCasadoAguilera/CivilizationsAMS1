package com.project.UI.Battles;

import javax.swing.*;

import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.PButton;

import java.awt.*;
import java.awt.GridLayout;

public class BattlesView extends JPanel {

    PButton returnButton;
    PButton lastLog;
    PButton lastDetailedLog;
    PButton BattleLog;
    PButton detailedBattleLog;

    public BattlesView(){
        setLayout(new BorderLayout());

        initNorth();
        initContent();
        initButtons();
    }

    private void initContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2,2));
        contentPanel.add(lastLog = new PButton("View Last Battle log"));
        contentPanel.add(lastDetailedLog = new PButton("View Last Detailed Battle log"));
        contentPanel.add(BattleLog = new PButton("View All Battle logs"));
        contentPanel.add(detailedBattleLog = new PButton("View All Detailed Battle logs"));
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
