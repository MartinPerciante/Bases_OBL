/*
 * Created by JFormDesigner on Thu Nov 10 18:39:10 UYT 2022
 */

package frames;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class MenuFrame extends JFrame {
    public MenuFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        createPublicationButton = new JButton();
        listPublicationsButton = new JButton();
        createUserButton = new JButton();
        myProfileButton = new JButton();

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

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(124, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(myProfileButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(createUserButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                .addComponent(listPublicationsButton)
                                .addComponent(createPublicationButton))
                            .addGap(122, 122, 122))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap(37, Short.MAX_VALUE)
                            .addComponent(createPublicationButton)
                            .addGap(18, 18, 18)
                            .addComponent(listPublicationsButton)
                            .addGap(18, 18, 18)
                            .addComponent(createUserButton)
                            .addGap(18, 18, 18)
                            .addComponent(myProfileButton)
                            .addGap(34, 34, 34))
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
    private JButton createPublicationButton;
    private JButton listPublicationsButton;
    private JButton createUserButton;
    private JButton myProfileButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
