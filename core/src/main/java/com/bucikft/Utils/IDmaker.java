package com.bucikft.Utils;

/**
 * The type Dmaker.
 */
public class IDmaker {

    /**
     * The ID of the ID maker.
     */
    private static int id;

    /**
     * The constructor of the ID maker.
     *
     * @return The ID.
     */
    public static String makeID() {
        return Integer.toString(id++);
    }

}
