package com.tiagoenriquez.sorteadorDeFrases.models;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Sorteador {

    private final String texto;
    private final String separador;
    private String[] partes;

    public Sorteador(String texto, String separador) {
        this.texto = texto;
        this.separador = separador.replace("\t", "");
        this.separar();
    }

    public String getTexto() {
        return this.texto;
    }

    public String getSeparador() {
        return this.separador;
    }

    public String sortear() {
        String parte = "";
        while (parte.isEmpty() || parte.trim().isEmpty()) {
            parte = this.partes[(int) (Math.random() * (this.partes.length))];
        }
        return parte;
    }

    private void separar()  {
        this.partes = this.texto.split(Pattern.quote(this.separador));
        this.partes = Arrays.stream(this.partes).filter(parte -> !parte.isEmpty()).toArray(String[]::new);
    }
    
}
