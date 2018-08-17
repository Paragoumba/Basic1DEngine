package fr.paragoumba.b1de.shapes;

import java.awt.*;

public class Line implements Object1D {

    public Line(int x, int length){

        this.x = x;
        this.length = length;

    }

    public Line(int x, int length, Color color){

        this.x = x;
        this.length = length;
        this.color = color;

    }

    private int x;
    private int length;
    private Color color;

    @Override
    public boolean hit(Object1D object1D) {
        
        if (object1D instanceof Point){

            Point point = (Point) object1D;

            return length > 0 ? point.getX() >= x && point.getX() <= x + length : point.getX() <= x && point.getX() >= x + length;
            
        } if (object1D instanceof Line){

            Line line = (Line) object1D;
            
            for (int i = x; i <= x + length; ++i){

                if (i == line.x || i == line.x + line.length) return true;

            }

            return false;

        }

        return false;

    }

    @Override
    public void draw(Graphics g, int y) {
        
        g.setColor(color);
        g.drawRect(x, y, length, 0);

    }

    @Override
    public Color getColor() {

        return color;

    }

    public int getX() {

        return x;

    }

    public int getLength() {

        return length;

    }
}
