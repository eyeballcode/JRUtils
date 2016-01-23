package com.jrutil.examples;

import com.jrutil.DelayedCode;

import static com.jrutil.DelayedCode.setTimeout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
