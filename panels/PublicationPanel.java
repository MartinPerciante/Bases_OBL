package panels;

import controller.PublicationController;
import controller.ViewController;
import entities.Publicacion;
import utils.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublicationPanel extends JPanel {
    public PublicationPanel(Boolean isOwner, int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        initComponents();
        if (isOwner) {
            offerButton.setText("VER OFERTAS");
        }
        buttonActions(isOwner);
    }

    private void buttonActions(Boolean isOwner) {
        offerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOwner) {
                    try {
                        ViewController.getInstance().goToMyOffers((JFrame) getParent().getParent().getParent().getParent().getParent().getParent().getParent(), false, documentLabel.getText(), dateLabel.getText());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        PublicationController.getInstance().setPublicacionSelected(new Publicacion(documentLabel.getText(), dateLabel.getText()));
                        ViewController.getInstance().goToCreateOffer((JFrame) getParent().getParent().getParent().getParent().getParent().getParent().getParent(), true);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public void setPublicationData(String document, String name, String date, String publicationState, String figuritaState, Icon offeredFiguritaImage, ArrayList<Icon> interestedFiguritasList) {
        documentLabel.setText(document);
        firstNameLabel.setText(name);
        dateLabel.setText(date);
        publicationStateLabel.setText(publicationState);
        figuritaStateValueLabel.setText(figuritaState);
        figuritaImageLabel.setIcon(new ImageIcon(((ImageIcon) offeredFiguritaImage).getImage().getScaledInstance(232, 312, Image.SCALE_SMOOTH)));
        Icon[] iconsRows = new Icon[3];
        int index = 0;
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 3);
        for (Icon icon : interestedFiguritasList) {
            iconsRows[index] = new ImageIcon(((ImageIcon) icon).getImage().getScaledInstance(140, 189, Image.SCALE_SMOOTH));
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
        interestedFiguritasTable.setModel(defaultTableModel);
    }

    private void initComponents() {
        offeredFiguritaLabel = new JLabel();
        figuritaImageLabel = new JLabel();
        documentLabel = new JLabel();
        firstNameLabel = new JLabel();
        dateLabel = new JLabel();
        figuritaStateLabel = new JLabel();
        figuritaStateValueLabel = new JLabel();
        interestedFiguritasLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        interestedFiguritasTable = new JTable(3, 3) {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        setBorder(Utils.blackBorder1);
        figuritaImageLabel.setBorder(Utils.blackBorder1);
        interestedFiguritasTable.setBorder(Utils.blackBorder1);
        interestedFiguritasTable.setTableHeader(null);
        interestedFiguritasTable.setRowHeight(189);
        interestedFiguritasTable.setBounds(300, 40, 420, 378);

        offerButton = new JButton();
        publicationStateLabel = new JLabel();

        offeredFiguritaLabel.setText("Figurita ofrecida");

        figuritaStateLabel.setText("Estado:");

        interestedFiguritasLabel.setText("Figuritas interesadas");

        {
            scrollPane1.setViewportView(interestedFiguritasTable);
        }

        offerButton.setText("OFERTAR");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup()
                                                                        .addComponent(documentLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(figuritaStateLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(firstNameLabel, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                                                        .addComponent(figuritaStateValueLabel, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                                                        .addComponent(dateLabel, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(offerButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(offeredFiguritaLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(publicationStateLabel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(162, 162, 162)
                                                .addComponent(interestedFiguritasLabel)
                                                .addGap(181, 181, 181))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(offeredFiguritaLabel)
                                        .addComponent(interestedFiguritasLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(publicationStateLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup()
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(figuritaStateLabel)
                                                                        .addComponent(figuritaStateValueLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(documentLabel)
                                                                        .addComponent(firstNameLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(dateLabel))
                                                        .addComponent(offerButton, GroupLayout.Alignment.TRAILING)))
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    private JLabel offeredFiguritaLabel;
    private JLabel figuritaImageLabel;
    private JLabel documentLabel;
    private JLabel firstNameLabel;
    private JLabel dateLabel;
    private JLabel figuritaStateLabel;
    private JLabel figuritaStateValueLabel;
    private JLabel interestedFiguritasLabel;
    private JScrollPane scrollPane1;
    private JTable interestedFiguritasTable;
    private JButton offerButton;
    private JLabel publicationStateLabel;
}
