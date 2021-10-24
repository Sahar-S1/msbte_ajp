package vp.ajp.experiments.exp_09;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Prog03_JProgressBarButton {
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);

    public static final int START = 0;
    public static final int STOP = 2000;
    public static final int STEP = 20;

    public static final long STEP_TIME = 150;

    private static boolean isRunning = false;
    private static boolean isFinished = false;

    public static GridBagConstraints getGridBagConstraints(int x, int y, int w) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = w;
        gridBagConstraints.insets = new Insets(4, 4, 4, 4);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        return gridBagConstraints;
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("JProgressBar Button");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        JProgressBar progressBar = new JProgressBar(START, STOP);
        progressBar.setStringPainted(true);
        progressBar.setValue(START);
        progressBar.setFont(FONT);
        contentPane.add(progressBar, getGridBagConstraints(0, 0, 3));

        JButton startButton = new JButton("Start");
        startButton.setFont(FONT);
        contentPane.add(startButton, getGridBagConstraints(0, 1, 1));

        JButton stopButton = new JButton("Stop");
        stopButton.setFont(FONT);
        contentPane.add(stopButton, getGridBagConstraints(1, 1, 1));

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(FONT);
        contentPane.add(resetButton, getGridBagConstraints(2, 1, 1));

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = true;
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = false;
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progressBar.setValue(START);
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                isFinished = true;
            }
        });

        new Thread() {
            public void run() {
                while (!isFinished) {
                    try {
                        if (isRunning) {
                            if (progressBar.getValue() < STOP) {
                                progressBar.setValue(progressBar.getValue() + STEP);
                            } else {
                                isRunning = false;
                            }
                        }
                        Thread.sleep(STEP_TIME);
                    } catch (InterruptedException interruptedException) {}
                }
            }
        }.start();

        frame.setVisible(true);
    }
}