package com.project.UI.newUnits;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class TrainUnitsController {

    CardLayout layout;
    JPanel cards;

    TrainUnitsView trainUnitsView;

    public TrainUnitsController(CardLayout layout,JPanel cards,TrainUnitsView trainUnitsView){
        this.trainUnitsView = trainUnitsView;
        this.layout = layout;
        this.cards = cards;

        setListeners();
    }

    private void setListeners(){
        trainUnitsView.returnButton.addActionListener(e->{
            layout.show(cards, "main");
        });
    }
}
