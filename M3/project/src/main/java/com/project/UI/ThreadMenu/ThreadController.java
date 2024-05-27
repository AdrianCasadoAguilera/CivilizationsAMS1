package com.project.UI.ThreadMenu;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.project.UI.nextBattle.NextBattleController;
import java.awt.event.ActionEvent;

public class ThreadController {

    CardLayout layout;
    JPanel cards;
    ThreadView threadView;

    public ThreadController(CardLayout cardLayout, JPanel cards, ThreadView threadView) {
        this.threadView = threadView;
        this.layout = cardLayout;
        this.cards = cards;

        setListeners();
    }

    private void setListeners() {
        threadView.returnButton.addActionListener(e->{
            layout.show(cards, "main");
        });
        new NextBattleController(layout, cards, threadView.nextBattlePanel,null);
        
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                threadView.updateValues();
            }
        });
        timer.start();
    }
}
