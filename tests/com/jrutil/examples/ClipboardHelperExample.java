package com.jrutil.examples;

import com.jrutil.datatransfer.ClipboardHelper;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipboardHelperExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ClipboardHelper.getStringClipboardContents());
    }

}
