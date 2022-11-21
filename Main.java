import controller.PublicationController;
import controller.ViewController;
import utils.Utils;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ViewController.getInstance().getLoginFrame();
        PublicationController.getInstance().updateStatusOffers();
        //Utils.cargarFigus();
    }
}
