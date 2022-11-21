/*
 * Created by JFormDesigner on Sat Nov 19 15:29:57 UYT 2022
 */

package frames;

import controller.PublicationController;
import controller.ViewController;
import entities.Oferta;
import entities.Publicacion;
import entities.Usuario;
import utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class OfferPanel extends JPanel {
    public OfferPanel(Boolean isOwner, int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        initComponents();
        buttonActions();
        if (isOwner) {
            counterOfferButton.setVisible(false);
            acceptButton.setVisible(false);
            rejectButton.setVisible(false);
        }
    }

    private void buttonActions() {
        counterOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PublicationController.getInstance().setOfertaSelected(new Oferta(ofertanteDocumentLabel.getText(), ofertanteOfferDateLabel.getText()));
                    PublicationController.getInstance().setPublicacionSelected(new Publicacion(documentLabel.getText(), dateLabel.getText()));
                    if (offerStateLabel.getText().equals("CONTRAOFERTADA")) {
                        ViewController.getInstance().goToMyOffers((JFrame) getParent().getParent().getParent().getParent().getParent(), true, null, null);
                    } else {
                        ViewController.getInstance().goToCreateCounterOfferFrame((JFrame) getParent().getParent().getParent().getParent().getParent(), true);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!offerStateLabel.getText().equals("ACEPTADA")) {
                    PublicationController.getInstance().acceptOffer(documentLabel.getText(), ofertanteDocumentLabel.getText(), dateLabel.getText(), ofertanteOfferDateLabel.getText());
                }
                String usernameToShow = "";
                if (Usuario.getInstance().getUsername().equals(documentLabel.getText())) {
                    usernameToShow = ofertanteDocumentLabel.getText();
                } else {
                    usernameToShow = documentLabel.getText();
                }
                try {
                    ViewController.getInstance().goToInfoUserFrame((JFrame) getParent().getParent().getParent().getParent().getParent(), usernameToShow);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PublicationController.getInstance().rejectOffer(documentLabel.getText(), ofertanteDocumentLabel.getText(), dateLabel.getText(), ofertanteOfferDateLabel.getText());
                try {
                    ViewController.getInstance().goToMyOffers((JFrame) getParent().getParent().getParent().getParent().getParent(), false, documentLabel.getText(), dateLabel.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void setOfferData(String ofertanteDocument, String ofertanteOfferDate, String documentPublication, String namePublication, String datePublication, String offerState, String figuritaState, Icon offeredFiguritaImage, ArrayList<Icon> offeredFiguritasArrayList) {
        ofertanteDocumentLabel.setText(ofertanteDocument);
        ofertanteOfferDateLabel.setText(ofertanteOfferDate);
        documentLabel.setText(documentPublication);
        firstNameLabel.setText(namePublication);
        dateLabel.setText(datePublication);
        offerStateLabel.setText(offerState);
        figuritaStateValueLabel.setText(figuritaState);
        figuritaImageLabel.setIcon(new ImageIcon(((ImageIcon) offeredFiguritaImage).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
        Icon[] iconsRows = new Icon[3];
        int index = 0;
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 3);
        for (Icon icon : offeredFiguritasArrayList) {
            iconsRows[index] = new ImageIcon(((ImageIcon) icon).getImage().getScaledInstance(140, 189, Image.SCALE_DEFAULT));
            index++;
            if (index == 3) {
                defaultTableModel.addRow(iconsRows);
                iconsRows = new Icon[3];
                index = 0;
            }
        }
        if (index != 0) {
            defaultTableModel.addRow(iconsRows);
        }
        offeredFiguritasTable.setModel(defaultTableModel);
        if (offerState.equals("ACEPTADA")) {
            counterOfferButton.setVisible(false);
            rejectButton.setVisible(false);
            acceptButton.setText("CONTACTO");
            acceptButton.setVisible(true);
        } else if (offerState.equals("CONTRAOFERTADA")) {
            rejectButton.setVisible(false);
            acceptButton.setVisible(false);
            counterOfferButton.setText("VER CONTRAOFERTAS");
            counterOfferButton.setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        publishedFiguritaLabel = new JLabel();
        figuritaImageLabel = new JLabel();
        documentLabel = new JLabel();
        firstNameLabel = new JLabel();
        dateLabel = new JLabel();
        figuritaStateLabel = new JLabel();
        figuritaStateValueLabel = new JLabel();
        offeredFiguritasLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        offeredFiguritasTable = new JTable(3, 3) {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        setBorder(Utils.blackBorder1);
        figuritaImageLabel.setBorder(Utils.blackBorder1);
        offeredFiguritasTable.setBorder(Utils.blackBorder1);
        offeredFiguritasTable.setTableHeader(null);
        offeredFiguritasTable.setRowHeight(189);
        offeredFiguritasTable.setBounds(300, 40, 420, 378);
        counterOfferButton = new JButton();
        offerStateLabel = new JLabel();
        ofertanteLabel = new JLabel();
        ofertanteDocumentLabel = new JLabel();
        ofertanteOfferDateLabel = new JLabel();
        rejectButton = new JButton();
        acceptButton = new JButton();

        //======== this ========

        //---- publishedFiguritaLabel ----
        publishedFiguritaLabel.setText("Figurita publicada");

        //---- figuritaStateLabel ----
        figuritaStateLabel.setText("Estado:");

        //---- offeredFiguritasLabel ----
        offeredFiguritasLabel.setText("Figuritas ofrecidas");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(offeredFiguritasTable);
        }

        //---- counterOfferButton ----
        counterOfferButton.setText("CONTRAOFERTAR");

        //---- ofertanteLabel ----
        ofertanteLabel.setText("OFERTANTE");

        //---- rejectButton ----
        rejectButton.setText("RECHAZAR");

        //---- acceptButton ----
        acceptButton.setText("ACEPTAR");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(79, 79, 79)
                                                                .addComponent(publishedFiguritaLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(ofertanteLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(ofertanteDocumentLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ofertanteOfferDateLabel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 41, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(figuritaStateLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(figuritaStateValueLabel, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                                                .addGap(159, 159, 159))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(documentLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(firstNameLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(offerStateLabel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(167, 167, 167)
                                                .addComponent(offeredFiguritasLabel)
                                                .addGap(171, 171, 171))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup()
                                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(acceptButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(rejectButton, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(counterOfferButton)))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(publishedFiguritaLabel)
                                        .addComponent(offeredFiguritasLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(offerStateLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(figuritaStateLabel)
                                                        .addComponent(figuritaStateValueLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(documentLabel)
                                                        .addComponent(firstNameLabel)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 2, Short.MAX_VALUE)
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(ofertanteLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ofertanteDocumentLabel)
                                                        .addComponent(ofertanteOfferDateLabel)))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(counterOfferButton)
                                                .addComponent(rejectButton)
                                                .addComponent(acceptButton)))
                                .addGap(40, 40, 40))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel publishedFiguritaLabel;
    private JLabel figuritaImageLabel;
    private JLabel documentLabel;
    private JLabel firstNameLabel;
    private JLabel dateLabel;
    private JLabel figuritaStateLabel;
    private JLabel figuritaStateValueLabel;
    private JLabel offeredFiguritasLabel;
    private JScrollPane scrollPane1;
    private JTable offeredFiguritasTable;
    private JButton counterOfferButton;
    private JLabel offerStateLabel;
    private JLabel ofertanteLabel;
    private JLabel ofertanteDocumentLabel;
    private JLabel ofertanteOfferDateLabel;
    private JButton rejectButton;
    private JButton acceptButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
