package com.project.UI;

import com.project.UI.Battles.BattleLogController;
import com.project.UI.Battles.BattleLogView;
import com.project.UI.entities.SeeEntitiesView;
import com.project.UI.entities.entitiesController;
import com.project.UI.nextBattle.BattleHappened;
import com.project.UI.nextBattle.NextBattleController;
import com.project.UI.nextBattle.NextBattlePanel;
import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.*;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class MainView extends JPanel {

    Image bgImage;

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
    public PButton ThreadButton;
    public PButton BattlesButton;
    public SeeEntitiesView infoPanel;
    public NextBattleController nextBattleController;
    public BattleLogController battleLogController;
    public BattleLogView battleLogView;

    public MainView(CardLayout cardLayout,JPanel cards){
        setLayout(new BorderLayout());

        initBgImage();

        setNorthPanel();
        setUpButtons();
        setCentralOptions();
        
        setMenuOptions();

        nextBattleController = new NextBattleController(cardLayout,cards,nextBattlePanel,battleHappened);
        nextBattleController.battleLogController = this.battleLogController;
        nextBattleController.battleLogView = this.battleLogView;

    }
    
    private void setNorthPanel(){
        resourcesPanel = new ResourcesPanel();

        add(resourcesPanel,BorderLayout.NORTH);
    }

    private void setUpButtons(){
        createBuildingButton = new PButton("Create Building");
        trainButton = new PButton("Train Units");
        upgradeTechLevelButton = new PButton("Upgrade Technology Level");
        ThreadButton = new PButton("View Thread");
        BattlesButton = new PButton("View Battles");
    }

    private void setCentralOptions(){
        JPanel centralPanel = new JPanel(new GridBagLayout());
        centralPanel.setOpaque(false);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonsPanel.setBackground(new Color(255, 255, 255, 128)); 

        buttonsPanel.add(createBuildingButton);
        buttonsPanel.add(trainButton);
        buttonsPanel.add(upgradeTechLevelButton);
        buttonsPanel.add(ThreadButton);
        buttonsPanel.add(BattlesButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;

        centralPanel.add(buttonsPanel, gbc);

        infoPanel = new SeeEntitiesView();
        new entitiesController(infoPanel);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        centralPanel.add(infoPanel, gbc);

        add(centralPanel, BorderLayout.CENTER);
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

    private void initBgImage(){
        URL imageURL = getClass().getResource("/com/project/UI/src/mainBgImage.gif");
        bgImage = new ImageIcon(imageURL).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0,getWidth(),getHeight(), this);
        }else{
            System.out.println("NULL IMAGE");
        }
    }
}
