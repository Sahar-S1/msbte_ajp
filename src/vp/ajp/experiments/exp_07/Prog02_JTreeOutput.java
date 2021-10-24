package vp.ajp.experiments.exp_07;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;

public class Prog02_JTreeOutput {
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

    public static final RawTreeNode ROOT = new RawTreeNode("India")
            .attach(
                    new RawTreeNode("Maharashtra")
                            .attach("Mumbai")
                            .attach("Pune")
                            .attach("Nashik")
                            .attach("Nagpur"))
            .attach("Gujrath");

    public static void main(String args[]) {
        System.out.println(ROOT);

        JFrame frame = new JFrame();
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

        frame.setVisible(true);
    }
}