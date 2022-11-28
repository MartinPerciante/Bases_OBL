package entities;

import lombok.Data;

@Data
public class Usuario {

    private String username;

    private static Usuario instance;

    public static Usuario getInstance() {
        if (instance == null) {
            instance = new Usuario();
        }
        return instance;
    }
}
