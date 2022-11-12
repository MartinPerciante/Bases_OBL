/*
 * Created by JFormDesigner on Thu Nov 10 18:37:14 UYT 2022
 */

package frames;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class CreateUserFrame extends JFrame {
    public CreateUserFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentLabel = new JLabel();
        documentTextField = new JTextField();
        firstNameLabel = new JLabel();
        firstNameTextField = new JTextField();
        lastNameField = new JTextField();
        lastNameLabel = new JLabel();
        phoneLabel = new JLabel();
        phoneTextField = new JTextField();
        emailLabel = new JLabel();
        emailTextField = new JTextField();
        passwordLabel = new JLabel();
        passwordTextField = new JTextField();
        createUserButton = new JButton();
        cancelButton = new JButton();

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
                                            .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
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
                                .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                .addComponent(createUserButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGap(28, 28, 28))
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
                                    .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel documentLabel;
    private JTextField documentTextField;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JButton createUserButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
