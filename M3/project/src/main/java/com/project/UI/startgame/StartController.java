package com.project.UI.startgame;

import java.awt.event.*;

import com.project.*;
import com.project.UI.*;
import com.project.UI.startgame.initialScreens.InitialScreens;

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
            String name = askName();
            wdw.dispose();
            // Main.stopped = false;
            // Main.ActiveSave = Main.saves.AddNewSaveData(name);
            // Main.NextEnemyArmy = null;
            // Main.saves.LoadSaveData(Main.ActiveSave);
            // MainWindow m = new MainWindow();
            // m.setVisible(true);
            // m.addWindowListener(new WindowAdapter() {
            //     @Override
            //     public void windowClosing(WindowEvent windowEvent) {
            //         Main.closeApp();
            //     }
            // });
        });
        mainPanel.continueButton.addActionListener(e->{
            wdw.remove(mainPanel);
            ContinueView continueView = new ContinueView();
            wdw.add(continueView);
            wdw.revalidate();
            wdw.repaint();
            setContinueViewEvenets(continueView);
        });
    }

    private void setContinueViewEvenets(ContinueView continueView) {
        for (int i = 0; i < continueView.playButtons.size(); i++) {
            final int index = i;
            ActionListener listener = ContinueSave(i); 
            continueView.playButtons.get(i).addActionListener(listener);
            continueView.deleteButtons.get(i).addActionListener(ev->{
                Saves.getInstance().DeleteSaveData(index);
                continueView.LoadSaves();
                setContinueViewEvenets(continueView);
            });
        }
    }

    private ActionListener ContinueSave(final int index){
        return (e-> {
            wdw.dispose();
            Main.stopped = false;
            Main.ActiveSave = index;
            Saves.getInstance().LoadSaveData(index);
            MainWindow m = new MainWindow();
            m.setVisible(true);
            m.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    Main.closeApp();
                }
            });
        });
    }

    private String askName(){
        new InitialScreens();
        return "";
    }
}
