package vp.ajp.experiments.exp_02;

import java.awt.List;
import java.awt.Font;

import javax.swing.JFrame;

public class Prog01_Seasons {
    public static final String[] SEASONS = new String[] { "Summer", "Winter", "Rainy" };

    public static void main(String args[]) {
        JFrame frame = new JFrame("Seasons");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List seasonsList = new List(SEASONS.length, false);
        seasonsList.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        for (String seasonName : SEASONS) {
            seasonsList.add(seasonName);
        }

        frame.add(seasonsList);

        frame.setVisible(true);
    }
}
