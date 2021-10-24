package vp.ajp.experiments.exp_03;

import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Prog02_NumberedButtons {
    public static final int BUTTONS_START_INDEX = 0;
    public static final int BUTTONS_END_INDEX = 9;

    public static final Color BUTTONS_COLOR = Color.GREEN;

    public static void main(String args[]) {
        JFrame frame = new JFrame("Numbered Buttons");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        Button btns[] = new Button[BUTTONS_END_INDEX - BUTTONS_START_INDEX + 1];
        for (int i = BUTTONS_START_INDEX; i <= BUTTONS_END_INDEX; i++) {
            btns[i] = new Button("Button " + i);
            btns[i].setFont(new Font("Times New Roman", Font.ITALIC, 18));
            btns[i].setPreferredSize(new Dimension(150, 50));
            btns[i].setBackground(BUTTONS_COLOR);
            frame.add(btns[i]);
        }

        frame.setVisible(true);
    }
}