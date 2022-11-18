package controller;

import frames.*;

import javax.swing.*;
import java.sql.SQLException;

public class ViewController {

    private static ViewController instance;
    private LoginFrame loginFrame;

    public LoginFrame getLoginFrame() {
        if (loginFrame == null) {
            loginFrame = new LoginFrame();
            loginFrame.setBounds(500, 200, 435, 320);
            loginFrame.setVisible(true);
        }
        return loginFrame;
    }

    private ChangePasswordFrame changePasswordFrame;

    public ChangePasswordFrame getChangePasswordFrame() {
        if (changePasswordFrame == null) {
            changePasswordFrame = new ChangePasswordFrame();
        }
        return changePasswordFrame;
    }

    private MenuFrame menuFrame;

    public MenuFrame getMenuFrame() {
        if (menuFrame == null) {
            menuFrame = new MenuFrame();
        }
        return menuFrame;
    }

    private UserDataFrame userDataFrame;

    public UserDataFrame getUserDataFrame() {
        if (userDataFrame == null) {
            userDataFrame = new UserDataFrame();
        }
        return userDataFrame;
    }

    private CreateUserFrame createUserFrame;

    public CreateUserFrame getCreateUserFrame() {
        if (createUserFrame == null) {
            createUserFrame = new CreateUserFrame();
        }
        return createUserFrame;
    }

    private CreatePublicationFrame createPublicationFrame;

    public CreatePublicationFrame getCreatePublicationFrame() throws SQLException {
        if (createPublicationFrame == null) {
            createPublicationFrame = new CreatePublicationFrame();
        }
        return createPublicationFrame;
    }

    private PickFiguritaFrame pickFiguritaFrame;

    public PickFiguritaFrame getPickFiguritaFrame() throws SQLException {
        if (pickFiguritaFrame == null) {
            pickFiguritaFrame = new PickFiguritaFrame();
        }
        return pickFiguritaFrame;
    }

    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }

    public static void goToFrom(JFrame to, JFrame from) {
        from.setVisible(false);
        to.setVisible(true);
    }

    public void goToCreatePublication(JFrame origin) throws SQLException {
        goToFrom(getCreatePublicationFrame(), origin);
    }

    public void goToLogin(JFrame origin) {
        goToFrom(getLoginFrame(), origin);
    }

    public void goToMenu(JFrame origin) {
        goToFrom(getMenuFrame(), origin);
    }

    public void goToChangePassword(JFrame origin) {
        goToFrom(getChangePasswordFrame(), origin);
    }

    public void goToUserData(JFrame origin) {
        goToFrom(getUserDataFrame(), origin);
    }

    public void goToRegistration(JFrame origin) {
        goToFrom(getCreateUserFrame(), origin);
    }

    public void goToPickFigurita(JFrame origin) throws SQLException {
        goToFrom(getPickFiguritaFrame(), origin);
    }

}
