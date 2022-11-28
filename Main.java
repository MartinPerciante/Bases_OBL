import controller.ViewController;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ViewController.getInstance().getLoginFrame();
        //Utils.cargarFigus();
    }
}
