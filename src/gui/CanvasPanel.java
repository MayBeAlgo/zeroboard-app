package gui;

import utility.Line;

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
            Line line = new Line();
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


//    static class Line
//{
//    int x1,y1,x2,y2;
//    Color brushColor;
//    int brushSize;
//
//    Line(int x1,int y1,int x2,int y2)
//    {
//        this.x1= x1;
//        this.x2=x2;
//        this.y1=y1;
//        this.y2=y2;
//    }
//
//    public void setBrushColor(Color brushColor)
//    {
//        this.brushColor = brushColor;
//    }
//
//    public void setBrushSize(int brushSize)
//    {
//        this.brushSize = brushSize;
//    }
//    public int getX1()
//    {
//        return x1;
//    }
//    public int getX2()
//    {
//        return x2;
//    }
//    public int getY1()
//    {
//        return y1;
//    }
//    public int getY2()
//    {
//        return y2;
//    }
//    public Color getBrushColor()
//    {
//        return brushColor;
//    }
//    public int getBrushSize()
//    {
//        return brushSize;
//    }
//}

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
