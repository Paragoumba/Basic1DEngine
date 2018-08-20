package fr.paragoumba.b1de.shapes;

import java.awt.*;

public class Line implements Object1D {

    public Line(Point point1, Point point2){

        this.point1 = point1;
        this.point2 = point2;

    }

    public Line(Point point1, Point point2, Color color){

        this.point1 = point1;
        this.point2 = point2;
        this.color = color;

    }

    public Point point1;
    public Point point2;
    public double velocity;
    public Color color = Color.BLACK;

    @Override
    public boolean hit(Object1D object1D) {
        
        if (object1D instanceof Point){

            Point point = (Point) object1D;

            return point2.x > 0 ? point.x >= point1.x && point.x <= point1.x + getLength() : point.x <= point1.x && point.x >= point1.x + getLength();
            
        } if (object1D instanceof Line){

            Line line = (Line) object1D;
            
            for (int i = point1.x; i <= point1.x + getLength(); ++i){

                if (i == line.point1.x || i == line.point1.x + line.getLength()) return true;

            }

            return false;

        }

        return false;

    }

    @Override
    public void draw(Graphics g, int y) {
        
        g.setColor(color);
        g.drawRect(point1.x, y, getLength(), 0);

    }

    @Override
    public void move() {

        point1.move();
        point2.move();

    }

    @Override
    public Color getColor() {

        return color;

    }

    public int getLength() {

        return (int) Math.round(Math.sqrt(Math.pow(point1.x - point2.x, 2)));

    }
}
