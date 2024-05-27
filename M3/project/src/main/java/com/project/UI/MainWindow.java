package com.project.UI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import com.project.Main;
import com.project.SaveData;
import com.project.Saves;
import com.project.UI.ThreadMenu.ThreadController;
import com.project.UI.ThreadMenu.ThreadView;
import com.project.UI.entities.*;
import com.project.UI.newBuilding.NewBuildingController;
import com.project.UI.newBuilding.NewBuildingView;
import com.project.UI.newUnits.TrainUnitsController;
import com.project.UI.newUnits.TrainUnitsView;
import com.project.UI.newUnits.unitsViews.SwordsmanView;
import com.project.UI.newUnits.unitsViews.UnitsViewsController;
import com.project.UI.nextBattle.NextBattleController;

public class MainWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;

    private MainView mainView;
    private NewBuildingView newBuildingView;
    private TrainUnitsView trainUnitsView;
    private PauseView pauseView;
    private ThreadView threadView;
    public BattleLogView battleLog;

    public SwordsmanView swordsmanView;

    public boolean canPause = true;  
    
    public MainWindow(){
        super("Civilization");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setView();

        new Controller(cardLayout,cards,mainView);
        new TrainUnitsController(cardLayout, cards, trainUnitsView);
        new NewBuildingController(cardLayout, cards, newBuildingView);
        new UnitsViewsController(cardLayout, cards, swordsmanView);
        new ThreadController(cardLayout, cards, threadView);

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

        mainView = new MainView(cardLayout,cards);
        newBuildingView = new NewBuildingView();
        trainUnitsView = new TrainUnitsView();
        threadView = new ThreadView();
        addUnitsViews();
        pauseView = new PauseView();
        battleLog = new BattleLogView();

        cards.add(mainView,"main");
        cards.add(newBuildingView,"new building");
        cards.add(trainUnitsView,"train units");
        cards.add(pauseView,"pause");
        cards.add(threadView, "thread");
        //cards.add(BattlesView, "battles");
        //cards.add(Technology, "tech");
        cards.add(battleLog,"battlelog");

        cardLayout.show(cards, "main");

        add(cards);
    }

    private void addUnitsViews(){
        swordsmanView = new SwordsmanView();

        cards.add(swordsmanView,"swordsman");
    }
}