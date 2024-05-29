package com.project.UI.Battles;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.project.Main;

public class BattlesController {

    private CardLayout cardLayout;
    private JPanel cards;
    private BattlesView battlesView;
    private BattleLogView battleLogView;
    public BattleLogController battleLogController;


    public BattlesController(CardLayout cardLayout, JPanel cards, BattlesView battlesView,BattleLogView battleLogView) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.battlesView = battlesView;
        this.battleLogView = battleLogView;
        battleLogController = new BattleLogController(cardLayout, cards, battleLogView);
        battleLogView.controler = battleLogController;
        setListeners();
    }

    private void setListeners() {
        battlesView.returnButton.addActionListener(e -> cardLayout.show(cards, "main"));
        battlesView.BattleLog.addActionListener(e->{
            if (Main.battlesFaugth.size() == 0)
                return;
            battleLogView.detailed = false;
            battleLogView.index = 0;
            battleLogController.CurrentIndex = 0;
            battleLogView.LoadLog();
            cardLayout.show(cards, "battlelog");
        });
        battlesView.detailedBattleLog.addActionListener(e->{
            if (Main.battlesFaugth.size() == 0)
                return;
            battleLogView.detailed = true;
            battleLogView.index = 0;
            battleLogController.CurrentIndex = 0;
            battleLogView.LoadLog();
            cardLayout.show(cards, "battlelog");
        });
        battlesView.lastDetailedLog.addActionListener(e->{
            if (Main.battlesFaugth.size() == 0)
                return;
            battleLogView.detailed = true;
            battleLogView.index = Main.battlesFaugth.size() - 1;
            battleLogController.CurrentIndex = Main.battlesFaugth.size() - 1;
            battleLogView.LoadLog();
            cardLayout.show(cards, "battlelog");
        });
        battlesView.lastLog.addActionListener(e->{
            if (Main.battlesFaugth.size() == 0)
                return;
            battleLogView.detailed = false;
            battleLogView.index = Main.battlesFaugth.size() - 1;
            battleLogController.CurrentIndex = Main.battlesFaugth.size() - 1;
            battleLogView.LoadLog();
            cardLayout.show(cards, "battlelog");
        });
        Timer timer = new Timer(1000, e -> {
            if (Main.battlesFaugth.size() == 0 ) {
                battlesView.BattleLog.setEnabled(false);
                battlesView.detailedBattleLog.setEnabled(false);
                battlesView.lastDetailedLog.setEnabled(false);
                battlesView.lastLog.setEnabled(false);
            }
            else {
                battlesView.BattleLog.setEnabled(true);
                battlesView.detailedBattleLog.setEnabled(true);
                battlesView.lastDetailedLog.setEnabled(true);
                battlesView.lastLog.setEnabled(true);
                battleLogController.BattleCount = Main.battlesFaugth.size();
            }
        });
    }

}
