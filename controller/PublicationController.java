package controller;

import database.DBService;
import frames.CreatePublicationFrame;
import frames.PickFiguritaFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicationController {

    private static PublicationController instance;

    private CreatePublicationFrame createPublicationFrame;

    private PickFiguritaFrame pickFiguritaFrame;

    public static PublicationController getInstance() {
        if (instance == null) {
            instance = new PublicationController();
        }
        return instance;
    }

    public void setCreatePublicationFrame(CreatePublicationFrame createPublicationFrame) {
        this.createPublicationFrame = createPublicationFrame;
    }

    public void setPublicationFrameData() throws SQLException {
        ResultSet resultSet = DBService.executeQuery("SELECT estado FROM estado_figurita");
        while (resultSet.next()) {
            createPublicationFrame.getFiguritaStateComboBox().addItem(resultSet.getString("estado"));
        }
        JLabel label = createPublicationFrame.getFiguritaImageLabel();
        label.setText("Haga click para seleccionar una figurita");
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    pickFiguritaFrame = new PickFiguritaFrame();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                pickFiguritaFrame.setSize(500, 500);
                pickFiguritaFrame.setVisible(true);
            }
        });
        JTable table = createPublicationFrame.getInterestedFiguritasTable();
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setRowHeight(312);
        createPublicationFrame.getAddFiguritaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pickFiguritaFrame = new PickFiguritaFrame();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                pickFiguritaFrame.setSize(500, 500);
                pickFiguritaFrame.setVisible(true);
            }
        });
    }

    public void setPublicationOfferedFiguritaImageSelected(ImageIcon imageSelected) {
        createPublicationFrame.getFiguritaImageLabel().setIcon(new ImageIcon(imageSelected.getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
        createPublicationFrame.getFiguritaImageLabel().setText("");
        createPublicationFrame.setVisible(true);
    }

    public void setPickFiguritaFrameData() throws SQLException {
        ResultSet resultSet = DBService.executeQuery("SELECT pais FROM pais_figurita");
        while (resultSet.next()) {
            pickFiguritaFrame.getCountryComboBox().addItem(resultSet.getString("pais"));
        }
        //agregar num de figurita oficiales, no se si son 30, tambien podria ser una query a la tabla de figurita
        //que agarra los num sin repetir
        for (int i = 1; i <= 30; i++) {
            pickFiguritaFrame.getNumberComboBox().addItem(i);
        }
        JTable table = pickFiguritaFrame.getFiguritasTable();
        table.setTableHeader(null);
        table.setRowHeight(312);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                switch (eAddFiguritaOptions) {
//                    case ADD_OFFERED_FIGURITA_PUBLICATION: {
                PublicationController.getInstance().setPublicationOfferedFiguritaImageSelected((ImageIcon) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
//                        break;
//                    }
//                    case ADD_INTERESTED_FIGURITA_PUBLICATION: {
//                        PublicationController.getInstance().setPublicationFiguritaImageSelected((ImageIcon) figuritasTable.getValueAt(figuritasTable.getSelectedRow(), figuritasTable.getSelectedColumn()));
//                        break;
//                    }
//                }
                createPublicationFrame.setVisible(false);
            }
        });

        pickFiguritaFrame.getFilterButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    populateFilteredFiguritasTable();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        populateFilteredFiguritasTable();
    }

    DefaultTableModel defaultTableModelFiguritas;

    private void populateFilteredFiguritasTable() throws SQLException {
        ResultSet resultSet = DBService.executeQuery("SELECT foto FROM figurita WHERE pais = '" + pickFiguritaFrame.getCountryComboBox().getSelectedItem().toString() + "' AND numero = " + Integer.parseInt(pickFiguritaFrame.getNumberComboBox().getSelectedItem().toString()));
        if (resultSet != null) {
            defaultTableModelFiguritas = new DefaultTableModel(0, 5);
            int column = 0;
            Icon[] data = new Icon[5];
            while (resultSet.next()) {
                byte[] bytes = resultSet.getBytes("foto");
                if (bytes != null) {
                    ImageIcon icon = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT));
                    data[column] = icon;
                    column++;
                    if (column == 5) {
                        column = 0;
                        defaultTableModelFiguritas.addRow(data);
                        data = new Icon[]{};
                    }
                }
            }
            if (data[0] != null) {
                defaultTableModelFiguritas.addRow(data);
            }
            pickFiguritaFrame.getFiguritasTable().setModel(defaultTableModelFiguritas);
        }
    }
}
