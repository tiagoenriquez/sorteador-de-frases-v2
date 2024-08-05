package com.tiagoenriquez.sorteadorDeFrases.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CopiadoComSucessoView extends JFrame {

    private Color backgroundColor;
    private Color white;
    private Font font;
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public CopiadoComSucessoView() { 
        this.backgroundColor = new Color(64, 128, 64);
        this.white = new Color(255, 255, 255);
        this.font = new Font("Serif", 0, 12);   
        this.init();
        this.setLocationRelativeTo(this);    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.events();
    }

    private void init() {
        this.setTitle("Sucesso!");
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setPreferredSize(new Dimension(400, 112));
        this.panel.setBackground(this.backgroundColor);
        this.label = new JLabel();
        this.label.setText("Texto copiado com sucesso.");
        this.label.setBounds(16, 16, 368, 32);
        this.label.setOpaque(true);
        this.label.setBackground(this.backgroundColor);
        this.label.setForeground(this.white);
        this.label.setFont(this.font);
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.panel.add(this.label);
        this.button = new JButton();
        this.button.setBounds(160, 64, 80, 32);
        this.button.setText("Fechar");
        this.button.setBackground(new Color(64, 64, 64));
        this.button.setForeground(this.white);
        this.button.setFont(this.font);
        this.panel.add(this.button);
        this.add(this.panel);
        this.pack();
    }

    private void fechar() {
        this.dispose();
    }

    private void events() {
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fechar();
            }
        });
        this.button.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    fechar();
                }
            }
        });
    }
    
}
