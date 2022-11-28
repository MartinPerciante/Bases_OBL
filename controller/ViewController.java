package controller;

import frames.*;

import javax.swing.*;
import java.sql.SQLException;

public class ViewController {

    private static ViewController instance;
    private LoginFrame loginFrame;

    public LoginFrame getLoginFrame() throws SQLException {
        PublicationController.getInstance().updateStatusOffers();
        loginFrame = new LoginFrame();
        loginFrame.setBounds(500, 200, 435, 320);
        loginFrame.setVisible(true);
        return loginFrame;
    }

    private ChangePasswordFrame changePasswordFrame;

    public ChangePasswordFrame getChangePasswordFrame() {
        changePasswordFrame = new ChangePasswordFrame();
        return changePasswordFrame;
    }

    private MenuFrame menuFrame;

    public MenuFrame getMenuFrame() {
        menuFrame = new MenuFrame();
        return menuFrame;
    }

    private UserDataFrame userDataFrame;

    public UserDataFrame getUserDataFrame() {
        userDataFrame = new UserDataFrame();
        return userDataFrame;
    }

    private CreateUserFrame createUserFrame;

    public CreateUserFrame getCreateUserFrame() {
        createUserFrame = new CreateUserFrame();
        return createUserFrame;
    }

    private CreatePublicationFrame createPublicationFrame;

    public CreatePublicationFrame getCreatePublicationFrame(Boolean newFrame) throws SQLException {
        if (newFrame) {
            createPublicationFrame = new CreatePublicationFrame();
            createPublicationFrame.setSize(955, 750);
        }
        return createPublicationFrame;
    }

    private PickFiguritaFrame pickFiguritaFrame;

    public PickFiguritaFrame getPickFiguritaFrame() throws SQLException {
        pickFiguritaFrame = new PickFiguritaFrame();
        pickFiguritaFrame.setSize(725, 520);
        return pickFiguritaFrame;
    }

    private ShowPublicationsFrame showPublicationsFrame;

    public ShowPublicationsFrame getShowPublicationsFrame() throws SQLException {
        showPublicationsFrame = new ShowPublicationsFrame();
        showPublicationsFrame.setSize(1200, 700);
        return showPublicationsFrame;
    }

    private CreateOfferFrame createOfferFrame;

    public CreateOfferFrame getCreateOfferFrame(Boolean newFrame) {
        if (newFrame) {
            createOfferFrame = new CreateOfferFrame();
            createOfferFrame.setSize(700, 469);
        }
        return createOfferFrame;
    }

    private MyPublicationsFrame myPublicationsFrame;

    public MyPublicationsFrame getMyPublicationsFrame() throws SQLException {
        myPublicationsFrame = new MyPublicationsFrame();
        myPublicationsFrame.setSize(1200, 700);
        return myPublicationsFrame;
    }

    private MyOffersFrame myOffersFrame;

    public MyOffersFrame getMyOffersFrame(Boolean isCounterOffer, String document, String date) throws SQLException {
        myOffersFrame = new MyOffersFrame(isCounterOffer, document, date);
        myOffersFrame.setSize(1200, 700);
        return myOffersFrame;
    }

    private CreateCounterOfferFrame createCounterOfferFrame;

    public CreateCounterOfferFrame getCreateCounterOfferFrame(Boolean newFrame) {
        if (newFrame) {
            createCounterOfferFrame = new CreateCounterOfferFrame();
        }
        return createCounterOfferFrame;
    }

    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }

    private InfoUserFrame infoUserFrame;

    public InfoUserFrame getInfoUserFrame(String username) throws SQLException {
        infoUserFrame = new InfoUserFrame(username);
        return infoUserFrame;
    }


    public static void goToFrom(JFrame to, JFrame from) {
        from.setVisible(false);
        to.setVisible(true);
    }

    public void goToCreatePublication(JFrame origin, Boolean newFrame) throws SQLException {
        goToFrom(getCreatePublicationFrame(newFrame), origin);
    }

    public void goToLogin(JFrame origin) throws SQLException {
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

    public void goToShowPublications(JFrame origin) throws SQLException {
        goToFrom(getShowPublicationsFrame(), origin);
    }

    public void goToCreateOffer(JFrame origin, Boolean newFrame) throws SQLException {
        goToFrom(getCreateOfferFrame(newFrame), origin);
    }

    public void goToMyPublications(JFrame origin) throws SQLException {
        goToFrom(getMyPublicationsFrame(), origin);
    }

    public void goToMyOffers(JFrame origin, Boolean isCounterOffer, String document, String date) throws SQLException {
        goToFrom(getMyOffersFrame(isCounterOffer, document, date), origin);
    }

    public void goToCreateCounterOfferFrame(JFrame origin, Boolean newFrame) throws SQLException {
        goToFrom(getCreateCounterOfferFrame(newFrame), origin);
    }

    public void goToInfoUserFrame(JFrame origin, String username) throws SQLException {
        goToFrom(getInfoUserFrame(username), origin);
    }
}