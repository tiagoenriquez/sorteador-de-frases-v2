package com.tiagoenriquez.sorteadorDeFrases.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    protected Color backgroundColor;
    protected Color white;
    protected Dimension dimension;
    protected Font font;
    
    public MainFrame() {
        this.setTitle("Sorteador de Frases");
        this.dimension = new Dimension(800, 600);
        this.backgroundColor = new Color(64, 64, 64);
        this.white = new Color(255, 255, 255);
        this.font = new Font("Serif", 0, 12);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("img/lista.png")));
    }
    
}
