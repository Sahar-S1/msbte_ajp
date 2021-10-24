package vp.ajp.experiments.exp_11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog04_MouseMotion {
    public static final Font FONT = new Font("Times New Roman", Font.BOLD, 22);

    public static final String MESSAGE_FORMAT = "MousePoint: (%d, %d)";
    public static final Color PAINT_BRUSH_COLOR = Color.BLUE;
    public static final int PAINT_BRUSH_SIZE = 20;

    public static void main(String args[]) {
        JFrame frame = new JFrame("Mouse Motion Listner");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel label = new JLabel(MESSAGE_FORMAT, JLabel.CENTER);
        label.setFont(FONT);
        contentPane.add(label, BorderLayout.NORTH);

        frame.setVisible(true);

        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                label.setText(String.format(MESSAGE_FORMAT, e.getX(), e.getY()));

                Graphics graphics = frame.getGraphics();
                if (graphics != null) {
                    Color lastColor = graphics.getColor();
                    graphics.setColor(PAINT_BRUSH_COLOR);
                    graphics.fillOval(e.getX(), e.getY(), PAINT_BRUSH_SIZE, PAINT_BRUSH_SIZE);
                    graphics.setColor(lastColor);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                label.setText(String.format(MESSAGE_FORMAT, e.getX(), e.getY()));
            }
        });
    }
}