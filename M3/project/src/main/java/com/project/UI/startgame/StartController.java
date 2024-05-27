package com.project.UI.startgame;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.project.Main;
import com.project.UI.MainWindow;
import com.project.UI.resources.ResourcesController;

public class StartController {
    
    StartGameUI wdw;
    private MainPanel mainPanel;

    public StartController(StartGameUI wdw,MainPanel mainPanel){
        this.wdw = wdw;
        this.mainPanel = mainPanel;
        setListeners();
    }

    private void setListeners(){
        mainPanel.closeButton.addActionListener(e->{System.exit(0);});
        mainPanel.newGameButton.addActionListener(e->{
            String name = JOptionPane.showInputDialog(null,"Insert your name","Your name",JOptionPane.PLAIN_MESSAGE);
            wdw.dispose();
            new MainWindow().setVisible(true);

            Main.stopped = false;
            Main.ActiveSave = Main.saves.AddNewSaveData(name);
            Main.NextEnemyArmy = null;
            Main.saves.LoadSaveData(Main.ActiveSave);

            // Main.NewGame("");
        });
    }
}
