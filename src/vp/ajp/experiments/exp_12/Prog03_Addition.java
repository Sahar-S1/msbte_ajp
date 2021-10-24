package vp.ajp.experiments.exp_12;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Prog03_Addition {
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 18);

    public static GridBagConstraints getGridBagConstraints(int x, int y, int w) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = w;
        gridBagConstraints.insets = new Insets(4, 4, 4, 4);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        return gridBagConstraints;
    }

    public static JLabel getLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(FONT);
        return label;
    }

    public static JTextField getTextField(int columns) {
        JTextField textField = new JTextField(null, columns);
        textField.setFont(FONT);
        return textField;
    }

    public static JButton getButton(String text) {
        JButton button = new JButton(text);
        button.setFont(FONT);
        return button;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Addition");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        JLabel num1Label = getLabel("Num 1 : ");
        JTextField num1TextField = getTextField(20);

        JLabel num2Label = getLabel("Num 2 : ");
        JTextField num2TextField = getTextField(20);

        JLabel resLabel = getLabel("Result : ");
        JTextField resTextField = getTextField(20);
        resTextField.setEditable(false);

        JButton addButton = getButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1TextField.getText());
                    double num2 = Double.parseDouble(num2TextField.getText());
                    resTextField.setText(String.valueOf(num1 + num2));
                } catch (NumberFormatException numberFormatException) {
                    resTextField.setText(null);
                }
            }
        });

        int row = 0;
        contentPane.add(num1Label, getGridBagConstraints(0, row, 1));
        contentPane.add(num1TextField, getGridBagConstraints(1, row, 1));
        row++;
        contentPane.add(num2Label, getGridBagConstraints(0, row, 1));
        contentPane.add(num2TextField, getGridBagConstraints(1, row, 1));
        row++;
        contentPane.add(resLabel, getGridBagConstraints(0, row, 1));
        contentPane.add(resTextField, getGridBagConstraints(1, row, 1));
        row++;
        contentPane.add(addButton, getGridBagConstraints(0, row, 2));

        frame.setVisible(true);
    }
}
