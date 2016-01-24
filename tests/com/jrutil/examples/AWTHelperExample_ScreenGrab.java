package com.jrutil.examples;

import com.jrutil.AWTHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import static com.jrutil.DelayedCode.setTimeout;

public class AWTHelperExample_ScreenGrab {

    public static void main(String[] args) throws AWTException {
        AWTHelper.setClipboardContents(null);
        final JFrame frame = new JFrame("Image Booth");
        final JLabel label = new JLabel("Waiting for grab call.");
        final JScrollPane pane = new JScrollPane(label, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton button = new JButton("Screen Grab!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                setTimeout(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            BufferedImage grab = AWTHelper.screenGrab(null);
                            label.setIcon(new ImageIcon(grab));
                            label.setText("");
                            pane.setPreferredSize(new Dimension(grab.getWidth() / 2, grab.getHeight() / 2));
                            frame.pack();
                            frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getWidth() / 2,
                                    Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getHeight() / 2);
                            frame.setVisible(true);
                            frame.repaint();
                        } catch (AWTException ignored) {
                        }
                    }
                }, 800);
            }
        });

        frame.add(pane, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getHeight() / 2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
