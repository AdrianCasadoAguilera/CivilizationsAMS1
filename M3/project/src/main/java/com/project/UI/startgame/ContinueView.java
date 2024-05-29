package com.project.UI.startgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.project.Saves;
import com.project.UI.util.fonts.*;

public class ContinueView extends JPanel {

    private JTable savesList;
    private DefaultTableModel savesListModel;
    public JButton playButton;
    public JButton deleteButton;

    public ContinueView() {
        setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());

        // Título
        JLabel title = new JLabel("Select Game", JLabel.CENTER);
        title.setFont(Fonts.getInstance().rusticFont);
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(title, BorderLayout.NORTH);

        // Lista de partidas
        savesListModel = new DefaultTableModel();
        savesListModel.addColumn("Name");
        savesList = new JTable(savesListModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Deshabilitar la edición de celdas
            }
        };
        savesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        savesList.setFont(new Font("Monospaced", Font.PLAIN, 16)); // Fuente más pequeña
        savesList.setForeground(Color.WHITE);
        savesList.setBackground(Color.DARK_GRAY);
        savesList.setRowHeight(30);
        savesList.setShowGrid(false);
        savesList.setIntercellSpacing(new Dimension(0, 0));

        // Ocultar y eliminar el espacio del encabezado de la tabla
        JTableHeader header = savesList.getTableHeader();
        header.setPreferredSize(new Dimension(0, 0));

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        cellRenderer.setForeground(Color.WHITE);
        cellRenderer.setBackground(Color.DARK_GRAY);
        savesList.setDefaultRenderer(Object.class, cellRenderer);

        JScrollPane scrollPane = new JScrollPane(savesList);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setBackground(Color.DARK_GRAY);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.DARK_GRAY);
        playButton = new JButton("Play");
        deleteButton = new JButton("Delete");
        styleButton(playButton);
        styleButton(deleteButton);
        buttonsPanel.add(playButton);
        buttonsPanel.add(deleteButton);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Cargar partidas
        LoadSaves();
    }

    private void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(Fonts.getInstance().rusticFont);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.GRAY);
        button.setPreferredSize(new Dimension(120, 40));
        button.setFocusPainted(false);
        // button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                button.setBackground(new Color(115, 115, 115));
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                button.setBackground(Color.GRAY);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                button.setBackground(new Color(115, 115, 115));
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                button.setBackground(Color.GRAY);
            }
            
        });
    }

    public void LoadSaves() {
        // Limpiar el modelo de la tabla antes de recargar los datos
        savesListModel.setRowCount(0);
        
        String[] saveNames = Saves.getInstance().GetSaveNames();
        for (String saveName : saveNames) {
            savesListModel.addRow(new Object[]{saveName});
        }

        // Actualizar la interfaz
        revalidate();
        repaint();
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTable getSavesList() {
        return savesList;
    }
}
