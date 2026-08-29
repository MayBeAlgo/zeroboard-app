package gui;

import utility.Line;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ToolsPanel extends JPanel {
    private CanvasPanel canvas;
    public ToolsPanel(CanvasPanel canvas) {
        this.canvas = canvas;

        setPreferredSize(new Dimension(100, 0));

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
        // ---------------------------------------------------------
        // TITLE
        // ---------------------------------------------------------

        JLabel title = new JLabel("TOOLS");

        title.setForeground(Color.WHITE);
        title.setFont(
                new Font("SansSerif", Font.BOLD, 12)
        );

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(title);

        add(Box.createVerticalStrut(20));

        // ---------------------------------------------------------
        // COLOR
        // ---------------------------------------------------------

        JButton colorButton =
                createToolButton("Color");

        colorButton.addActionListener(e -> {

            Color selected =
                    JColorChooser.showDialog(
                            this,
                            "Choose Color",
                            canvas.getBrushColor()
                    );

            if (selected != null) {
                canvas.setBrushColor(selected);
            }
        });

        add(colorButton);

        add(Box.createVerticalStrut(10));

        // ---------------------------------------------------------
        // BRUSH SIZE
        // ---------------------------------------------------------

        JButton brushButton =
                createToolButton("Brush");

        brushButton.addActionListener(e -> {

            String value =
                    JOptionPane.showInputDialog(
                            this,
                            "Brush size:",
                            canvas.getBrushSize()
                    );

            if (value != null) {

                try {

                    int size = Integer.parseInt(value);

                    if (size > 0 && size <= 50) {

                        canvas.setBrushSize(size);
                    }

                } catch (NumberFormatException ignored) {
                }
            }
        });

        add(brushButton);

        add(Box.createVerticalStrut(10));

        // ---------------------------------------------------------
        // ERASER
        // ---------------------------------------------------------

        JButton eraserButton =
                createToolButton("Eraser");

        add(eraserButton);

        add(Box.createVerticalStrut(10));

        // ---------------------------------------------------------
        // CLEAR
        // ---------------------------------------------------------

        JButton clearButton =
                createToolButton("Clear");

        clearButton.addActionListener(e -> {

            int result =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Clear whiteboard?",
                            "Confirm",
                            JOptionPane.YES_NO_OPTION
                    );

            if (result == JOptionPane.YES_OPTION) {

                canvas.repaint();

                /*
                 * Later:
                 *
                 * networkClient.sendClear();
                 */
            }
        });

        add(clearButton);

        add(Box.createVerticalGlue());
    }

    private JButton createToolButton(String text) {

        JButton button = new JButton(text);

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        return button;
    }
    }

