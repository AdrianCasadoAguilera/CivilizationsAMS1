package com.project.UI.nextBattle;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.project.Battle;
import com.project.Civilization;
import com.project.Main;
import com.project.UI.Battles.*;

public class NextBattleController {
    
    NextBattlePanel nextBattlePanel;
    BattleHappened battleHappened;
    Civilization civilization;
    Timer timer;

    CardLayout cardLayout;
    JPanel cards;
    public BattleLogView battleLogView;
    public BattleLogController battleLogController;

    public NextBattleController(CardLayout cardLayout,JPanel cards,NextBattlePanel nextBattlePanel,BattleHappened battleHappened){
        this.nextBattlePanel = nextBattlePanel;
        this.battleHappened = battleHappened;
        this.cardLayout = cardLayout;
        this.cards = cards;
        civilization = Civilization.getInstance();

        setListeners();

        timer = new Timer(200, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                nextBattlePanel.timeToBattleLabel.setText(String.valueOf((int)(Main.NextBattleIn-Main.BattleTimer)));
                if(Main.BattleTimer >= Main.NextBattleIn-1 && battleHappened != null){
                    battleHappened.setVisible(true);
                    new Timer(5000, new ActionListener() {
                        
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            battleHappened.setVisible(false);
                            ((Timer)e.getSource()).stop();
                        }
                        
                    }).start();
                }
            }
            
        });

        timer.start();
    }

    private void setListeners(){
        if (battleHappened != null) {
            battleHappened.seeLog.addActionListener(e->{
                battleLogView.detailed = false;
                battleLogView.index = Main.battlesFaugth.size() - 1;
                battleLogController.CurrentIndex = Main.battlesFaugth.size() - 1;
                battleLogController.mainreturn = true;
                battleLogView.LoadLog();
                cardLayout.show(cards, "battlelog");
            });
        }
    }
}
