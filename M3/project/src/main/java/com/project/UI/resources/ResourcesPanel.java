package com.project.UI.resources;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;

import com.project.UI.util.fonts.Fonts;

public class ResourcesPanel extends JPanel {
    
    public FlowLayout layout;
    public Image backgroundImage;

    public JPanel woodPanel;
        public JLabel woodImageLabel;
        public JLabel woodLabel;
    public JPanel foodPanel;
        public JLabel foodImageLabel;
        public JLabel foodLabel;
    public JPanel ironPanel;
        public JLabel ironImageLabel;
        public JLabel ironLabel;
    public JPanel manaPanel;
        public JLabel manaImageLabel;
        public JLabel manaLabel;

    public ResourcesPanel(){
        layout = new FlowLayout();
        setLayout(layout);

        initBackgroundImage();

        initComponents();

        new ResourcesController(this);
    }

    private void initComponents(){
        woodPanel = new JPanel();
            woodImageLabel = new JLabel();
                URL urlWood = getClass().getResource("/com/project/UI/src/resources_wood.png");
                ImageIcon woodIcon = new ImageIcon(new ImageIcon(urlWood).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            woodImageLabel.setIcon(woodIcon);
            woodLabel = new JLabel("000");
            woodLabel.setFont(Fonts.getInstance().itemsFont);
            woodLabel.setForeground(new Color(255,255,255));
        woodPanel.add(woodImageLabel);
        woodPanel.add(woodLabel);

        foodPanel = new JPanel();
            foodImageLabel = new JLabel();
                URL urlFood = getClass().getResource("/com/project/UI/src/resources_food.png");
                ImageIcon foodIcon = new ImageIcon(new ImageIcon(urlFood).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            foodImageLabel.setIcon(foodIcon);
            foodLabel = new JLabel("000");
            foodLabel.setFont(Fonts.getInstance().itemsFont);
            foodLabel.setForeground(new Color(255,255,255));
        foodPanel.add(foodImageLabel);
        foodPanel.add(foodLabel);

        ironPanel = new JPanel();
            ironImageLabel = new JLabel();
                URL urlIron = getClass().getResource("/com/project/UI/src/resources_iron.png");
                ImageIcon ironIcon = new ImageIcon(new ImageIcon(urlIron).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            ironImageLabel.setIcon(ironIcon);
            ironLabel = new JLabel("000");
            ironLabel.setFont(Fonts.getInstance().itemsFont);
            ironLabel.setForeground(new Color(255,255,255));
        ironPanel.add(ironImageLabel);
        ironPanel.add(ironLabel);

        manaPanel = new JPanel();
            manaImageLabel = new JLabel();
                URL urlMana = getClass().getResource("/com/project/UI/src/resources_mana.png");
                ImageIcon manaIcon = new ImageIcon(new ImageIcon(urlMana).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            manaImageLabel.setIcon(manaIcon);
            manaLabel = new JLabel("000");
            manaLabel.setFont(Fonts.getInstance().itemsFont);
            manaLabel.setForeground(new Color(255,255,255));
        manaPanel.add(manaImageLabel);
        manaPanel.add(manaLabel);

        woodPanel.setOpaque(false);
        foodPanel.setOpaque(false);
        ironPanel.setOpaque(false);
        manaPanel.setOpaque(false);

        add(foodPanel);
        add(woodPanel);
        add(ironPanel);
        add(manaPanel);
    }

    private void initBackgroundImage() {
        // Ajusta la ruta de la imagen de fondo según sea necesario
        URL backgroundUrl = getClass().getResource("/com/project/UI/src/resources_background.jpg");
        if (backgroundUrl != null) {
            backgroundImage = new ImageIcon(backgroundUrl).getImage();
        } else {
            System.out.println("No se encontró la imagen de fondo en la ruta especificada.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Dibujar la imagen de fondo
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
