package com.tiagoenriquez.sorteadorDeFrases.utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class SorteadorClipBoard {

    private String texto;

    public SorteadorClipBoard(String texto) {
        this.texto = texto;
    }

    public void copiar() {
        StringSelection stringSelection = new StringSelection(this.texto);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
    
}
