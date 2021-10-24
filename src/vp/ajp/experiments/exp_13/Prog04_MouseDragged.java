package vp.ajp.experiments.exp_13;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog04_MouseDragged {
    public static final String URL = "https://www.oracle.com/a/tech/img/cb88-java-logo-001.jpg";

    public static class DragComponentMouseListner extends MouseAdapter {
        Component comp;

        public DragComponentMouseListner(Component comp) {
            this.comp = comp;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point point = new Point();
            point.x = e.getX() - comp.getWidth() / 2;
            point.y = e.getY() - comp.getHeight() / 2;
            comp.setLocation(point);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drag Image");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel image = null;
        try {
            frame.setLayout(new BorderLayout());
            image = new JLabel(new ImageIcon(new URL(URL)), JLabel.CENTER);
            frame.add(image, BorderLayout.CENTER);
            frame.addMouseMotionListener(new DragComponentMouseListner(image));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
}
