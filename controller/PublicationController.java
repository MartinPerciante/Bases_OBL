package controller;

import database.DBService;
import entities.Figurita;
import enums.EPickFigurita;
import utils.Utils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicationController {

    private static PublicationController instance;

    private EPickFigurita statusEnum;

    public EPickFigurita getStatusEnum() {
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

    public void setPublicationOfferedFiguritaImageSelected(Figurita figurita) throws SQLException {
        ViewController.getInstance().getCreatePublicationFrame().setFiguritaImageSelected(figurita);
    }

    public void setPublicationInterestedFiguritaImageSelected(Figurita figurita) throws SQLException {
        ViewController.getInstance().getCreatePublicationFrame().setFiguritaInterestedImageSelected(figurita);
    }

    public ResultSet getPublications(String figuritaNumber, String figuritaCountry) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ci, nombre, apellido, fecha, estado, estado_figurita, foto FROM publicacion p " +
                "INNER JOIN usuario u on p.ci_usuario = u.ci " +
                "INNER JOIN figurita f on p.numero_figurita = f.numero and p.pais_figurita = f.pais ");
        if (!figuritaNumber.equals(Utils.EMPTY_ITEM) && !figuritaCountry.equals(Utils.EMPTY_ITEM)) {
            query.append("WHERE p.numero_figurita = ").append(figuritaNumber).append(" AND p.pais_figurita = '").append(figuritaCountry).append("'");
        } else if(!figuritaNumber.equals(Utils.EMPTY_ITEM)) {
            query.append("WHERE p.numero_figurita = ").append(figuritaNumber);
        } else if(!figuritaCountry.equals(Utils.EMPTY_ITEM)) {
            query.append("WHERE p.pais_figurita = '").append(figuritaCountry).append("'");
        }
        return DBService.executeQuery(query.toString());
    }

    public ResultSet getPublicationsInterestedFiguritas(String userDocument, String date) {
        return DBService.executeQuery("SELECT foto FROM publicacion_tiene_interesada_figurita " +
                "INNER JOIN figurita ON publicacion_tiene_interesada_figurita.numero_figurita = figurita.numero AND " +
                "publicacion_tiene_interesada_figurita.pais_figurita = figurita.pais " +
                "WHERE ci_usuario_publicacion = '" + userDocument + "' AND fecha_publicacion = '" + date + "'");
    }

    public ResultSet getFiguritasCountry() {
        return DBService.executeQuery("SELECT pais FROM pais_figurita");
    }

    public ResultSet getFiguritasPhotos(String country, String number) {
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT * FROM figurita ");
        if (!country.equals(Utils.EMPTY_ITEM) && !number.equals(Utils.EMPTY_ITEM)) {
            stringBuilderQuery.append("WHERE pais = '").append(country).append("' AND numero = ").append(number);
        } else if (!country.equals(Utils.EMPTY_ITEM)) {
            stringBuilderQuery.append("WHERE pais = '").append(country).append("'");
        } else if (!number.equals(Utils.EMPTY_ITEM)) {
            stringBuilderQuery.append("WHERE numero = ").append(number);
        }
        return DBService.executeQuery(stringBuilderQuery.toString());
    }

    public void gotToPickFigurita(JFrame origin, EPickFigurita enumValue) {
        statusEnum = enumValue;
        try {
            ViewController.getInstance().goToPickFigurita(origin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
