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

    private int x;
    private Color color;

    @Override
    public boolean hit(Object1D object1D) {

        if (object1D instanceof Point) return x == ((Point) object1D).x;
        return object1D.hit(this);

    }

    @Override
    public void draw(Graphics g, int y) {

        g.setColor(color);
        g.drawRect(x, y, 1, 1);

    }

    @Override
    public Color getColor() {

        return color;

    }

    int getX() {

        return x;

    }
}
