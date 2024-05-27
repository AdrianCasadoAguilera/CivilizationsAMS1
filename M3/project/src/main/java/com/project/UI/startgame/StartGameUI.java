package com.project.UI.startgame;

import java.awt.GraphicsEnvironment;
import javax.swing.*;

public class StartGameUI extends JFrame {

    private MainPanel mainPanel;

    public StartGameUI(){
        super("Civilizations AMS1");

        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setElements();
        setSize(614,300);

        new StartController(this,mainPanel);
    }

    private void setElements(){
        mainPanel = new MainPanel();

        add(mainPanel);
    }
}
