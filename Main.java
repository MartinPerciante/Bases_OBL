import controller.PublicationController;
import controller.UserController;
import controller.ViewController;
import frames.CreatePublicationFrame;
import frames.LoginFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

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

        ViewController.getInstance().getLoginFrame();
    }
}
