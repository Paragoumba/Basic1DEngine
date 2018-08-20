package fr.paragoumba.b1de.shapes;

import java.awt.*;

/**
 * Created by Paragoumba on 05/11/2017.
 */

public class Point implements Object1D {

    public Point(int x){

        this.x = x;

    }

    public Point(int x, Color color){

        this.x = x;
        this.color = color;

    }

    public int x;
    public double velocity;
    public Color color = Color.BLACK;

    @Override
    public boolean hit(Object1D object1D) {

        if (object1D instanceof Point) return x == ((Point) object1D).x;
        return object1D.hit(this);

    }

    @Override
    public void draw(Graphics g, int y) {

        g.setColor(color);
        g.drawRect(x, y, 0, 0);

    }

    @Override
    public void move() {

        x += velocity;

    }

    @Override
    public Color getColor() {

        return color;

    }
}
