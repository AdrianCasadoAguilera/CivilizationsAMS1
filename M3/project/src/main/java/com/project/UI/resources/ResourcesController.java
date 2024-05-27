package com.project.UI.resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.project.Civilization;

public class ResourcesController {

    Civilization civilization;
    ResourcesPanel resourcesPanel;
    Timer timer;

    public ResourcesController(ResourcesPanel resourcesPanel){
        this.resourcesPanel = resourcesPanel;
        civilization = Civilization.getInstance();

        timer = new Timer(100, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                resourcesPanel.foodLabel.setText(String.valueOf(civilization.getFood()));
                resourcesPanel.woodLabel.setText(String.valueOf(civilization.getWood()));
                resourcesPanel.ironLabel.setText(String.valueOf(civilization.getIron()));
                resourcesPanel.manaLabel.setText(String.valueOf(civilization.getMana()));
            }
            
        });
        timer.start();
    }
}
