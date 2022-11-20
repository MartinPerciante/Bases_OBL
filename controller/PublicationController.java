package controller;

import database.DBService;
import enums.EPickFigurita;
import utils.Utils;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicationController {

    private static PublicationController instance;

    private EPickFigurita statusEnum;

    public EPickFigurita getStatusEnum(){
        return this.statusEnum;
    }

    public static PublicationController getInstance() {
        if (instance == null) {
            instance = new PublicationController();
        }
        return instance;
    }

    public ResultSet getFiguritasState() {
        return DBService.executeQuery("SELECT estado FROM estado_figurita");
    }

    public void setPublicationOfferedFiguritaImageSelected(ImageIcon imageSelected) throws SQLException {
        ViewController.getInstance().getCreatePublicationFrame().setFiguritaImageSelected(imageSelected);
    }

    public void setPublicationInterestedFiguritaImageSelected(ImageIcon imageSelected) throws SQLException {
        ViewController.getInstance().getCreatePublicationFrame().setFiguritaInterestedImageSelected(imageSelected);
    }

    public ResultSet getFiguritasCountry() {
        return DBService.executeQuery("SELECT pais FROM pais_figurita");
    }

    public ResultSet getFiguritasPhotos(String country, String number) {
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT * FROM figurita ");
        if (!country.equals(Utils.EMPTY_ITEM) && !number.equals(Utils.EMPTY_ITEM)) {
            stringBuilderQuery.append("WHERE pais = '" + country + "' AND numero = " + number);
        } else if (!country.equals(Utils.EMPTY_ITEM) && number.equals(Utils.EMPTY_ITEM)) {
            stringBuilderQuery.append("WHERE pais = '" + country + "'");
        } else if (country.equals(Utils.EMPTY_ITEM) && !number.equals(Utils.EMPTY_ITEM)) {
            stringBuilderQuery.append("WHERE numero = " + number);
        }
        return DBService.executeQuery(stringBuilderQuery.toString());
    }

    public void gotToPickFigurita(JFrame origin, EPickFigurita enumValue){
        statusEnum = enumValue;
        try {
            ViewController.getInstance().goToPickFigurita(origin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
