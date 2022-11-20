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
    private final String notEmpty = "Los campos no pueden estar vacios";

    public ChangePasswordFrame() {
        initComponents();
        buttonActions();
        errorLabel.setVisible(false);
        setResizable(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        actualPasswordLabel = new JLabel();
        newPasswordLabel = new JLabel();
        repeatPasswordLabel = new JLabel();
        saveButton = new JButton();
        cancelButton = new JButton();
        errorLabel = new JLabel();
        actualPasswordField = new JPasswordField();
        newPasswordField = new JPasswordField();
        repeatNewPasswordField = new JPasswordField();

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(cancelButton)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saveButton))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(errorLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(actualPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(actualPasswordField))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(newPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(repeatPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(repeatNewPasswordField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(60, 60, 60)))))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(actualPasswordLabel)
                                .addComponent(actualPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(newPasswordLabel)
                                .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(repeatPasswordLabel)
                                .addComponent(repeatNewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                            .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
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
                if (!newPasswordField.getText().isEmpty() && ! repeatNewPasswordField.getText().isEmpty()) {
                    if (newPasswordField.getText().equals(repeatNewPasswordField.getText())) {

                        if (userController.changePassword(Usuario.getInstance().getUsername(),
                                actualPasswordField.getText(),
                                newPasswordField.getText())) {
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
                } else {
                    errorLabel.setText(notEmpty);
                    errorLabel.setVisible(true);
                }
            }
        });


    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel actualPasswordLabel;
    private JLabel newPasswordLabel;
    private JLabel repeatPasswordLabel;
    private JButton saveButton;
    private JButton cancelButton;
    private JLabel errorLabel;
    private JPasswordField actualPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField repeatNewPasswordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
