package vp.ajp.experiments.exp_09;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Prog01_JProgressBarOutput {
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);

    public static final int START = 0;
    public static final int STOP = 2000;
    public static final int STEP = 20;

    public static final long STEP_TIME = 150;

    private static boolean isFinished = false;

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        JProgressBar jb = new JProgressBar(START, STOP);
        jb.setStringPainted(true);
        jb.setValue(START);
        jb.setFont(FONT);
        contentPane.add(jb, new GridBagConstraints());

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isFinished = true;
            }
        });

        frame.setVisible(true);

        new Thread() {
            public void run() {
                while (!isFinished) {
                    try {
                        for (int i = START; i <= STOP; i += STEP) {
                            Thread.sleep(STEP_TIME);
                            jb.setValue(i);
                        }
                        Thread.sleep(10 * STEP_TIME);
                    } catch (InterruptedException interruptedException) {}
                }
            };
        }.start();
    }
}