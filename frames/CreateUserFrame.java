/*
 * Created by JFormDesigner on Sun Nov 13 17:58:13 UYT 2022
 */

package frames;

import controller.UserController;
import controller.ViewController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
import java.lang.NumberFormatException;

/**
 * @author unknown
 */
public class CreateUserFrame extends JFrame {

    private final String notTheSame = "La contraseña y la confirmación no coinciden";
    private final String nullText = "Debe rellenar todos los campos";
    private final String notNumber = "El documento o teléfono tiene caracteres no numéricos";

    public CreateUserFrame() {
        initComponents();
        buttonActions();
        errorLabel.setVisible(false);
        setResizable(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentLabel = new JLabel();
        documentTextField = new JTextField();
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField();
        lastNameTextField = new JTextField();
        lastNameLabel = new JLabel();
        phoneLabel = new JLabel();
        phoneTextField = new JTextField();
        emailLabel = new JLabel();
        emailTextField = new JTextField();
        passwordLabel = new JLabel();
        createUserButton = new JButton();
        cancelButton = new JButton();
        errorLabel = new JLabel();
        passwordField = new JPasswordField();
        repeatPasswordLabel = new JLabel();
        repeatPasswordField = new JPasswordField();

        //======== this ========
        setTitle("CREAR USUARIO");
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

                //---- firstNameLabel ----
                firstNameLabel.setText("Nombre");

                //---- lastNameLabel ----
                lastNameLabel.setText("Apellido");

                //---- phoneLabel ----
                phoneLabel.setText("Tel\u00e9fono");

                //---- emailLabel ----
                emailLabel.setText("Email");

                //---- passwordLabel ----
                passwordLabel.setText("Contrase\u00f1a");

                //---- createUserButton ----
                createUserButton.setText("CREAR");

                //---- cancelButton ----
                cancelButton.setText("CANCELAR");

                //---- repeatPasswordLabel ----
                repeatPasswordLabel.setText("Repetir contrase\u00f1a");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(createUserButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                    .addComponent(firstNameLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(12, 12, 12)
                                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(repeatPasswordLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(repeatPasswordField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(150, 150, 150)
                                            .addComponent(documentLabel)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(documentTextField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(documentLabel)
                                        .addComponent(documentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstNameLabel))
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lastNameLabel)))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneLabel)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLabel)
                                        .addComponent(repeatPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(repeatPasswordLabel))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                    .addGap(0, 209, Short.MAX_VALUE)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(createUserButton, GroupLayout.Alignment.TRAILING)
                                        .addComponent(cancelButton, GroupLayout.Alignment.TRAILING)))))
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

        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                if (documentTextField.getText() != null && firstNameTextField.getText() != null &&
                        lastNameTextField.getText() != null && phoneTextField.getText() != null &&
                        emailTextField.getText() != null && passwordField.getText() != null &&
                        repeatPasswordField.getText() != null) {
                        try {
                            if (passwordField.getText().compareTo(repeatPasswordField.getText()) == 0) {
                                Integer.parseInt(documentTextField.getText());
                                Integer.parseInt(phoneTextField.getText());
                                userController.register(documentTextField.getText(), firstNameTextField.getText(),
                                        lastNameTextField.getText(), phoneTextField.getText(),
                                        emailTextField.getText(), passwordField.getText());
                                //Salto al frame de creación de usuario
                                viewController.goToLogin(CreateUserFrame.this);
                            } else {
                                errorLabel.setText(notTheSame);
                            }

                        } catch (NumberFormatException h) {
                            errorLabel.setText(notNumber);
                            errorLabel.setVisible(true);
                        }
                } else {
                    errorLabel.setText(nullText);
                    errorLabel.setVisible(true);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Salto al frame de creación de usuario
                viewController.goToLogin(CreateUserFrame.this);
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel documentLabel;
    private JTextField documentTextField;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JLabel lastNameLabel;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JButton createUserButton;
    private JButton cancelButton;
    private JLabel errorLabel;
    private JPasswordField passwordField;
    private JLabel repeatPasswordLabel;
    private JPasswordField repeatPasswordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
