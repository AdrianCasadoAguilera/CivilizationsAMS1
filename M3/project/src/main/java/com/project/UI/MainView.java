package com.project.UI;

import com.project.*;

import javax.swing.*;
import java.awt.*;

public class MainView extends View {
    
    public JButton seeStats;
    public JButton returnMenu;
    private ResourcesMenu rsc;

    public MainView(Model model){
        setLayout(new BorderLayout());

        rsc = new ResourcesMenu(model);
        setResources();
        setOptions();
    }

    private void setOptions(){
        JPanel options = new JPanel();
            seeStats = new JButton("See Stats");
            returnMenu = new JButton("Back to Menu");
        options.add(seeStats);
        options.add(returnMenu);

        add(options,BorderLayout.SOUTH);
    }

    private void setResources(){
        add(rsc,BorderLayout.NORTH);
    }

    public void update(){
        rsc.updateResources();
        add(rsc,BorderLayout.NORTH);
    }
}