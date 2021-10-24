package vp.ajp.experiments.exp_11;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/* <APPLET CODE ="vp.ajp.experiments.exp_11.Prog01_MouseDemo" WIDTH=300 HEIGHT=300> </APPLET> */
public class Prog01_MouseDemo extends Applet implements MouseListener {
    Label l;

    public void init() {
        setLayout(null);
        l = new Label("Hello Mouse");
        l.setBounds(50, 150, 200, 100);
        add(l);

        this.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e) {
        l.setText("Mouse Pressed no. of clicks:" + e.getClickCount() + "at position" + e.getX() + "," + e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        l.setText("Mouse Released; # of clicks:" + e.getClickCount());
    }

    public void mouseEntered(MouseEvent e) {
        l.setText("Mouse Entered");
    }

    public void mouseExited(MouseEvent e) {
        l.setText("Mouse exited");
    }

    public void mouseClicked(MouseEvent e) {
        l.setText("mouse clicked(# of clicks:" + e.getClickCount());
    }
}
