package vp.ajp.experiments.exp_04;

import java.awt.Button;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class Prog03_FormGridBagLayout {
    public static final class Form extends JFrame {
        private int yCounter = 0;

        public Form() {
            super();
            this.setLayout(new GridBagLayout());
        }

        public void addRowToFrame(Map<Component, GridBagConstraints> components_constraints) {
            for (Map.Entry<Component, GridBagConstraints> component_constraint : components_constraints.entrySet()) {
                Component comp = component_constraint.getKey();
                GridBagConstraints gc = component_constraint.getValue();
                gc.gridy = yCounter;
                this.add(comp, gc);
            }
            this.yCounter++;
        }
    }

    public static Label getLabel(String text, Font font) {
        Label label = new Label(text);
        label.setFont(font);
        return label;
    }

    public static TextField getTextField(String text, int columns, Font font) {
        TextField textField = new TextField(text, columns);
        textField.setFont(font);
        return textField;
    }

    public static TextArea getTextArea(String text, int rows, int columns, Font font) {
        TextArea textArea = new TextArea(text, rows, columns);
        textArea.setFont(font);
        return textArea;
    }

    public static Button getButton(String label, Font font) {
        Button button = new Button(label);
        button.setFont(font);
        return button;
    }

    public static GridBagConstraints getGridBagConstrains(int x, int wx) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = x;
        gc.gridwidth = wx;
        gc.insets = new Insets(4, 4, 4, 4);
        return gc;
    }

    public static void main(String[] args) {
        Form form = new Form();
        form.setSize(600, 400);
        form.setTitle("GridBagLayout in Java Example");
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Font font = new Font("Times New Roman", Font.PLAIN, 20);

        Map<Component, GridBagConstraints> nameRow = new HashMap<Component, GridBagConstraints>();
        nameRow.put(getLabel("Name", font), getGridBagConstrains(0, 1));
        nameRow.put(getTextField(null, 20, font), getGridBagConstrains(1, 1));
        form.addRowToFrame(nameRow);

        Map<Component, GridBagConstraints> commentsRow = new HashMap<Component, GridBagConstraints>();
        commentsRow.put(getLabel("Comments", font), getGridBagConstrains(0, 1));
        commentsRow.put(getTextArea(null, 8, 25, font), getGridBagConstrains(1, 1));
        form.addRowToFrame(commentsRow);

        Map<Component, GridBagConstraints> submitRow = new HashMap<Component, GridBagConstraints>();
        submitRow.put(getButton("Submit", font), getGridBagConstrains(0, 2));
        form.addRowToFrame(submitRow);

        form.setVisible(true);
    }
}
