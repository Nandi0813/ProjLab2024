package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/**
 * Represents a TVSZ item, which can protect a Student from professors.
 */
public class TVSZ extends Item {

    private int health; // The health points of the TVSZ item.

    public TVSZ(String ID, final boolean isFalseItem) {
        super(ID, isFalseItem);
        this.falseItem = isFalseItem;
        this.health = 3;
    }

    /**
     * Applies the effect of the TVSZ item, protecting the user from professors.
     *
     * @param user The student who uses the TVSZ item.
     */
    @Override
    public void effect(Student user) {
        if (this.isFalse())
            throw new IllegalStateException("This item is a false item. No result.");
        // Protect the user from professors
        user.setProtected(true);

        // Decrease health and break the item if health reaches zero
        health--;
        if (health == 0) {
            setBroken(true);
        }
    }

    /**
     * Sets the health points of the TVSZ item.
     *
     * @param health The health points to set.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the health points of the TVSZ item.
     *
     * @return The health points of the TVSZ item.
     */
    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "TVSZ#"+ID+" remaining uses: "+health;
    }

}
