package com.jrutil;

import java.security.SecureRandom;
import java.util.Random;

/**
 * A class for generating random numbers
 */
public class RandomGen {
    /**
     * Generates a random int in the range provided.
     *
     * @param startRange The start range.
     * @param endRange   The end range.
     * @return The random int
     */
    public static int randomInt(int startRange, int endRange) {
        Random rand = new SecureRandom();
        return rand.nextInt((endRange - startRange) + 1) + startRange;
    }

}
