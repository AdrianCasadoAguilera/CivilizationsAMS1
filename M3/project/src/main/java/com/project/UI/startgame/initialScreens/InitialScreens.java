package com.project.UI.startgame.initialScreens;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

import com.project.Main;
import com.project.UI.MainWindow;
import com.project.UI.startgame.StartController;
import com.project.UI.util.clips.Clips;
import com.project.UI.util.swing_elements.PButton;
import com.project.UI.util.swing_elements.PLabel;

public class InitialScreens extends JFrame {

    JPanel cards;
    CardLayout cardLayout;
    Image bgImage;

    InitialScreens instance = this;
    StartController cont;

    private int i;
    PButton nextButton;
    String[] txt;
    PLabel initialText;
    String name;

    public InitialScreens(StartController cont){
        super("Hello, dear visitor");
        Clips.playAudio(Clips.ELF);
        this.cont = cont;
        setResizable(false);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        bgImage = new ImageIcon(getClass().getResource("/com/project/UI/src/newPlayer.jpeg")).getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);

        setFirstView();

        nextButton = new PButton("Accept"){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g.create();

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25);

                g2.setColor(getBackground());
                g2.fill(roundedRectangle);

                super.paintComponent(g2);
                g2.dispose();
            }
        };
        nextButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(i<3){
                    Clips.playAudio(Clips.ELF);
                    i = (i+1)%txt.length;
                    initialText.setText(txt[i]);
                }else if(i==3){
                    Clips.playAudio(Clips.ELF);
                    nextButton.setText("Of course!");
                    i = (i+1)%txt.length;
                    initialText.setText(txt[i]);
                }else{
                    Clips.stopPlaying(Clips.START);
                    instance.dispose();
                    cont.executeApp(name);
                }
            }
            
        });

        add(cards);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setFirstView(){
        JPanel firstPanel = new JPanel(new BorderLayout()){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(bgImage, 0, 0, this);
            }
        };

        PLabel initialText = new PLabel("Hi! What are you doing here?"){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25);

                g2.setColor(getBackground());
                g2.fill(roundedRectangle);

                super.paintComponent(g2);
                g2.dispose();
            };
        };
        initialText.setForeground(Color.BLACK);
        initialText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JPanel initialTextPanel = new JPanel();
        initialTextPanel.setOpaque(false);
        initialTextPanel.add(initialText);
        initialTextPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel optionsPanel = new JPanel();
            optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
            // optionsPanel.setOpaque(false);
            PButton justWalkingButton = new PButton("I was just going for a walk.");
                justWalkingButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                justWalkingButton.addActionListener(e->{
                    setSecondView(0);
                });
            justWalkingButton.setAlignmentX(CENTER_ALIGNMENT);
            justWalkingButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            PButton dontAskMeButton = new PButton("None of your business.");
                dontAskMeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                dontAskMeButton.addActionListener(e->{
                    setSecondView(1);
                });
            dontAskMeButton.setAlignmentX(CENTER_ALIGNMENT);
            dontAskMeButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

            optionsPanel.add(justWalkingButton);
            optionsPanel.add(dontAskMeButton);

        firstPanel.add(initialTextPanel,BorderLayout.NORTH);
        firstPanel.add(optionsPanel,BorderLayout.SOUTH);
        
        cards.add(firstPanel,"1");

        cardLayout.show(cards, "1");
    }

    private void setSecondView(int prev){
        JPanel secondPanel = new JPanel(new BorderLayout()){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(bgImage, 0, 0, this);
            }
        };
        String txt;
        if(prev==0){
            txt = "That's cool! Anyways, what's your name?";
        }else{
            txt = "Oookay... I was just asking. Can I know your name?";
        }
        PLabel initialText = new PLabel(txt){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25);

                g2.setColor(getBackground());
                g2.fill(roundedRectangle);

                super.paintComponent(g2);
                g2.dispose();
            };
        };
        initialText.setForeground(Color.BLACK);
        initialText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JPanel initialTextPanel = new JPanel();
        initialTextPanel.setOpaque(false);
        initialTextPanel.add(initialText);
        initialTextPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel optionsPanel = new JPanel();
            optionsPanel.setOpaque(false);

            JTextField nameField = new JTextField(10);
            nameField.setFont(new Font("Arial",Font.BOLD,15));
            nameField.setBackground(Color.LIGHT_GRAY);

            PButton acceptButton = new PButton("Accept"){
                @Override
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D)g.create();

                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25);

                    g2.setColor(getBackground());
                    g2.fill(roundedRectangle);

                    super.paintComponent(g2);
                    g2.dispose();
                }
            };
            acceptButton.setBackground(Color.LIGHT_GRAY);
            
            acceptButton.addActionListener(e->{
                if(nameField.getText()!=""){
                    setThirdView(nameField.getText());
                }
            });

        optionsPanel.add(nameField);
        optionsPanel.add(acceptButton);

        secondPanel.add(initialTextPanel,BorderLayout.NORTH);
        secondPanel.add(optionsPanel,BorderLayout.SOUTH);

        cards.add(secondPanel,"2");
        cardLayout.show(cards, "2");
    }

    private void setThirdView(String name){
        JPanel secondPanel = new JPanel(new BorderLayout()){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(bgImage, 0, 0, this);
            }
        };
        this.name = name;
        txt = new String[]{"Hi "+name+", nice to meet you!","I'm glad you found us, we need help.","Our last leader abandoned us in the middle of a war.","We need someone to lead us.","Would you accept such a challenge?"};
        int i = 0;
        initialText = new PLabel(txt[0]){
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 25, 25);

                g2.setColor(getBackground());
                g2.fill(roundedRectangle);

                super.paintComponent(g2);
                g2.dispose();
            };
        };
        initialText.setForeground(Color.BLACK);
        initialText.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JPanel initialTextPanel = new JPanel();
        initialTextPanel.setOpaque(false);
        initialTextPanel.add(initialText);
        initialTextPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel optionsPanel = new JPanel();
            optionsPanel.setOpaque(false);

            JTextField nameField = new JTextField(10);
            nameField.setFont(new Font("Arial",Font.BOLD,15));
            nameField.setBackground(Color.LIGHT_GRAY);

            
            nextButton.setBackground(Color.LIGHT_GRAY);

        optionsPanel.add(nextButton);

        secondPanel.add(initialTextPanel,BorderLayout.NORTH);
        secondPanel.add(optionsPanel,BorderLayout.SOUTH);

        cards.add(secondPanel,"2");
        cardLayout.show(cards, "2");
    }
}
