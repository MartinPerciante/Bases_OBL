/*
 * Created by JFormDesigner on Thu Nov 10 18:39:10 UYT 2022
 */

package frames;

import controller.UserController;
import controller.ViewController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class MenuFrame extends JFrame {
    public MenuFrame() {
        initComponents();
        buttonActions();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        createPublicationButton = new JButton();
        listPublicationsButton = new JButton();
        myProfileButton = new JButton();
        logOutButton = new JButton();

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(125, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(createPublicationButton)
                                .addComponent(listPublicationsButton)
                                .addComponent(myProfileButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                            .addGap(121, 121, 121))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(33, Short.MAX_VALUE)
                            .addComponent(createPublicationButton)
                            .addGap(18, 18, 18)
                            .addComponent(listPublicationsButton)
                            .addGap(18, 18, 18)
                            .addComponent(myProfileButton)
                            .addGap(18, 18, 18)
                            .addComponent(logOutButton)
                            .addGap(38, 38, 38))
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
        createPublicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ViewController.getInstance().goToCreatePublication(MenuFrame.this);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        myProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.getInstance().goToUserData(MenuFrame.this);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.getInstance().goToLogin(MenuFrame.this);
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
