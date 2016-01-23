package com.jrutil;

import sun.awt.ComponentFactory;

import javax.tools.Tool;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.peer.RobotPeer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AWTHelper {

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException ignored) {
            ;
        }
    }

    /**
     * Gets a screengrab of the screen.
     *
     * @param rectangle The {@link Rectangle} to capture, or null for the while screen.
     * @return A {@link BufferedImage} that contains the screengrab.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static BufferedImage screenGrab(Rectangle rectangle) throws AWTException {
        if (rectangle == null)
            rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        return robot.createScreenCapture(rectangle);
    }

    /**
     * Moves the cursor the the specified location on the screen.
     *
     * @param x The x location of the cursor
     * @param y The y location of the cursor
     * @throws AWTException
     */
    public static void moveCursor(int x, int y) throws AWTException {
        robot.mouseMove(x, y);
    }

    /**
     * Simulates a left mouse click at the specified location.
     *
     * @param x The x coordinate to click at.
     * @param y The y coordinate to click at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void LClick(int x, int y) throws AWTException {
        LPress(x, y);
        LRelease(x, y);
    }

    /**
     * Simulates a right mouse click at the specified location.
     *
     * @param x The x coordinate to click at.
     * @param y The y coordinate to click at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void RClick(int x, int y) throws AWTException {
        RPress(x, y);
        RRelease(x, y);
    }

    /**
     * Simulates a middle mouse button click at the specified location.
     *
     * @param x The x coordinate to click at.
     * @param y The y coordinate to click at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void MClick(int x, int y) throws AWTException {
        MPress(x, y);
        MRelease(x, y);
    }


    /**
     * Simulates a left mouse press at the specified location.
     *
     * @param x The x coordinate to press at.
     * @param y The y coordinate to press at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void LPress(int x, int y) throws AWTException {
        moveCursor(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }

    /**
     * Simulates a right mouse press at the specified location.
     *
     * @param x The x coordinate to press at.
     * @param y The y coordinate to press at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void RPress(int x, int y) throws AWTException {
        moveCursor(x, y);
        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
    }

    /**
     * Simulates a middle mouse button press at the specified location.
     *
     * @param x The x coordinate to press at.
     * @param y The y coordinate to press at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void MPress(int x, int y) throws AWTException {
        moveCursor(x, y);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
    }


    /**
     * Simulates a left mouse release at the specified location.
     *
     * @param x The x coordinate to release at.
     * @param y The y coordinate to release at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void LRelease(int x, int y) throws AWTException {
        moveCursor(x, y);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    /**
     * Simulates a right mouse release at the specified location.
     *
     * @param x The x coordinate to release at.
     * @param y The y coordinate to release at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void RRelease(int x, int y) throws AWTException {
        moveCursor(x, y);
        robot.mouseRelease(InputEvent.BUTTON2_MASK);
    }

    /**
     * Simulates a middle mouse button release at the specified location.
     *
     * @param x The x coordinate to release at.
     * @param y The y coordinate to release at.
     * @throws AWTException If an {@link AWTException} occurred. One example would be a {@link HeadlessException}
     */
    public static void MRelease(int x, int y) throws AWTException {
        moveCursor(x, y);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    /**
     * Presses a key press.
     *
     * @param keycode The keycode of the key. See the {@link KeyEvent} class for a list of key codes.
     */
    public static void keyPress(int keycode) {
        robot.keyPress(keycode);
    }

    /**
     * Presses a key release.
     *
     * @param keycode The keycode of the key. See the {@link KeyEvent} class for a list of key codes.
     */
    public static void keyRelease(int keycode) {
        robot.keyRelease(keycode);
    }
    /**
     * Presses a key type.
     *
     * @param keycode The keycode of the key. See the {@link KeyEvent} class for a list of key codes.
     */
    public static void keyType(int keycode) {
        keyPress(keycode);
        keyRelease(keycode);
    }

}
