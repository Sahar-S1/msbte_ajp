package vp.ajp.experiments.exp_10;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog01_KeyPressedMessage {
    public static final String DEFAULT_MESSAGE = "";
    public static final String KEY_PRESSED_MESSAGE = "Key Pressed";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Pressed Message");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel(DEFAULT_MESSAGE, JLabel.CENTER);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        frame.add(label);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.paramString());
                label.setText(KEY_PRESSED_MESSAGE);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText(DEFAULT_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
