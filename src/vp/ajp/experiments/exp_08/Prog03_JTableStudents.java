package vp.ajp.experiments.exp_08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Prog03_JTableStudents {
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);
    public static final Object[] HEAD = {
            "Name", "Percentage", "Grade"
    };
    public static final Object[][] DATA = new Object[][] {
            { "Gail", "90%", "A" },
            { "Ken", "85%", "B+" },
            { "Viviane", "87%", "B" },
            { "Melanie", "65%", "C" },
            { "Anne", "92%", "A" },
            { "John", "93%", "A" },
            { "Anand", "55%", "D" },
            { "Hector", "91%", "A" },
            { "Carlitos", "69%", "C+" },
            { "Bill", "99%", "A+" },
    };

    public static void main(String args[]) {
        JFrame frame = new JFrame("JTable Students");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JTable table = new JTable(DATA, HEAD);
        table.setFont(FONT);

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);

        contentPane.add(jsp, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}