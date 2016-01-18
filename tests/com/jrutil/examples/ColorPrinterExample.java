package com.jrutil.examples;

import com.jrutil.ColorPrinter;

/**
 * An example to show off the {@link ColorPrinter} class.
 *
 * @see ColorPrinter
 * @see java.io.PrintWriter#println(String)
 * @see java.io.PrintWriter#print(String)
 * @see String#format(String, Object...)
 */
public class ColorPrinterExample {

    public static void main(String[] args) {
        ColorPrinter.println("%bold%%yellow%Hello world!");
        ColorPrinter.println("%yellow%Not so bold...");
        ColorPrinter.println("%bold%%green%Success!");
        ColorPrinter.println("%bgiblack%%yellow%I am a code block!");
        ColorPrinter.println("%italic%Italic words...");
    }

}
