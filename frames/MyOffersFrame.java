package frames;

import controller.PublicationController;
import controller.ViewController;
import entities.Publicacion;
import entities.Usuario;
import panels.OfferPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyOffersFrame extends JFrame {
    public MyOffersFrame(Boolean isCounterOffer, String document, String date) throws SQLException {
        initComponents();
        offerPanelArrayList = new ArrayList<>();
        buttonActions();
        if (document != null && date != null) {
            setTitle("OFERTAS");
        }
        if (isCounterOffer) {
            setTitle("CONTRAOFERTA");
        }
        populateOffers(isCounterOffer, document, date);
        setResizable(false);
    }

    int xPosition = 0;

    int yPosition = 0;

    int width = 770;

    int height = 500;

    ArrayList<OfferPanel> offerPanelArrayList;

    private void populateOffers(Boolean isCounterOffer, String document, String date) throws SQLException {
        for (OfferPanel offerPanel : offerPanelArrayList) {
            offersPanel.remove(offerPanel);
        }
        xPosition = 0;
        yPosition = 0;
        offerPanelArrayList = new ArrayList<>();
        ResultSet resultSetOffers = null;
        if (isCounterOffer) {
            Publicacion publicacion = PublicationController.getInstance().getPublicacionSelected();
            resultSetOffers = PublicationController.getInstance().getCounterOffers(publicacion.getUserDocument(), publicacion.getDate());
        } else {
            resultSetOffers = PublicationController.getInstance().getOffersFromUser(Usuario.getInstance().getUsername(), document, date);
        }
        if (resultSetOffers != null) {
            Boolean isPositionedLeft = true;
            while (resultSetOffers.next()) {
                String publicationUserDocument = resultSetOffers.getString("ci");
                String offerUserDocument = resultSetOffers.getString("ci_usuario_oferta");
                String publicationUserFirstName = resultSetOffers.getString("nombre");
                String publicationUserLastName = resultSetOffers.getString("apellido");
                String publicationDate = resultSetOffers.getString("fecha_publicacion");
                String offerDate = resultSetOffers.getString("fecha_oferta");
                String publicationFiguritaState = resultSetOffers.getString("estado_figurita");
                String offerState = resultSetOffers.getString("estado");
                Icon figuritaPublicatedImage = new ImageIcon(new ImageIcon(resultSetOffers.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_SMOOTH));

                ResultSet resultSetOfferedFiguritas = PublicationController.getInstance().getOffersFiguritas(publicationUserDocument, publicationDate, offerUserDocument, offerDate);
                ArrayList<Icon> iconArrayList = new ArrayList<>();
                if (resultSetOfferedFiguritas != null) {
                    while (resultSetOfferedFiguritas.next()) {
                        Icon icon = new ImageIcon(new ImageIcon(resultSetOfferedFiguritas.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_SMOOTH));
                        iconArrayList.add(icon);
                    }
                }
                OfferPanel offerPanel = new OfferPanel((offerUserDocument.equals(Usuario.getInstance().getUsername())), xPosition, yPosition, width, height);
                offerPanel.setOfferData(offerUserDocument, offerDate, publicationUserDocument, publicationUserFirstName.concat(" ").concat(publicationUserLastName), publicationDate, offerState, publicationFiguritaState, figuritaPublicatedImage, iconArrayList);
                offerPanelArrayList.add(offerPanel);
                offersPanel.add(offerPanel);
                if (isPositionedLeft) {
                    xPosition += width + 5;
                    isPositionedLeft = false;
                } else {
                    xPosition -= width + 5;
                    yPosition += height + 5;
                    isPositionedLeft = true;
                }
            }
        }
        int offersPanelArrayListSize = offerPanelArrayList.size();
        GroupLayout publicationsPanelLayout = new GroupLayout(offersPanel);
        offersPanel.setLayout(publicationsPanelLayout);
        publicationsPanelLayout.setHorizontalGroup(
                publicationsPanelLayout.createParallelGroup()
                        .addGap(0, offersPanelArrayListSize > 1 ? 1610 : 805, Short.MAX_VALUE)
        );
        publicationsPanelLayout.setVerticalGroup(
                publicationsPanelLayout.createParallelGroup()
                        .addGap(0, (offersPanelArrayListSize % 2 == 0 ? offersPanelArrayListSize / 2 : (offersPanelArrayListSize + 1) / 2) * (height + 5), Short.MAX_VALUE)
        );
        scrollPane1.setViewportView(offersPanel);
        getContentPane().add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void buttonActions() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.getInstance().goToMenu(MyOffersFrame.this);
            }
        });
    }

    private void initComponents() {
        buttonsPanel = new JPanel();
        goBackButton = new JButton();
        scrollPane1 = new JScrollPane();
        offersPanel = new JPanel();

        setTitle("MIS OFERTAS");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        {

            goBackButton.setText("VOLVER");

            GroupLayout buttonsPanelLayout = new GroupLayout(buttonsPanel);
            buttonsPanel.setLayout(buttonsPanelLayout);
            buttonsPanelLayout.setHorizontalGroup(
                    buttonsPanelLayout.createParallelGroup()
                            .addGroup(buttonsPanelLayout.createSequentialGroup()
                                    .addGap(372, 372, 372)
                                    .addComponent(goBackButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(402, Short.MAX_VALUE))
            );
            buttonsPanelLayout.setVerticalGroup(
                    buttonsPanelLayout.createParallelGroup()
                            .addGroup(buttonsPanelLayout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(goBackButton)
                                    .addContainerGap(38, Short.MAX_VALUE))
            );
        }
        contentPane.add(buttonsPanel, BorderLayout.NORTH);

        {

            {

                GroupLayout offersPanelLayout = new GroupLayout(offersPanel);
                offersPanel.setLayout(offersPanelLayout);
                offersPanelLayout.setHorizontalGroup(
                        offersPanelLayout.createParallelGroup()
                                .addGap(0, 886, Short.MAX_VALUE)
                );
                offersPanelLayout.setVerticalGroup(
                        offersPanelLayout.createParallelGroup()
                                .addGap(0, 502, Short.MAX_VALUE)
                );
            }
            scrollPane1.setViewportView(offersPanel);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel buttonsPanel;
    private JButton goBackButton;
    private JScrollPane scrollPane1;
    private JPanel offersPanel;
}
