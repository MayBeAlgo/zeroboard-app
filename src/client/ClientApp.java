package client;

import gui.WhiteboardGUI;

import javax.swing.*;

public class ClientApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            WhiteboardGUI whiteboard = new WhiteboardGUI();

            whiteboard.setVisible(true);
        });
    }
}
