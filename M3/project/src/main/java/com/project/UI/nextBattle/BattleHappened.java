package com.project.UI.nextBattle;

import java.awt.Color;

import javax.swing.*;

import com.project.UI.util.swing_elements.PWhiteButton;
import com.project.UI.util.swing_elements.PLabel;

public class BattleHappened extends JPanel {

    public PWhiteButton seeLog;

    public BattleHappened(){
        setBackground(Color.BLACK);
        setVisible(false);

        initComponents();
    }

    private void initComponents(){
        PLabel titleLabel = new PLabel("A Battle Occured!");
        titleLabel.setForeground(Color.WHITE);

        seeLog = new PWhiteButton("See battle log");

        add(titleLabel);
        add(seeLog);
    }
}
