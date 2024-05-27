package com.project.UI.startgame;

import java.awt.event.*;
import javax.swing.*;

import com.project.*;
import com.project.UI.*;

import java.util.ArrayList;

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
            Main.stopped = false;
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
}

class ContinueView extends JPanel{

    ArrayList<JButton> playButtons = new ArrayList<>();
    ArrayList<JButton> deleteButtons = new ArrayList<>();

    public ContinueView(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Saves");
        add(title);
        title.setAlignmentX(CENTER_ALIGNMENT);
        LoadSaves();
    }

    public void LoadSaves() {
        removeAll();
        playButtons.clear();
        deleteButtons.clear();
        ArrayList<JPanel> saves = new ArrayList<>();
        String[] saveNames = Saves.getInstance().GetSaveNames();
        for (int i = 0; i < saveNames.length; i++) {
            JPanel save =  new JPanel();
            save.add(new JLabel(saveNames[i]));
            JButton plaButton = new JButton("Play");
            save.add(plaButton);
            playButtons.add(plaButton);
            JButton delButton = new JButton("Delete");
            save.add(delButton);
            deleteButtons.add(delButton);
            saves.add(save);
        }
        for (JPanel save : saves) {
            add(save);
        }
        revalidate();
        repaint();
    }
}
