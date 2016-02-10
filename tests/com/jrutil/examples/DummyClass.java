package com.jrutil.examples;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DummyClass {

    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    public void print(Object[] toPrint) {
        System.out.println(Arrays.toString(toPrint));
    }

    public String read() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public String[] getNames() {
        return new String[]{"Hello, Hello"};
    }

    public JPanel[][] getBoard() {
        return new JPanel[][]{};
    }

}
