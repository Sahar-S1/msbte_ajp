package vp.ajp.experiments.exp_08;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Prog01_JTableUse {
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);
    public static final Object[] HEAD = {
            "Name", "Phone", "Fax"
    };
    public static final Object[][] DATA = {
            { "Gail", "4567", "8675" },
            { "Ken", "7566", "5555" },
            { "Viviane", "5634", "5887" },
            { "Melanie", "7345", "9222" },
            { "Anne", "1237", "3333" },
            { "John", "5656", "3144" },
    };

    public static void main(String args[]) {
        JFrame frame = new JFrame("JTable Use");
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