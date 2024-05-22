package com.project.UI.startgame;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class StartGameUI extends JFrame {

    private MainPanel mainPanel;

    public StartGameUI(){
        super("Civilizations AMS1");

        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setElements();
        setSize(mainPanel.backgroundImage.getWidth(rootPane),mainPanel.backgroundImage.getHeight(rootPane));

        new StartController(this,mainPanel);
    }

    private void setElements(){
        mainPanel = new MainPanel();

        add(mainPanel);

        validate();
    }
}
