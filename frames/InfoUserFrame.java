package frames;

import controller.UserController;
import controller.ViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InfoUserFrame extends JFrame {
    public InfoUserFrame(String username) {
        initComponents();
        buttonActions();
        loadInfo(username);
    }

    private void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentLabel = new JLabel();
        lastNameLabel = new JLabel();
        firstNameLabel = new JLabel();
        emailLabel = new JLabel();
        phoneLabel = new JLabel();
        returnButton = new JButton();
        documentValueLabel = new JLabel();
        firstNameValueLabel = new JLabel();
        phoneValueLabel = new JLabel();
        lastNameValueLabel = new JLabel();
        emailValueLabel = new JLabel();

        setTitle("INFORMACI\u00d3N CONTACTO");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            {

                documentLabel.setText("Documento");

                lastNameLabel.setText("Apellido");

                firstNameLabel.setText("Nombre");

                emailLabel.setText("Email");

                phoneLabel.setText("Tel\u00e9fono");

                returnButton.setText("VOLVER");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(firstNameLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(documentLabel))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(phoneValueLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(43, 43, 43)
                                                                        .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(firstNameValueLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lastNameValueLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(emailValueLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(documentValueLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(9, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(documentLabel)
                                                                .addComponent(documentValueLabel))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(firstNameLabel)
                                                                .addComponent(firstNameValueLabel)))
                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lastNameLabel)
                                                        .addComponent(lastNameValueLabel)))
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGap(22, 22, 22)
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(emailLabel)
                                                                .addComponent(emailValueLabel)))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(phoneLabel)
                                                                .addComponent(phoneValueLabel))))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                        .addComponent(returnButton)
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
        ViewController viewController = ViewController.getInstance();

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.goToMenu(InfoUserFrame.this);
            }
        });
    }

    private void loadInfo(String username) {
        ArrayList<String> fieldList = UserController.getInstance().loadInfoUser(username);
        documentValueLabel.setText(fieldList.get(0));
        firstNameValueLabel.setText(fieldList.get(1));
        lastNameValueLabel.setText(fieldList.get(2));
        emailValueLabel.setText(fieldList.get(3));
        phoneValueLabel.setText(fieldList.get(4));
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel documentLabel;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JButton returnButton;
    private JLabel documentValueLabel;
    private JLabel firstNameValueLabel;
    private JLabel phoneValueLabel;
    private JLabel lastNameValueLabel;
    private JLabel emailValueLabel;
}
