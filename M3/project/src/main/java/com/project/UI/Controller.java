package com.project.UI;

import java.awt.CardLayout;
import javax.swing.*;

public class Controller {
    StartView startView;
    MainView mainView;
    StatsView statsView;
    CardLayout cardLayout;
    JPanel cards;

    public Controller(StartView startView,MainView mainView,StatsView statsView,CardLayout cardLayout,JPanel cards){
        this.startView = startView;
        this.mainView = mainView;
        this.statsView = statsView;
        this.cardLayout = cardLayout;
        this.cards = cards;

        setListeners();
    }

    private void setListeners(){

        startView.newGameButton.addActionListener(e->{
            cardLayout.show(cards,"main");
        });

        mainView.seeStats.addActionListener(e-> {
            cardLayout.show(cards,"stats");
        });
        mainView.returnMenu.addActionListener(e->{
            startView.setContinueAvailability();
            cardLayout.show(cards, "start");
        });

        statsView.goBack.addActionListener(e->{
           cardLayout.show(cards,"main"); 
        });
    }
}
