/*
 * Created by JFormDesigner on Sat Nov 19 16:55:56 UYT 2022
 */

package frames;

import controller.PublicationController;
import controller.ViewController;
import database.DBService;
import entities.Figurita;
import entities.Publicacion;
import entities.Usuario;
import enums.EPickFigurita;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class CreateOfferFrame extends JFrame {
    public CreateOfferFrame() {
        initComponents();
        offeredFiguritasList = new ArrayList<>();
        buttonActions();
        setResizable(false);
    }

    ArrayList<Figurita> offeredFiguritasList;

    public void setFiguritaOfferedImageSelected(Figurita figurita) {
        offeredFiguritasList.add(figurita);
        int rows = offeredFiguritasTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) offeredFiguritasTable.getModel();
        if (rows == 0) {
            model.addRow(new ImageIcon[]{null, null, null});
            rows = 1;
        }
        boolean added = false;
        boolean isFull = false;
        for (int i = 0; i < 3 && !added; i++) {
            Object exists = model.getValueAt(rows - 1, i);
            if (exists == null) {
                model.setValueAt(figurita.getFoto(), rows - 1, i);
                added = true;
                isFull = (i == 2);
                break;
            }
        }
        if (!added) {
            model.addRow(new ImageIcon[]{figurita.getFoto(), null, null});
        }
        if (isFull) {
            model.addRow(new ImageIcon[]{null, null, null});
        }

        setVisible(true);
    }

    private void buttonActions() {
        ViewController viewController = ViewController.getInstance();
        addFiguritaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PublicationController.getInstance().goToPickFigurita(CreateOfferFrame.this, EPickFigurita.CREATE_OFFER_OFFERED_FIGURITAS);
            }
        });

        deleteFiguritaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon iconSelected = (Icon) offeredFiguritasTable.getValueAt(offeredFiguritasTable.getSelectedRow(), offeredFiguritasTable.getSelectedColumn());
                if (iconSelected != null) {
                    offeredFiguritasTable.setValueAt(null, offeredFiguritasTable.getSelectedRow(), offeredFiguritasTable.getSelectedColumn());
                }
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actualDate = Utils.formatLocalDateTimeToString(LocalDateTime.now());
                Publicacion publicacion = PublicationController.getInstance().getPublicacionSelected();
                DBService.executeUpdate("INSERT INTO oferta VALUES ('" + Usuario.getInstance().getUsername() + "', '"
                        + publicacion.getUserDocument() + "', '" + actualDate + "', '" + publicacion.getDate() + "', '"
                        + "OFERTA', 'PENDIENTE', null, null)");
                if (offeredFiguritasTable.getRowCount() > 0) {
                    StringBuilder stringBuilderQuery = new StringBuilder();
                    stringBuilderQuery.append("INSERT INTO oferta_tiene_figurita VALUES ");
                    for (Figurita figurita : offeredFiguritasList) {
                        stringBuilderQuery.append("('").append(publicacion.getUserDocument()).append("', '");
                        stringBuilderQuery.append(publicacion.getDate()).append("', '");
                        stringBuilderQuery.append(Usuario.getInstance().getUsername()).append("', '");
                        stringBuilderQuery.append(actualDate).append("', ");
                        stringBuilderQuery.append(figurita.getNumero()).append(", '");
                        stringBuilderQuery.append(figurita.getPais()).append("', '");
                        stringBuilderQuery.append(figurita.getEstado()).append("'),");
                    }
                    String query = stringBuilderQuery.toString();
                    DBService.executeUpdate(query.substring(0, query.length() - 1));
                }
                try {
                    viewController.goToShowPublications(CreateOfferFrame.this);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewController.goToShowPublications(CreateOfferFrame.this);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        cancelButton = new JButton();
        createButton = new JButton();
        scrollPane1 = new JScrollPane();
        offeredFiguritasTable = new JTable(0, 3) {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        offeredFiguritasTable.setTableHeader(null);
        offeredFiguritasTable.setRowHeight(312);
        offeredFiguritasTable.setBorder(Utils.blackBorder1);
        addFiguritaButton = new JButton();
        deleteFiguritaButton = new JButton();

        //======== this ========
        setTitle("CREAR OFERTA");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- cancelButton ----
                cancelButton.setText("CANCELAR");

                //---- createButton ----
                createButton.setText("CREAR");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(offeredFiguritasTable);
                }

                //---- addFiguritaButton ----
                addFiguritaButton.setText("AGREGAR");

                //---- deleteFiguritaButton ----
                deleteFiguritaButton.setText("ELIMINAR");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(addFiguritaButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(deleteFiguritaButton)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                                    .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addFiguritaButton)
                                .addComponent(deleteFiguritaButton))
                            .addGap(16, 16, 16)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JButton cancelButton;
    private JButton createButton;
    private JScrollPane scrollPane1;
    private JTable offeredFiguritasTable;
    private JButton addFiguritaButton;
    private JButton deleteFiguritaButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
