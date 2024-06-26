package com.project.UI.util.swing_elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notification extends JPanel {
    private static final int DURATION = 3000; // Duración de la notificación en milisegundos

    public Notification(JFrame frame, String message, Color bgColor) {
        setLayout(new BorderLayout());
        setBackground(bgColor);
        setOpaque(false);

        // Crear un panel interno para la notificación
        JPanel innerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f)); // Semitransparencia
                g2d.setColor(bgColor);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
            }
        };
        innerPanel.setOpaque(false);
        innerPanel.setLayout(new BorderLayout());
        innerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel();
        label.setText("<html><p>" + message + "</p></html>");
        label.setForeground(Color.BLACK); // Puedes ajustar el color del texto aquí
        innerPanel.add(label, BorderLayout.CENTER);

        add(innerPanel, BorderLayout.CENTER);

        // Configurar la posición y el tamaño del panel
        int width = 300;
        int height = 100;
        int x = (frame.getWidth() - width) / 2;
        int y = 50;
        setBounds(x, y, width, height);

        // Añadir el panel de notificación al JFrame
        frame.getLayeredPane().add(this, JLayeredPane.POPUP_LAYER);

        // Crear un temporizador para ocultar el panel de notificación después de un tiempo
        Timer timer = new Timer(DURATION, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getLayeredPane().remove(Notification.this);
                frame.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
