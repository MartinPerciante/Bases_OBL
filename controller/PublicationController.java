package controller;

public class PublicationController {

    private static PublicationController instance;

    public static PublicationController getInstance() {
        if(instance == null) {
            instance = new PublicationController();
        }
        return instance;
    }
}
