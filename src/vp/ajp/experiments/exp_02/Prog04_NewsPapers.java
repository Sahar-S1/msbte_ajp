package vp.ajp.experiments.exp_02;

import java.awt.List;
import java.awt.Font;

import javax.swing.JFrame;

public class Prog04_NewsPapers {
    public static final String[] NEWSPAPERS = new String[] { "TOI", "Midday", "Maharashtra Times" };

    public static void main(String args[]) {
        JFrame frame = new JFrame("News Papers");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List newspapersList = new List(NEWSPAPERS.length, true);
        newspapersList.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        for (String newspaperName : NEWSPAPERS) {
            newspapersList.add(newspaperName);
        }

        frame.add(newspapersList);

        frame.setVisible(true);
    }
}
