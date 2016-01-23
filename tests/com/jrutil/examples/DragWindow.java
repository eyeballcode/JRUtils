package com.jrutil.examples;

import com.jrutil.AWTHelper;

import java.awt.*;

public class DragWindow {

    public static void main(String[] args) throws AWTException {
        AWTHelper.LPress(1000, 10);
        for (int i = 0; i < 100; i++) {
            AWTHelper.moveCursor(1000, 10 + i);
        }
        AWTHelper.LRelease();
    }

}
