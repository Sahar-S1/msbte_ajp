package vp.ajp.experiments.exp_06;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog02_IndiaStates extends JFrame {
    public static final String STATES[] = {
            "Andhra Pradesh",
            "Arunachal Pradesh",
            "Assam",
            "Bihar",
            "Chhattisgarh",
            "Goa",
            "Gujarat",
            "Haryana",
            "Himachal Pradesh",
            "Jharkhand",
            "Karnataka",
            "Kerala",
            "Madhya Pradesh",
            "Maharashtra",
            "Manipur",
            "Meghalaya",
            "Mizoram",
            "Nagaland",
            "Odisha",
            "Punjab",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telangana",
            "Tripura",
            "Uttar Pradesh",
            "Uttarakhand",
            "West Bengal",
    };
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);

    public Prog02_IndiaStates() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        JComboBox<String> comboBox = new JComboBox<String>(STATES);
        comboBox.setFont(FONT);

        JLabel label = new JLabel("You are in ", JLabel.CENTER);
        label.setFont(FONT);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                label.setText("You are in " + comboBox.getSelectedItem());
            }
        });
        comboBox.getItemListeners()[0].itemStateChanged(null);

        contentPane.add(comboBox);
        contentPane.add(label);
    }

    public static void main(String[] args) {
        Prog02_IndiaStates frame = new Prog02_IndiaStates();
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
