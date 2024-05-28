package com.project.UI.Pause;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.project.Main;
import com.project.UI.MainWindow;

public class PauseController {
    
    private CardLayout layout;
    private JPanel cards;
    private PauseView pauseView;
    private MainWindow wdw;

    public PauseController(CardLayout layout,JPanel cards,PauseView pauseView,MainWindow wdw){
        this.layout = layout;
        this.cards = cards;
        this.pauseView = pauseView;
        this.wdw = wdw;

        initListeners();
    }

    private void initListeners(){
        pauseView.resumeButton.addActionListener(e->{
            wdw.canPause = true;
            layout.show(cards, "main");
            Main.stopped = false;
        });
        pauseView.exitButton.addActionListener(e->{
            wdw.dispose();
        });
    }
}
