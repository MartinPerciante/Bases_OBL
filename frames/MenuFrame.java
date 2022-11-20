/*
 * Created by JFormDesigner on Thu Nov 10 18:39:10 UYT 2022
 */

package frames;

import controller.ViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(122, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(createPublicationButton, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(listPublicationsButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(myPublicationsButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(myProfileButton, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(logOutButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
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
                            .addComponent(myProfileButton)
                            .addGap(18, 18, 18)
                            .addComponent(logOutButton)
                            .addContainerGap(35, Short.MAX_VALUE))
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
                    viewController.goToCreatePublication(MenuFrame.this);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
