package com.tiagoenriquez.sorteadorDeFrases.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import com.tiagoenriquez.sorteadorDeFrases.models.Sorteador;

public class EdicaoDeTextoView extends MainFrame {

    private Sorteador sorteador;
    private JPanel edicaoPanel;
    private JLabel label;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JButton atualizarButton;
    private JButton procurarButton;
    private Color blue;
    private boolean ctrlPressed;

    public EdicaoDeTextoView(Sorteador sorteador) {
        this.sorteador = sorteador;
        this.blue = new Color(128, 128, 191);
        this.ctrlPressed = false;
        this.init();
        this.setLocationRelativeTo(this);
        this.events();
    }

    private void init() {
        this.edicaoPanel = new JPanel();
        this.edicaoPanel.setLayout(null);
        this.edicaoPanel.setPreferredSize(this.dimension);
        this.edicaoPanel.setBackground(this.backgroundColor);
        this.label = new JLabel();
        this.label.setText("Cole um texto");
        this.label.setBounds(0, 16, 800, 32);
        this.label.setOpaque(true);
        this.label.setBackground(this.backgroundColor);
        this.label.setForeground(this.white);
        this.label.setFont(this.font);
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.edicaoPanel.add(this.label);
        this.textArea = new JTextArea();
        this.textArea.setFont(this.font);
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        this.textArea.setText(this.sorteador.getTexto());
        this.textArea.setCaretPosition(0);
        this.scrollPane = new JScrollPane(this.textArea);
        this.scrollPane.setBounds(16, 64, 768, 472);
        this.edicaoPanel.add(this.scrollPane);
        this.atualizarButton = new JButton();
        this.atualizarButton.setBounds(248, 552, 144, 32);
        this.atualizarButton.setText("Atualizar");
        this.atualizarButton.setBackground(this.backgroundColor);
        this.atualizarButton.setForeground(this.white);
        this.atualizarButton.setFont(this.font);
        this.edicaoPanel.add(this.atualizarButton);
        this.procurarButton = new JButton();
        this.procurarButton.setBounds(408, 552, 144, 32);
        this.procurarButton.setText("Localizar Trecho");
        this.procurarButton.setBackground(this.backgroundColor);
        this.procurarButton.setForeground(this.white);
        this.procurarButton.setFont(this.font);
        this.edicaoPanel.add(this.procurarButton);
        this.add(this.edicaoPanel);
        this.pack();
    }

    private void selecionarButton() {
        int posicao = this.textArea.getCaretPosition();
        String texto = this.textArea.getText();
        String antes = texto.substring(0, posicao);
        String depois = texto.substring(posicao, texto.length());
        this.textArea.setText(antes + depois);
        this.atualizarButton.requestFocus();
    }

    private void atualizar() {
        this.dispose();
        new FraseSorteadaView(new Sorteador(this.textArea.getText(), this.sorteador.getSeparador())).setVisible(true);
    }

    private void editarTrechoProcurado() {
        new LocalizarTrechoView(this).setVisible(true);
    }

    public void localizar(String trecho) throws BadLocationException {
        this.desSelecionar();
        Highlighter highlighter = this.textArea.getHighlighter();
        try {
            int inicio = this.textArea.getText().indexOf(trecho, this.textArea.getCaretPosition());
            int fim = inicio + trecho.length();
            highlighter.addHighlight(inicio, fim, new DefaultHighlighter.DefaultHighlightPainter(this.blue));
            this.textArea.select(inicio, fim);
            this.textArea.setSelectionColor(this.white);
        } catch (BadLocationException exception) {
            throw new BadLocationException("Trecho não encontrado. Localizar outro trecho.", ABORT);
        }
    }

    private void desSelecionar() {
        this.textArea.getHighlighter().removeAllHighlights();
    }

    private void digitarAtalho(KeyEvent event) {
        if (event.getKeyCode() == 70 && this.ctrlPressed) {
            this.editarTrechoProcurado();
        }
        if (event.getKeyCode() == KeyEvent.VK_CONTROL) {
            this.ctrlPressed = true;
        } else {
            this.ctrlPressed = false;
        }
    }

    private void events() {
        this.textArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_TAB) {
                    selecionarButton();
                }
            }
        });
        this.textArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                desSelecionar();
            }
        });
        this.textArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                digitarAtalho(event);
            }
        });
        this.atualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                atualizar();
            }
        });
        this.atualizarButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    atualizar();
                }
            }
        });
        this.procurarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                editarTrechoProcurado();
            }
        });
        this.procurarButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    editarTrechoProcurado();
                }
            }
        });
    }
    
}