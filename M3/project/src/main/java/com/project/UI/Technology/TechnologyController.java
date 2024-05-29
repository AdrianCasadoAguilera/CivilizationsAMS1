package com.project.UI.Technology;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.project.Civilization;

import java.awt.Color;
import javax.swing.SwingUtilities;

import com.project.UI.util.swing_elements.*;

public class TechnologyController {

    CardLayout layout;
    JPanel cards;
    TechnologyView technologyView;

    public TechnologyController(CardLayout cardLayout, JPanel cards, TechnologyView technologyView) {
        this.technologyView = technologyView;
        this.layout = cardLayout;
        this.cards = cards;

        setListeners();
    }

    private void setListeners() {
        technologyView.returnButton.addActionListener(e->{
            layout.show(cards, "main");
        });
        technologyView.AttackTech.addActionListener(e->{
            int code = Civilization.getInstance().upgradeTechnologyAttack();
            if (code == 1) {
                new Notification((JFrame)SwingUtilities.getWindowAncestor(technologyView),"Technology upgraded",Color.GREEN);
            }
            else if (code == 0) {
                new Notification((JFrame)SwingUtilities.getWindowAncestor(technologyView), "Not enough resources", Color.RED);
            }
            else {
                new Notification((JFrame)SwingUtilities.getWindowAncestor(technologyView), "Technology has reached max level", Color.YELLOW);
            }
            technologyView.setResources();
        });
        technologyView.DefenseTech.addActionListener(e->{
            int code = Civilization.getInstance().upgradeTechnologyDefense();
            if (code == 1) {
                new Notification((JFrame)SwingUtilities.getWindowAncestor(technologyView),"Technology upgraded",Color.GREEN);
            }
            else if (code == 0) {
                new Notification((JFrame)SwingUtilities.getWindowAncestor(technologyView), "Not enough resources", Color.RED);
            }
            else {
                new Notification((JFrame)SwingUtilities.getWindowAncestor(technologyView), "Technology has reached max level", Color.YELLOW);
            }
            technologyView.setResources();
        });
    }

}
