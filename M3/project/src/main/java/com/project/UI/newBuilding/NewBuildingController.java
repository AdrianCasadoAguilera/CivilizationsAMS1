package com.project.UI.newBuilding;

import java.awt.CardLayout;
import java.awt.Color;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.project.Civilization;
import com.project.UI.util.clips.Clips;
import com.project.UI.util.swing_elements.Notification;

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
            if(created == true){
                Clips.playAudio(Clips.CONTRUCTIONDONE);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Smithy created succesfully",Color.GREEN);
            }else{
                Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Not enough resources",Color.RED);
            }
        });

        newBuildingView.carpentryButton.addActionListener(e->{
            int build = civilization.getCarpentry();
            civilization.newCarpentry();
            boolean created = build < civilization.getCarpentry();
            if(created == true){
                Clips.playAudio(Clips.CONTRUCTIONDONE);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Carpentry created succesfully",Color.GREEN);
            }else{
                Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Not enough resources",Color.RED);
            }
        });

        newBuildingView.farmButton.addActionListener(e->{
            int build = civilization.getFarm();
            civilization.newFarm();
            boolean created = build < civilization.getFarm();
            if(created == true){
                Clips.playAudio(Clips.CONTRUCTIONDONE);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Farm created succesfully",Color.GREEN);
            }else{
                Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Not enough resources",Color.RED);
            }
        });

        newBuildingView.magicTowerButton.addActionListener(e->{
            int build = civilization.getMagicTower();
            civilization.newMagicTower();
            boolean created = build < civilization.getMagicTower();
            if(created == true){
                Clips.playAudio(Clips.CONTRUCTIONDONE);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Magic Tower created succesfully",Color.GREEN);
            }else{
                Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Not enough resources",Color.RED);
            }
        });

        newBuildingView.churchButton.addActionListener(e->{
            int build = civilization.getChurch();
            civilization.newChurch();
            boolean created = build < civilization.getChurch();
            if(created == true){
                Clips.playAudio(Clips.CONTRUCTIONDONE);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Church created succesfully",Color.GREEN);
            }else{
                Clips.playAudio(Clips.FAILEDCONSTRUCTION);
                new Notification((JFrame)SwingUtilities.getWindowAncestor(newBuildingView),"Not enough resources",Color.RED);
            }
        });
    }
}
