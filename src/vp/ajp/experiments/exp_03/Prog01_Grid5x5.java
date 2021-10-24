package vp.ajp.experiments.exp_03;

import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Prog01_Grid5x5 {
    public static final int GRID_SIZE = 5;
    public static final int GRID_GAP = 20;

    public static final int BUTTONS_COUNT = 25;
    public static final Color BUTTONS_COLOR = Color.ORANGE;

    public static void main(String args[]) {
        JFrame frame = new JFrame("5x5 Grid");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE, GRID_GAP, GRID_GAP));

        Button btns[] = new Button[BUTTONS_COUNT];
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new Button("Button " + (i + 1));
            btns[i].setFont(new Font("Times New Roman", Font.PLAIN, 12));
            btns[i].setBackground(BUTTONS_COLOR);
            frame.add(btns[i]);
        }

        frame.setVisible(true);
    }
}