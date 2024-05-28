package com.project.UI;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.project.UI.Battles.BattleLogView;

public class BattleLogController {

    private CardLayout cardLayout;
    private JPanel cards;
    private BattleLogView battleLog;
    public int BattleCount = 0;

    public BattleLogController(CardLayout cardLayout, JPanel cards, BattleLogView battleLog) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.battleLog = battleLog;

        setListeners();
    }

    private void setListeners() {
        battleLog.returnButton.addActionListener(e->cardLayout.show(cards, "battles"));
        battleLog.next.addActionListener(e->{

        });
        battleLog.previus.addActionListener(e->{

        });
    }

}
