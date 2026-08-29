package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class CanvasPanel extends JPanel{
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
    setBackground(Color.YELLOW);
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
            int currentX = e.getX();
            int currentY = e.getY();
            if(!drawing)
            {
                return;
            }

            lines.add(new Line(prevX,prevY,currentX,currentY));

            repaint();

            prevX = currentX;
            prevY = currentY;
        }

    });
}


public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    g2.setStroke(new BasicStroke(2));
    g2.setColor(Color.blue);

    for(Line line : lines)
    {
        g2.drawLine(line.x1,line.y1,line.x2,line.y2);
        System.out.println("x1 :"+line.x1+" y1 :"+line.y1+" x2 :"+line.x2+" y2 :"+line.y2);
    }
}

static class Line
{
    int x1,y1,x2,y2;
    Line(int x1,int y1,int x2,int y2)
    {
        this.x1= x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
    }
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
