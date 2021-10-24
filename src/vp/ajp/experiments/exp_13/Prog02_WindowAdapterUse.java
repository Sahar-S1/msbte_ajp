package vp.ajp.experiments.exp_13;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Prog02_WindowAdapterUse {
    public static void main(String[] args) {
        JFrame frame = new JFrame("WindowAdapter Use");
        frame.setSize(400, 400);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void log(String message) {
                System.out.println("[" + "WindowAdapterLog" + "]" + " " + message);
            }

            @Override
            public void windowActivated(WindowEvent e) {
                this.log("Activated");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                this.log("Closed");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                this.log("Closing");

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (confirm == 0) {
                    this.log("Pressed YES");
                    frame.dispose();
                } else if (confirm == 1) {
                    this.log("Pressed NO");
                } else {
                    this.log("Pressed CANCEL");
                }
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                this.log("Deactivated");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                this.log("Deiconified");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                this.log("Iconified");
            }

            @Override
            public void windowOpened(WindowEvent e) {
                this.log("Opened");
            }
        });

        frame.setVisible(true);
    }
}
