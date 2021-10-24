package vp.ajp.experiments.exp_13;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog03_AnonymousInnerClassUse {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Anonymous Inner Class");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Times New Roman", Font.BOLD, 30));

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(label, BorderLayout.CENTER);

        frame.addKeyListener(new KeyAdapter() {
            private TreeSet<Integer> keysPressed = new TreeSet<Integer>();

            private void updateLabel() {
                ArrayList<String> keys = new ArrayList<String>();
                for (Integer key : keysPressed) {
                    keys.add(KeyEvent.getKeyText(key));
                }
                label.setText(String.join("+", keys));
                keys.clear();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                keysPressed.add(e.getKeyCode());
                this.updateLabel();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keysPressed.remove(e.getKeyCode());
                this.updateLabel();
            }
        });

        frame.setVisible(true);
    }
}
