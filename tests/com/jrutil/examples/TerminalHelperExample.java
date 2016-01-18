package com.jrutil.examples;

import com.jrutil.TerminalHelper;

import java.io.IOException;

/**
 * An example that shows how to get the console's width.
 *
 * @see TerminalHelper
 */
public class TerminalHelperExample {

    public static void main(String[] args) throws IOException {
        System.out.println("TerminalHelper#read variants");
        System.out.println("    " + TerminalHelper.readInt("Int: "));
        System.out.println("    " + TerminalHelper.readLong("Long: "));
        System.out.println("    " + TerminalHelper.readFloat("Float: "));
        System.out.println("    " + TerminalHelper.read("String: "));
        System.out.println("    " + TerminalHelper.readBoolean("Boolean: "));
        try {
            System.out.println("    " + TerminalHelper.readPassword("Password: "));
        } catch (NullPointerException ignored) {
            System.out.println("    Password reading not supported!");
        }
        System.out.println("Terminal / Console width: ");
        System.out.println("    " + TerminalHelper.getTerminalWidth());
    }

}
