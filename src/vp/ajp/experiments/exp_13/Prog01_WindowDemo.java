package vp.ajp.experiments.exp_13;

import java.awt.*;
import java.awt.event.*;

public class Prog01_WindowDemo {
    Frame f;

    Prog01_WindowDemo() {
        f = new Frame("Window Adapter");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Prog01_WindowDemo();
    }
}