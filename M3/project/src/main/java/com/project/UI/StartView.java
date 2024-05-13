package com.project.UI;

import javax.swing.*;
import java.awt.*;
import com.project.*;

public class StartView extends JPanel {
    
    public JButton newGameButton;
    public JButton continueButton;

    public StartView(){
        setLayout(new FlowLayout());

        setTitle();

        String url = "./M3/project/src/main/java/com/project/UI/src/startImage.jpg";
        ImageIcon imageMenu = new ImageIcon(url);
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(imageMenu.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT)));
        
        add(imageLabel);
        setButtons();
    }

    private void setTitle(){
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());

        JLabel title = new JLabel("CIVILIZATION");
        JLabel subtitle = new JLabel("Powered by IETI©");

        title.setAlignmentX(CENTER_ALIGNMENT);
        subtitle.setAlignmentX(CENTER_ALIGNMENT);

        title.setFont(new Font("Arial",Font.BOLD,40));
        subtitle.setFont(new Font("Arial",Font.PLAIN,10));

        titlePanel.add(title);
        titlePanel.add(subtitle);

        add(titlePanel);
    }

    private void setButtons(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        newGameButton = new JButton("New Game");
        continueButton = new JButton("Continue"); 

        newGameButton.setAlignmentX(CENTER_ALIGNMENT);
        continueButton.setAlignmentX(CENTER_ALIGNMENT);
        
        setContinueAvailability();

        buttonsPanel.add(continueButton);
        buttonsPanel.add(newGameButton);

        add(buttonsPanel);
    }

    public void setContinueAvailability(){
        Saves saves = Saves.getInstance();
        continueButton.setEnabled(false);
        if(saves.GetSaveCount()>0){
            continueButton.setEnabled(true);
        }
    }

}
