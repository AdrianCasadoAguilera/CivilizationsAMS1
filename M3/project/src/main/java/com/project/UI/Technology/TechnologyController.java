package com.project.UI.Technology;

import java.awt.CardLayout;
import javax.swing.JPanel;

import com.project.Civilization;

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
            Civilization.getInstance().upgradeTechnologyAttack();
            technologyView.setToolTips();
        });
        technologyView.DefenseTech.addActionListener(e->{
            Civilization.getInstance().upgradeTechnologyDefense();
            technologyView.setToolTips();
        });
    }

}
