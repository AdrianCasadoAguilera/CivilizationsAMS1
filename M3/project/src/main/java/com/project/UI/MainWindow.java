package com.project.UI;

import com.project.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainWindow extends JFrame {
    
    private MainView mainView;
    private StatsView statsView;
    private CardLayout cardLayout;
    private JPanel cards;
    private ResourcesMenu resourcesMenu;

    private Model model;

    public MainWindow(){
        super("Civilizations");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        model = new Model(Civilization.getInstance());

        // Temporitzador d'actualització de la info al Swing
        setTimer();

        setCards();

        setController();
    }

    private void setTimer(){
        int delay = 100; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateResources();
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    private void setCards(){
        mainView = new MainView(model);
        statsView = new StatsView(model);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        cards.add(mainView,"main");
        cards.add(statsView,"stats");

        cardLayout.show(cards,"main");

        add(cards);
    }

    private void setController(){
        new Controller(mainView, statsView, cardLayout, cards);
    }

    private void updateResources(){
        model.update();
        updateViews();
    }

    private void updateViews(){
        statsView.update();
        mainView.update();
    }
}
