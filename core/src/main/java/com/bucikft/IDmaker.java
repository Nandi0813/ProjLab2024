package com.bucikft;

/**
 * The type Dmaker.
 */
public class IDmaker {

    /**
     * The ID of the ID maker.
     */
    private int id;

    /**
     * The constructor of the ID maker.
     *
     * @return The ID.
     */
    public String makeID() {
        return Integer.toString(id++);
    }

}
