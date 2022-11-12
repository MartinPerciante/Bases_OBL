package controller;

import database.DBService;
import database.Queries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {


    public boolean isInfoLogOk(String username, String password){
        String condition = "ci = " + username + " " + "password = " + password;
        String query = Queries.findByColumn("Usuario", condition);

        ResultSet result = DBService.executeQuery(query);

        try {
                if (!result.next()) return false;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return true;
    }

}
