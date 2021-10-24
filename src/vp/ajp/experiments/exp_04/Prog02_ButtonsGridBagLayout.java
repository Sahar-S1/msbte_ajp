package vp.ajp.experiments.exp_04;

import java.awt.Font;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;

public class Prog02_ButtonsGridBagLayout {
    public static String[][] BUTTONS_NAMES = new String[][] { //
            new String[] { "Button One", "Button two" }, //
            new String[] { "Button Three", "Button Four" }, //
            new String[] { "Button Five" }, //
    }; //

    public static void main(String[] args) {
        JFrame frame = new JFrame("Buttons Grid");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new GridBagLayout());

        float maxLength = 0;
        for (String[] buttonNamesRow : BUTTONS_NAMES) {
            if (buttonNamesRow.length >= maxLength) {
                maxLength = buttonNamesRow.length;
            }
        }

        for (int row = 0; row < BUTTONS_NAMES.length; row++) {
            for (int col = 0; col < BUTTONS_NAMES[row].length; col++) {
                Button button = new Button(BUTTONS_NAMES[row][col]);
                button.setFont(new Font("Times New Roman", Font.BOLD, 24));

                GridBagConstraints gc = new GridBagConstraints();
                gc.gridy = row;
                gc.gridx = col;
                gc.fill = GridBagConstraints.HORIZONTAL;
                gc.gridwidth = (int) (maxLength / BUTTONS_NAMES[row].length);

                frame.add(button, gc);
            }
        }

        frame.setVisible(true);
    }
}
