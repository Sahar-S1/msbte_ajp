package vp.ajp.experiments.exp_06;

import java.awt.*;
import javax.swing.*;

public class Prog03_ScrollPane {
    public static class ScrollableTextArea extends JFrame {
        public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);

        ScrollableTextArea(String title) {
            super(title);

            Container contentPane = getContentPane();
            contentPane.setLayout(new FlowLayout());

            JLabel label = new JLabel("Enter Text: ");
            label.setFont(FONT);

            JTextArea textArea = new JTextArea(5, 15);
            textArea.setFont(FONT);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            contentPane.add(label);
            contentPane.add(scrollPane);
        }
    }

    public static void main(String[] args) {
        ScrollableTextArea sp = new ScrollableTextArea("ScrollPane Use");
        sp.setSize(500, 500);
        sp.setVisible(true);
        sp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
