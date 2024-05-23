package com.project.UI;

import java.awt.*;

import javax.swing.*;

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
    
    public MainWindow(){
        super("Civilization");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setView();

        new Controller(cardLayout,cards,mainView);
        new entitiesController(seeEntitiesView);
        new NewBuildingController(cardLayout, cards, newBuildingView);
    }

    private void setView(){
        cardLayout = new CardLayout();
        cards = new JPanel();
        cards.setLayout(cardLayout);

        mainView = new MainView();
        seeEntitiesView = new SeeEntitiesView();
        newBuildingView = new NewBuildingView();
        cards.add(mainView,"main");
        cards.add(seeEntitiesView,"entities");
        cards.add(newBuildingView,"new building");

        cardLayout.show(cards, "main");

        add(cards);
    }
}