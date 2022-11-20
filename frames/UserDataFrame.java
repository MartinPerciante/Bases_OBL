/*
 * Created by JFormDesigner on Thu Nov 10 18:18:54 UYT 2022
 */

package frames;

import controller.UserController;
import controller.ViewController;
import entities.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class UserDataFrame extends JFrame {
    public UserDataFrame() {
        initComponents();
        buttonActions();
        loadInfo();
        documentTextField.setEnabled(false);
    }

    private void loadInfo(){
        ArrayList<String> fieldList = UserController.getInstance().loadInfoUser(Usuario.getInstance().getUsername());

        documentTextField.setText(fieldList.get(0));
        firstNameTextField.setText(fieldList.get(1));
        lastNameTextField.setText(fieldList.get(2));
        emailTextField.setText(fieldList.get(3));
        phoneTextField.setText(fieldList.get(4));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentLabel = new JLabel();
        documentTextField = new JTextField();
        lastNameLabel = new JLabel();
        lastNameTextField = new JTextField();
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField();
        emailLabel = new JLabel();
        emailTextField = new JTextField();
        phoneTextField = new JTextField();
        phoneLabel = new JLabel();
        changePasswordButton = new JButton();
        saveButton = new JButton();
        returnButton = new JButton();

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
                documentLabel.setText("Documento");

                //---- lastNameLabel ----
                lastNameLabel.setText("Apellido");

                //---- firstNameLabel ----
                firstNameLabel.setText("Nombre");

                //---- emailLabel ----
                emailLabel.setText("Email");

                //---- phoneLabel ----
                phoneLabel.setText("Tel\u00e9fono");

                //---- changePasswordButton ----
                changePasswordButton.setText("CAMBIAR CONTRASE\u00d1A");

                //---- saveButton ----
                saveButton.setText("GUARDAR");

                //---- returnButton ----
                returnButton.setText("VOLVER");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(phoneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(12, 12, 12)
                                            .addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(firstNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(12, 12, 12)
                                            .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(documentLabel)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(documentTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(documentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(documentLabel))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(firstNameLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                            .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(lastNameLabel))
                                            .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18))))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(emailLabel)
                                        .addComponent(phoneLabel))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(changePasswordButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(returnButton))
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

    private void buttonActions() {
        UserController userController = UserController.getInstance();
        ViewController viewController = ViewController.getInstance();

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {viewController.goToChangePassword(UserDataFrame.this);}
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.goToMenu(UserDataFrame.this);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { userController.updateInfo(documentTextField.getText(),
                                                                                    firstNameTextField.getText(),
                                                                                    lastNameTextField.getText(),
                                                                                    phoneTextField.getText(),
                                                                                    emailTextField.getText());}
        });
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel documentLabel;
    private JTextField documentTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JLabel phoneLabel;
    private JButton changePasswordButton;
    private JButton saveButton;
    private JButton returnButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
