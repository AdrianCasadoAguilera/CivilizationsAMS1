package com.project.UI.newBuilding;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.project.Civilization;
import com.project.Main;

public class NewBuildingController {

    private NewBuildingView newBuildingView;
    private CardLayout layout;
    private JPanel cards;
    private Civilization civilization;

    public NewBuildingController(CardLayout layout,JPanel cards,NewBuildingView newBuildingView){
        this.newBuildingView = newBuildingView;
        this.layout = layout;
        this.cards = cards;
        
        civilization = Civilization.getInstance();

        setListeners();
    }

    private void setListeners(){
        newBuildingView.returnButton.addActionListener(e->{
            layout.show(cards, "main");
        });

        newBuildingView.smithyButton.addActionListener(e->{
            int build =  civilization.getSmithy();
            civilization.newSmithy();
            boolean created = build < civilization.getSmithy();
        });

        newBuildingView.carpentryButton.addActionListener(e->{
            int build = civilization.getCarpentry();
            civilization.newCarpentry();
            boolean created = build < civilization.getCarpentry();
        });

        newBuildingView.farmButton.addActionListener(e->{
            int build = civilization.getFarm();
            civilization.newFarm();
            boolean created = build < civilization.getFarm();
        });

        newBuildingView.magicTowerButton.addActionListener(e->{
            int build = civilization.getMagicTower();
            civilization.newMagicTower();
            boolean created = build < civilization.getMagicTower();
        });

        newBuildingView.churchButton.addActionListener(e->{
            int build = civilization.getChurch();
            civilization.newChurch();
            boolean created = build < civilization.getChurch();
        });
    }
}
