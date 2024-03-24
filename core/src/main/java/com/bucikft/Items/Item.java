package com.bucikft.Items;

import com.bucikft.Person.Student;

/**
 * Represents an abstract Item.
 */
public abstract class Item {

    private boolean broken = false; // Indicates whether the item is broken or not.

    /**
     * Gets the status of the item (broken or not).
     *
     * @return True if the item is broken, false otherwise.
     */
    public boolean getBroken() {
        return broken;
    }

    /**
     * Sets the status of the item (broken or not).
     *
     * @param newBroken The new status of the item.
     */
    public void setBroken(boolean newBroken) {
        broken = newBroken;
    }

    /**
     * Applies the effect of the item on the user (a student).
     *
     * @param user The student who uses the item.
     */
    public abstract void effect(Student user);
}
