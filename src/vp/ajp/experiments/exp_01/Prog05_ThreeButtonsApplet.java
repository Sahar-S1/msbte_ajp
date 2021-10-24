package vp.ajp.experiments.exp_01;

/*
<applet code="vp.ajp.experiments.exp_01.Prog05_ThreeButtonsApplet" width=400 height=400></applet>
*/
import java.applet.Applet;
import java.awt.Button;

public class Prog05_ThreeButtonsApplet extends Applet {
    public static final String[] CAPTIONS = new String[] { "OK", "RESET", "CANCEL" };

    Button[] buttons;

    public void init() {
        this.buttons = new Button[CAPTIONS.length];
        for (int i = 0; i < CAPTIONS.length; i++) {
            this.buttons[i] = new Button(CAPTIONS[i]);
            this.add(this.buttons[i]);
        }
    }
}