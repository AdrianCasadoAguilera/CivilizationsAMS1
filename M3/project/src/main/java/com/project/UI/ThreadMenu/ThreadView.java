package com.project.UI.ThreadMenu;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.net.*;
import com.project.*;
import com.project.UI.nextBattle.NextBattlePanel;
import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.fonts.Fonts;
import com.project.UI.util.swing_elements.*;
import javax.swing.ImageIcon;

public class ThreadView extends JPanel {

    PButton returnButton = new PButton("Go Back");
    ArrayList<JLabel> labels = new ArrayList<>();
    NextBattlePanel nextBattlePanel;

    public ThreadView() {
        setLayout(new BorderLayout());
        initNorth();
        initContent();
        initButtons();
    }

    private void initContent() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        nextBattlePanel = new NextBattlePanel();
        contentPanel.add(nextBattlePanel,BorderLayout.NORTH);
        JPanel threadPanel = new JPanel();
        threadPanel.setLayout(new BoxLayout(threadPanel,BoxLayout.Y_AXIS));
        for (int i=0; i<4; i++) {
            JPanel panel = new JPanel();
            String unittype = UnitTypes.values()[i].toString();
            //Image
            URL url = getClass().getResource("/com/project/UI/src/" + unittype + ".png");
            ImageIcon imageicon = new ImageIcon(url);
            Image image = imageicon.getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
            JLabel labelImage = new JLabel();
            labelImage.setIcon(new ImageIcon(image));
            panel.add(labelImage);
            //Number
            JLabel label = new JLabel("0");
            label.setFont(Fonts.getInstance().itemsFont);
            labels.add(label);
            panel.add(label);
            threadPanel.add(panel);
        }
        updateValues();
        contentPanel.add(threadPanel, BorderLayout.CENTER);
        add(contentPanel, BorderLayout.CENTER);
    }

    public void updateValues() {
        for (int i=0; i<4; i++) {
            labels.get(i).setText(""+Main.CountUnitType(Main.NextEnemyArmy,UnitTypes.values()[i]));
        }
    }

    private void initNorth(){
        add(new ResourcesPanel(),BorderLayout.NORTH);
    }

    private void initButtons(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonsPanel.setBackground(Color.lightGray);
        returnButton = new PButton("Go back");
        buttonsPanel.add(returnButton);

        add(buttonsPanel,BorderLayout.SOUTH);
    }
}
