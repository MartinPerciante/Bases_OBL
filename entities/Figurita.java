package entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;

@Data
@AllArgsConstructor
public class Figurita {

    private int numero;

    private String pais;

    private ImageIcon foto;

}
