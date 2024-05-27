package com.project.UI.newUnits.unitsViews;

import java.awt.CardLayout;
import javax.swing.*;

public class UnitsViewsController {
 
    SwordsmanView swordsman;
    SpearmanView spearman;
    CrossbowView crossbow;
    CardLayout layout;
    JPanel cards;
    
    public UnitsViewsController(CardLayout layout,JPanel cards,SwordsmanView swordsman,SpearmanView spearman,CrossbowView crossbow){
        this.layout = layout;
        this.cards = cards;
        this.swordsman = swordsman;
        this.spearman = spearman;
        this.crossbow = crossbow;

        setListeners();
        setGoBackListeners();
    }

    private void setListeners(){
        setSwordsmanListeners();
    }

    private void setSwordsmanListeners(){
        
    }

    private void setGoBackListeners(){
        swordsman.returnButton.addActionListener(e->goBack());
        spearman.returnButton.addActionListener(e->goBack());
        crossbow.returnButton.addActionListener(e->goBack());
    }

    private void goBack(){
        layout.show(cards, "train units");
    }
}
