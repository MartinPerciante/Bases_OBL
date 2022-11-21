package utils;

import database.DBService;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public final static String EMPTY_ITEM = " - ";

    private final static DateTimeFormatter YYYYMMDDHHMMSS = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public final static Border blackBorder1 = BorderFactory.createLineBorder(Color.black, 1);

    private static Integer MAX_COLUMNS = 5;
    private static Integer MAX_ROWS = 6;

    public static String formatLocalDateTimeToString(LocalDateTime localDateTime) {
        return YYYYMMDDHHMMSS.format(localDateTime);
    }

    public static LocalDateTime formatStringToLocalDateTime(String date) {
        return LocalDateTime.parse(date);
    }

    public static boolean isTableEmpty(JTable table) {
        int columnCount = table.getColumnCount();
        int rowCount = table.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                try {
                    if (table.getValueAt(i, j) != null) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void cargarFigus() throws SQLException {
        String[] paises = {"QAT",
                "ECU",
                "SEN",
                "NED",
                "ENG",
                "IRN",
                "USA",
                "WAL",
                "ARG",
                "KSA",
                "MEX",
                "POL",
                "FRA",
                "AUS",
                "DEN",
                "TUN",
                "ESP",
                "CRC",
                "GER",
                "JPN",
                "BEL",
                "CAN",
                "MAR",
                "CRO",
                "BRA",
                "SRB",
                "SUI",
                "CMR",
                "POR",
                "GHA",
                "URU",
                "KOR",
                "FWC"};
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<String> paisesArray = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();

        for (String pais : paises) {
            int limite = pais.equals("FWC") ? 28 : 20;

            File dir = new File("Figuritas/" + pais);
            String[] figuritasList = dir.list();
            Map<Integer, String> map = new HashMap<Integer, String>();
            for (String figuritaNom : figuritasList) {
                ArrayList<String> array = new ArrayList<>(Arrays.stream(figuritaNom.split("-")).toList());
                //System.out.println("Estoy en " + figuritaNom);
                int numFigurita = Integer.parseInt(array.get(0));
                map.put(numFigurita, figuritaNom);
            }

            Connection connection = DBService.connect();
            for (int i = 1; i < limite; i++) {
                numeros.add(i);
                paisesArray.add(pais);
                String imagePath = dir + "/" + map.get(i);
                paths.add(imagePath);
            }

        }
        try {
            DBService.setImagen(numeros, paisesArray, paths);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

