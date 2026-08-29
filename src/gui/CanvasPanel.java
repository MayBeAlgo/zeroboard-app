package gui;

import javax.swing.*;
import java.awt.*;

public class CanvasPanel extends JPanel{
    private Color brushColor = Color.BLACK;
    private int brushSize = 4;

    public CanvasPanel() {

        setBackground(Color.WHITE);

        setBorder(
                BorderFactory.createLineBorder(
                        new Color(60, 60, 60),
                        1
                )
        );
    }

    public void setBrushColor(Color color) {

        this.brushColor = color;
    }

    public Color getBrushColor() {

        return brushColor;
    }

    public void setBrushSize(int size) {

        this.brushSize = size;
    }

    public int getBrushSize() {

        return brushSize;
    }
}
