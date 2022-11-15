package controller;

import database.DBService;
import database.Queries;
import frames.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.List;

public class UserController {

    private static UserController instance;
    private LoginFrame loginFrame;
    private ChangePasswordFrame changePasswordFrame;
    private MenuFrame menuFrame;
    private UserDataFrame userDataFrame;
    private CreateUserFrame createUserFrame;

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

        return !(result == null);
    }

    public boolean login(String username, String password) {
        boolean result = isInfoLogOk(username, password);
        if (result) {
            //Salto a la pantalla ya logeado
            loginFrame.setVisible(false);
            menuFrame.setVisible(true);
        }
        return result;
    }

    public void register(String ci, String nombre, String apellido, String telefono, String email, String password) {
        DBService.executeUpdate("INSERT INTO usuario (ci, nombre, apellido, telefono, email, password) " +
                "VALUES (" + ci + ",'" + nombre + "','" + apellido + "'," +
                telefono + ",'" + email + "','" + password + "')");
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        if (isInfoLogOk(username, oldPassword)) {
            String condition = "ci = '" + username + "' AND " + "password = '" + oldPassword + "'";
            String query = Queries.update("usuario", List.of("password = '" + newPassword + "'"), condition);

            ResultSet result = DBService.executeQuery(query);
        }
        goToMenuFromChangePassword();
    }


    public static void goToFrom(JFrame to, JFrame from) {
        from.setVisible(false);
        to.setVisible(true);
    }

    public void goToRegistrationScreenFromLogin() {
        goToFrom(createUserFrame, loginFrame);
    }

    public void goToLoginScreenFromRegistration() {
        goToFrom(loginFrame, createUserFrame);
    }

    public void goToMenuFromChangePassword() {
        goToFrom(menuFrame, changePasswordFrame);
    }

    public void goToUserDataFrameFromMenu() {
        goToFrom(userDataFrame, menuFrame);
    }

    public void goToMenuFromUserDataFrame() {
        goToFrom(menuFrame, userDataFrame);
    }

    public void goToChangePasswordFromUserDataFrame() {
        goToFrom(changePasswordFrame, userDataFrame);
    }

}
