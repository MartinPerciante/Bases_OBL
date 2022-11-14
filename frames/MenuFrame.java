/*
 * Created by JFormDesigner on Thu Nov 10 18:39:10 UYT 2022
 */

package frames;

import controller.UserController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        createUserButton = new JButton();
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

                //---- createUserButton ----
                createUserButton.setText("Crear usuario");

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
                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(myProfileButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(createUserButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(listPublicationsButton)
                                .addComponent(createPublicationButton))
                            .addGap(121, 121, 121))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(25, Short.MAX_VALUE)
                            .addComponent(createPublicationButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(listPublicationsButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(createUserButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(myProfileButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(logOutButton)
                            .addGap(22, 22, 22))
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
        UserController userController = UserController.getInstance();
        myProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userController.goToUserDataFrameFromMenu();
            }
        });
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JButton createPublicationButton;
    private JButton listPublicationsButton;
    private JButton createUserButton;
    private JButton myProfileButton;
    private JButton logOutButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
