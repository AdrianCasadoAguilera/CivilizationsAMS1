package com.project.UI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.project.UI.resources.ResourcesPanel;

public class BattleLogView extends JPanel {


    public BattleLogView(){
        setLayout(new BorderLayout());
        add(new ResourcesPanel(),BorderLayout.NORTH);
        add(new JLabel("Battle log view in construction"),BorderLayout.CENTER);
    }
}
