import controller.ViewController;
import controller.PublicationController;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ViewController.getInstance().getLoginFrame();
        PublicationController.getInstance().updateStatusOffers();
//        Utils.cargarFigus();
    }
}
