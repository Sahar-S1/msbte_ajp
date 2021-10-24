package vp.ajp.experiments.exp_02;

import java.awt.List;
import java.awt.Font;
import java.awt.Label;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Prog02_Subjects {
    public static final String[] SUBJECTS = new String[] { "Maths", "Physics", "Java", "C++", "Operating System",
            "Microprocessors", "Chemistry" };
    public static final String SELECT_SUBJECT_MESSAGE = "Select Subjects You Like";

    public static void main(String args[]) {
        JFrame frame = new JFrame("Subjects");
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        List subjectsList = new List(SUBJECTS.length, true);
        subjectsList.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        for (String subjectName : SUBJECTS) {
            subjectsList.add(subjectName);
        }
        frame.add(subjectsList);

        Label selectSubjectLabel = new Label(SELECT_SUBJECT_MESSAGE);
        selectSubjectLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        frame.add(selectSubjectLabel);

        frame.setVisible(true);
    }
}
