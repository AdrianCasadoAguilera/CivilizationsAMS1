package com.project.UI.Pause;

import java.awt.*;

import javax.swing.*;
import com.project.UI.util.swing_elements.*;

public class PauseView extends JPanel {
    
    public PWhiteButton resumeButton;
    public PWhiteButton exitButton;

    public PauseView(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);

        initComponents();
    }

    private void initComponents(){
        resumeButton = new PWhiteButton("Resume");
        resumeButton.setAlignmentX(CENTER_ALIGNMENT);
        resumeButton.setAlignmentY(CENTER_ALIGNMENT);
        
        exitButton = new PWhiteButton("Exit game");
        exitButton.setAlignmentX(CENTER_ALIGNMENT);
        exitButton.setAlignmentY(CENTER_ALIGNMENT);

        add(resumeButton);
        add(exitButton);
    }
}
