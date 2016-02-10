package com.jrutil.examples;

import com.jrutil.datatransfer.ClipboardHelper;

public class ClipboardHelperExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Contents of clipboard before setting: " + ClipboardHelper.getStringClipboardContents());
//        ClipboardHelper.setStringClipboardContents("I am permanent, haha!");
        System.out.println("Contents of clipboard after setting:  " + ClipboardHelper.getStringClipboardContents());
    }

}
