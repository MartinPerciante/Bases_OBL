package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.temporal.TemporalAccessor;

public class Utils {

    public static String EMPTY_ITEM = " - ";
    private static Integer MAX_COLUMNS = 5;
    private static Integer MAX_ROWS = 6;

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

