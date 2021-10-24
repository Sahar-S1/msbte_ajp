package vp.ajp.experiments.exp_01;

import java.awt.Font;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class Prog02_TFieldTAreaButtonLabel {
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
        frame = new JFrame("AWT Components");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        Label studentProfileLabel = new Label("Student Profile");
        studentProfileLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));

        Label studentNameLabel = new Label("Student Name: ");
        studentNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        TextField studentNameInput = new TextField("NAME", 25);
        studentNameInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        Label studentDescLabel = new Label("Student Description: ");
        studentDescLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        TextArea studentDescInput = new TextArea("DESCRIPTION", 15, 50);
        studentDescInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        Button submitButton = new Button("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

        frame.add(wrapComponentsInsideJPanel(FlowLayout.CENTER, studentProfileLabel));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.LEFT, studentNameLabel, studentNameInput));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.LEFT, studentDescLabel));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.CENTER, studentDescInput));
        frame.add(wrapComponentsInsideJPanel(FlowLayout.RIGHT, submitButton));

        frame.setVisible(true);
    }
}
