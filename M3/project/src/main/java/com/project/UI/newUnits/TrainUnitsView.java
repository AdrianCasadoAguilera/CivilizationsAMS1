package com.project.UI.newUnits;

import com.project.UI.resources.*;
import com.project.UI.util.swing_elements.*;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class TrainUnitsView extends JPanel {

    Image bgImage;

    public PButton returnButton;

    private ImageIcon swordsmanIcon;
    public RedButton swordsmanButton;
    private ImageIcon spearmanIcon;
    public RedButton spearmanButton;
    private ImageIcon crossbowIcon;
    public RedButton crossbowButton;
    private ImageIcon cannonIcon;
    public RedButton cannonButton;

    private ImageIcon arrowTowerIcon;
    public BlueButton arrowTowerButton;
    private ImageIcon catapultIcon;
    public BlueButton catapultButton;
    private ImageIcon rocketLauncherIcon;
    public BlueButton rocketLauncherButton;

    private ImageIcon magicianIcon;
    public PurpleButton magicianButton;
    private ImageIcon priestIcon;
    public PurpleButton priestButton;
 
    public TrainUnitsView(){
        setLayout(new BorderLayout());

        bgImage = new ImageIcon(getClass().getResource("/com/project/UI/src/bg_train.png")).getImage();

        initNorth();
        initOptions();
        initButtons();
    }

    private void initNorth(){
        add(new ResourcesPanel(),BorderLayout.NORTH);
    }

    private void initOptions(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        mainPanel.add(new BorderedLabel("Training Ground"){
            @Override
            public void setAlignmentX(float arg0) {
                super.setAlignmentX(CENTER_ALIGNMENT);
            }
        });

        initImages();

        JPanel attackUnitsPanel = new JPanel();
        attackUnitsPanel.setLayout(new GridLayout(1,3,20,20));
        attackUnitsPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
        attackUnitsPanel.setOpaque(false);

        swordsmanButton = new RedButton(swordsmanIcon);
        spearmanButton = new RedButton(spearmanIcon);
        crossbowButton = new RedButton(crossbowIcon);
        cannonButton = new RedButton(cannonIcon);

        attackUnitsPanel.add(swordsmanButton);
        attackUnitsPanel.add(spearmanButton);
        attackUnitsPanel.add(crossbowButton);
        attackUnitsPanel.add(cannonButton);

        mainPanel.add(new BorderedLabel("Attack Units"){
            @Override
            public void setFont(Font arg0) {
                super.setFont(arg0.deriveFont(20f));
            }
            @Override
            public void setAlignmentX(float arg0) {
                super.setAlignmentX(CENTER_ALIGNMENT);
            }
        });
        mainPanel.add(attackUnitsPanel);

        JPanel defenseUnitsPanel = new JPanel();
        defenseUnitsPanel.setLayout(new GridLayout(1,3,20,20));
        defenseUnitsPanel.setBorder(BorderFactory.createEmptyBorder(5, 30, 5, 30));
        defenseUnitsPanel.setOpaque(false);

        arrowTowerButton = new BlueButton(arrowTowerIcon);
        catapultButton = new BlueButton(catapultIcon);
        rocketLauncherButton = new BlueButton(rocketLauncherIcon);

        defenseUnitsPanel.add(arrowTowerButton);
        defenseUnitsPanel.add(catapultButton);
        defenseUnitsPanel.add(rocketLauncherButton);

        mainPanel.add(new BorderedLabel("Defense Units"){
            @Override
            public void setFont(Font arg0) {
                super.setFont(arg0.deriveFont(20f));
            }
            @Override
            public void setAlignmentX(float arg0) {
                super.setAlignmentX(CENTER_ALIGNMENT);
            }
        });
        mainPanel.add(defenseUnitsPanel);

        JPanel specialUnitsPanel = new JPanel();
        specialUnitsPanel.setLayout(new GridLayout(1,3,20,20));
        specialUnitsPanel.setBorder(BorderFactory.createEmptyBorder(5,30,5,30));
        specialUnitsPanel.setOpaque(false);

        magicianButton = new PurpleButton(magicianIcon);
        priestButton = new PurpleButton(priestIcon);

        specialUnitsPanel.add(magicianButton);
        specialUnitsPanel.add(priestButton);

        mainPanel.add(new BorderedLabel("Special Units"){
            @Override
            public void setFont(Font arg0) {
                super.setFont(arg0.deriveFont(20f));
            }
            @Override
            public void setAlignmentX(float arg0) {
                super.setAlignmentX(CENTER_ALIGNMENT);
            }
        });
        mainPanel.add(specialUnitsPanel);
        
        add(mainPanel,BorderLayout.CENTER);
    }

    private void initImages(){
        String linkString = "/com/project/UI/src/";
        URL link;

        link = getClass().getResource(linkString+"swordsman.png");
        swordsmanIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"spearman.png");
        spearmanIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"crossbow.png");
        crossbowIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"cannon.png");
        cannonIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"arrow_tower.png");
        arrowTowerIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"catapult.png");
        catapultIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"rocket_launcher.png");
        rocketLauncherIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"magician.png");
        magicianIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        link = getClass().getResource(linkString+"priest.png");
        priestIcon = new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
    }

    private void initButtons(){
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonsPanel.setBackground(Color.lightGray);
        returnButton = new PButton("Go back");
        buttonsPanel.add(returnButton);

        add(buttonsPanel,BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(bgImage!=null){
            g.drawImage(bgImage, 0, 0, getWidth(),getHeight(),this);
        }else{
            System.out.println("NULL IMAGE");
        }
    }
}
