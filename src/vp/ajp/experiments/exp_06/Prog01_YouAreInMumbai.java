package vp.ajp.experiments.exp_06;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prog01_YouAreInMumbai extends JFrame {
    public static final String CITIES[] = { "Solapur", "Pune", "Banglore", "Mumbai" };
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);

    public Prog01_YouAreInMumbai() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        JComboBox<String> comboBox = new JComboBox<String>(CITIES);
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
        Prog01_YouAreInMumbai frame = new Prog01_YouAreInMumbai();
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
