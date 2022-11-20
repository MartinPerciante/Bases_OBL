import controller.ViewController;
import frames.PublicationPanel;
import frames.ShowPublicationsFrame;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
//        LoginFrame loginFrame = new LoginFrame();
//        loginFrame.setVisible(true);

//        pruebaimagen imagenframe = new pruebaimagen();
//        imagenframe.setVisible(true);

//        JFrame newFrame = new JFrame();
//        newFrame.setSize(500, 500);
//        newFrame.setVisible(true);
//        JLabel jLabel = new JLabel(new ImageIcon("lionel-messi.png"));
//        JLabel jLabel1 = new JLabel(new ImageIcon("luis-suarez.png"));
//        newFrame.getContentPane().add(jLabel);
//        newFrame.getContentPane().add(jLabel1);
//        newFrame.setVisible(true);


//        JFrame frame = new JFrame();
//        frame.setSize(500, 500);
//        JPanel panel = new JPanel();
//        for (int i = 0; i <= 5; i++) {
//            JLabel jLabel = new JLabel(new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
//            jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//            jLabel.setVerticalAlignment(SwingConstants.TOP);
//            panel.add(jLabel);
//        }
//        for (int i = 0; i <= 5; i++) {
//            JLabel jLabel = new JLabel(new ImageIcon(new ImageIcon("luis-suarez.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
//            jLabel.setHorizontalAlignment(SwingConstants.LEFT);
//            jLabel.setVerticalAlignment(SwingConstants.BOTTOM);
//            panel.add(jLabel);
//        }
//
//        JScrollPane jScrollPane = new JScrollPane(panel);
//        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//        frame.getContentPane().add(jScrollPane);
//        frame.setVisible(true);

//        JFrame f = new JFrame();
//
//        ImageIcon aboutIcon = new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
//        ImageIcon addIcon = new ImageIcon(new ImageIcon("luis-suarez.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
//        ImageIcon copyIcon = new ImageIcon(new ImageIcon("neymar-jr.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
//
//        String[] columnNames = { "", "", "", "", "" };
//        Object[][] data = { { aboutIcon, aboutIcon, aboutIcon, aboutIcon, aboutIcon }, { addIcon, addIcon, addIcon, addIcon, addIcon },
//                { copyIcon, copyIcon, copyIcon ,copyIcon ,copyIcon }, };
//
//        DefaultTableModel model = new DefaultTableModel(data, columnNames);
//        JTable table = new JTable(model) {
//            public Class getColumnClass(int column) {
//                return Icon.class;
//            }
//        };
//        table.setPreferredScrollableViewportSize(table.getPreferredSize());
//        table.setRowHeight(312);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        f.getContentPane().add(scrollPane);
//        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        f.pack();
//        f.setVisible(true);
//        f.setSize(500, 500);

//        CreatePublicationFrame createPublicationFrame = new CreatePublicationFrame();
//        createPublicationFrame.setSize(1366, 768);
//        createPublicationFrame.setVisible(true);
//        PublicationController.getInstance().setCreatePublicationFrame(createPublicationFrame);

//        ShowPublicationsFrame showPublicationsFrame = new ShowPublicationsFrame();
//
//        PublicationPanel publicationPanel = new PublicationPanel();
//        publicationPanel.setLayout(null);
//        publicationPanel.setBounds(100,100,300,200);
//        Border br = BorderFactory.createLineBorder(Color.black);
//        publicationPanel.setBorder(br);
//        showPublicationsFrame.getContentPane().add(publicationPanel);
//        showPublicationsFrame.setSize(1300, 700);
//        showPublicationsFrame.setVisible(true);
//
//        JTable jTable = new JTable(5, 5);
//        Utils.populateTableWithIcon(jTable, new ImageIcon("lionel-messi.png"));
//        Utils.populateTableWithIcon(jTable, new ImageIcon("lionel-messi.png"));
//        Utils.populateTableWithIcon(jTable, new ImageIcon("lionel-messi.png"));

        ViewController.getInstance().getLoginFrame();

//        JFrame jFrame = new JFrame();
//        jFrame.setLayout(new BorderLayout(1, 2));
//        //setting the bounds for the JFrame
//        jFrame.setBounds(0, 0, 1432, 730);
////        Border br = BorderFactory.createLineBorder(Color.black);
//        Container c = jFrame.getContentPane();
        //Creating a JPanel for the JFrame
//
//        PublicationPanel panel = new PublicationPanel(0, 0, 706, 422);
//        PublicationPanel panel1 = new PublicationPanel(716, 0, 706, 422);
//        JScrollPane jScrollPane = new JScrollPane(panel);
//        jScrollPane.setViewportView(panel);
//        jScrollPane.setVisible(true);
//        c.add(jScrollPane);
////        c.add(panel1);
//
//        jFrame.setVisible(true);
//        panel.setLayout(null);
//        panel.setBackground(Color.white);
//        panel.setBounds(0, 0, 706, 422);
//        panel.setBorder(br);
//
//        JLabel imagenfigurita = new JLabel(new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
//        imagenfigurita.setBounds(10, 40, 232, 312);
//        imagenfigurita.setBorder(br);
//        panel.add(imagenfigurita);
//
//        JLabel labelOfferedFigurita = new JLabel("Figurita ofrecida");
//        labelOfferedFigurita.setBounds(75, 10, 100, 25);
//        panel.add(labelOfferedFigurita);
//
//        JLabel userLabel = new JLabel("51630541 - Lautaro Da Rosa");
//        userLabel.setBounds(10, 362, 200, 25);
//        panel.add(userLabel);
//
//        JLabel dateLabel = new JLabel("2022-11-05 22:22:22.000000");
//        dateLabel.setBounds(10, 387, 200, 25);
//        panel.add(dateLabel);
//
//        JLabel interestedFiguritasLabel = new JLabel("Figuritas interesadas");
//        interestedFiguritasLabel.setBounds(425, 10, 150, 25);
//        panel.add(interestedFiguritasLabel);
//
//        JButton jButton = new JButton("OFERTAR");
//        jButton.setBounds(200,388,90,22);
//        panel.add(jButton);
//        JTable jTable = new JTable(3, 3) {
//            public Class getColumnClass(int column) {
//                return Icon.class;
//            }
//        };
//        jTable.setValueAt(new ImageIcon(new ImageIcon("lionel-messi.png").getImage().getScaledInstance(132, 186, Image.SCALE_DEFAULT)), 0, 0);
//        jTable.setValueAt(new ImageIcon(new ImageIcon("luis-suarez.png").getImage().getScaledInstance(132, 186, Image.SCALE_DEFAULT)), 1, 1);
//        jTable.setValueAt(new ImageIcon(new ImageIcon("neymar-jr.png").getImage().getScaledInstance(132, 186, Image.SCALE_DEFAULT)), 2, 2);
//        jTable.setBounds(300, 40, 396, 372);
//        jTable.setBorder(br);
//        jTable.setRowHeight(186);
//        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

//        JScrollPane scrollPane = new JScrollPane(jTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

//        scrollPane.setViewportView(jTable);
//        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        panel.add(new JScrollPane(jTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS));


//        JScrollPane scrollPane = new JScrollPane(jTable);
//        scrollPane.setVisible(true);
//        panel.add(scrollPane);
//        panel.add(jTable);







    }
}
