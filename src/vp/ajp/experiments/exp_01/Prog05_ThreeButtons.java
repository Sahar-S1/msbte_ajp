package vp.ajp.experiments.exp_01;

import java.awt.Font;
import java.awt.Button;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class Prog05_ThreeButtons {
    public static final String[] CAPTIONS = new String[] { "OK", "RESET", "CANCEL" };

    public static void main(String args[]) {
        JFrame frame = new JFrame("Three Buttons");
        frame.setSize(400, 400);
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Button[] buttons = new Button[CAPTIONS.length];
        for (int i = 0; i < CAPTIONS.length; i++) {
            buttons[i] = new Button(CAPTIONS[i]);
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 24));
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }
}