package com.project.UI;

import com.project.*;

public class Controller {

    private MainView mainView;

    public Controller(MainView mainView){
        this.mainView = mainView;

        setMainListeners();
    }

    private void setMainListeners(){
        mainView.pause.addActionListener(e->{
            Main.stopped = true;
            mainView.pause.setVisible(false);
            mainView.resume.setVisible(true);
            Main.SaveGame();
        });
        mainView.resume.addActionListener(e->{
            Main.stopped = false;
            mainView.pause.setVisible(true);
            mainView.resume.setVisible(false);
            Main.SaveGame();
        });
    }
    
}
