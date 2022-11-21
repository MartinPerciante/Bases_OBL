/*
 * Created by JFormDesigner on Sat Nov 19 15:29:57 UYT 2022
 */

package frames;

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

/**
 * @author unknown
 */
public class OfferPanel extends JPanel {
    public OfferPanel(Boolean isOwner, int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        initComponents();
        buttonActions();
        if(isOwner) {
            offerButton.setVisible(false);
        }
    }

    private void buttonActions() {
        offerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PublicationController.getInstance().setPublicacionSelected(new Publicacion(documentLabel.getText(), dateLabel.getText()));
                    ViewController.getInstance().goToCreateOffer((JFrame) getParent().getParent().getParent().getParent().getParent(), true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void setOfferData(String document, String name, String date, String offerState, String figuritaState, Icon offeredFiguritaImage, ArrayList<Icon> offeredFiguritasArrayList) {
        documentLabel.setText(document);
        firstNameLabel.setText(name);
        dateLabel.setText(date);
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
        offeredFiguritasTable = new JTable();
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
        offerButton = new JButton();
        offerStateLabel = new JLabel();

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

        //---- offerButton ----
        offerButton.setText("CONTRAOFERTAR");

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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(offerStateLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(79, 79, 79)
                                    .addComponent(publishedFiguritaLabel))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(194, 194, 194)
                                    .addComponent(offerButton, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(offeredFiguritasLabel)
                            .addGap(171, 171, 171))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(publishedFiguritaLabel)
                        .addComponent(offeredFiguritasLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(offerStateLabel)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(figuritaStateLabel)
                                        .addComponent(figuritaStateValueLabel))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(documentLabel)
                                        .addComponent(firstNameLabel)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(offerButton)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateLabel))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
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
    private JButton offerButton;
    private JLabel offerStateLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
