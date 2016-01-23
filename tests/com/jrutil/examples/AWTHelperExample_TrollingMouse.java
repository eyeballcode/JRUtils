package com.jrutil.examples;

import com.jrutil.AWTHelper;
import com.jrutil.RandomGen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.jrutil.RepeatedCode.setInterval;

public class AWTHelperExample_TrollingMouse {

    public static void main(String[] args) throws AWTException {
        JFrame f = new JFrame();
        f.setLocation(0, 0);
        f.setUndecorated(true);
        f.setPreferredSize(new Dimension(0, 0));
        f.setAlwaysOnTop(true);
        f.setOpacity(0f);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final int width = Toolkit.getDefaultToolkit().getScreenSize().width,
                height = Toolkit.getDefaultToolkit().getScreenSize().height;
        final int[] x = {width / 2};
        final int[] y = {height / 2};
        AWTHelper.moveCursor(x[0], y[0]);
        setInterval(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nX = RandomGen.randomInt(x[0] - 1, x[0] + 1);
                int nY = RandomGen.randomInt(y[0] - 1, y[0] + 1);
                try {
                    AWTHelper.moveCursor(x[0], y[0]);
                } catch (AWTException ignored) {
                }
                x[0] = nX;
                y[0] = nY;
            }
        }, 1);
    }

}
