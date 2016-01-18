package com.jrutil.examples;

import com.jrutil.LockableHashMap;
import com.jrutil.LockedHashMap;
import com.jrutil.TerminalHelper;

import java.util.HashMap;

/**
 * An example to show the usages of {@link LockedHashMap} and {@link LockableHashMap}s.
 *
 * It also shows their differences, and a bit of {@link TerminalHelper}. See a {@link TerminalHelper} example {@linkplain TerminalHelperExample here}
 *
 * @see LockedHashMap
 * @see LockableHashMap
 * @see TerminalHelperExample
 */
public class LockableHashMapsExample {

    public static void main(String[] args) {
        // LockedHashMap example
        {
            System.out.println("LockedHashMap Example:");
            HashMap<String, Integer> numbersMap = new HashMap<>();
            for (int i = 0; i < 10; i++) numbersMap.put(String.valueOf(i), i);
            System.out.println("    Existing HashMap:");
            System.out.println("    " + numbersMap.toString());
            LockedHashMap<String, Integer> lockedHashMap = new LockedHashMap<>(numbersMap);
            System.out.println("    LockedHashMap before attempted modifications");
            System.out.println("    " + lockedHashMap);
            lockedHashMap.put("11", 11);
            System.out.println("    LockedHashMap after attempted modifications");
            System.out.println("    " + lockedHashMap);
        }
        for (int i = 0; i < TerminalHelper.getTerminalWidth(); i++) System.out.print("-");
        System.out.print("\n");
        //LockableHashMap example
        {
            System.out.println("LockableHashMap Example:");
            LockableHashMap<String, Integer> numbersMap = new LockableHashMap<>();
            for (int i = 0; i < 10; i++) numbersMap.put(String.valueOf(i), i);
            System.out.println("    First Numbers Map before locking");
            System.out.println("    " + numbersMap);
            System.out.println("    Locking the HashMap with LockableHashMap#lock()");
            numbersMap.lock();
            System.out.println("    Locked!");
            numbersMap.put("11", 11);
            System.out.println("    LockableHashMap after locking and attempted modifications:");
            System.out.println("    " + numbersMap);
        }
    }


}