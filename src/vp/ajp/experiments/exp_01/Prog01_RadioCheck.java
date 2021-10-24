package vp.ajp.experiments.exp_01;

import java.awt.Font;
import java.awt.Label;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.CheckboxGroup;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class Prog01_RadioCheck {
    static final String[] PROGRAMMING_LANGUAGES = new String[] { "Python", "PHP", "Javascript", "Java", "C++", "C" };

    static JFrame frame;

    public static JPanel wrapComponentsInsideJPanel(int align, Component... components) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(align));
        for (Component component : components) {
            panel.add(component);
        }
        return panel;
    }

    public static void main(String[] args) {
        frame = new JFrame("Radio Buttons and Checkboxes");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        Label surveyLabel = new Label("Programming Languages Survey");
        surveyLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        // Checkboxes
        Label familiarLanguagesLabel = new Label("Familiar Programming Languages: ");
        familiarLanguagesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));

        Checkbox[] languagesCheckboxes = new Checkbox[PROGRAMMING_LANGUAGES.length];
        for (int i = 0; i < languagesCheckboxes.length; i++) {
            languagesCheckboxes[i] = new Checkbox(PROGRAMMING_LANGUAGES[i]);
            languagesCheckboxes[i].setFont(new Font("Times New Roman", Font.ITALIC, 18));
        }

        // Radio Buttons
        Label favoriteLanguagesLabel = new Label("Favorite Programming Language: ");
        favoriteLanguagesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));

        CheckboxGroup languagesRadioButtonsGroup = new CheckboxGroup();
        Checkbox[] languagesRadioButtons = new Checkbox[PROGRAMMING_LANGUAGES.length];
        for (int i = 0; i < languagesRadioButtons.length; i++) {
            languagesRadioButtons[i] = new Checkbox(PROGRAMMING_LANGUAGES[i], languagesRadioButtonsGroup, false);
            languagesRadioButtons[i].setFont(new Font("Times New Roman", Font.ITALIC, 18));
        }

        Button submitButton = new Button("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

        frame.add(wrapComponentsInsideJPanel(FlowLayout.CENTER, surveyLabel));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.LEFT, familiarLanguagesLabel));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.CENTER, languagesCheckboxes));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.LEFT, favoriteLanguagesLabel));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.CENTER, languagesRadioButtons));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.RIGHT, submitButton));

        frame.setVisible(true);
    }
}
