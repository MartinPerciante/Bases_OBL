package utils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public final static String EMPTY_ITEM = " - ";

    private final static DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public final static Border blackBorder1 = BorderFactory.createLineBorder(Color.black, 1);

    private static Integer MAX_COLUMNS = 5;
    private static Integer MAX_ROWS = 6;

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return YYYYMMDDHHMMSS.format(localDateTime);
    }

    public static void populateTableWithIcon(JTable table, Icon icon) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.addRow(new String[]{"1"});
//        if(defaultTableModel.getDataVector().eleme)


        //int rowCount = defaultTableModel.getRowCount();

        // Si es la primera fila que s etiene que insertar
        //if (rowCount == 0) {
        //    defaultTableModel.addRow(new Icon[]{icon});
        //    table.setModel(defaultTableModel);
        //} else { // Si ya se ingreso al menos un dato

            /*boolean added = false;
            for (int i = 0; i < MAX_COLUMNS; i++){
                int j = rowCount - 1;
                var a = defaultTableModel.getValueAt(j, i);
                if (a == null){
                    defaultTableModel.setValueAt(new Icon[]{icon}, rowCount - 1, i);
                    added = true;
                }
             */
        //defaultTableModel = (DefaultTableModel) table.getModel();
        //var a = defaultTableModel.getValueAt(0, 0);
        //  System.out.println("LLegue aca");
        //}
        //Si no se agrego entonces es que estaba llena la fila
            /*if (!added){
                defaultTableModel.addRow(new Icon[]{icon});
                added = true;
            }
            String temp = added ? "Se agrego" : "No se agrego";
            System.out.println(temp);*/
    }
}

