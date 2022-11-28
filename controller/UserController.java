package controller;

import database.DBService;
import entities.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {

    private static UserController instance;

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public boolean isInfoLogOk(String ci, String password) {
        ResultSet result = DBService.executeQuery("SELECT * FROM usuario WHERE ci = '" + ci + "' AND " + "password = '" + password.hashCode() + "'");

        int counter = 0;
        if (result != null) {
            while (true) {
                try {
                    if (!result.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (result.first()) {
                        String usernameDb = result.getString("ci");
                        String passwordDb = result.getString("password");
                        //Se ingresaron datos para inyeccion SQL
                        String hashedPw = String.valueOf(password.hashCode());
                        if (!(usernameDb.equals(ci) && passwordDb.equals(hashedPw))) {
                            counter = -1;
                            break;
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                counter++;
            }
            ;
        }

        return (counter > 0);
    }

    public boolean login(String ci, String password) {
        boolean result = isInfoLogOk(ci, password);
        if (result) Usuario.getInstance().setUsername(ci);
        return result;
    }


    public ArrayList<String> loadInfoUser(String ci) {
        ResultSet result = DBService.executeQuery("SELECT * FROM usuario WHERE ci = '" + ci + "'");
        if (result != null) {
            while (true) {
                try {
                    if (!result.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    if (result.first()) {
                        String ciDb = result.getString("ci");
                        String nombreDb = result.getString("nombre");
                        String apellidoDb = result.getString("apellido");
                        String telefonoDb = result.getString("telefono");
                        String emailDb = result.getString("email");

                        ArrayList<String> list = new ArrayList<>();
                        list.add(ciDb);
                        list.add(nombreDb);
                        list.add(apellidoDb);
                        list.add(emailDb);
                        list.add(telefonoDb);

                        return list;
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new ArrayList<>();
    }

    public void register(String ci, String username, String lastname, String telefono, String email, String password) {
        DBService.executeUpdate("INSERT INTO usuario (ci, nombre, apellido, telefono, email, password) " +
                "VALUES ('" + ci + "','" + username + "','" + lastname + "','" +
                telefono + "','" + email + "','" + password.hashCode() + "')");
    }

    public boolean changePassword(String ci, String oldPassword, String newPassword) {
        if (isInfoLogOk(ci, oldPassword)) {
            DBService.executeUpdate("UPDATE usuario SET password = '" + newPassword.hashCode() + "' WHERE ci = '" + ci + "' AND " + "password = '" + oldPassword.hashCode() + "'");
            return true;
        }
        return false;
    }

    public void updateInfo(String ci, String username, String lastname, String telefono, String email) {
        DBService.executeUpdate("UPDATE usuario SET nombre = '" + username + "', apellido = '" + lastname
                + "', telefono = '" + telefono + "', email = '" + email + "' WHERE ci = '" + ci + "'");
    }
}
