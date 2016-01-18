package com.jrutil;

import java.awt.event.ActionListener;

/**
 * A class representing delayable code.
 */
public class DelayedCode extends Thread {

    ActionListener l;

    long d;

    public DelayedCode(ActionListener listener, long delay) {
        l = listener;
        d = delay;
        setDaemon(false);
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(d);
            l.actionPerformed(null);
        } catch (InterruptedException e) {
            // JS's clearTimeout called.
            return;
        }
    }

    /**
     * Delays running of code, just like JavaScript's window#setTimeout
     * @param listener The listener when it's time to run the code.
     * @param delay The amount of time to delay in milliseconds.
     * @return A stoppable thread, link JavaScript's window#clearTimeout
     */
    public static Thread delayCode(ActionListener listener, long delay) {
        return new DelayedCode(listener, delay);
    }

}
