package com.project.UI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import com.project.Main;
import com.project.SaveData;
import com.project.Saves;
import com.project.Spearman;
import com.project.UI.entities.*;
import com.project.UI.newBuilding.NewBuildingController;
import com.project.UI.newBuilding.NewBuildingView;
import com.project.UI.newUnits.TrainUnitsController;
import com.project.UI.newUnits.TrainUnitsView;
import com.project.UI.newUnits.unitsViews.*;
import com.project.UI.nextBattle.NextBattleController;

public class MainWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;

    private MainView mainView;
    private NewBuildingView newBuildingView;
    private TrainUnitsView trainUnitsView;
    private PauseView pauseView;
    public BattleLogView battleLog;

    public SwordsmanView swordsmanView;
    public SpearmanView spearmanView;
    public CrossbowView crossbowView;
    public CannonView cannonView;

    public boolean canPause = true;  
    
    public MainWindow(){
        super("Civilization");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setView();

        new Controller(cardLayout,cards,mainView);
        new TrainUnitsController(cardLayout, cards, trainUnitsView, swordsmanView, spearmanView, crossbowView, cannonView);
        new NewBuildingController(cardLayout, cards, newBuildingView);
        new UnitsViewsController(cardLayout, cards, swordsmanView, spearmanView, crossbowView, cannonView);

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
        addUnitsViews();
        pauseView = new PauseView();
        battleLog = new BattleLogView();

        cards.add(mainView,"main");
        cards.add(newBuildingView,"new building");
        cards.add(trainUnitsView,"train units");
        cards.add(pauseView,"pause");
        cards.add(battleLog,"battlelog");

        cardLayout.show(cards, "main");

        add(cards);
    }

    private void addUnitsViews(){
        swordsmanView = new SwordsmanView();
        spearmanView = new SpearmanView();
        crossbowView = new CrossbowView();
        cannonView = new CannonView();

        cards.add(swordsmanView,"swordsman");
        cards.add(spearmanView,"spearman");
        cards.add(crossbowView,"crossbow");
        cards.add(cannonView,"cannon");
    }
}