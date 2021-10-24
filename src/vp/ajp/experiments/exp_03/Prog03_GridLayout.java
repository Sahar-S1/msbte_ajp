package vp.ajp.experiments.exp_03;

import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Prog03_GridLayout {
    public static final int GRID_ROWS = 3;
    public static final int GRID_COLS = 2;

    public static final int GRID_HGAP = 20;
    public static final int GRID_VGAP = 20;

    public static final int BUTTONS_COUNT = 5;
    public static final Color BUTTONS_COLOR = new Color(202, 218, 233);

    public static void main(String args[]) {
        JFrame frame = new JFrame("Grid Layout");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new GridLayout(GRID_ROWS, GRID_COLS, GRID_HGAP, GRID_VGAP));

        Button btns[] = new Button[BUTTONS_COUNT];
        for (int i = 0; i < btns.length; i++) {
            btns[i] = new Button("Button " + (i + 1));
            btns[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
            btns[i].setBackground(BUTTONS_COLOR);
            frame.add(btns[i]);
        }

        frame.setVisible(true);
    }
}