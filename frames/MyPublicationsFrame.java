package frames;

import controller.PublicationController;
import controller.ViewController;
import entities.Usuario;
import panels.PublicationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyPublicationsFrame extends JFrame {
    public MyPublicationsFrame() throws SQLException {
        initComponents();
        publicationPanelArrayList = new ArrayList<>();
        buttonActions();
        populatePublications();
        setResizable(false);
    }

    int xPosition = 0;

    int yPosition = 0;

    int width = 800;

    int height = 480;

    ArrayList<PublicationPanel> publicationPanelArrayList;

    private void populatePublications() throws SQLException {
        for (PublicationPanel publicationPanel : publicationPanelArrayList) {
            publicationsPanel.remove(publicationPanel);
        }
        xPosition = 0;
        yPosition = 0;
        publicationPanelArrayList = new ArrayList<>();
        ResultSet resultSetPublications = PublicationController.getInstance().getPublicationsFromUser(Usuario.getInstance().getUsername());
        if (resultSetPublications != null) {
            Boolean isPositionedLeft = true;
            while (resultSetPublications.next()) {
                PublicationPanel publicationPanel = new PublicationPanel(true, xPosition, yPosition, width, height);
                String document = resultSetPublications.getString("ci");
                String firstName = resultSetPublications.getString("nombre");
                String lastName = resultSetPublications.getString("apellido");
                String date = resultSetPublications.getString("fecha");
                String publicationState = resultSetPublications.getString("estado");
                String figuritaState = resultSetPublications.getString("estado_figurita");
                Icon figuritaPublicatedImage = new ImageIcon(new ImageIcon(resultSetPublications.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_SMOOTH));
                ResultSet resultSetInterestedFiguritas = PublicationController.getInstance().getPublicationsInterestedFiguritas(document, date);
                ArrayList<Icon> iconArrayList = new ArrayList<>();
                if (resultSetInterestedFiguritas != null) {
                    while (resultSetInterestedFiguritas.next()) {
                        Icon icon = new ImageIcon(new ImageIcon(resultSetInterestedFiguritas.getBytes("foto")).getImage().getScaledInstance(232, 312, Image.SCALE_SMOOTH));
                        iconArrayList.add(icon);
                    }
                }
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
        int panelsArrayListSize = publicationPanelArrayList.size();
        GroupLayout publicationsPanelLayout = new GroupLayout(publicationsPanel);
        publicationsPanel.setLayout(publicationsPanelLayout);
        publicationsPanelLayout.setHorizontalGroup(
                publicationsPanelLayout.createParallelGroup()
                        .addGap(0, panelsArrayListSize > 1 ? 1610 : 805, Short.MAX_VALUE)
        );
        publicationsPanelLayout.setVerticalGroup(
                publicationsPanelLayout.createParallelGroup()
                        .addGap(0, (panelsArrayListSize % 2 == 0 ? panelsArrayListSize / 2 : (panelsArrayListSize + 1) / 2) * (height + 5), Short.MAX_VALUE)
        );
        scrollPane1.setViewportView(publicationsPanel);
        getContentPane().add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private void buttonActions() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.getInstance().goToMenu(MyPublicationsFrame.this);
            }
        });
    }

    private void initComponents() {
        buttonsPanel = new JPanel();
        goBackButton = new JButton();
        scrollPane1 = new JScrollPane();
        publicationsPanel = new JPanel();

        setTitle("MIS PUBLICACIONES");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        {

            goBackButton.setText("VOLVER");

            GroupLayout buttonsPanelLayout = new GroupLayout(buttonsPanel);
            buttonsPanel.setLayout(buttonsPanelLayout);
            buttonsPanelLayout.setHorizontalGroup(
                    buttonsPanelLayout.createParallelGroup()
                            .addGroup(buttonsPanelLayout.createSequentialGroup()
                                    .addGap(372, 372, 372)
                                    .addComponent(goBackButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(402, Short.MAX_VALUE))
            );
            buttonsPanelLayout.setVerticalGroup(
                    buttonsPanelLayout.createParallelGroup()
                            .addGroup(buttonsPanelLayout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(goBackButton)
                                    .addContainerGap(38, Short.MAX_VALUE))
            );
        }
        contentPane.add(buttonsPanel, BorderLayout.NORTH);

        {

            {

                GroupLayout publicationsPanelLayout = new GroupLayout(publicationsPanel);
                publicationsPanel.setLayout(publicationsPanelLayout);
                publicationsPanelLayout.setHorizontalGroup(
                        publicationsPanelLayout.createParallelGroup()
                                .addGap(0, 886, Short.MAX_VALUE)
                );
                publicationsPanelLayout.setVerticalGroup(
                        publicationsPanelLayout.createParallelGroup()
                                .addGap(0, 502, Short.MAX_VALUE)
                );
            }
            scrollPane1.setViewportView(publicationsPanel);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel buttonsPanel;
    private JButton goBackButton;
    private JScrollPane scrollPane1;
    private JPanel publicationsPanel;
}
