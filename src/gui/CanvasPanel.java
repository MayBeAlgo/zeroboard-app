package gui;

import model.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class CanvasPanel extends JPanel{

    private Line line;
    private Color brushColor = Color.BLACK;
    private int brushSize = 4;

    private int prevX,prevY;
    boolean drawing = false;

    java.util.List<Line> lines = new ArrayList<>();

    public CanvasPanel() {

        setBackground(Color.WHITE);

        setBorder(
                BorderFactory.createLineBorder(
                        new Color(60, 60, 60),
                        1
                )
        );


    //MAIN DRAWING LOGIC

    addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            prevX = e.getX();
            prevY = e.getY();
            drawing =  true;
        }
        @Override
        public void mouseReleased(MouseEvent e)
        {
            drawing = false;
        }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
             line = new Line();
            int currentX = e.getX();
            int currentY = e.getY();
            if(!drawing)
            {
                return;
            }
            line.setX1(prevX) ;
            line.setY1(prevY);
            line.setX2(currentX);
            line.setY2(currentY);
            line.setBrushColor(brushColor);
            line.setBrushSize(brushSize);
            lines.add(line);

            repaint();

            prevX = currentX;
            prevY = currentY;
        }

    });
}

public void clearCanvas()
{
    lines.clear();
}
public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;


    for(Line line : lines)
    {
        g2.setStroke(new BasicStroke(line.getBrushSize()));
        g2.setColor(line.getBrushColor());
        g2.drawLine(line.getX1(),line.getY1(),line.getX2(),line.getY2());
        System.out.println("x1 :"+line.getX1()+" y1 :"+line.getY1()+" x2 :"+line.getX2()+" y2 :"+line.getY2());
    }
}

   //Undo and redo option
    public void undoLastLine()
    {

    }

    public void redoLastLine()
    {

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
