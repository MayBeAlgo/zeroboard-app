import client.gui.WhiteboardGUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            WhiteboardGUI gui = new WhiteboardGUI();
            gui.setVisible(true);
        });
    }
}