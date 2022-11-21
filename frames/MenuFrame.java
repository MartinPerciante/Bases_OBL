/*
 * Created by JFormDesigner on Thu Nov 10 18:39:10 UYT 2022
 */

package frames;

import controller.ViewController;
import database.DBService;
import entities.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * @author unknown
 */
public class MenuFrame extends JFrame {
    public MenuFrame() {
        initComponents();
        buttonActions();
        setResizable(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        createPublicationButton = new JButton();
        listPublicationsButton = new JButton();
        myProfileButton = new JButton();
        logOutButton = new JButton();
        myPublicationsButton = new JButton();
        myOffersButton = new JButton();

        //======== this ========
        setTitle("MENU PRINCIPAL");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- createPublicationButton ----
                createPublicationButton.setText("Crear publicaci\u00f3n");

                //---- listPublicationsButton ----
                listPublicationsButton.setText("Ver publicaciones");

                //---- myProfileButton ----
                myProfileButton.setText("Mi perfil");

                //---- logOutButton ----
                logOutButton.setText("Cerrar sesi\u00f3n");

                //---- myPublicationsButton ----
                myPublicationsButton.setText("Mis publicaciones");

                //---- myOffersButton ----
                myOffersButton.setText("Mis ofertas");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(122, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addComponent(myProfileButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addComponent(myOffersButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(createPublicationButton, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(listPublicationsButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(myPublicationsButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
                            .addGap(121, 121, 121))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(createPublicationButton)
                            .addGap(18, 18, 18)
                            .addComponent(listPublicationsButton)
                            .addGap(18, 18, 18)
                            .addComponent(myPublicationsButton)
                            .addGap(18, 18, 18)
                            .addComponent(myOffersButton)
                            .addGap(18, 18, 18)
                            .addComponent(myProfileButton)
                            .addGap(18, 18, 18)
                            .addComponent(logOutButton)
                            .addContainerGap(18, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void buttonActions() {
        ViewController viewController = ViewController.getInstance();

        createPublicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet result = DBService.executeQuery("SELECT * FROM publicacion WHERE ci_usuario = '" + Usuario.getInstance().getUsername() + "'");
                    int cont = 0;
                    while (result.next()) {
                        cont++;
                    }
                    if (cont < 3) {
                        viewController.goToCreatePublication(MenuFrame.this, true);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        listPublicationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewController.goToShowPublications(MenuFrame.this);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        myPublicationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewController.goToMyPublications(MenuFrame.this);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        myOffersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewController.goToMyOffers(MenuFrame.this, null, null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        myProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.goToUserData(MenuFrame.this);
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.goToLogin(MenuFrame.this);
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JButton createPublicationButton;
    private JButton listPublicationsButton;
    private JButton myProfileButton;
    private JButton logOutButton;
    private JButton myPublicationsButton;
    private JButton myOffersButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
