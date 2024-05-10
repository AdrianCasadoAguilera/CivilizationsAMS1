package com.project.UI;

import com.project.*;

import javax.swing.*;
import java.awt.*;

public class StatsView extends View {
    
    public JButton goBack;
    private ResourcesMenu rsc;

    public StatsView(Model model){
        setLayout(new BorderLayout());

        rsc = new ResourcesMenu(model);
        setResources();
        setOptions();
    }

    private void setOptions(){
        JPanel options = new JPanel();
            goBack = new JButton("Go Back");
        options.add(goBack);

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
