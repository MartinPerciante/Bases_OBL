/*
 * Created by JFormDesigner on Sun Nov 13 17:58:13 UYT 2022
 */

package frames;

import controller.UserController;

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
    public CreateUserFrame() {
        initComponents();
        buttonActions();
        errorLabel.setVisible(false);
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
        passwordTextField = new JTextField();
        createUserButton = new JButton();
        cancelButton = new JButton();
        errorLabel = new JLabel();

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(documentLabel)
                                            .addGap(12, 12, 12)
                                            .addComponent(documentTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(firstNameLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)))
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addComponent(createUserButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(75, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(documentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(documentLabel)
                                                .addComponent(passwordLabel))))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(firstNameLabel)
                                                .addComponent(lastNameLabel))))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(phoneLabel)
                                                .addComponent(emailLabel)))))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelButton)
                                .addComponent(createUserButton))
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

        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorLabel.setVisible(false);
                if (documentTextField.getText() != null && firstNameTextField.getText() != null &&
                        lastNameTextField.getText() != null && phoneTextField.getText() != null &&
                        emailTextField.getText() != null && passwordTextField.getText() != null) {
                        try {
                            Integer.parseInt(documentTextField.getText());
                            Integer.parseInt(phoneTextField.getText());
                            userController.register(documentTextField.getText(), firstNameTextField.getText(),
                                    lastNameTextField.getText(), phoneTextField.getText(),
                                    emailTextField.getText(), passwordTextField.getText());
                            //Salto al frame de creación de usuario
                            LoginFrame a = new LoginFrame();
                            setVisible(false);
                            a.setVisible(true);
                        } catch (NumberFormatException h) {
                            errorLabel.setText("El documento o teléfono tiene caracteres no numéricos");
                            errorLabel.setVisible(true);
                        }
                } else {
                    errorLabel.setText("Debe rellenar todos los campos");
                    errorLabel.setVisible(true);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Salto al frame de creación de usuario
                userController.goToLoginScreenFromRegistration();
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
    private JTextField passwordTextField;
    private JButton createUserButton;
    private JButton cancelButton;
    private JLabel errorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
