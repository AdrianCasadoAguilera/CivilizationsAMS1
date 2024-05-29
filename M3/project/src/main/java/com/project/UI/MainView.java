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
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MainView extends JPanel {

    Clip clip;
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

        setMusic();

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
        JPanel centralPanel = new JPanel();
        centralPanel.setOpaque(false);
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        buttonsPanel.setOpaque(false);
        buttonsPanel.setAlignmentX(CENTER_ALIGNMENT);

        buttonsPanel.add(createBuildingButton);
        buttonsPanel.add(trainButton);
        buttonsPanel.add(upgradeTechLevelButton);
        buttonsPanel.add(ThreadButton);
        buttonsPanel.add(BattlesButton);

        infoPanel = new SeeEntitiesView();
        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
        new entitiesController(infoPanel);

        centralPanel.add(infoPanel);
        centralPanel.add(buttonsPanel);

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

    private void setMusic(){
        URL route = getClass().getResource("/com/project/UI/src/audio/main_music.wav");
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(route));
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
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
