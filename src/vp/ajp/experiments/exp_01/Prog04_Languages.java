package vp.ajp.experiments.exp_01;

import java.awt.Font;
import java.awt.Label;
import java.awt.Checkbox;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Prog04_Languages {
    public static final String LANGUAGES_SELECT_MESSAGE = "Select known languages: ";
    public static final String[] LANGUAGES = new String[] { "Marathi", "Hindi", "Sanskrit", "English", "Spanish" };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Languages");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Label languageSelectLabel = new Label(LANGUAGES_SELECT_MESSAGE);
        languageSelectLabel.setAlignment(Label.CENTER);
        languageSelectLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        frame.add(languageSelectLabel);

        Checkbox[] languagesCheckboxs = new Checkbox[LANGUAGES.length];
        for (int i = 0; i < LANGUAGES.length; i++) {
            languagesCheckboxs[i] = new Checkbox(LANGUAGES[i]);
            languagesCheckboxs[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            frame.add(languagesCheckboxs[i]);
        }

        frame.setVisible(true);
    }
}