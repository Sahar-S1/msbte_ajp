package vp.ajp.experiments.exp_08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Prog02_JTableOutput {
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);
    public static final Object[] HEAD = {
            "ID", "NAME", "SALARY"
    };
    public static final Object[][] DATA = {
            { 101, "Amit", 670000 },
            { 102, "Jai", 780000 },
            { 101, "Sachin", 700000 },
    };

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JTable table = new JTable(DATA, HEAD);
        table.setFont(FONT);

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp = new JScrollPane(table, v, h);

        contentPane.add(jsp, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}