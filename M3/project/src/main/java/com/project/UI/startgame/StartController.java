package com.project.UI.startgame;

import com.project.Main;
import com.project.UI.MainWindow;

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
            new Thread(new Runnable() {
                public void run() {
                    wdw.dispose();Main.NewGame("");
                }
            }).start();
        });
    }
}
