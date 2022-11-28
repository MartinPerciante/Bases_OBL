package frames;

import controller.PublicationController;
import controller.ViewController;
import entities.Figurita;
import entities.Usuario;
import enums.EPickFigurita;
import utils.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CreatePublicationFrame extends JFrame {
    public CreatePublicationFrame() throws SQLException {
        initComponents();
        buttonActions();
        interestedFiguritasList = new ArrayList<>();
        setResizable(false);
        ResultSet resultSet = PublicationController.getInstance().getFiguritasState();
        while (resultSet.next()) {
            figuritaStateComboBox.addItem(resultSet.getString("estado"));
        }
    }

    Figurita figuritaPublicated;

    ArrayList<Figurita> interestedFiguritasList;

    public void setFiguritaImageSelected(Figurita figurita) {
        figuritaPublicated = figurita;
        figuritaImageLabel.setIcon(new ImageIcon(figurita.getFoto().getImage().getScaledInstance(232, 312, Image.SCALE_SMOOTH)));
        figuritaImageLabel.setText("");
        setVisible(true);
    }

    public void setFiguritaInterestedImageSelected(Figurita figurita) {
        interestedFiguritasList.add(figurita);
        int rows = interestedFiguritasTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) interestedFiguritasTable.getModel();
        if (rows == 0) {
            model.addRow(new ImageIcon[]{null, null, null});
            rows = 1;
        }
        boolean added = false;
        boolean isFull = false;
        for (int i = 0; i < 3 && !added; i++) {
            Object exists = model.getValueAt(rows - 1, i);
            if (exists == null) {
                model.setValueAt(figurita.getFoto(), rows - 1, i);
                added = true;
                isFull = (i == 2);
                break;
            }
        }
        if (!added) {
            model.addRow(new ImageIcon[]{figurita.getFoto(), null, null});
        }
        if (isFull) {
            model.addRow(new ImageIcon[]{null, null, null});
        }

        setVisible(true);
    }

    private void buttonActions() {
        ViewController viewController = ViewController.getInstance();
        figuritaImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PublicationController.getInstance().goToPickFigurita(CreatePublicationFrame.this, EPickFigurita.CREATE_PUBLICATION_OFFERED_FIGURITA);

            }
        });

        addFiguritaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PublicationController.getInstance().goToPickFigurita(CreatePublicationFrame.this, EPickFigurita.CREATE_PUBLICATION_INTERESTED_FIGURITAS);
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (figuritaImageLabel.getIcon() != null) {
                    String actualDate = Utils.formatLocalDateTimeToString(LocalDateTime.now());
                    PublicationController.getInstance().createPublication(documentValueLabel.getText(), actualDate, figuritaPublicated.getNumero(), figuritaPublicated.getPais(), figuritaStateComboBox.getSelectedItem().toString());
                    if (interestedFiguritasTable.getRowCount() > 0) {
                        StringBuilder stringBuilderQuery = new StringBuilder();
                        stringBuilderQuery.append("INSERT INTO publicacion_tiene_interesada_figurita VALUES ");
                        for (Figurita figurita : interestedFiguritasList) {
                            stringBuilderQuery.append("('" + documentValueLabel.getText() + "', ");
                            stringBuilderQuery.append(figurita.getNumero() + ", '");
                            stringBuilderQuery.append(figurita.getPais() + "', '");
                            stringBuilderQuery.append(actualDate + "'),");
                        }
                        String query = stringBuilderQuery.toString();
                        PublicationController.getInstance().insertPublicationInterestedFiguritas(query.substring(0, query.length() - 1));
                    }
                    viewController.goToMenu(CreatePublicationFrame.this);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController.goToMenu(CreatePublicationFrame.this);
            }
        });

        deleteFiguritaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon iconSelected = (Icon) interestedFiguritasTable.getValueAt(interestedFiguritasTable.getSelectedRow(), interestedFiguritasTable.getSelectedColumn());
                if (iconSelected != null) {
                    interestedFiguritasTable.setValueAt(null, interestedFiguritasTable.getSelectedRow(), interestedFiguritasTable.getSelectedColumn());
                }
            }
        });
    }

    public void initComponents() {
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        documentLabel = new JLabel();
        offeredFiguritaLabel = new JLabel();
        interestedFiguritasLabel = new JLabel();
        figuritaImageLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        interestedFiguritasTable = new JTable(0, 3) {
            public Class getColumnClass(int column) {
                return Icon.class;
            }
        };
        figuritaImageLabel.setText("Haga click para seleccionar una figurita");
        interestedFiguritasTable.setPreferredScrollableViewportSize(interestedFiguritasTable.getPreferredSize());
        interestedFiguritasTable.setRowHeight(312);
        interestedFiguritasTable.setTableHeader(null);
        interestedFiguritasTable.setBorder(Utils.blackBorder1);
        figuritasStateLabel = new JLabel();
        documentValueLabel = new JLabel();
        documentValueLabel.setText(Usuario.getInstance().getUsername());
        figuritaStateComboBox = new JComboBox();
        cancelButton = new JButton();
        createButton = new JButton();
        addFiguritaButton = new JButton();
        deleteFiguritaButton = new JButton();

        setTitle("CREAR PUBLICACI\u00d3N");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            {

                documentLabel.setText("Documento del usuario:");

                offeredFiguritaLabel.setText("Figurita ofrecida");

                interestedFiguritasLabel.setText("Figuritas interesadas");

                {
                    scrollPane1.setViewportView(interestedFiguritasTable);
                }

                figuritasStateLabel.setText("Estado:");

                cancelButton.setText("CANCELAR");

                createButton.setText("CREAR");

                addFiguritaButton.setText("AGREGAR");

                deleteFiguritaButton.setText("ELIMINAR");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addComponent(figuritaImageLabel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                                        .addComponent(figuritasStateLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(figuritaStateComboBox, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(offeredFiguritaLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(documentLabel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(documentValueLabel, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                                        .addComponent(addFiguritaButton)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(deleteFiguritaButton)
                                                                        .addGap(87, 87, 87)
                                                                        .addComponent(interestedFiguritasLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 681, Short.MAX_VALUE)
                                                        .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap(9, Short.MAX_VALUE)
                                                        .addComponent(documentLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addContainerGap(9, Short.MAX_VALUE)
                                                        .addComponent(documentValueLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(offeredFiguritaLabel)
                                                .addComponent(addFiguritaButton)
                                                .addComponent(interestedFiguritasLabel)
                                                .addComponent(deleteFiguritaButton))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addGroup(contentPanelLayout.createSequentialGroup()
                                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(figuritasStateLabel)
                                                                .addComponent(figuritaStateComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(figuritaImageLabel, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 547, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(cancelButton)
                                                .addComponent(createButton))
                                        .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel documentLabel;
    private JLabel offeredFiguritaLabel;
    private JLabel interestedFiguritasLabel;
    private JLabel figuritaImageLabel;
    private JScrollPane scrollPane1;
    private JTable interestedFiguritasTable;
    private JLabel figuritasStateLabel;
    private JLabel documentValueLabel;
    private JComboBox figuritaStateComboBox;
    private JButton cancelButton;
    private JButton createButton;
    private JButton addFiguritaButton;
    private JButton deleteFiguritaButton;
}
