package com.jrutil.ui;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * A {@link javax.swing.JTextField} that allows you to get a {@link com.jrutil.ui.event.TypingEvent} when the user finishes typing in the text field.
 * <br><br>
 * Code example:
 * <p/>
 * <pre>
 *      JRTypingTextbox typingTextbox = new JRTypingTextbox();
 *      typingTextbox.addTypingFinishedListener(new TypingFinishedListener() {
 *           \@Override
 *           public void typingFinished(TypingEvent event) {
 *               // Prints the contents of the textbox to the console.
 *               System.out.println("User finished typing! Textbox contents: \"" + typingTextbox.getText() + "\"");
 *           }
 *       });
 * </pre>
 * <p/>
 * Note that this typing listener ignores {@linkplain KeyEvent#VK_CONTROL}, {@linkplain KeyEvent#VK_META}, {@linkplain KeyEvent#VK_ALT} and {@linkplain KeyEvent#VK_ESCAPE}.
 * <p/>
 * The constructors {@link #JRTypingTextbox()}, {@link #JRTypingTextbox(String)}, {@link #JRTypingTextbox(int)}, {@link #JRTypingTextbox(String, int)} and {@link #JRTypingTextbox(Document, String, int)}
 * are all the same as those in {@link JTextField}
 *
 * @see KeyUtil#isPrintableKey(KeyEvent)
 */
public class JRTypingTextbox extends JTextField {

    transient List<TypingFinishedListener> typingFinishedListeners = new LinkedList<>();

    public JRTypingTextbox() {
        this(null, null, 0);
    }

    public JRTypingTextbox(String text) {
        this(null, text, 0);
    }

    public JRTypingTextbox(int columns) {
        this(null, null, columns);
    }

    public JRTypingTextbox(String text, int columns) {
        this(null, text, columns);
    }

    public JRTypingTextbox(Document document, String text, int columns) {
        super(document, text, columns);
        addKeyListener(new KeyAdapter() {
            JRTypingTextboxThread thread = new JRTypingTextboxThread(typingFinishedListeners, typingFinishedTime);

            @Override
            public void keyReleased(KeyEvent e) {
                if (KeyUtil.isPrintableKey(e)) {
                    thread.interrupt();
                    thread = new JRTypingTextboxThread(typingFinishedListeners, typingFinishedTime);
                    thread.start();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyUtil.isPrintableKey(e)) {
                    thread.interrupt();
                    thread = new JRTypingTextboxThread(typingFinishedListeners, typingFinishedTime);
                }
            }
        });
    }

    int typingFinishedTime = 500;

    /**
     * Sets the timeout to trigger the {@link com.jrutil.ui.event.TypingEvent}.
     *
     * @param typingFinishedTime The timeout to trigger the event, in milliseconds
     */
    public void setTypingFinishedTime(int typingFinishedTime) {
        this.typingFinishedTime = typingFinishedTime;
    }

    /**
     * Gets the timeout to trigger the {@link com.jrutil.ui.event.TypingEvent}
     *
     * @return The timeout to trigger the event, in milliseconds. If {@link #setTypingFinishedTime(int)} was not called earlier, the value defaults to 500 milliseconds (Half a second)
     */
    public int getTypingFinishedTime() {
        return typingFinishedTime;
    }

    /**
     * Adds a {@link TypingFinishedListener} to run when user typing is complete.
     *
     * @param listener The {@link TypingFinishedListener} to attach.
     * @see TypingFinishedListener
     * @see com.jrutil.ui.event.TypingEvent
     * @see #removeTypingFinishedListner(TypingFinishedListener)
     * @see #getTypingFinishedListners()
     */
    public synchronized void addTypingFinishedListener(TypingFinishedListener listener) {
        if (listener == null) return;
        typingFinishedListeners.add(listener);
    }

    /**
     * Removes a {@link TypingFinishedListener} from the list of {@link TypingFinishedListener}s to run when user typing is complete.
     *
     * @param listener The {@link TypingFinishedListener} to remove.
     * @see TypingFinishedListener
     * @see com.jrutil.ui.event.TypingEvent
     * @see #addTypingFinishedListener(TypingFinishedListener)
     * @see #getTypingFinishedListners()
     */
    public synchronized void removeTypingFinishedListner(TypingFinishedListener listener) {
        if (listener == null) return;
        typingFinishedListeners.remove(listener);
    }

    /**
     *
     * Gets an array {@link TypingFinishedListener} that will be run when the user finishes typing.
     *
     * @return The array of {@link TypingFinishedListener}
     * @see TypingFinishedListener
     * @see com.jrutil.ui.event.TypingEvent
     * @see #addTypingFinishedListener(TypingFinishedListener)
     * @see #removeTypingFinishedListner(TypingFinishedListener)
     */
    public TypingFinishedListener[] getTypingFinishedListners() {
        return typingFinishedListeners.toArray(new TypingFinishedListener[typingFinishedListeners.size()]);
    }



}
