/*
 * Created by JFormDesigner on Sat Nov 12 14:38:04 UYT 2022
 */

package frames;

import controller.PublicationController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

/**
 * @author unknown
 */
public class CreatePublicationFrame extends JFrame {
    public CreatePublicationFrame() throws SQLException {
        initComponents();
        PublicationController.getInstance().setCreatePublicationFrame(this);
        PublicationController.getInstance().setPublicationFrameData();
    }

    public JLabel getFiguritaImageLabel() {
        return figuritaImageLabel;
    }

    //añadir a table metodo getColumnClass con return Icon.class
    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentLabel = new JLabel();
        offeredFiguritaLabel = new JLabel();
        interestedFiguritasLabel = new JLabel();
        figuritaImageLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        interestedFiguritasTable = new JTable() {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        figuritasStateLabel = new JLabel();
        documentValueLabel = new JLabel();
        figuritaStateComboBox = new JComboBox();
        cancelButton = new JButton();
        createButton = new JButton();
        addFiguritaButton = new JButton();

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
                    scrollPane1.setViewportView(interestedFiguritasTable);
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
                                                                        .addGap(425, 425, 425)
                                                                        .addComponent(interestedFiguritasLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1005, GroupLayout.PREFERRED_SIZE))))
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap(9, Short.MAX_VALUE)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(documentValueLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(documentLabel, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
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
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
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
    private JLabel figuritaImageLabel;
    private JScrollPane scrollPane1;
    private JTable interestedFiguritasTable;
    private JLabel figuritasStateLabel;
    private JLabel documentValueLabel;

    public JTable getInterestedFiguritasTable() {
        return interestedFiguritasTable;
    }

    public JComboBox getFiguritaStateComboBox() {
        return figuritaStateComboBox;
    }

    public JButton getAddFiguritaButton() {
        return addFiguritaButton;
    }

    private JComboBox figuritaStateComboBox;
    private JButton cancelButton;
    private JButton createButton;
    private JButton addFiguritaButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
