/*
 * Created by JFormDesigner on Sat Nov 12 15:53:20 UYT 2022
 */

package frames;

import controller.PublicationController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author unknown
 */
public class PickFiguritaFrame extends JFrame {
    public PickFiguritaFrame() throws SQLException {
        initComponents();
        PublicationController.getInstance().setPickFiguritaFrameData();
    }

    //borrar lineas numberComboBox, countryComboBox, figuritasTable, filterButton
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        numberLabel = new JLabel();
        numberComboBox = new JComboBox();
        countryLabel = new JLabel();
        countryComboBox = new JComboBox();
        scrollPane1 = new JScrollPane();
        figuritasTable = new JTable() {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        filterButton = new JButton();
        cancelButton = new JButton();

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
                filterButton.setText("FILTRAR");

                //---- cancelButton ----
                cancelButton.setText("CANCELAR");

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
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                                        .addComponent(cancelButton)
                                        .addContainerGap())
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
                                                        .addComponent(countryLabel)
                                                        .addComponent(cancelButton)))
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

    public JComboBox getNumberComboBox() {
        return numberComboBox;
    }

    public JComboBox getCountryComboBox() {
        return countryComboBox;
    }

    public JTable getFiguritasTable() {
        return figuritasTable;
    }

    public JButton getFilterButton() {
        return filterButton;
    }

    private JComboBox numberComboBox;
    private JLabel countryLabel;
    private JComboBox countryComboBox;
    private JScrollPane scrollPane1;
    private JTable figuritasTable;
    private JButton filterButton;
    private JButton cancelButton;

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private DefaultTableModel defaultTableModel;
}
