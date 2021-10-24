package vp.ajp.experiments.exp_02;

import java.awt.List;
import java.awt.Font;

import javax.swing.JFrame;

public class Prog03_TenCities {
    public static final String[] CITIES = new String[] { "Mumbai", "New Delhi", "Bangalore", "Hyderabad", "Chennai",
            "Kolkata", "Pune", "Jaipur", "Thane", "Agra" };

    public static void main(String args[]) {
        JFrame frame = new JFrame("Cities");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List citiesList = new List(CITIES.length);
        citiesList.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        for (String city : CITIES) {
            citiesList.add(city);
        }

        frame.add(citiesList);

        frame.setVisible(true);
    }
}