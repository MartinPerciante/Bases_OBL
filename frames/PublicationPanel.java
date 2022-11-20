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
public class PublicationPanel extends JPanel {
    public PublicationPanel(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        initComponents();
        buttonActions();

//        figuritaImageLabel.setIcon(new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
//        interestedFiguritasTable.setValueAt(new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(136, 186, Image.SCALE_DEFAULT)), 0, 0);
//        interestedFiguritasTable.setValueAt(new ImageIcon(new ImageIcon("luis-suarez.png").getImage().getScaledInstance(136, 186, Image.SCALE_DEFAULT)), 1, 1);
//        interestedFiguritasTable.setValueAt(new ImageIcon(new ImageIcon("neymar-jr.png").getImage().getScaledInstance(136, 186, Image.SCALE_DEFAULT)), 2, 2);


//        setBorder(Utils.blackBorder1);
//        figuritaImageLabel.setBorder(Utils.blackBorder1);
//        interestedFiguritasTable.setBorder(Utils.blackBorder1);
//        interestedFiguritasTable.setTableHeader(null);
//        interestedFiguritasTable.setRowHeight(186);
//        interestedFiguritasTable.setBounds(300, 40, 396, 372);
//        interestedFiguritasTable =  new JTable(3, 3) {
//            public Class getColumnClass(int column) {
//                return Icon.class;
//            }
//        };
    }

    private void buttonActions() {
        offerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PublicationController.getInstance().setPublicacionSelected(new Publicacion(documentLabel.getText(), dateLabel.getText()));
                    ViewController.getInstance().goToCreateOffer((ShowPublicationsFrame) getParent().getParent().getParent().getParent().getParent());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
        figuritaImageLabel.setIcon(new ImageIcon(((ImageIcon) offeredFiguritaImage).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
        Icon[] iconsRows = new Icon[3];
        int index = 0;
        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 3);
        for (Icon icon : interestedFiguritasList) {
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
        interestedFiguritasTable.setModel(defaultTableModel);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
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

        //======== this ========

        //---- offeredFiguritaLabel ----
        offeredFiguritaLabel.setText("Figurita ofrecida");

        //---- figuritaStateLabel ----
        figuritaStateLabel.setText("Estado:");

        //---- interestedFiguritasLabel ----
        interestedFiguritasLabel.setText("Figuritas interesadas");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(interestedFiguritasTable);
        }

        //---- offerButton ----
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
                                                .addComponent(offerButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(offeredFiguritaLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(publicationStateLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
