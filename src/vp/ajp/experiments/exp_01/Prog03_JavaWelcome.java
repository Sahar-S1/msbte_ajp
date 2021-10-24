package vp.ajp.experiments.exp_01;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;

public class Prog03_JavaWelcome {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Java Welcome");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Label javaWelcomeLabel = new Label("Welcome To Java!");
        javaWelcomeLabel.setAlignment(Label.CENTER);
        javaWelcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        frame.add(javaWelcomeLabel);

        frame.setVisible(true);
    }
}