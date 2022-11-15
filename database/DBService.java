package database;

import java.sql.*;

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
}