package database;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class DBService {
    private static final String url = "jdbc:postgresql://192.168.56.4:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "ubuntu";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static ResultSet executeQuery(String query) {
        System.out.println(query);
        try (Connection conn = DBService.connect()) {
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return statement.executeQuery(query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static long executeUpdate(String query) {
        System.out.println(query);
        long id = 0;
        try (Connection conn = DBService.connect()) {
            Statement statement = conn.createStatement();
            int affectedRows = statement.executeUpdate(query);
            if (affectedRows > 0) {
                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public static void setImagen(ArrayList<Integer> numeros, ArrayList<String> paises, ArrayList<String> paths)throws SQLException {
        try{

            int cantMax = numeros.size();
            String query = "insert into figurita values (?, ?, ?)";
            for (int j = 0; j < cantMax - 1; j++){
                query += ", (?, ?, ?)";
            }

            ArrayList<FileInputStream> streams = new ArrayList<>();

            PreparedStatement p = connect().prepareStatement(query);
            for(int i = 0; i < cantMax; i++){
                String path = paths.get(i);
                String pais = paises.get(i);
                int numero = numeros.get(i);
                File f = new File(path);
                FileInputStream s = new FileInputStream(f);
                streams.add(s);

                p.setInt(1 + i * 3, numero);
                p.setString(2 + i * 3, pais);
                p.setBinaryStream(3 + i * 3, s, (int)f.length());
            }
            p.executeUpdate();
            for (FileInputStream stream : streams) {
                stream.close();
            }
            System.out.println("Se termino de ingresar las figuritas");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
