package vp.ajp.experiments.exp_07;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class Prog01_JTreeUse {
    public static class RawTreeNode {
        private Object value;
        private RawTreeNode parent;
        private List<RawTreeNode> children;

        public RawTreeNode(Object value) {
            this.value = value;
            this.parent = null;
            this.children = new ArrayList<RawTreeNode>();
        }

        public RawTreeNode attach(RawTreeNode child) {
            child.parent = this;
            this.children.add(child);
            return this;
        }

        public RawTreeNode attach(Object child) {
            return this.attach(new RawTreeNode(child));
        }

        public DefaultMutableTreeNode toDefaultMutableTreeNode() {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(this.value);
            for (RawTreeNode child : this.children) {
                node.add(child.toDefaultMutableTreeNode());
            }
            return node;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"parent\":" + (this.parent == null ? "null" : "\"" + this.parent.value + "\"") +
                    "," +
                    "\"value\": " + "\"" + this.value + "\"" +
                    "," +
                    "\"children\": " + this.children +
                    "}";
        }
    }

    public static final RawTreeNode ROOT = new RawTreeNode("Options")
            .attach(
                    new RawTreeNode("A")
                            .attach("A1")
                            .attach("A2"))
            .attach(
                    new RawTreeNode("B")
                            .attach("B1")
                            .attach(
                                    new RawTreeNode("B2")
                                            .attach("B21")
                                            .attach("B22"))
                            .attach("B3"));

    public static void main(String args[]) {
        System.out.println(ROOT);

        JFrame frame = new JFrame("JTree Use");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JTree tree = new JTree(ROOT.toDefaultMutableTreeNode());
        tree.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane treeScrollPane = new JScrollPane(tree, v, h);

        contentPane.add(treeScrollPane, BorderLayout.CENTER);

        JTextField jtf = new JTextField("", 20);
        jtf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contentPane.add(jtf, BorderLayout.SOUTH);

        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
                if (tp == null)
                    jtf.setText("null");
                else
                    jtf.setText(tp.toString());
            }
        });

        frame.setVisible(true);
    }
}