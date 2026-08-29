package host;

import gui.WhiteboardGUI;


public class HostApp {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            WhiteboardGUI gui = new WhiteboardGUI();
            gui.setVisible(true);
        });
    }
}