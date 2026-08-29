package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConnectionPanel extends JPanel{
    public ConnectionPanel() {

        setPreferredSize(new Dimension(220, 0));

        setBackground(new Color(35, 35, 35));

        setBorder(
                new EmptyBorder(
                        15,
                        15,
                        15,
                        15
                )
        );

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    }
