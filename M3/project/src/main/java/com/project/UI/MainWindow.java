package com.project.UI;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import com.project.Main;
import com.project.SaveData;
import com.project.Saves;
import com.project.UI.Battles.BattleLogView;
import com.project.UI.Battles.BattlesController;
import com.project.UI.Battles.BattlesView;
import com.project.UI.Pause.PauseController;
import com.project.UI.Pause.PauseView;
import com.project.UI.Technology.TechnologyController;
import com.project.UI.Technology.TechnologyView;
import com.project.UI.ThreadMenu.ThreadController;
import com.project.UI.ThreadMenu.ThreadView;
import com.project.UI.newBuilding.NewBuildingController;
import com.project.UI.newBuilding.NewBuildingView;
import com.project.UI.newUnits.TrainUnitsController;
import com.project.UI.newUnits.TrainUnitsView;
import com.project.UI.newUnits.unitsViews.*;

public class MainWindow extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;

    private MainView mainView;
    private NewBuildingView newBuildingView;
    private TrainUnitsView trainUnitsView;
    private PauseView pauseView;
    private ThreadView threadView;
    private TechnologyView technologyView;
    private BattlesView battlesView;
    public BattleLogView battleLog;

    public SwordsmanView swordsmanView;
    public SpearmanView spearmanView;
    public CrossbowView crossbowView;
    public CannonView cannonView;
    public ArrowTowerView arrowTowerView;
    public CatapultView catapultView;
    public RocketLauncherView rocketLauncherView;
    public MagicianView magicianView;
    public PriestView priestView;

    public boolean canPause = true;  
    
    public MainWindow(){
        super("Civilization");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setResizable(false);

        setView();

        new Controller(cardLayout,cards,mainView);
        new TrainUnitsController(cardLayout, cards, trainUnitsView, swordsmanView, spearmanView, crossbowView, cannonView, arrowTowerView, catapultView, rocketLauncherView, magicianView, priestView);
        new NewBuildingController(cardLayout, cards, newBuildingView);
        new ThreadController(cardLayout, cards, threadView);
        new TechnologyController(cardLayout, cards, technologyView);
        BattlesController bc = new BattlesController(cardLayout, cards, battlesView, battleLog);
        mainView.nextBattleController.battleLogView = battleLog;
        mainView.nextBattleController.battleLogController = bc.battleLogController;
        new UnitsViewsController(cardLayout, cards, swordsmanView, spearmanView, crossbowView, cannonView, arrowTowerView, catapultView, rocketLauncherView, magicianView, priestView);

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
        technologyView = new TechnologyView();
        battlesView = new BattlesView();
        addUnitsViews();
        pauseView = new PauseView();
        battleLog = new BattleLogView();

        cards.add(mainView,"main");
        cards.add(newBuildingView,"new building");
        cards.add(trainUnitsView,"train units");
        cards.add(pauseView,"pause");
        cards.add(threadView, "thread");
        cards.add(battlesView, "battles");
        cards.add(technologyView, "tech");
        cards.add(battleLog,"battlelog");

        cardLayout.show(cards, "main");

        add(cards);
    }

    private void addUnitsViews(){
        swordsmanView = new SwordsmanView();
        spearmanView = new SpearmanView();
        crossbowView = new CrossbowView();
        cannonView = new CannonView();
        arrowTowerView = new ArrowTowerView();
        catapultView = new CatapultView();
        rocketLauncherView = new RocketLauncherView();
        magicianView = new MagicianView();
        priestView = new PriestView();

        cards.add(swordsmanView,"swordsman");
        cards.add(spearmanView,"spearman");
        cards.add(crossbowView,"crossbow");
        cards.add(cannonView,"cannon");
        cards.add(arrowTowerView,"arrowtower");
        cards.add(catapultView,"catapult");
        cards.add(rocketLauncherView,"rocketlauncher");
        cards.add(magicianView,"magician");
        cards.add(priestView,"priest");
    }
}