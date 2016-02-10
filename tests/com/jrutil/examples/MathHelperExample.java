package com.jrutil.examples;

import com.jrutil.TerminalHelper;
import com.jrutil.math.MathHelper;

import java.io.IOException;

public class MathHelperExample {

    public static void main(String[] args) {
        System.out.println("Random INT from 1 - 10:");
        for (int i = 0; i < 10; i++)
            System.out.println(MathHelper.randomInt(1, 10));

        System.out.println("Random FLOAT from 1.5 - 10.5:");
        for (int i = 0; i < 10; i++)
            System.out.println(MathHelper.randomFloat(1.5f, 10.5f));

        System.out.println("Random DOUBLE from 1.8 - 10.8:");
        for (int i = 0; i < 10; i++)
            System.out.println(MathHelper.randomDouble(1.8, 10.8));

        System.out.println("Round off a number!");
        try {
            int numberOfDP = TerminalHelper.readInt("Number of decimal places: ");
            double number = TerminalHelper.readDouble("Number to round: ");
            System.out.println(MathHelper.roundDoubleToXDP(number, numberOfDP));
        } catch (IOException e) {
            System.out.println("Bruh bye.");
        }
    }

}
