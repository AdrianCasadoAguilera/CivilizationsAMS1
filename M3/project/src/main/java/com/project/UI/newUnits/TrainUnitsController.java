package com.project.UI.newUnits;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.project.*;
import com.project.UI.newUnits.unitsViews.*;

public class TrainUnitsController {

    CardLayout layout;
    JPanel cards;

    TrainUnitsView trainUnitsView;
    SwordsmanView swordsmanView;
    SpearmanView spearmanView;
    CrossbowView crossbowView;
    CannonView cannonView;

    public TrainUnitsController(CardLayout layout,JPanel cards,TrainUnitsView trainUnitsView,SwordsmanView swordsmanView,SpearmanView spearmanView,CrossbowView crossbowView,CannonView cannonView){
        this.trainUnitsView = trainUnitsView;
        this.layout = layout;
        this.cards = cards;

        this.swordsmanView = swordsmanView;
        this.spearmanView = spearmanView;
        this.crossbowView = crossbowView;
        this.cannonView = cannonView;

        setListeners();
    }

    private void setListeners(){
        trainUnitsView.returnButton.addActionListener(e->{
            layout.show(cards, "main");
        });
        trainUnitsView.swordsmanButton.addActionListener(e->{
            swordsmanView.updateValues();
            layout.show(cards, "swordsman");
        });
        trainUnitsView.spearmanButton.addActionListener(e->{
            spearmanView.updateValues();
            layout.show(cards, "spearman");
        });
        trainUnitsView.crossbowButton.addActionListener(e->{
            crossbowView.updateValues();
            layout.show(cards, "crossbow");
        });
        trainUnitsView.cannonButton.addActionListener(e->{
            cannonView.updateValues();
            layout.show(cards,"cannon");
        });
    }
}
