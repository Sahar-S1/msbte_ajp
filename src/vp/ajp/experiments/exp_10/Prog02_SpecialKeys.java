package vp.ajp.experiments.exp_10;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog02_SpecialKeys {
    public static final JFrame frame = new JFrame();

    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 22);

    public static JLabel addLabel(String pos) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(FONT);
        frame.add(label, pos);
        return label;
    }

    public static void main(String[] args) {
        frame.setTitle("Key Pressed Message");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        JLabel cLabel = addLabel(BorderLayout.CENTER);
        JLabel nLabel = addLabel(BorderLayout.NORTH);
        JLabel sLabel = addLabel(BorderLayout.SOUTH);
        JLabel wLabel = addLabel(BorderLayout.WEST);
        JLabel eLabel = addLabel(BorderLayout.EAST);

        frame.addKeyListener(new KeyAdapter() {
            public void displayText(int keyCode, String text) {
                if (KeyEvent.VK_F1 <= keyCode && keyCode <= KeyEvent.VK_F24)
                    cLabel.setText(text);
                if (keyCode == KeyEvent.VK_KP_UP || keyCode == KeyEvent.VK_UP)
                    nLabel.setText(text);
                if (keyCode == KeyEvent.VK_KP_DOWN || keyCode == KeyEvent.VK_DOWN)
                    sLabel.setText(text);
                if (keyCode == KeyEvent.VK_KP_LEFT || keyCode == KeyEvent.VK_LEFT)
                    wLabel.setText(text);
                if (keyCode == KeyEvent.VK_KP_RIGHT || keyCode == KeyEvent.VK_RIGHT)
                    eLabel.setText(text);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                String keyText = KeyEvent.getKeyText(keyCode);
                this.displayText(keyCode, keyText);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                this.displayText(keyCode, null);
            }
        });

        frame.setVisible(true);
    }
}
