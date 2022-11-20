/*
 * Created by JFormDesigner on Thu Nov 10 18:29:03 UYT 2022
 */

package frames;

import controller.UserController;
import controller.ViewController;
import entities.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ChangePasswordFrame extends JFrame {

    private final String notActualPassword = "La contraseña actual ingresada es incorrecta";
    private final String notTheSame = "La nueva contraseña y la confirmación no coinciden";

    public ChangePasswordFrame() {
        initComponents();
        buttonActions();
        errorLabel.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        actualPasswordTextField = new JTextField();
        actualPasswordLabel = new JLabel();
        newPasswordTextField = new JTextField();
        newPasswordLabel = new JLabel();
        repeatPasswordTextField = new JTextField();
        repeatPasswordLabel = new JLabel();
        saveButton = new JButton();
        cancelButton = new JButton();
        errorLabel = new JLabel();

        //======== this ========
        setTitle("CAMBIAR CONTRASE\u00d1A");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- actualPasswordLabel ----
                actualPasswordLabel.setText("Contrase\u00f1a actual");

                //---- newPasswordLabel ----
                newPasswordLabel.setText("Nueva contrase\u00f1a");

                //---- repeatPasswordLabel ----
                repeatPasswordLabel.setText("Repetir contrase\u00f1a");

                //---- saveButton ----
                saveButton.setText("GUARDAR");

                //---- cancelButton ----
                cancelButton.setText("CANCELAR");

                //---- errorLabel ----
                errorLabel.setText("text");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(cancelButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                    .addComponent(saveButton))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(newPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(actualPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(actualPasswordTextField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(repeatPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(repeatPasswordTextField, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(errorLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(0, 64, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(actualPasswordLabel)
                                .addComponent(actualPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(newPasswordLabel))
                                .addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(repeatPasswordLabel))
                                .addComponent(repeatPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
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

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.getInstance().goToMenu(ChangePasswordFrame.this);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //Los campos de password estan iguales
                if (newPasswordTextField.getText().equals(repeatPasswordTextField.getText())) {

                    if (userController.changePassword(Usuario.getInstance().getUsername(),
                             actualPasswordTextField.getText(),
                             newPasswordTextField.getText())) {
                        errorLabel.setVisible(false);
                         ViewController.getInstance().goToMenu(ChangePasswordFrame.this);
                     } else {
                        errorLabel.setText(notActualPassword);
                        errorLabel.setVisible(true);
                     }
                } else {
                    errorLabel.setText(notTheSame);
                    errorLabel.setVisible(true);
                }
            }
        });


    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField actualPasswordTextField;
    private JLabel actualPasswordLabel;
    private JTextField newPasswordTextField;
    private JLabel newPasswordLabel;
    private JTextField repeatPasswordTextField;
    private JLabel repeatPasswordLabel;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel errorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
