package com.project.UI;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.project.*;

public class Controller {

    private MainView mainView;
    private CardLayout layout;
    private JPanel cards;

    public Controller(CardLayout layout,JPanel cards,MainView mainView){
        this.mainView = mainView;
        this.layout = layout;
        this.cards = cards;

        setMainListeners();
    }

    private void setMainListeners(){

        mainView.createBuildingButton.addActionListener(e->{
            layout.show(cards, "new building");
        });
        mainView.trainButton.addActionListener(e->{
            layout.show(cards, "train units");
        });
        mainView.upgradeTechLevelButton.addActionListener(e->{
            layout.show(cards, "tech");
        });
        mainView.ThreadButton.addActionListener(e->{
            layout.show(cards, "thread");
        });
        mainView.BattlesButton.addActionListener(e->{
            
        });
    }
    
}
