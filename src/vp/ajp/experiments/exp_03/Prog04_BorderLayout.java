package vp.ajp.experiments.exp_03;

import java.awt.Font;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Prog04_BorderLayout {
    static JFrame frame;

    public static Button addButtonToFrame(String label, Object constraints) {
        Button button = new Button(label);
        button.setFont(new Font("Times New Romal", Font.BOLD, 24));

        frame.add(button, constraints);

        return button;
    }

    public static void main(String args[]) {
        frame = new JFrame("Border Layout");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        addButtonToFrame("North", BorderLayout.NORTH);
        addButtonToFrame("South", BorderLayout.SOUTH);
        addButtonToFrame("West", BorderLayout.WEST);
        addButtonToFrame("East", BorderLayout.EAST);
        addButtonToFrame("Center", BorderLayout.CENTER).setPreferredSize(new Dimension(300, 300));

        frame.setVisible(true);
    }
}