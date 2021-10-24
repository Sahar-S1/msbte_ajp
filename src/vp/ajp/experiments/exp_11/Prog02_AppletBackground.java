package vp.ajp.experiments.exp_11;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
    <applet
        code="vp.ajp.experiments.exp_11.Prog02_AppletBackground"
        width=500 height=500
    >
    </applet>
*/
public class Prog02_AppletBackground extends Applet {
    public static class BackgroundChangerMouseAdapter extends MouseAdapter {
        private final Component comp;
        private boolean mouseDown = false;

        public BackgroundChangerMouseAdapter(Component comp) {
            this.comp = comp;
        }

        public static float limit(float value, float min, float max) {
            return Math.min(Math.max(value, min), max);
        }

        public void setBackground(MouseEvent me) {
            int x = me.getXOnScreen();
            int y = me.getYOnScreen();

            float wProp = (float) x / this.comp.getWidth();
            float hProp = (float) y / this.comp.getHeight();

            float h = limit(wProp, 0, 1);
            float s = limit(hProp, 0, 1);
            float b = this.mouseDown ? 0.60f : 0.40f;

            Color color = Color.getHSBColor(h, s, b);

            this.comp.setBackground(color);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.mouseDown = true;
            this.setBackground(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            this.mouseDown = false;
            this.setBackground(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            this.setBackground(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            this.setBackground(e);
        }
    }

    @Override
    public void init() {
        MouseAdapter mouseAdapter = new BackgroundChangerMouseAdapter(this);
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);
        this.addMouseWheelListener(mouseAdapter);
    }
}
