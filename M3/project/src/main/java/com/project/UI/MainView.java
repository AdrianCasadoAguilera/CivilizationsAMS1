package com.project.UI;

import com.project.UI.entities.SeeEntitiesView;
import com.project.UI.nextBattle.BattleHappened;
import com.project.UI.nextBattle.NextBattleController;
import com.project.UI.nextBattle.NextBattlePanel;
import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.*;

import java.awt.*;
import javax.swing.*;

public class MainView extends JPanel {

    // NEXT BALLE ELEMENTS
    public JPanel southernPanel;
    public NextBattlePanel nextBattlePanel;
    public BattleHappened battleHappened;

    // RESOURCES ELEMENTS
    public ResourcesPanel resourcesPanel;

    // CENTRAL ELEMENTS
    public JPanel buttonsPanel;
        public PButton createBuildingButton;
        public PButton trainButton;
        public PButton upgradeTechLevelButton;
    public SeeEntitiesView infoPanel;

    public MainView(CardLayout cardLayout,JPanel cards){
        setLayout(new BorderLayout());

        setNorthPanel();
        setUpButtons();
        setCentralOptions();
        
        setMenuOptions();

        new NextBattleController(cardLayout,cards,nextBattlePanel,battleHappened);
    }
    
    private void setNorthPanel(){
        resourcesPanel = new ResourcesPanel();

        add(resourcesPanel,BorderLayout.NORTH);
    }

    private void setUpButtons(){
        createBuildingButton = new PButton("Create Building");
        trainButton = new PButton("Train Units");
        upgradeTechLevelButton = new PButton("Upgrade Technology Level");
    }

    private void setCentralOptions(){
        JPanel centralPanel = new JPanel();
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));

        buttonsPanel.add(createBuildingButton);
        buttonsPanel.add(trainButton);
        buttonsPanel.add(upgradeTechLevelButton);

        infoPanel = new SeeEntitiesView();

        centralPanel.add(infoPanel);
        centralPanel.add(buttonsPanel);
        add(centralPanel,BorderLayout.CENTER);
    }

    private void setMenuOptions(){
        southernPanel = new JPanel();
        southernPanel.setLayout(new BorderLayout());
        nextBattlePanel = new NextBattlePanel();

        battleHappened = new BattleHappened();
        battleHappened.setVisible(false);

        southernPanel.add(battleHappened,BorderLayout.CENTER);
        southernPanel.add(nextBattlePanel,BorderLayout.SOUTH);

        add(southernPanel,BorderLayout.SOUTH);
    }
}
