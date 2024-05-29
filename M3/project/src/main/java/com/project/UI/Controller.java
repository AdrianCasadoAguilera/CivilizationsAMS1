package com.project.UI;

import java.awt.CardLayout;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import com.project.*;
import com.project.UI.util.clips.Clips;

import oracle.ons.Cli;

public class Controller {

    private MainView mainView;
    private CardLayout layout;
    private JPanel cards;

    public Controller(CardLayout layout,JPanel cards,MainView mainView){
        this.mainView = mainView;
        this.layout = layout;
        this.cards = cards;

        setMainListeners();
    }

    private void setMainListeners(){

        mainView.createBuildingButton.addActionListener(e->{
            layout.show(cards, "new building");
            Clips.playAudio(Clips.BUTTONCLICKED);
        });
        mainView.trainButton.addActionListener(e->{
            layout.show(cards, "train units");
            Clips.playAudio(Clips.BUTTONCLICKED);
        });
        mainView.upgradeTechLevelButton.addActionListener(e->{
            layout.show(cards, "tech");
            Clips.playAudio(Clips.BUTTONCLICKED);
        });
        mainView.ThreadButton.addActionListener(e->{
            layout.show(cards, "thread");
            Clips.playAudio(Clips.BUTTONCLICKED);
        });
        mainView.BattlesButton.addActionListener(e->{
            layout.show(cards, "battles");
            Clips.playAudio(Clips.BUTTONCLICKED);
        });
    }
    
}
