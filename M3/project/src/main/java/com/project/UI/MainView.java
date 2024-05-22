package com.project.UI;

import java.awt.*;
import javax.swing.*;

public class MainView extends JPanel {

    // MENU OPTIONS ELEMENTS
    public JPanel menuOptionsPanel;
    public JButton pause;
    public JButton resume;

    // CENTRAL ELEMENTS
    public JPanel centralPanel;
    public JButton createBuildingButton;
    public JButton trainButton;
    public JButton upgradeTechLevelButton;

    public MainView(){
        setLayout(new BorderLayout());

        setUpButtons();
        setCentralOptions();
        
        setMenuOptions();
    }

    private void setUpButtons(){
        createBuildingButton = new JButton("Create Building");
        trainButton = new JButton("Train Units");
        upgradeTechLevelButton = new JButton("Upgrade Technology Level");

        upgradeTechLevelButton.setBorderPainted(false);
        // upgradeTechLevelButton.back

        pause = new JButton("Pause");
        resume = new JButton("Resume");
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
