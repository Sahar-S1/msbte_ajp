package vp.ajp.experiments.exp_05;

import java.util.Arrays;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;

public class Prog01_ColorsMenu {
    public static final String[] COLORS = new String[] { "BLACK", "RED", "GREEN", "BLUE", "WHITE" };
    public static final String[] DISABLED_COLORS = new String[] { "BLACK" };

    public static void main(String args[]) {
        JFrame frame = new JFrame("Colors Menu");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        MenuBar menuBar = new MenuBar();
        frame.setMenuBar(menuBar);

        Menu menu = new Menu("Colors");
        menuBar.add(menu);

        MenuItem[] menuItems = new MenuItem[COLORS.length];
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i] = new MenuItem(COLORS[i]);
            if (Arrays.asList(DISABLED_COLORS).contains(COLORS[i])) {
                menuItems[i].setEnabled(false);
            }
            menu.add(menuItems[i]);
        }

        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);
    }
}