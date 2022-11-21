/*
 * Created by JFormDesigner on Sat Nov 19 16:54:06 UYT 2022
 */

package frames;

import controller.PublicationController;
import controller.ViewController;
import entities.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class MyOffersFrame extends JFrame {
    public MyOffersFrame(String document, String date) throws SQLException {
        initComponents();
        offerPanelArrayList = new ArrayList<>();
        buttonActions();
        if (document != null && date != null) {
            setTitle("OFERTAS");
        }
        populateOffers(document, date);
        setResizable(false);
    }

    int xPosition = 0;

    int yPosition = 0;

    int width = 770;

    int height = 500;

    ArrayList<OfferPanel> offerPanelArrayList;

    private void populateOffers(String document, String date) throws SQLException {
        for (OfferPanel offerPanel : offerPanelArrayList) {
            offersPanel.remove(offerPanel);
        }
        xPosition = 0;
        yPosition = 0;
        offerPanelArrayList = new ArrayList<>();
        ResultSet resultSetOffers = PublicationController.getInstance().getOffersFromUser(Usuario.getInstance().getUsername(), document, date);
        if (resultSetOffers != null) {
            Boolean isPositionedLeft = true;
            while (resultSetOffers.next()) {
                OfferPanel offerPanel = new OfferPanel(xPosition, yPosition, width, height);
                String publicationUserDocument = resultSetOffers.getString("ci");
                String offerUserDocument = resultSetOffers.getString("ci_usuario_oferta");
                String publicationUserFirstName = resultSetOffers.getString("nombre");
                String publicationUserLastName = resultSetOffers.getString("apellido");
                String publicationDate = resultSetOffers.getString("fecha_publicacion");
                String offerDate = resultSetOffers.getString("fecha_oferta");
                String publicationFiguritaState = resultSetOffers.getString("estado_figurita");
                String offerState = resultSetOffers.getString("estado");
                Icon figuritaPublicatedImage = new ImageIcon(new ImageIcon(resultSetOffers.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));

                ResultSet resultSetOfferedFiguritas = PublicationController.getInstance().getOffersFiguritas(publicationUserDocument, publicationDate, offerUserDocument, offerDate);
                ArrayList<Icon> iconArrayList = new ArrayList<>();
                if (resultSetOfferedFiguritas != null) {
                    while (resultSetOfferedFiguritas.next()) {
                        Icon icon = new ImageIcon(new ImageIcon(resultSetOfferedFiguritas.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
                        iconArrayList.add(icon);
                    }
                }
                offerPanel.setOfferData(publicationUserDocument, publicationUserFirstName.concat(" ").concat(publicationUserLastName), publicationDate, offerState, publicationFiguritaState, figuritaPublicatedImage, iconArrayList);
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
        getContentPane().add(offersPanel);
        SwingUtilities.updateComponentTreeUI(this);
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
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        buttonsPanel = new JPanel();
        goBackButton = new JButton();
        offersPanel = new JPanel();

        //======== this ========
        setTitle("MIS OFERTAS");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== buttonsPanel ========
        {

            //---- goBackButton ----
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

        //======== offersPanel ========
        {

            GroupLayout offersPanelLayout = new GroupLayout(offersPanel);
            offersPanel.setLayout(offersPanelLayout);
            offersPanelLayout.setHorizontalGroup(
                    offersPanelLayout.createParallelGroup()
                            .addGap(0, 888, Short.MAX_VALUE)
            );
            offersPanelLayout.setVerticalGroup(
                    offersPanelLayout.createParallelGroup()
                            .addGap(0, 504, Short.MAX_VALUE)
            );
        }
        contentPane.add(offersPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel buttonsPanel;
    private JButton goBackButton;
    private JPanel offersPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
