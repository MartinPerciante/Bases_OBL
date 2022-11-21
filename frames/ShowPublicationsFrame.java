/*
 * Created by JFormDesigner on Sat Nov 19 16:54:06 UYT 2022
 */

package frames;

import controller.PublicationController;
import controller.ViewController;
import entities.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static utils.Utils.EMPTY_ITEM;

/**
 * @author unknown
 */
public class ShowPublicationsFrame extends JFrame {
    public ShowPublicationsFrame() throws SQLException {
        initComponents();
        publicationPanelArrayList = new ArrayList<>();
        buttonActions();
        loadComboBoxData();
        populatePublications(EMPTY_ITEM, EMPTY_ITEM);
        setResizable(false);
    }

    int xPosition = 0;

    int yPosition = 0;

    int width = 800;

    int height = 480;

    ArrayList<PublicationPanel> publicationPanelArrayList;

    private void populatePublications(String number, String country) throws SQLException {
        for (PublicationPanel publicationPanel : publicationPanelArrayList) {
            publicationsPanel.remove(publicationPanel);
        }
        xPosition = 0;
        yPosition = 0;
        publicationPanelArrayList = new ArrayList<>();
        ResultSet resultSetPublications = PublicationController.getInstance().getPublications(number, country);
        if (resultSetPublications != null) {
            Boolean isPositionedLeft = true;
            while (resultSetPublications.next()) {
                String document = resultSetPublications.getString("ci");
                String firstName = resultSetPublications.getString("nombre");
                String lastName = resultSetPublications.getString("apellido");
                String date = resultSetPublications.getString("fecha");
                String publicationState = resultSetPublications.getString("estado");
                String figuritaState = resultSetPublications.getString("estado_figurita");
                Icon figuritaPublicatedImage = new ImageIcon(new ImageIcon(resultSetPublications.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
                ResultSet resultSetInterestedFiguritas = PublicationController.getInstance().getPublicationsInterestedFiguritas(document, date);
                ArrayList<Icon> iconArrayList = new ArrayList<>();
                if (resultSetInterestedFiguritas != null) {
                    while (resultSetInterestedFiguritas.next()) {
                        Icon icon = new ImageIcon(new ImageIcon(resultSetInterestedFiguritas.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
                        iconArrayList.add(icon);
                    }
                }
                PublicationPanel publicationPanel = new PublicationPanel(document.equals(Usuario.getInstance().getUsername()), xPosition, yPosition, width, height);
                publicationPanel.setPublicationData(document, firstName.concat(" ").concat(lastName), date, publicationState, figuritaState, figuritaPublicatedImage, iconArrayList);
                publicationPanelArrayList.add(publicationPanel);
                publicationsPanel.add(publicationPanel);
                if (isPositionedLeft) {
                    xPosition += width + 5;
                    isPositionedLeft = false;
                } else {
                    xPosition -= width + 5;
                    yPosition += height + 5;
                    isPositionedLeft = true;
                }
            }
        }
        getContentPane().add(publicationsPanel);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void loadComboBoxData() throws SQLException {
        ResultSet resultSet = PublicationController.getInstance().getFiguritasCountry();
        countryComboBox.addItem(EMPTY_ITEM);
        while (resultSet.next()) {
            countryComboBox.addItem(resultSet.getString("pais"));
        }
        //agregar num de figurita oficiales, no se si son 30, tambien podria ser una query a la tabla de figurita
        //que agarra los num sin repetir
        numberComboBox.addItem(EMPTY_ITEM);
        for (int i = 1; i <= 30; i++) {
            numberComboBox.addItem(i);
        }
    }

    private void buttonActions() {
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    populatePublications(numberComboBox.getSelectedItem().toString(), countryComboBox.getSelectedItem().toString());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.getInstance().goToMenu(ShowPublicationsFrame.this);
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        filterPanel = new JPanel();
        numberLabel = new JLabel();
        numberComboBox = new JComboBox();
        countryLabel = new JLabel();
        countryComboBox = new JComboBox();
        filterButton = new JButton();
        cancelButton = new JButton();
        publicationsPanel = new JPanel();

        //======== this ========
        setTitle("PUBLICACIONES");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== filterPanel ========
        {

            //---- numberLabel ----
            numberLabel.setText("Numero");

            //---- countryLabel ----
            countryLabel.setText("Pa\u00eds");

            //---- filterButton ----
            filterButton.setText("FILTRAR");

            //---- cancelButton ----
            cancelButton.setText("CANCELAR");

            GroupLayout filterPanelLayout = new GroupLayout(filterPanel);
            filterPanel.setLayout(filterPanelLayout);
            filterPanelLayout.setHorizontalGroup(
                    filterPanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, filterPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 340, Short.MAX_VALUE)
                                    .addComponent(numberLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numberComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(countryLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(countryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
            filterPanelLayout.setVerticalGroup(
                    filterPanelLayout.createParallelGroup()
                            .addGroup(filterPanelLayout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(filterPanelLayout.createParallelGroup()
                                            .addGroup(filterPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(numberComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(numberLabel)
                                                    .addComponent(cancelButton))
                                            .addComponent(countryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(filterButton)
                                            .addGroup(filterPanelLayout.createSequentialGroup()
                                                    .addGap(4, 4, 4)
                                                    .addComponent(countryLabel)))
                                    .addContainerGap(41, Short.MAX_VALUE))
            );
        }
        contentPane.add(filterPanel, BorderLayout.NORTH);

        //======== publicationsPanel ========
        {

            GroupLayout publicationsPanelLayout = new GroupLayout(publicationsPanel);
            publicationsPanel.setLayout(publicationsPanelLayout);
            publicationsPanelLayout.setHorizontalGroup(
                    publicationsPanelLayout.createParallelGroup()
                            .addGap(0, 888, Short.MAX_VALUE)
            );
            publicationsPanelLayout.setVerticalGroup(
                    publicationsPanelLayout.createParallelGroup()
                            .addGap(0, 498, Short.MAX_VALUE)
            );
        }
        contentPane.add(publicationsPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel filterPanel;
    private JLabel numberLabel;
    private JComboBox numberComboBox;
    private JLabel countryLabel;
    private JComboBox countryComboBox;
    private JButton filterButton;
    private JButton cancelButton;
    private JPanel publicationsPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
