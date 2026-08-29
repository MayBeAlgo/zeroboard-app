package client.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatPanel extends JPanel {
    public ChatPanel() {

        setPreferredSize(new Dimension(0, 130));

        setBackground(new Color(25, 25, 25));

        setBorder(
                new EmptyBorder(
                        8,
                        10,
                        8,
                        10
                )
        );

        setLayout(new BorderLayout(8, 8));
    }
}
