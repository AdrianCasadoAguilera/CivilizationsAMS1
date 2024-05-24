package com.project.UI;

import com.project.UI.nextBattle.NextBattleController;
import com.project.UI.nextBattle.NextBattlePanel;
import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.*;

import java.awt.*;
import javax.swing.*;

public class MainView extends JPanel {

    // NEXT BALLE ELEMENTS
    public NextBattlePanel nextBattlePanel;

    // RESOURCES ELEMENTS
    public ResourcesPanel resourcesPanel;

    // CENTRAL ELEMENTS
    public JPanel centralPanel;
    public PButton createBuildingButton;
    public PButton trainButton;
    public PButton upgradeTechLevelButton;

    public MainView(){
        setLayout(new BorderLayout());

        setNorthPanel();
        setUpButtons();
        setCentralOptions();
        
        setMenuOptions();

        new NextBattleController(nextBattlePanel);
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
        centralPanel = new JPanel();
        centralPanel.setLayout(new FlowLayout());
        centralPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        centralPanel.add(createBuildingButton);
        centralPanel.add(trainButton);
        centralPanel.add(upgradeTechLevelButton);

        add(centralPanel,BorderLayout.CENTER);
    }

    private void setMenuOptions(){
        nextBattlePanel = new NextBattlePanel();

        add(nextBattlePanel,BorderLayout.SOUTH);
    }
}
