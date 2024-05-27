package com.project.UI.entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.project.*;

public class entitiesController {
    
    SeeEntitiesView seeEntitiesView;
    Civilization civilization;

    public entitiesController(SeeEntitiesView seeEntitiesView){
        this.seeEntitiesView = seeEntitiesView;
        civilization = Civilization.getInstance();

        setTimer();

        setListeners();
    }

    private void setTimer(){
        int delay = 1000; 
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                seeEntitiesView.smithyQuantity.setText(String.valueOf(civilization.getSmithy()));
                seeEntitiesView.carpentryQuantity.setText(String.valueOf(civilization.getCarpentry()));
                seeEntitiesView.farmQuantity.setText(String.valueOf(civilization.getFarm()));
                seeEntitiesView.magicTowerQuantity.setText(String.valueOf(civilization.getMagicTower()));
                seeEntitiesView.churchQuantity.setText(String.valueOf(civilization.getChurch()));
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private void setListeners(){
        // Listeners
    }
}
