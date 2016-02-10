package com.jrutil.examples;

import com.jrutil.DelayedCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.jrutil.DelayedCode.setTimeout;


public class DelayedCodeExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        DelayedCode code = setTimeout(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(System.currentTimeMillis());
            }
        }, 500);
    }

}
