/*
 * Created by JFormDesigner on Sat Nov 12 14:38:04 UYT 2022
 */

package frames;

import database.DBService;

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

/**
 * @author unknown
 */
public class CreatePublicationFrame extends JFrame {
    public CreatePublicationFrame() throws SQLException {
        ResultSet resultSet = DBService.executeQuery("SELECT estado FROM estado_figurita");
        figuritaStateComboBox = new JComboBox();
        while (resultSet.next()) {
            figuritaStateComboBox.addItem(resultSet.getString("estado"));
        }
        figuritaImageLabel = new JLabel();
        figuritaImageLabel.setText("Haga click para seleccionar una figurita");
        figuritaImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PickFiguritaFrame pickFiguritaFrame;
                try {
                    pickFiguritaFrame = new PickFiguritaFrame();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                pickFiguritaFrame.setSize(500, 500);
                pickFiguritaFrame.setVisible(true);
            }
        });
        table1 = new JTable() {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        table1.setPreferredScrollableViewportSize(table1.getPreferredSize());
        table1.setRowHeight(312);
        addFiguritaButton = new JButton();
        addFiguritaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PickFiguritaFrame pickFiguritaFrame;
                try {
                    pickFiguritaFrame = new PickFiguritaFrame();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                pickFiguritaFrame.setSize(500, 500);
                pickFiguritaFrame.setVisible(true);
            }
        });
        initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentLabel = new JLabel();
        offeredFiguritaLabel = new JLabel();
        interestedFiguritasLabel = new JLabel();
        documentValueLabel = new JLabel();
        scrollPane1 = new JScrollPane();

        figuritasStateLabel = new JLabel();


        cancelButton = new JButton();
        createButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- documentLabel ----
                documentLabel.setText("Documento del usuario:");

                //---- offeredFiguritaLabel ----
                offeredFiguritaLabel.setText("Figurita ofrecida");

                //---- interestedFiguritasLabel ----
                interestedFiguritasLabel.setText("Figuritas interesadas");

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }

                //---- figuritasStateLabel ----
                figuritasStateLabel.setText("Estado:");

                //---- cancelButton ----
                cancelButton.setText("CANCELAR");

                //---- createButton ----
                createButton.setText("CREAR");

                //---- addFiguritaButton ----
                addFiguritaButton.setText("AGREGAR");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1091, Short.MAX_VALUE)
                                    .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(figuritaImageLabel, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(documentLabel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(documentValueLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(figuritasStateLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(figuritaStateComboBox, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(offeredFiguritaLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 115, Short.MAX_VALUE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(addFiguritaButton)
                                            .addGap(371, 371, 371)
                                            .addComponent(interestedFiguritasLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1005, GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(documentValueLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                .addComponent(documentLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(offeredFiguritaLabel)
                                .addComponent(interestedFiguritasLabel)
                                .addComponent(addFiguritaButton))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(figuritasStateLabel)
                                        .addComponent(figuritaStateComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(createButton)
                                .addComponent(cancelButton))
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
    private JLabel documentLabel;
    private JLabel offeredFiguritaLabel;
    private JLabel interestedFiguritasLabel;

    public JLabel getFiguritaImageLabel() {
        return figuritaImageLabel;
    }

    private JLabel figuritaImageLabel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel figuritasStateLabel;
    private JLabel documentValueLabel;
    private JComboBox figuritaStateComboBox;
    private JButton cancelButton;
    private JButton createButton;
    private JButton addFiguritaButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
