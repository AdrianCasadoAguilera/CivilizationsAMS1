package com.project.UI.entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.project.*;

public class entitiesController {
    
    SeeEntitiesView seeEntitiesView;
    Civilization civilization = Civilization.getInstance();

    public entitiesController(SeeEntitiesView seeEntitiesView){
        this.seeEntitiesView = seeEntitiesView;

        setTimer();

        setListeners();
    }

    private void setTimer(){
        int delay = 1000; 
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                seeEntitiesView.foodInfoLabel.setText(String.valueOf(civilization.getFood()));
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private void setListeners(){
        // Listeners
    }
}
