package com.project.UI.Battles;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.project.Main;

public class BattleLogController {

    private CardLayout cardLayout;
    private JPanel cards;
    private BattleLogView battleLog;
    public int BattleCount = 0;
    public int CurrentIndex = 0;
    Timer timer = null;
    public boolean mainreturn;

    public BattleLogController(CardLayout cardLayout, JPanel cards, BattleLogView battleLog) {
        this.cardLayout = cardLayout;
        this.cards = cards;
        this.battleLog = battleLog;
        battleLog.controler = this;
    }

    public void startTimer() {
        if (timer != null && timer.isRunning())
            timer.stop();
        timer = new Timer(1000, e -> {
            System.out.println(CurrentIndex);
            if(CurrentIndex == Main.battlesFaugth.size()-1){
                battleLog.next.setEnabled(false);
            }
            else{
                battleLog.next.setEnabled(true);
            }
            if (CurrentIndex == 0) {
                battleLog.previus.setEnabled(false);
            }
            else{
                battleLog.previus.setEnabled(true);
            }
        });
        timer.setInitialDelay(0);
        timer.start();
    }

    public void setListeners() {
        System.out.println(battleLog.returnButton == null);
        battleLog.returnButton.addActionListener(e->{
            if (mainreturn) {
                cardLayout.show(cards, "main");
                mainreturn = false;
            }
            else
                cardLayout.show(cards, "battles");
        });
        battleLog.next.addActionListener(e->{
            CurrentIndex++;
            battleLog.index++;
            battleLog.LoadLog();
        });
        battleLog.previus.addActionListener(e->{
            CurrentIndex--;
            battleLog.index--;
            battleLog.LoadLog();
        });
    }

}
