package com.project.UI.newUnits.unitsViews;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;

import com.project.Civilization;
import com.project.UnitTypes;

import com.project.UI.util.swing_elements.Notification;

public class UnitsViewsController {
 
    Civilization civilization;

    SwordsmanView swordsman;
    SpearmanView spearman;
    CrossbowView crossbow;
    CannonView cannon;
    ArrowTowerView arrowTower;

    CardLayout layout;
    JPanel cards;
    
    public UnitsViewsController(CardLayout layout,JPanel cards,SwordsmanView swordsman,SpearmanView spearman,CrossbowView crossbow,CannonView cannon,ArrowTowerView arrowTower){
        this.layout = layout;
        this.cards = cards;
        this.swordsman = swordsman;
        this.spearman = spearman;
        this.crossbow = crossbow;
        this.cannon = cannon;
        this.arrowTower = arrowTower;
        
        civilization = Civilization.getInstance();

        setListeners();
        setGoBackListeners();
    }

    private void setListeners(){
        setSwordsmanListeners();
        setSpearmanListeners();
        setCrossbowListeners();
        setCannonListeners();
        setArrowTowerListeners();
    }

    private void setSwordsmanListeners(){
        swordsman.createUnit.addActionListener(e->{
            if((int)swordsman.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.SWORDSMAN, (int)swordsman.amount.getValue());
                if(done>0){
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman),String.valueOf(done)+" swordsmans have just been added to your army!.",new Color(0, 166, 11));
                }else{
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman),"Not enough resources",Color.RED);
                }
            }
        });
        swordsman.amount.addChangeListener(e->{
            swordsman.updateCosts();
        });
    }
    private void setSpearmanListeners(){
        spearman.createUnit.addActionListener(e->{
            if((int)spearman.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.SPEARMAN, (int)spearman.amount.getValue());
                if(done>0){
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman),String.valueOf(done)+" spearmans have just been added to your army!.",new Color(0, 166, 11));
                }else{
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman),"Not enough resources",Color.RED);
                }
            }
        });
        spearman.amount.addChangeListener(e->{
            spearman.updateCosts();
        });
    }

    private void setCrossbowListeners(){
        crossbow.createUnit.addActionListener(e->{
            if((int)crossbow.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.CROSSBOW, (int)crossbow.amount.getValue());
                if(done>0){
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(crossbow),String.valueOf(done)+" crossbows have just been added to your army!.",new Color(0, 166, 11));
                }else{
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(crossbow),"Not enough resources",Color.RED);
                }
            }
        });
        crossbow.amount.addChangeListener(e->{
            crossbow.updateCosts();
        });
    }

    private void setCannonListeners(){
        cannon.createUnit.addActionListener(e->{
            if((int)cannon.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.CANNON, (int)cannon.amount.getValue());
                if(done>0){
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(cannon),String.valueOf(done)+" cannons have just been added to your army!.",new Color(0, 166, 11));
                }else{
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(cannon),"Not enough resources",Color.RED);
                }
            }
        });
        cannon.amount.addChangeListener(e->{
            cannon.updateCosts();
        });
    }

    private void setArrowTowerListeners(){
        arrowTower.createUnit.addActionListener(e->{
            if((int)arrowTower.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.ARROWTOWER, (int)arrowTower.amount.getValue());
                if(done>0){
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(arrowTower),String.valueOf(done)+" cannons have just been added to your army!.",new Color(0, 166, 11));
                }else{
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(arrowTower),"Not enough resources",Color.RED);
                }
            }
        });
        arrowTower.amount.addChangeListener(e->{
            arrowTower.updateCosts();
        });
    }

    private void setGoBackListeners(){
        swordsman.returnButton.addActionListener(e->goBack());
        spearman.returnButton.addActionListener(e->goBack());
        crossbow.returnButton.addActionListener(e->goBack());
        cannon.returnButton.addActionListener(e->goBack());
        arrowTower.returnButton.addActionListener(e->goBack());
    }

    private void goBack(){
        layout.show(cards, "train units");
    }
}
