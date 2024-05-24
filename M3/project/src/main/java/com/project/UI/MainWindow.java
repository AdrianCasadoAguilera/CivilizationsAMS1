package com.project.UI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import com.project.Main;
import com.project.SaveData;
import com.project.Saves;
import com.project.UI.entities.*;
import com.project.UI.newBuilding.NewBuildingController;
import com.project.UI.newBuilding.NewBuildingView;

public class MainWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;

    private MainView mainView;
    private SeeEntitiesView seeEntitiesView;
    private NewBuildingView newBuildingView;
    private PauseView pauseView;

    public boolean canPause = true;
    
    public MainWindow(){
        super("Civilization");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setView();

        new Controller(cardLayout,cards,mainView);
        new entitiesController(seeEntitiesView);
        new NewBuildingController(cardLayout, cards, newBuildingView);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ESCAPE && canPause == true){
                    canPause = false;
                    cardLayout.show(cards, "pause");
                    Main.stopped = true;
                    Main.SaveGame();
                }
                return false;
            }
        });

        new PauseController(cardLayout, cards, pauseView,this);
    }

    private void setView(){
        cardLayout = new CardLayout();
        cards = new JPanel();
        cards.setLayout(cardLayout);

        mainView = new MainView();
        seeEntitiesView = new SeeEntitiesView();
        newBuildingView = new NewBuildingView();
        pauseView = new PauseView();
        cards.add(mainView,"main");
        cards.add(seeEntitiesView,"entities");
        cards.add(newBuildingView,"new building");
        cards.add(pauseView,"pause");

        cardLayout.show(cards, "main");

        add(cards);
    }
}