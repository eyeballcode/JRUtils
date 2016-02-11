#JRUtil

What's this?

It's an API for Java that hopes to clean and dry your code. Just see this:

Original:
    System.out.print("Number of decimal places: ");
    int numberOfDP = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    System.out.print("Number to round: ");
    double number = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
    System.out.println(MathHelper.roundDoubleToXDP(number, numberOfDP));

With JRUtil:
    int numberOfDP = TerminalHelper.readInt("Number of decimal places: ");
    double number = TerminalHelper.readDouble("Number to round: ");
    System.out.println(MathHelper.roundDoubleToXDP(number, numberOfDP));

Or maybe, random numbers:
    int randomNumber = MathHelper.randomInt(1, TerminalHelper.readInt("What's the largest value for the random number? "));

It also gives you utility methods such as this:

    BufferedImage screenGrab = AWTHelper.screenGrab();

Or maybe, to click and move the mouse?

    AWTHelper.moveCursor(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
That centers the mouse.

    AWTHelper.LClick(Toolkit.getDefaultToolkit().getScreenSize().width / 2, Toolkit.getDefaultToolkit().getScreenSize().height / 2);
That left clicks in the middle of the screen.

    AWTHelper.keyPress(KeyEvent.VK_ALT);
    AWTHelper.keyPress(KeyEvent.VK_TAB);
    AWTHelper.keyRelease(KeyEvent.VK_ALT);
    AWTHelper.keyRelease(KeyEvent.VK_TAB);
That? Switches windows. (If you use Alt + Tab for it, of course.)

    AWTHelper.getCursorPos();
Tells you where the cursor is.

-------

JavaScript lover? You'll find something you love here.

    // Imports
    import static com.jrutil.DelayedCode.setTimeout;
    import static com.jrutil.RepeatedCode.setInterval;

    //...

    setTimeout(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Delayed by 500ms!");
        }
    }, 500);

    setInterval(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Runs every 500ms!");
        }
    }, 500);

------

Terminal based apps? Plain white on black too boring? Why not bring in some colours?

    ColorPrinter.println("%bold%%green%Success!");
    ColorPrinter.print("%red%Build failed. %reset%Continue? %underline%");
    String s = TerminalHelper.read();

Consult the ColorPrinter class JavaDocs for more info.

-------

Building an API? HashMaps that shouldn't be touched? Try the LockedHashMap or the LockableHashMap!

Once locked, they cannot be modified!

    LockableHashMap<String, Integer> numbersMap = new LockableHashMap<String, Integer>();
    for (int i = 0; i < 10; i++) numbersMap.put(String.valueOf(i), i);
    numbersMap.lock();

Now, it contains the numbers 1 - 10, and nothing can be added!

-------------

UI stuff? Maybe a chat client that shows when you're typing?

JRTypingTextBox is for you then!

    final JRTypingTextbox typingTextbox = new JRTypingTextbox();
    typingTextbox.addTypingListener(new TypingListener() {
        @Override
        public void typingFinished(TypingEvent event) {
            System.out.println(typingTextbox.getText());
        }
    });

There. After you finish typing, it prints the text to the terminal.



TODO FOR THIS PROJECT:

[ ]: JRTypingTextBox TypingListener#TypingStart(TypingEvent) to be done up.
