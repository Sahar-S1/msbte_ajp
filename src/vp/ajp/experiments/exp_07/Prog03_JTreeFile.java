package vp.ajp.experiments.exp_07;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;

public class Prog03_JTreeFile {
    public static final File ROOT_FILE = new File("D:\\SoftwareDump\\Important\\Sahil\\VP\\Semester5\\AJP\\Practicals\\AJP\\src\\vp");

    public static DefaultMutableTreeNode fileToTreeNode(File file) {
        if (file.isFile()) {
            return new DefaultMutableTreeNode(file.getName(), false);
        } else {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName(), true);
            for (File child : file.listFiles()) {
                if (!child.isHidden())
                    node.add(fileToTreeNode(child));
            }
            return node;
        }
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("JTree System Directory");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JTree tree = new JTree(fileToTreeNode(ROOT_FILE), true);
        tree.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane treeScrollPane = new JScrollPane(tree, v, h);

        contentPane.add(treeScrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}