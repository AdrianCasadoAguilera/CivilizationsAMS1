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
        
    }

}
