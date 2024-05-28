package com.project.UI.startgame;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.project.Saves;

public class ContinueView extends JPanel{

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