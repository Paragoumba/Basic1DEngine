package fr.paragoumba.b1de.example;

import fr.paragoumba.b1de.shapes.Line;
import fr.paragoumba.b1de.shapes.Point;

import javax.swing.*;
import java.awt.*;

public class Example {

    private static final int Y = 5;
    private static int frameWidth = 500;

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Basic1DEngine Example");
        Line line = new Line(new Point(0), new Point(30), Color.BLUE);
        Line line2 = new Line(new Point(300), new Point(350), Color.GREEN);
        Point point = new Point(31, Color.RED);
        Color background = Color.WHITE;
        JPanel panel = new JPanel(){

            @Override
            protected void paintComponent(Graphics g) {

                g.setColor(background);
                g.fillRect(0, 0, frameWidth, 50);

                line.draw(g, Y);
                line2.draw(g, Y);
                point.draw(g, Y);
                //System.out.println(point.x);

            }
        };

        frame.setContentPane(panel);
        frame.setPreferredSize(new Dimension(frameWidth, 50));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        line.point1.velocity = 1;
        line.point2.velocity = 1;
        line2.point1.velocity = -1;
        line2.point2.velocity = -1;

        while (true){

            frameWidth = frame.getWidth();

            if (line.point1.x < 0 || line.point1.x >= frameWidth - 15 || line.hit(line2)) line.point1.velocity *= -1;
            if (line.point2.x < 0 || line.point2.x >= frameWidth - 15 || line.hit(line2)) line.point2.velocity *= -1;
            if (line2.point1.x < 0 || line2.point1.x >= frameWidth - 15 || line.hit(line2)) line2.point1.velocity *= -1;
            if (line2.point2.x < 0 || line2.point2.x >= frameWidth - 15 || line.hit(line2)) line2.point2.velocity *= -1;

            line.move();
            line2.move();

            panel.repaint();
            Thread.sleep(17);

        }
    }
}
