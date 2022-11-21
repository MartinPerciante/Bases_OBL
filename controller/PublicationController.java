package controller;

import database.DBService;
import entities.Figurita;
import entities.Oferta;
import entities.Publicacion;
import enums.EPickFigurita;
import utils.Utils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicationController {

    private static PublicationController instance;

    private EPickFigurita statusEnum;

    public Publicacion getPublicacionSelected() {
        return publicacionSelected;
    }

    public void setPublicacionSelected(Publicacion publicacionSelected) {
        this.publicacionSelected = publicacionSelected;
    }

    private Publicacion publicacionSelected;

    public Oferta getOfertaSelected() {
        return ofertaSelected;
    }

    public void setOfertaSelected(Oferta ofertaSelected) {
        this.ofertaSelected = ofertaSelected;
    }

    private Oferta ofertaSelected;

    public EPickFigurita getStatusEnum() {
        return this.statusEnum;
    }

    public static PublicationController getInstance() {
        if (instance == null) {
            instance = new PublicationController();
        }
        return instance;
    }

    public void updateOffer(String documentUserCounterOffer, String documentUserOffer, String dateCounterOffer, String dateOffer, String datePublication) {
        DBService.executeUpdate("UPDATE oferta SET ci_usuario_contraoferta = '" + documentUserCounterOffer + "', " +
                "fecha_contraoferta = '" + dateCounterOffer + "', " +
                "estado = 'CONTRAOFERTADA' WHERE ci_usuario_oferta = '" + documentUserOffer + "' " +
                "AND ci_usuario_publicacion = '" + documentUserCounterOffer + "' " +
                "AND fecha_oferta = '" + dateOffer + "' " +
                "AND fecha_publicacion = '" + datePublication + "'");
    }

    public void insertOffer(String userDocument, String publicationUserDocument, String offerDate, String publicationDate, Boolean isOffer) {
        DBService.executeUpdate("INSERT INTO oferta VALUES ('" + userDocument + "', '"
                + publicationUserDocument + "', '" + offerDate + "', '" + publicationDate + "', '"
                + (isOffer ? "OFERTA'" : "CONTRAOFERTA'") + ", 'PENDIENTE', null, null)");
    }

    public void insertOfferHasFigurita(String query) {
        DBService.executeUpdate(query);
    }

    public ResultSet getFiguritasState() {
        return DBService.executeQuery("SELECT estado FROM estado_figurita");
    }

    public void setPublicationOfferedFiguritaImageSelected(Figurita figurita) throws SQLException {
        ViewController.getInstance().getCreatePublicationFrame(false).setFiguritaImageSelected(figurita);
    }

    public void setPublicationInterestedFiguritaImageSelected(Figurita figurita) throws SQLException {
        ViewController.getInstance().getCreatePublicationFrame(false).setFiguritaInterestedImageSelected(figurita);
    }

    public void setOfferOfferedFiguritaImageSelected(Figurita figurita) throws SQLException {
        ViewController.getInstance().getCreateOfferFrame(false).setFiguritaOfferedImageSelected(figurita);
    }

    public void setCounterOfferFiguritaImageSelected(Figurita figurita) throws SQLException {
        ViewController.getInstance().getCreateCounterOfferFrame(false).setFiguritaOfferedImageSelected(figurita);
    }

    public ResultSet getPublications(String figuritaNumber, String figuritaCountry) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ci, nombre, apellido, fecha, estado, estado_figurita, foto FROM publicacion p " +
                "INNER JOIN usuario u on p.ci_usuario = u.ci " +
                "INNER JOIN figurita f on p.numero_figurita = f.numero and p.pais_figurita = f.pais ");
        if (!figuritaNumber.equals(Utils.EMPTY_ITEM) && !figuritaCountry.equals(Utils.EMPTY_ITEM)) {
            query.append("WHERE p.numero_figurita = ").append(figuritaNumber).append(" AND p.pais_figurita = '").append(figuritaCountry).append("'");
        } else if (!figuritaNumber.equals(Utils.EMPTY_ITEM)) {
            query.append("WHERE p.numero_figurita = ").append(figuritaNumber);
        } else if (!figuritaCountry.equals(Utils.EMPTY_ITEM)) {
            query.append("WHERE p.pais_figurita = '").append(figuritaCountry).append("'");
        }
        return DBService.executeQuery(query.toString());
    }

    public ResultSet getPublicationsFromUser(String userDocument) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ci, nombre, apellido, fecha, estado, estado_figurita, foto FROM publicacion p " +
                "INNER JOIN usuario u on p.ci_usuario = u.ci " +
                "INNER JOIN figurita f on p.numero_figurita = f.numero and p.pais_figurita = f.pais " +
                "WHERE p.ci_usuario = '" + userDocument + "'");
        return DBService.executeQuery(query.toString());
    }

    public ResultSet getPublicationsInterestedFiguritas(String userDocument, String date) {
        return DBService.executeQuery("SELECT foto FROM publicacion_tiene_interesada_figurita " +
                "INNER JOIN figurita ON publicacion_tiene_interesada_figurita.numero_figurita = figurita.numero AND " +
                "publicacion_tiene_interesada_figurita.pais_figurita = figurita.pais " +
                "WHERE ci_usuario_publicacion = '" + userDocument + "' AND fecha_publicacion = '" + date + "'");
    }

    public ResultSet getOffersFromUser(String userDocument, String documentOwner, String dateOwner) {
        StringBuilder query = new StringBuilder();
        if (documentOwner != null && dateOwner != null) {
            query.append("SELECT ci_usuario_oferta, fecha_oferta, ci, nombre, apellido, fecha_publicacion, estado_figurita, o.estado, foto FROM oferta o " +
                    "INNER JOIN usuario u ON o.ci_usuario_publicacion = u.ci " +
                    "INNER JOIN publicacion p ON o.ci_usuario_publicacion = p.ci_usuario AND o.fecha_publicacion = p.fecha " +
                    "INNER JOIN figurita f on p.numero_figurita = f.numero and p.pais_figurita = f.pais " +
                    "WHERE p.ci_usuario = '" + documentOwner + "' AND p.fecha = '" + dateOwner + "' AND o.tipo = 'OFERTA'");
        } else {
            query.append("SELECT ci_usuario_oferta, fecha_oferta, ci, nombre, apellido, fecha_publicacion, estado_figurita, o.estado, foto FROM oferta o " +
                    "INNER JOIN usuario u ON o.ci_usuario_publicacion = u.ci " +
                    "INNER JOIN publicacion p ON o.ci_usuario_publicacion = p.ci_usuario AND o.fecha_publicacion = p.fecha " +
                    "INNER JOIN figurita f on p.numero_figurita = f.numero and p.pais_figurita = f.pais " +
                    "WHERE o.ci_usuario_oferta = '" + userDocument + "'");
        }
        return DBService.executeQuery(query.toString());
    }

    public ResultSet getOffersFiguritas(String publicationUserDocument, String publicationDate, String offerUserDocument, String offerDate) {
        return DBService.executeQuery("SELECT foto FROM oferta_tiene_figurita o " +
                "INNER JOIN figurita f on o.numero_figurita = f.numero and o.pais_figurita = f.pais " +
                "WHERE ci_usuario_publicacion = '" + publicationUserDocument + "' AND fecha_publicacion = '" + publicationDate +
                "' AND ci_usuario_oferta = '" + offerUserDocument + "' AND fecha_oferta = '" + offerDate + "'");
    }

    public ResultSet getFiguritasCountry() {
        return DBService.executeQuery("SELECT pais FROM pais_figurita");
    }

    public ResultSet getFiguritasNumber() {
        return DBService.executeQuery("SELECT DISTINCT numero FROM figurita ORDER BY numero");
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

    public void goToPickFigurita(JFrame origin, EPickFigurita enumValue) {
        statusEnum = enumValue;
        try {
            ViewController.getInstance().goToPickFigurita(origin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
