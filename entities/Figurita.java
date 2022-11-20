package entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;

@Data
@AllArgsConstructor
public class Figurita {

    public Figurita(int numero, String pais, ImageIcon foto) {
        this.numero = numero;
        this.pais = pais;
        this.foto = foto;
    }

    private int numero;

    private String pais;

    private ImageIcon foto;

    private String estado;
}
