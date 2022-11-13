package controller;

import frames.CreatePublicationFrame;

import javax.swing.*;
import java.awt.*;

public class PublicationController {

    private static PublicationController instance;

    public static PublicationController getInstance() {
        if(instance == null) {
            instance = new PublicationController();
        }
        return instance;
    }

    public void setCreatePublicationFrame(CreatePublicationFrame createPublicationFrame) {
        this.createPublicationFrame = createPublicationFrame;
    }

    private CreatePublicationFrame createPublicationFrame;

    public void setPublicationFiguritaImageSelected(ImageIcon imageSelected) {
        createPublicationFrame.getFiguritaImageLabel().setIcon(new ImageIcon(imageSelected.getImage().getScaledInstance(232, 312, Image.SCALE_DEFAULT)));
        createPublicationFrame.getFiguritaImageLabel().setText("");
        createPublicationFrame.setVisible(true);
//        createPublicationFrame.initComponents();
    }

}
