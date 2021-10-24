package vp.ajp.experiments.exp_11;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog03_MouseClicksCount {
    public static final Font FONT = new Font("Times New Roman", Font.BOLD, 22);

    public static final String MESSAGE_FORMAT = "Mouse Clicked #%d Times";

    public static void main(String args[]) {
        JFrame frame = new JFrame("Mouse Clicks Count");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel(String.format(MESSAGE_FORMAT, 0), JLabel.CENTER);
        label.setFont(FONT);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(label, BorderLayout.CENTER);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText(String.format(MESSAGE_FORMAT, e.getClickCount()));
            }
        });

        frame.setVisible(true);
    }
}
