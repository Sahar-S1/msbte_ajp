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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Prog04_PasswordValidation {
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);

    public static final String PASSWORD_REGEX = ".{6,}";
    public static final String PASSWORD_ERROR = "Password length must be >6 characters";
    public static final String SUCCESSFUL_MESSAGE = "Successfully Logged In";

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

    public static JPasswordField getPasswordField(int columns) {
        JPasswordField passwordField = new JPasswordField(null, columns);
        passwordField.setFont(FONT);
        return passwordField;
    }

    public static JButton getButton(String text) {
        JButton button = new JButton(text);
        button.setFont(FONT);
        return button;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("User Authentication");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        JLabel titleLabel = getLabel("User Authentication");

        JLabel usernameLabel = getLabel("Username : ");
        JTextField usernameField = getTextField(20);

        JLabel passwordLabel = getLabel("Password : ");
        JPasswordField passwordField = getPasswordField(20);

        JButton loginButton = getButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordField.getText().matches(PASSWORD_REGEX)) {
                    JOptionPane.showMessageDialog(
                            frame,
                            SUCCESSFUL_MESSAGE,
                            "Login Passed",
                            JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            PASSWORD_ERROR,
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        int row = 0;
        contentPane.add(titleLabel, getGridBagConstraints(0, row, 2));
        row++;
        contentPane.add(usernameLabel, getGridBagConstraints(0, row, 1));
        contentPane.add(usernameField, getGridBagConstraints(1, row, 1));
        row++;
        contentPane.add(passwordLabel, getGridBagConstraints(0, row, 1));
        contentPane.add(passwordField, getGridBagConstraints(1, row, 1));
        row++;
        contentPane.add(loginButton, getGridBagConstraints(0, row, 2));

        frame.setVisible(true);
    }
}
