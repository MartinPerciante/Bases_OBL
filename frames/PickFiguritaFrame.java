/*
 * Created by JFormDesigner on Sat Nov 12 15:53:20 UYT 2022
 */

package frames;

import controller.PublicationController;
import database.DBService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author unknown
 */
public class PickFiguritaFrame extends JFrame {
    public PickFiguritaFrame() throws SQLException {
        ResultSet resultSet = DBService.executeQuery("SELECT pais FROM pais_figurita");
        countryComboBox = new JComboBox();
        while (resultSet.next()) {
            countryComboBox.addItem(resultSet.getString("pais"));
        }
        numberComboBox = new JComboBox();
        //agregar num de figurita oficiales, no se si son 30, tambien podria ser una query a la tabla de figurita
        //que agarra los num sin repetir
        for (int i = 1; i <= 30; i++) {
            numberComboBox.addItem(i);
        }
        figuritasTable = new JTable() {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        figuritasTable.setTableHeader(null);
        figuritasTable.setRowHeight(312);
        figuritasTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PublicationController.getInstance().setPublicationFiguritaImageSelected((ImageIcon) figuritasTable.getValueAt(figuritasTable.getSelectedRow(), figuritasTable.getSelectedColumn()));
                setVisible(false);
            }
        });
        filterButton = new JButton();
        filterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    populateFilteredFiguritasTable();
                } catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        populateFilteredFiguritasTable();
        initComponents();
    }

    private void populateFilteredFiguritasTable() throws SQLException {
        ResultSet resultSet = DBService.executeQuery("SELECT foto FROM figurita WHERE pais = '" + countryComboBox.getSelectedItem().toString() + "' AND numero = " + Integer.parseInt(numberComboBox.getSelectedItem().toString()));
        if(resultSet != null) {
            defaultTableModel = new DefaultTableModel(0, 5);
            int column = 0;
            Icon[] data = new Icon[5];
            while (resultSet.next()) {
                byte[] bytes = resultSet.getBytes("foto");
                if (bytes != null) {
                    ImageIcon icon = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
                    data[column] = icon;
                    column++;
                    if (column == 5) {
                        column = 0;
                        defaultTableModel.addRow(data);
                        data = new Icon[]{};
                    }
                }
            }
            if(data[0] != null){
                defaultTableModel.addRow(data);
            }
            figuritasTable.setModel(defaultTableModel);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        numberLabel = new JLabel();

        countryLabel = new JLabel();

        scrollPane1 = new JScrollPane();

        //======== this ========
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
                filterButton.setText("BUSCAR");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addComponent(numberLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numberComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(countryLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(countryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 277, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numberComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(numberLabel))
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
    private DefaultTableModel defaultTableModel;
    private JButton filterButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
