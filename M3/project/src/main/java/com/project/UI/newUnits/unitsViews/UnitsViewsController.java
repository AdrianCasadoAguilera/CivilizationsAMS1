package com.project.UI.newUnits.unitsViews;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.project.Civilization;
import com.project.UnitTypes;
import com.project.UI.util.clips.Clips;
import com.project.UI.util.swing_elements.Notification;

public class UnitsViewsController {
 
    Civilization civilization;

    SwordsmanView swordsman;
    SpearmanView spearman;
    CrossbowView crossbow;
    CannonView cannon;
    ArrowTowerView arrowTower;
    CatapultView catapult;
    RocketLauncherView rocketLauncher;
    MagicianView magician;
    PriestView priest;

    CardLayout layout;
    JPanel cards;
    
    public UnitsViewsController(CardLayout layout,JPanel cards,SwordsmanView swordsman,SpearmanView spearman,CrossbowView crossbow,CannonView cannon,ArrowTowerView arrowTower,CatapultView catapult,RocketLauncherView rocketLauncher,MagicianView magician,PriestView priest){
        this.layout = layout;
        this.cards = cards;
        this.swordsman = swordsman;
        this.spearman = spearman;
        this.crossbow = crossbow;
        this.cannon = cannon;
        this.arrowTower = arrowTower;
        this.catapult = catapult;
        this.rocketLauncher = rocketLauncher;
        this.magician = magician;
        this.priest = priest;
        
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
        setCatapultListeners();
        setRocketLauncherListeners();
        setMagicianListeners();
        setPriestListeners();
    }

    private void setSwordsmanListeners(){
        swordsman.createUnit.addActionListener(e->{
            if((int)swordsman.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.SWORDSMAN, (int)swordsman.amount.getValue());
                if(done>1){
                    Clips.playAudio(Clips.SWORDSMAN);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman),String.valueOf(done)+" swordsmans have just been added to your army!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.SWORDSMAN);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman), "1 swordsman has just been added to your army!", new Color(0, 166, 11));
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
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
                if(done>1){
                    Clips.playAudio(Clips.SPEARMAN);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman),String.valueOf(done)+" spearmans have just been added to your army!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.SPEARMAN);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(spearman), "1 spearman has just been added to your army!", new Color(0, 166, 11));
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
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
                if(done>1){
                    Clips.playAudio(Clips.CROSSBOW);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(crossbow),String.valueOf(done)+" crossbows have just been added to your army!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.CROSSBOW);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(crossbow), "1 crossbow has just been added to your army!", new Color(0, 166, 11));
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
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
                if(done>1){
                    Clips.playAudio(Clips.CANNON);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(cannon),String.valueOf(done)+" cannons have just been added to your army!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.CANNON);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(cannon), "1 cannon has just been added to your army!", new Color(0, 166, 11));
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
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
                if(done>1){
                    Clips.playAudio(Clips.ARROWTOWER);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(arrowTower),String.valueOf(done)+" arrow tower have just been added to your defences!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.ARROWTOWER);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(arrowTower), "1 arrow tower has just been added to your defences!", new Color(0, 166, 11));
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(arrowTower),"Not enough resources",Color.RED);
                }
            }
        });
        arrowTower.amount.addChangeListener(e->{
            arrowTower.updateCosts();
        });
    }

    private void setCatapultListeners(){
        catapult.createUnit.addActionListener(e->{
            if((int)catapult.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.CATAPULT, (int)catapult.amount.getValue());
                if(done>1){
                    Clips.playAudio(Clips.CATAPULT);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(catapult),String.valueOf(done)+" catapults have just been added to your defences!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.CATAPULT);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(catapult), "1 catapult has just been added to your defences!", new Color(0, 166, 11));
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(catapult),"Not enough resources",Color.RED);
                }
            }
        });
        catapult.amount.addChangeListener(e->{
            catapult.updateCosts();
        });
    }
    
    private void setRocketLauncherListeners(){
        rocketLauncher.createUnit.addActionListener(e->{
            if((int)rocketLauncher.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.ROCKETLAUNCHERTOWER, (int)rocketLauncher.amount.getValue());
                if(done>1){
                    Clips.playAudio(Clips.ROCKETLAUNCHER);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(rocketLauncher),String.valueOf(done)+" catapults have just been added to your defences!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.ROCKETLAUNCHER);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(rocketLauncher), "1 catapult has just been added to your defences!", new Color(0, 166, 11));
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(rocketLauncher),"Not enough resources",Color.RED);
                }
            }
        });
        rocketLauncher.amount.addChangeListener(e->{
            rocketLauncher.updateCosts();
        });
    }

    private void setMagicianListeners(){
        magician.createUnit.addActionListener(e->{
            if((int)magician.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.MAGICIAN, (int)magician.amount.getValue());
                if(done>1){
                    Clips.playAudio(Clips.MAGICIAN);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(magician),String.valueOf(done)+" magician have just been added to your army!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.MAGICIAN);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(magician), "1 magician has just been added to your army!", new Color(0, 166, 11));
                }
                else if (done==-1) {
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(magician), "You need to build more magic towers to train more magicians", Color.RED);
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(magician),"Not enough resources",Color.RED);
                }
            }
        });
        magician.amount.addChangeListener(e->{
            magician.updateCosts();
        });
    }
    
    private void setPriestListeners(){
        priest.createUnit.addActionListener(e->{
            if((int)priest.amount.getValue()>0){
                int done = civilization.AddUnit(UnitTypes.PRIEST, (int)priest.amount.getValue());
                if(done>1){
                    Clips.playAudio(Clips.PRIEST);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(priest),String.valueOf(done)+" priest have just been added to your army!",new Color(0, 166, 11));
                }
                else if (done==1){
                    Clips.playAudio(Clips.PRIEST);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(priest), "1 priest has just been added to your army!", new Color(0, 166, 11));
                }
                else if (done==-1) {
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(priest), "You need to build more churches to train more priests", Color.RED);
                }
                else{
                    Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                    new Notification((JFrame)SwingUtilities.getWindowAncestor(priest),"Not enough resources",Color.RED);
                }
            }
        });
        priest.amount.addChangeListener(e->{
            priest.updateCosts();
        });
    }
    
    private void setGoBackListeners(){
        swordsman.returnButton.addActionListener(e->goBack());
        spearman.returnButton.addActionListener(e->goBack());
        crossbow.returnButton.addActionListener(e->goBack());
        cannon.returnButton.addActionListener(e->goBack());
        arrowTower.returnButton.addActionListener(e->goBack());
        catapult.returnButton.addActionListener(e->goBack());
        rocketLauncher.returnButton.addActionListener(e->goBack());
        magician.returnButton.addActionListener(e->goBack());
        priest.returnButton.addActionListener(e->goBack());
    }

    private void goBack(){
        layout.show(cards, "train units");
    }
}
