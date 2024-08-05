package com.tiagoenriquez.sorteadorDeFrases.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CadastroDeTextoView extends MainFrame {

    private JPanel cadastroPanel;
    private JLabel label;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JButton button;

    public CadastroDeTextoView() {
        this.init();
        this.setLocationRelativeTo(this);
        this.events();
    }
    
    private void init() {
        this.cadastroPanel = new JPanel();
        this.cadastroPanel.setLayout(null);
        this.cadastroPanel.setPreferredSize(this.dimension);
        this.cadastroPanel.setBackground(this.backgroundColor);
        this.label = new JLabel();
        this.label.setText("Cole um texto");
        this.label.setBounds(0, 16, 800, 32);
        this.label.setOpaque(true);
        this.label.setBackground(this.backgroundColor);
        this.label.setForeground(this.white);
        this.label.setFont(this.font);
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.cadastroPanel.add(this.label);
        this.textArea = new JTextArea();
        this.textArea.setFont(this.font);
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        this.scrollPane = new JScrollPane(this.textArea);
        this.scrollPane.setBounds(16, 64, 768, 472);
        this.cadastroPanel.add(this.scrollPane);
        this.button = new JButton();
        this.button.setBounds(360, 554, 80, 32);
        this.button.setText("Inserir");
        this.button.setBackground(this.backgroundColor);
        this.button.setForeground(this.white);
        this.button.setFont(this.font);
        this.cadastroPanel.add(this.button);
        this.add(this.cadastroPanel);
        this.pack();
    }

    private void selecionarButton() {
        int posicao = this.textArea.getCaretPosition();
        String texto = this.textArea.getText();
        String antes = texto.substring(0, posicao);
        String depois = texto.substring(posicao, texto.length());
        this.textArea.setText(antes + depois);
        this.button.requestFocus();
    }

    private void cadastrarTexto() {
        this.dispose();
        new CadastroDeSeparadorView(this.textArea.getText()).setVisible(true);
    }

    private void events() {
        this.textArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_TAB) {
                    selecionarButton();
                }
            }
        });
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cadastrarTexto();
            }
        });
        this.button.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    cadastrarTexto();
                }
            }
        });
    }

}