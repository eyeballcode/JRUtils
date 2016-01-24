package com.jrutil.examples;


import com.jrutil.RepeatedCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.jrutil.DelayedCode.setTimeout;
import static com.jrutil.RepeatedCode.clearInterval;
import static com.jrutil.RepeatedCode.setInterval;

public class RepeatedCodeExample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RepeatedCodeExample");
        final JTextArea text = new JTextArea("Timestamps go below...\nA new timestamp will be printed every 1 second (1000ms)\n");
        final JScrollPane pane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        final JButton stop = new JButton("Stop thread");
        final RepeatedCode[] code = new RepeatedCode[1];
        setTimeout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code[0] = setInterval(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        text.append("Current timestamp: " + System.currentTimeMillis() + "\n");
                        pane.getVerticalScrollBar().setValue(text.getHeight());
                    }

                }, 1000);
            }
        }, 1000);

        frame.add(pane, BorderLayout.CENTER);
        frame.add(stop, BorderLayout.SOUTH);

        text.setEditable(false);

        pane.setPreferredSize(new Dimension(500, 100));

        frame.pack();
        frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - frame.getWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - frame.getHeight() / 2);
        frame.setVisible(true);

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInterval(code[0]);
            }
        });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
