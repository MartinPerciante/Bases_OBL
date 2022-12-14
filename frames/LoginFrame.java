package frames;

import controller.UserController;
import controller.ViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        initComponents();
        buttonActions();
        errorLabel.setVisible(false);
        setResizable(false);
    }

    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentTextField = new JTextField();
        documentLabel = new JLabel();
        passwordLabel = new JLabel();
        loginButton = new JButton();
        passwordTextField = new JPasswordField();
        registerButton = new JButton();
        errorLabel = new JLabel();

        setResizable(false);
        setTitle("INICIAR SESI\u00d3N");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            {

                documentLabel.setText("Documento");

                passwordLabel.setText("Contrase\u00f1a");

                loginButton.setText("INGRESAR");

                registerButton.setText("REGISTRARSE");

                errorLabel.setText("Documento o contrase\u00f1a incorrectos");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGap(87, 87, 87)
                                                        .addComponent(errorLabel))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGap(48, 48, 48)
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(documentLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(documentTextField)
                                                                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(registerButton, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                                                        .addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addGap(50, 50, 50))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(errorLabel)
                                        .addGap(36, 36, 36)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(documentTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(documentLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(passwordLabel))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addComponent(loginButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(registerButton)
                                        .addGap(17, 17, 17))
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
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController.getInstance().goToRegistration(LoginFrame.this);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean bool = userController.login(documentTextField.getText(), passwordTextField.getText());
                if (!bool) {
                    errorLabel.setVisible(true);
                } else {
                    ViewController.getInstance().goToMenu(LoginFrame.this);
                }

            }
        });
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField documentTextField;
    private JLabel documentLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JPasswordField passwordTextField;
    private JButton registerButton;
    private JLabel errorLabel;
}
