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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;

public class LocalizarTrechoView extends JFrame {
    
    private final EdicaoDeTextoView mainView;
    private Color backgroundColor;
    private Color white;
    private Font font;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton localizarButton;
    private JButton fecharButton;

    public LocalizarTrechoView(EdicaoDeTextoView mainView) {
        this.mainView = mainView;
        this.backgroundColor = new Color(64, 64, 64);
        this.white = new Color(255, 255, 255);
        this.font = new Font("Serif", 0, 12);   
        this.init();
        this.setLocationRelativeTo(this);    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.events();
    }

    private void init() {
        this.setTitle("Localização de Trecho");
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setPreferredSize(new Dimension(400, 160));
        this.panel.setBackground(this.backgroundColor);
        this.label = new JLabel();
        this.label.setText("Digite o trecho.");
        this.label.setBounds(16, 16, 368, 32);
        this.label.setOpaque(true);
        this.label.setBackground(this.backgroundColor);
        this.label.setForeground(this.white);
        this.label.setFont(this.font);
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.panel.add(this.label);
        this.textField = new JTextField();
        this.textField.setBounds(16, 64, 368, 32);
        this.textField.setFont(this.font);
        this.panel.add(this.textField);
        this.localizarButton = new JButton();
        this.localizarButton.setBounds(64, 112, 128, 32);
        this.localizarButton.setText("Localizar");
        this.localizarButton.setBackground(this.backgroundColor);
        this.localizarButton.setForeground(this.white);
        this.localizarButton.setFont(this.font);
        this.panel.add(this.localizarButton);
        this.fecharButton = new JButton();
        this.fecharButton.setBounds(208, 112, 128, 32);
        this.fecharButton.setText("Fechar");
        this.fecharButton.setBackground(this.backgroundColor);
        this.fecharButton.setForeground(this.white);
        this.fecharButton.setFont(this.font);
        this.panel.add(this.fecharButton);
        this.add(this.panel);
        this.pack();
    }

    private void localizar() {
        try {
            this.mainView.localizar(this.textField.getText());
        } catch (BadLocationException exception) {
            this.label.setText(exception.getMessage());
        }
    }

    private void fechar() {
        this.dispose();
    }

    private void events() {
        this.textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                localizar();
            }
        });
        this.localizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                localizar();
            }
        });
        this.localizarButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    localizar();
                }
            }
        });
        this.fecharButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fechar();
            }
        });
        this.fecharButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    fechar();
                }
            }
        });
    }

}
