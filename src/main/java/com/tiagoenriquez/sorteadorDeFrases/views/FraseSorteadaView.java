package com.tiagoenriquez.sorteadorDeFrases.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.tiagoenriquez.sorteadorDeFrases.models.Sorteador;
import com.tiagoenriquez.sorteadorDeFrases.utils.SorteadorClipBoard;

public class FraseSorteadaView extends MainFrame {

    private final Sorteador sorteador;
    private JPanel frasesPanel;
    private JTextArea textArea;
    private JButton outraFraseButton;
    private JButton copiarButton;
    private JButton resetarButton;
    private JButton editarButton;

    public FraseSorteadaView(Sorteador sorteador) {
        this.sorteador = sorteador;
        this.init();
        this.setLocationRelativeTo(this);
        this.events();
    }

    private void init() {
        this.frasesPanel = new JPanel();
        this.frasesPanel.setLayout(null);
        this.frasesPanel.setPreferredSize(this.dimension);
        this.frasesPanel.setBackground(this.backgroundColor);
        this.textArea = new JTextArea();
        this.textArea.setText(this.sorteador.sortear());
        this.textArea.setBounds(16, 16, 768, 520);
        this.textArea.setOpaque(true);
        this.textArea.setBackground(this.backgroundColor);
        this.textArea.setForeground(this.white);
        this.textArea.setFont(this.font);
        this.textArea.setEditable(false);
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        this.frasesPanel.add(this.textArea);
        this.outraFraseButton = new JButton();
        this.outraFraseButton = new JButton();
        this.outraFraseButton.setBounds(16, 552, 180, 32);
        this.outraFraseButton.setText("Sortear Outra Frase");
        this.outraFraseButton.setBackground(this.backgroundColor);
        this.outraFraseButton.setForeground(this.white);
        this.outraFraseButton.setFont(this.font);
        this.frasesPanel.add(this.outraFraseButton);
        this.copiarButton = new JButton();
        this.copiarButton = new JButton();
        this.copiarButton.setBounds(212, 552, 180, 32);
        this.copiarButton.setText("Copiar");
        this.copiarButton.setBackground(this.backgroundColor);
        this.copiarButton.setForeground(this.white);
        this.copiarButton.setFont(this.font);
        this.frasesPanel.add(this.copiarButton);
        this.resetarButton = new JButton();
        this.resetarButton = new JButton();
        this.resetarButton.setBounds(408, 552, 180, 32);
        this.resetarButton.setText("Resetar");
        this.resetarButton.setBackground(this.backgroundColor);
        this.resetarButton.setForeground(this.white);
        this.resetarButton.setFont(this.font);
        this.frasesPanel.add(this.resetarButton);
        this.frasesPanel.add(this.copiarButton);
        this.editarButton = new JButton();
        this.editarButton = new JButton();
        this.editarButton.setBounds(604, 552, 180, 32);
        this.editarButton.setText("Editar Texto");
        this.editarButton.setBackground(this.backgroundColor);
        this.editarButton.setForeground(this.white);
        this.editarButton.setFont(this.font);
        this.frasesPanel.add(this.editarButton);
        this.add(this.frasesPanel);
        this.pack();
    }

    private void sortearOutraFrase() {
        this.textArea.setText(this.sorteador.sortear());
    }

    private void copiar() {
        new CopiadoComSucessoView().setVisible(true);
        new SorteadorClipBoard(this.textArea.getText()).copiar();
    }

    private void resetar() {
        this.dispose();
        new CadastroDeTextoView().setVisible(true);
    }

    private void editarTexto() {
        this.dispose();
        new EdicaoDeTextoView(this.sorteador).setVisible(true);
    }

    private void events() {
        this.outraFraseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                sortearOutraFrase();
            }
        });
        this.outraFraseButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    sortearOutraFrase();
                }
            }
        });
        this.copiarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                copiar();
            }
        });
        this.copiarButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    copiar();
                }
            }
        });
        this.resetarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                resetar();
            }
        });
        this.resetarButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    resetar();
                }
            }
        });
        this.editarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                editarTexto();
            }
        });
        this.editarButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    editarTexto();
                }
            }
        });
    }
    
}