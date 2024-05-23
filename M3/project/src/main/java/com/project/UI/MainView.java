package com.project.UI;

import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.swing_elements.*;

import java.awt.*;
import javax.swing.*;

public class MainView extends JPanel {

    // MENU OPTIONS ELEMENTS
    public JPanel menuOptionsPanel;
    public PButton pause;
    public PButton resume;

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
    }
    
    private void setNorthPanel(){
        resourcesPanel = new ResourcesPanel();

        add(resourcesPanel,BorderLayout.NORTH);
    }

    private void setUpButtons(){
        createBuildingButton = new PButton("Create Building");
        trainButton = new PButton("Train Units");
        upgradeTechLevelButton = new PButton("Upgrade Technology Level");

        pause = new PButton("Pause");
        resume = new PButton("Resume");
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
        menuOptionsPanel = new JPanel();
        menuOptionsPanel.setLayout(new FlowLayout());
        menuOptionsPanel.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.BLACK));
        menuOptionsPanel.setBackground(Color.LIGHT_GRAY);

        pause.setVisible(true);
        resume.setVisible(false);

        menuOptionsPanel.add(pause);
        menuOptionsPanel.add(resume);

        add(menuOptionsPanel,BorderLayout.SOUTH);
    }
}
