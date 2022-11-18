package frames;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.Border;
import java.awt.*;

public class PublicationPanel extends JPanel {
    public PublicationPanel(int x, int y, int width, int height) {
        setLayout(new GridLayout(1,0));
        setBackground(Color.white);
        setBounds(x, y, width, height);

        initComponents();
    }

    private void initComponents() {
        Border br = BorderFactory.createLineBorder(Color.black);

        setBorder(br);

        JLabel imagenfigurita = new JLabel(new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
        imagenfigurita.setBounds(10, 40, 232, 312);
        imagenfigurita.setBorder(br);
        add(imagenfigurita);

        JLabel labelOfferedFigurita = new JLabel("Figurita ofrecida");
        labelOfferedFigurita.setBounds(75, 10, 100, 25);
        add(labelOfferedFigurita);

        JLabel userLabel = new JLabel("51630541 - Lautaro Da Rosa");
        userLabel.setBounds(10, 362, 200, 25);
        add(userLabel);

        JLabel dateLabel = new JLabel("2022-11-05 22:22:22.000000");
        dateLabel.setBounds(10, 387, 200, 25);
        add(dateLabel);

        JLabel interestedFiguritasLabel = new JLabel("Figuritas interesadas");
        interestedFiguritasLabel.setBounds(425, 10, 150, 25);
        add(interestedFiguritasLabel);

        JButton jButton = new JButton("OFERTAR");
        jButton.setBounds(180,388,100,22);
        add(jButton);
        JTable jTable = new JTable(3, 3) {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        jTable.setValueAt(new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(132, 186, Image.SCALE_DEFAULT)), 0, 0);
        jTable.setValueAt(new ImageIcon(new ImageIcon("luis-suarez.png").getImage().getScaledInstance(132, 186, Image.SCALE_DEFAULT)), 1, 1);
        jTable.setValueAt(new ImageIcon(new ImageIcon("neymar-jr.png").getImage().getScaledInstance(132, 186, Image.SCALE_DEFAULT)), 2, 2);
        jTable.setBounds(300, 40, 396, 372);
        jTable.setBorder(br);
        jTable.setRowHeight(186);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        add(new JScrollPane(jTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS));
        add(jTable);
    }
}
