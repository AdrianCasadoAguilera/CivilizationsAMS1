package com.project.UI.ThreadMenu;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import com.project.Main;
import com.project.UnitTypes;
import com.project.UI.nextBattle.NextBattlePanel;
import com.project.UI.resources.ResourcesPanel;
import com.project.UI.util.fonts.Fonts;
import com.project.UI.util.swing_elements.PButton;

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
        contentPanel.add(nextBattlePanel, BorderLayout.NORTH);
        JPanel threadPanel = new JPanel();
        threadPanel.setLayout(new BoxLayout(threadPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < 4; i++) {
            JPanel panel = new JPanel();
            String unittype = UnitTypes.values()[i].toString();
            // Load image
            URL url = getClass().getResource("/com/project/UI/src/" + unittype.toLowerCase() + ".png");
            if (url != null) {
                ImageIcon imageIcon = new ImageIcon(url);
                Image image = imageIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                JLabel labelImage = new JLabel();
                labelImage.setIcon(new ImageIcon(image));
                panel.add(labelImage);
            } else {
                System.out.println("Recurso no encontrado: /com/project/UI/src/" + unittype + ".png");
            }
            // Number
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
        for (int i = 0; i < 4; i++) {
            labels.get(i).setText("" + Main.CountUnitType(Main.NextEnemyArmy, UnitTypes.values()[i]));
        }
    }

    private void initNorth() {
        add(new ResourcesPanel(), BorderLayout.NORTH);
    }

    private void initButtons() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonsPanel.setBackground(Color.lightGray);
        returnButton = new PButton("Go back");
        buttonsPanel.add(returnButton);
        add(buttonsPanel, BorderLayout.SOUTH);
    }
}
