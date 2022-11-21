/*
 * Created by JFormDesigner on Sat Nov 12 15:53:20 UYT 2022
 */

package frames;

import controller.PublicationController;
import controller.ViewController;
import entities.Figurita;
import enums.EPickFigurita;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author unknown
 */
public class PickFiguritaFrame extends JFrame {
    public PickFiguritaFrame() throws SQLException {
        initComponents();
        buttonActions();
        loadComboBoxData();
        setResizable(false);
    }

    HashMap<Icon, String> hashMap = new HashMap<>();

    private void loadComboBoxData() throws SQLException {
        ResultSet resultSetCountries = PublicationController.getInstance().getFiguritasCountry();
        countryComboBox.addItem(Utils.EMPTY_ITEM);
        while (resultSetCountries.next()) {
            countryComboBox.addItem(resultSetCountries.getString("pais"));
        }
        ResultSet resultSetNumbers = PublicationController.getInstance().getFiguritasNumber();
        numberComboBox.addItem(Utils.EMPTY_ITEM);
        while (resultSetNumbers.next()) {
            numberComboBox.addItem(resultSetNumbers.getString("numero"));
        }
        EPickFigurita ePickFigurita = PublicationController.getInstance().getStatusEnum();
        if (ePickFigurita.equals(EPickFigurita.CREATE_OFFER_OFFERED_FIGURITAS) || ePickFigurita.equals(EPickFigurita.CREATE_COUNTEROFFER_OFFERED_FIGURITAS)) {
            figuritaStateLabel.setVisible(true);
            figuritaStateComboBox.setVisible(true);
            ResultSet resultSetStates = PublicationController.getInstance().getFiguritasState();
            while (resultSetStates.next()) {
                figuritaStateComboBox.addItem(resultSetStates.getString("estado"));
            }
        } else {
            figuritaStateLabel.setVisible(false);
            figuritaStateComboBox.setVisible(false);
        }
    }

    private void buttonActions() {
        figuritasTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EPickFigurita eAddFiguritaOptions = PublicationController.getInstance().getStatusEnum();
                switch (eAddFiguritaOptions) {
                    case CREATE_PUBLICATION_OFFERED_FIGURITA: {
                        try {
                            ImageIcon icon = (ImageIcon) figuritasTable.getValueAt(figuritasTable.getSelectedRow(), figuritasTable.getSelectedColumn());
                            if (icon != null) {
                                String[] numAndCountry = hashMap.get(icon).split(" ");
                                PublicationController.getInstance().setPublicationOfferedFiguritaImageSelected(new Figurita(Integer.parseInt(numAndCountry[0]), numAndCountry[1], icon));
                                PickFiguritaFrame.this.setVisible(false);
                            }
                            ViewController.getInstance().goToCreatePublication(PickFiguritaFrame.this, false);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                    case CREATE_PUBLICATION_INTERESTED_FIGURITAS: {
                        try {
                            ImageIcon icon = (ImageIcon) figuritasTable.getValueAt(figuritasTable.getSelectedRow(), figuritasTable.getSelectedColumn());
                            if (icon != null) {
                                String[] numAndCountry = hashMap.get(icon).split(" ");
                                PublicationController.getInstance().setPublicationInterestedFiguritaImageSelected(new Figurita(Integer.parseInt(numAndCountry[0]), numAndCountry[1], icon));
                                PickFiguritaFrame.this.setVisible(false);
                            }
                            ViewController.getInstance().goToCreatePublication(PickFiguritaFrame.this, false);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                    case CREATE_OFFER_OFFERED_FIGURITAS: {
                        try {
                            ImageIcon icon = (ImageIcon) figuritasTable.getValueAt(figuritasTable.getSelectedRow(), figuritasTable.getSelectedColumn());
                            if (icon != null) {
                                String[] numAndCountry = hashMap.get(icon).split(" ");
                                PublicationController.getInstance().setOfferOfferedFiguritaImageSelected(new Figurita(Integer.parseInt(numAndCountry[0]), numAndCountry[1], icon, figuritaStateComboBox.getSelectedItem().toString()));
                                PickFiguritaFrame.this.setVisible(false);
                            }
                            ViewController.getInstance().goToCreateOffer(PickFiguritaFrame.this, false);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                    case CREATE_COUNTEROFFER_OFFERED_FIGURITAS: {
                        try {
                            ImageIcon icon = (ImageIcon) figuritasTable.getValueAt(figuritasTable.getSelectedRow(), figuritasTable.getSelectedColumn());
                            if (icon != null) {
                                String[] numAndCountry = hashMap.get(icon).split(" ");
                                PublicationController.getInstance().setCounterOfferFiguritaImageSelected(new Figurita(Integer.parseInt(numAndCountry[0]), numAndCountry[1], icon, figuritaStateComboBox.getSelectedItem().toString()));
                                PickFiguritaFrame.this.setVisible(false);
                            }
                            ViewController.getInstance().goToCreateCounterOfferFrame(PickFiguritaFrame.this, false);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                }
            }
        });

        filterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ResultSet resultSet = PublicationController.getInstance().getFiguritasPhotos(countryComboBox.getSelectedItem().toString(), numberComboBox.getSelectedItem().toString());
                    if (resultSet != null) {
                        hashMap = new HashMap<>();
                        Icon[] iconsRows = new Icon[3];
                        int index = 0;
                        DefaultTableModel defaultTableModel = new DefaultTableModel(0, 3);
                        while (resultSet.next()) {
                            Icon icon = new ImageIcon(new ImageIcon(resultSet.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_SMOOTH));
                            iconsRows[index] = icon;
                            hashMap.put(icon, resultSet.getInt("numero") + " " + resultSet.getString("pais"));
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
                        figuritasTable.setModel(defaultTableModel);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EPickFigurita eAddFiguritaOptions = PublicationController.getInstance().getStatusEnum();
                ViewController viewController = ViewController.getInstance();
                switch (eAddFiguritaOptions) {
                    case CREATE_PUBLICATION_OFFERED_FIGURITA:
                    case CREATE_PUBLICATION_INTERESTED_FIGURITAS: {
                        try {
                            viewController.goToCreatePublication(PickFiguritaFrame.this, false);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                    case CREATE_OFFER_OFFERED_FIGURITAS: {
                        try {
                            viewController.goToCreateOffer(PickFiguritaFrame.this, false);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                    case CREATE_COUNTEROFFER_OFFERED_FIGURITAS: {
                        try {
                            viewController.goToCreateCounterOfferFrame(PickFiguritaFrame.this, false);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        numberLabel = new JLabel();
        numberComboBox = new JComboBox();
        countryLabel = new JLabel();
        countryComboBox = new JComboBox();
        scrollPane1 = new JScrollPane();
        figuritasTable = new JTable(0, 3) {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        figuritasTable.setTableHeader(null);
        figuritasTable.setRowHeight(312);
        figuritasTable.setRowMargin(5);
        filterButton = new JButton();
        figuritaStateLabel = new JLabel();
        figuritaStateComboBox = new JComboBox();
        cancelButton = new JButton();

        //======== this ========
        setTitle("ELEGIR FIGURITA");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- numberLabel ----
                numberLabel.setText("Numero");

                //---- countryLabel ----
                countryLabel.setText("Pa\u00eds");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(figuritasTable);
                }

                //---- filterButton ----
                filterButton.setText("FILTRAR");

                //---- figuritaStateLabel ----
                figuritaStateLabel.setText("Estado");

                //---- cancelButton ----
                cancelButton.setText("CANCELAR");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addComponent(scrollPane1)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(numberLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numberComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(countryLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(countryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(figuritaStateLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(figuritaStateComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(figuritaStateComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(figuritaStateLabel))
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numberComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(numberLabel)
                                                        .addComponent(cancelButton))
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(countryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(filterButton)
                                                        .addComponent(countryLabel)))
                                        .addGap(18, 18, 18)
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JLabel numberLabel;
    private JComboBox numberComboBox;
    private JLabel countryLabel;
    private JComboBox countryComboBox;
    private JScrollPane scrollPane1;
    private JTable figuritasTable;
    private JButton filterButton;
    private JLabel figuritaStateLabel;
    private JComboBox figuritaStateComboBox;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
