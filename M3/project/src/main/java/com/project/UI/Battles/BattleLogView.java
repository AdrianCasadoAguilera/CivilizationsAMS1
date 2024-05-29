package com.project.UI.Battles;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.project.Main;
import com.project.UI.util.swing_elements.PButton;


public class BattleLogView extends JPanel {

    public boolean detailed = false;
    public int index;
    public PButton returnButton;
    public PButton previus;
    public PButton next;
    public BattleLogController controler;

    public BattleLogView(){
        setLayout(new BorderLayout());
    }

    public void initNorth() {
        JPanel seletionPanel = new JPanel();
        previus = new PButton("Previus");
        JLabel indexLabel = new JLabel("" + index);
        next = new PButton("Next");
        seletionPanel.add(previus);
        seletionPanel.add(indexLabel);
        seletionPanel.add(next);
        add(seletionPanel, BorderLayout.NORTH);
    }

    public void initSouth() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonsPanel.setBackground(Color.lightGray);
        returnButton = new PButton("Go back");
        buttonsPanel.add(returnButton);

        add(buttonsPanel,BorderLayout.SOUTH);

    }

    public void LoadLog(){
        removeAll();
        initNorth();
        JPanel logPanel = new JPanel();
        logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.Y_AXIS));
        ArrayList<JPanel> panels = new ArrayList<>();
        if (detailed) {
            panels = Main.battlesFaugth.get(index).getDeteiledReportSwing();
        }
        else {
            panels = Main.battlesFaugth.get(index).getReportSwing();
        }
        System.out.println("size" + panels.size());
        for (JPanel panel : panels) {
            logPanel.add(panel);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(logPanel);
        add(scrollPane, BorderLayout.CENTER);
        initSouth();
        controler.setListeners();
        controler.startTimer();
    }
}
