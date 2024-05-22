package com.project.UI;

import java.awt.*;

import javax.swing.*;

import com.project.UI.entities.*;

public class MainWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;

    private MainView mainView;
    private SeeEntitiesView seeEntitiesView;
    
    public MainWindow(){
        super("Civilizations");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setView();

        new Controller(mainView);
        new entitiesController(seeEntitiesView);
    }

    private void setView(){
        cardLayout = new CardLayout();
        cards = new JPanel();
        cards.setLayout(cardLayout);

        mainView = new MainView();
        seeEntitiesView = new SeeEntitiesView();
        cards.add(mainView,"main");
        cards.add(seeEntitiesView,"entities");

        cardLayout.show(cards, "main");

        add(cards);
    }

}