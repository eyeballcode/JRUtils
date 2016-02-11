package com.jrutil.examples;

import com.jrutil.TerminalHelper;
import com.jrutil.math.MathHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * An example that shows how to get the console's width.
 *
 * @see TerminalHelper
 */
public class TerminalHelperExample {

    static {
        try {
            System.out.print("Number of decimal places: ");
            int numberOfDP = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.print("Number to round: ");
            double number = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
            System.out.println(MathHelper.roundDoubleToXDP(number, numberOfDP));
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("TerminalHelper#read variants");
        System.out.println("    " + TerminalHelper.readInt("Int: "));
        System.out.println("    " + TerminalHelper.readLong("Long: "));
        System.out.println("    " + TerminalHelper.readFloat("Float: "));
        System.out.println("    " + TerminalHelper.read("String: "));
        System.out.println("    " + TerminalHelper.readBoolean("Boolean: "));
        try {
            System.out.println("    " + TerminalHelper.readPassword("Password: "));
        } catch (NullPointerException ignored) {
            System.out.println();
            System.out.println("    Password reading not supported!");
        }
        System.out.println("Terminal / Console width: ");
        System.out.println("    " + TerminalHelper.getTerminalWidth());
    }

}
