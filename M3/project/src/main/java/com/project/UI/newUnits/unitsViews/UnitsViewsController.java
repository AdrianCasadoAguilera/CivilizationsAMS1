package com.project.UI.newUnits.unitsViews;

import java.awt.CardLayout;
import javax.swing.*;

public class UnitsViewsController {
 
    SwordsmanView swordsman;
    CardLayout layout;
    JPanel cards;
    
    public UnitsViewsController(CardLayout layout,JPanel cards,SwordsmanView swordsman){
        this.layout = layout;
        this.cards = cards;
        this.swordsman = swordsman;

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
    }

    private void goBack(){
        layout.show(cards, "train units");
    }
}
