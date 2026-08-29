package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ToolsPanel extends JPanel {
    public ToolsPanel() {
        setPreferredSize(new Dimension(90, 0));

        setBackground(new Color(35, 35, 35));

        setBorder(
                new EmptyBorder(
                        15,
                        10,
                        15,
                        10
                )
        );

        setLayout(
                new BoxLayout(
                        this,
                        BoxLayout.Y_AXIS
                )
        );
    }
    }

