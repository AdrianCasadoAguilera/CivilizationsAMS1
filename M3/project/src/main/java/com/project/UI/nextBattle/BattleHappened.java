package com.project.UI.nextBattle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import java.awt.event.MouseEvent;

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
