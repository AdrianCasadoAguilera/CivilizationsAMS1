package com.project.UI;

import javax.swing.*;
import java.awt.*;
import com.project.*;

public class StartView extends JPanel {
    
    public JButton newGameButton;
    public JButton continueButton;

    public StartView(){

        Saves saves = Saves.getInstance();
        if(saves.GetSaveCount()>0){
            continueButton = new JButton("Continue"); 
        }
        setLayout(new FlowLayout());

        newGameButton = new JButton("New Game");
        add(newGameButton);
    }

}
