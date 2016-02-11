package com.jrutil.examples;

import com.jrutil.ui.JRTypingTextbox;
import com.jrutil.ui.TypingListener;
import com.jrutil.ui.event.TypingEvent;

import javax.swing.*;
import java.awt.*;

/**
 * An example to show off the {@link JRTypingTextbox} class.
 *
 * @see JRTypingTextbox
 */
public class JRTypingTextboxExample {

    public static void main(String[] args) {
        final JRTypingTextbox typingTextbox = new JRTypingTextbox();
        typingTextbox.addTypingListener(new TypingListener() {
            @Override
            public void typingFinished(TypingEvent event) {
                System.out.println(typingTextbox.getText());
            }

            @Override
            public void typingStarted(TypingEvent event) {
                // TODO NYI
                System.out.println("Typing start");
            }
        });
        typingTextbox.setPreferredSize(new Dimension(100, 30));
        JFrame f = new JFrame();
        f.add(typingTextbox);
        f.pack();
        f.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - f.getWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - f.getHeight() / 2);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
