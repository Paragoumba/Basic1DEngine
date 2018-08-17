package fr.paragoumba.b1de.example;

import fr.paragoumba.b1de.shapes.Line;

import javax.swing.*;
import java.awt.*;

public class Example {

    private static final int Y = 5;

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Basic1DEngine Example");
        Line line = new Line(0, 30, Color.BLUE);
        Line line2 = new Line(30, 20, Color.GREEN);
        JPanel panel = new JPanel(){

            @Override
            protected void paintComponent(Graphics g) {

                line.draw(g, Y);
                line2.draw(g, Y);
                System.out.println(line.hit(line2));

            }
        };

        frame.setContentPane(panel);
        frame.setPreferredSize(new Dimension(500, 50));
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        while (true){

            panel.repaint();
            Thread.sleep(17);

        }
    }
}
