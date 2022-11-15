package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Utils {

    private void populateTableWithIcon(JTable table, Icon icon) {
        if (table.getRowCount() == 0) {//< 1) {
            DefaultTableModel defaultTableModel = new DefaultTableModel(new String[][]{}, new String[]{});
            defaultTableModel.addRow(new Icon[]{icon});
            table.setModel(defaultTableModel);
        } else if (table.getRowCount() == 1) {

        } else {

        }

    }
}
