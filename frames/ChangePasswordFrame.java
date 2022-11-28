package frames;

import controller.UserController;
import controller.ViewController;
import entities.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordFrame extends JFrame {

    private final String notActualPasswordError = "La contraseña actual ingresada es incorrecta";
    private final String notTheSamePasswordError = "La nueva contraseña y la confirmación no coinciden";
    private final String notEmptyError = "Los campos no pueden estar vacios";

    public ChangePasswordFrame() {
        initComponents();
        buttonActions();
        errorLabel.setVisible(false);
        setResizable(false);
    }

    private void initComponents() {
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

        setTitle("CAMBIAR CONTRASE\u00d1A");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            {

                actualPasswordLabel.setText("Contrase\u00f1a actual");

                newPasswordLabel.setText("Nueva contrase\u00f1a");

                repeatPasswordLabel.setText("Repetir contrase\u00f1a");

                saveButton.setText("GUARDAR");

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
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(actualPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(actualPasswordField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                                .addComponent(newPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                                .addComponent(repeatPasswordLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(repeatNewPasswordField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(errorLabel, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap(155, Short.MAX_VALUE)
                                                        .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGap(34, 34, 34)
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(actualPasswordLabel)
                                                                .addComponent(actualPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(34, 34, 34)
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(newPasswordLabel)
                                                                .addComponent(newPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(34, 34, 34)
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(repeatPasswordLabel)
                                                                .addComponent(repeatNewPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)))
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
                if (!newPasswordField.getText().isEmpty() && !repeatNewPasswordField.getText().isEmpty()) {
                    if (newPasswordField.getText().equals(repeatNewPasswordField.getText())) {

                        if (userController.changePassword(Usuario.getInstance().getUsername(),
                                actualPasswordField.getText(),
                                newPasswordField.getText())) {
                            errorLabel.setVisible(false);
                            ViewController.getInstance().goToMenu(ChangePasswordFrame.this);
                        } else {
                            errorLabel.setText(notActualPasswordError);
                            errorLabel.setVisible(true);
                        }
                    } else {
                        errorLabel.setText(notTheSamePasswordError);
                        errorLabel.setVisible(true);
                    }
                } else {
                    errorLabel.setText(notEmptyError);
                    errorLabel.setVisible(true);
                }
            }
        });
    }

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
}
