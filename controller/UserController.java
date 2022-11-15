package controller;

import database.DBService;
import database.Queries;
import entities.User;
import lombok.Data;
import frames.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserController {

    private static UserController instance;
    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public boolean isInfoLogOk(String username, String password) {
        String condition = "ci = '" + username + "' AND " + "password = '" + password + "'";
        String query = Queries.findByColumn("usuario", condition);
        ResultSet result = DBService.executeQuery(query);

        int counter = 0;
        if (result != null){
            while (true){
                try {
                    if (!result.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (result.first()){
                        String usernameDb = result.getString("ci");
                        String passwordDb = result.getString("password");
                        //Se ingresaron datos para inyeccion SQL
                        if (!(usernameDb.equals(username) && passwordDb.equals(passwordDb))){
                            counter = -1;
                            break;
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            };
        }

        return (counter > 0);
    }

    public boolean login(String username, String password) {
        boolean result = isInfoLogOk(username, password);
        if (result) User.getInstance().setUsername(username);
        return result;
    }

    public void register(String ci, String nombre, String apellido, String telefono, String email, String password) {
        DBService.executeUpdate("INSERT INTO usuario (ci, nombre, apellido, telefono, email, password) " +
                "VALUES (" + ci + ",'" + nombre + "','" + apellido + "'," +
                telefono + ",'" + email + "','" + password + "')");
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        if (isInfoLogOk(username, oldPassword)) {
            String condition = "ci = '" + username + "' AND " + "password = '" + oldPassword + "'";
            String query = Queries.update("usuario", List.of("password = '" + newPassword + "'"), condition);
            DBService.executeUpdate(query);
            return true;
        }
        return false;
    }







}
