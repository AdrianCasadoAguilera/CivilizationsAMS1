package com.project.UI.nextBattle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.project.Civilization;
import com.project.Main;

public class NextBattleController {
    
    NextBattlePanel nextBattlePanel;
    Civilization civilization;
    Timer timer;

    public NextBattleController(NextBattlePanel nextBattlePanel){
        this.nextBattlePanel = nextBattlePanel;
        civilization = Civilization.getInstance();

        timer = new Timer(200, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                nextBattlePanel.timeToBattleLabel.setText(String.valueOf(Main.NextBattleIn-Main.BattleTimer));
            }
            
        });

        timer.start();
    }
}
