package com.project.UI;

import java.awt.CardLayout;
import javax.swing.*;

public class Controller {
    MainView mainView;
    StatsView statsView;
    CardLayout cardLayout;
    JPanel cards;

    public Controller(MainView mainView,StatsView statsView,CardLayout cardLayout,JPanel cards){
        this.mainView = mainView;
        this.statsView = statsView;
        this.cardLayout = cardLayout;
        this.cards = cards;

        setListeners();
    }

    private void setListeners(){
        mainView.seeStats.addActionListener(e-> {
            cardLayout.show(cards,"stats");
        });

        statsView.goBack.addActionListener(e->{
           cardLayout.show(cards,"main"); 
        });
    }
}
