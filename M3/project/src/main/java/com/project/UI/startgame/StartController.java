package com.project.UI.startgame;

import java.awt.event.*;
import javax.swing.*;
import com.project.*;
import com.project.UI.*;
import com.project.UI.startgame.initialScreens.InitialScreens;

public class StartController {

    private StartGameUI wdw;
    private MainPanel mainPanel;

    public StartController(StartGameUI wdw, MainPanel mainPanel) {
        this.wdw = wdw;
        this.mainPanel = mainPanel;
        setListeners();
    }

    private void setListeners() {
        mainPanel.closeButton.addActionListener(e -> System.exit(0));
        mainPanel.newGameButton.addActionListener(e -> {
            askName();
            wdw.dispose();
        });
        mainPanel.continueButton.addActionListener(e -> {
            wdw.remove(mainPanel);
            ContinueView continueView = new ContinueView();
            wdw.add(continueView);
            wdw.revalidate();
            wdw.repaint();
            setContinueViewEvents(continueView);
        });
    }

    private void setContinueViewEvents(ContinueView continueView) {
        continueView.getPlayButton().addActionListener(e -> {
            int selectedIndex = continueView.getSavesList().getSelectedRow();
            if (selectedIndex != -1) {
                ContinueSave(selectedIndex).actionPerformed(e);
            } else {
                JOptionPane.showMessageDialog(wdw, "Please select a save to play.");
            }
        });

        continueView.getDeleteButton().addActionListener(e -> {
            int selectedIndex = continueView.getSavesList().getSelectedRow();
            if (selectedIndex != -1) {
                Saves.getInstance().DeleteSaveData(selectedIndex);
                continueView.LoadSaves();
            } else {
                JOptionPane.showMessageDialog(wdw, "Please select a save to delete.");
            }
        });
    }

    private ActionListener ContinueSave(final int index) {
        return e -> {
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
        };
    }

    private String askName() {
        new InitialScreens(this);
        return "";
    }

    public void executeApp(String name) {
        Main.ActiveSave = Main.saves.AddNewSaveData(name);
        Main.NextEnemyArmy = null;
        Main.saves.LoadSaveData(Main.ActiveSave);
        MainWindow m = new MainWindow();
        m.setVisible(true);
        m.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                Main.closeApp();
            }
        });
        Main.stopped = false;
    }
}
