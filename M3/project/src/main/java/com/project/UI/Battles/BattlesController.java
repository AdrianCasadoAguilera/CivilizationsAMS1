package com.project.UI.Battles;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class BattlesController {

    private CardLayout cardLayout;
    private JPanel cards;
    private BattlesView battlesView;

    public BattlesController(CardLayout cardLayout, JPanel cards, BattlesView battlesView) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.battlesView = battlesView;

        setListeners();
    }

    private void setListeners() {
        battlesView.returnButton.addActionListener(e -> cardLayout.show(cards, "main"));
        battlesView.BattleLog.addActionListener(e->cardLayout.show(cards, "battlelog"));
        battlesView.detailedBattleLog.addActionListener(e->cardLayout.show(cards, "battlelog"));
        battlesView.lastDetailedLog.addActionListener(e->cardLayout.show(cards, "battlelog"));
        battlesView.lastLog.addActionListener(e->cardLayout.show(cards, "battlelog"));
    }

}
