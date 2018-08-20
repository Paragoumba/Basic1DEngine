package fr.paragoumba.b1de.shapes;

import java.awt.*;

public interface Object1D {

    boolean hit(Object1D object1D);

    void draw(Graphics g, int y);

    void move();

    Color getColor();

}
