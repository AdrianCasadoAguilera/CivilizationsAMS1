package com.project.UI.newUnits;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.project.UI.newUnits.unitsViews.*;

public class TrainUnitsController {

    CardLayout layout;
    JPanel cards;

    TrainUnitsView trainUnitsView;
    SwordsmanView swordsmanView;
    SpearmanView spearmanView;
    CrossbowView crossbowView;
    CannonView cannonView;
    ArrowTowerView arrowTowerView;
    CatapultView catapultView;
    RocketLauncherView rocketLauncherView;
    MagicianView magicianView;
    PriestView priestView;

    public TrainUnitsController(CardLayout layout,JPanel cards,TrainUnitsView trainUnitsView,SwordsmanView swordsmanView,SpearmanView spearmanView,CrossbowView crossbowView,CannonView cannonView, ArrowTowerView arrowTowerView, CatapultView catapultView, RocketLauncherView rocketLauncherView, MagicianView magicianView, PriestView priestView){
        this.trainUnitsView = trainUnitsView;
        this.layout = layout;
        this.cards = cards;

        this.swordsmanView = swordsmanView;
        this.spearmanView = spearmanView;
        this.crossbowView = crossbowView;
        this.cannonView = cannonView;
        this.arrowTowerView = arrowTowerView;
        this.catapultView = catapultView;
        this.rocketLauncherView = rocketLauncherView;
        this.magicianView = magicianView;
        this.priestView = priestView;

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
        trainUnitsView.arrowTowerButton.addActionListener(e->{
            arrowTowerView.updateValues();
            layout.show(cards, "arrowtower");
        });
        trainUnitsView.catapultButton.addActionListener(e->{
            catapultView.updateValues();
            layout.show(cards, "catapult");
        });
        trainUnitsView.rocketLauncherButton.addActionListener(e->{
            rocketLauncherView.updateValues();
            layout.show(cards, "rocketlauncher");
        });
        trainUnitsView.magicianButton.addActionListener(e->{
            magicianView.updateValues();
            layout.show(cards, "magician");
        });
        trainUnitsView.priestButton.addActionListener(e->{
            priestView.updateValues();
            layout.show(cards, "priest");
        });
    }
}
