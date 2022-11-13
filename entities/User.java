package entities;

import lombok.Data;

@Data
public class User {

    private String username;

    private static User instance;

    public static User getInstance(){
        if (instance == null){
            instance = new User();
        }
        return instance;
    }
}
