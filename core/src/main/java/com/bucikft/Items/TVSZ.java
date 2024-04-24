package com.bucikft.Items;

import com.bucikft.Items.Interface.FalseItem;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/**
 * Represents a TVSZ item, which can protect a Student from professors.
 */
public class TVSZ extends Item implements FalseItem {

    private int health; // The health points of the TVSZ item.

    public TVSZ(String ID, final boolean isFalseItem) {
        super(ID);
        this.falseItem = isFalseItem;
    }

    /**
     * Applies the effect of the TVSZ item, protecting the user from professors.
     *
     * @param user The student who uses the TVSZ item.
     */
    public void effect(Student user){

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
    public boolean isFalse() {
        return this.falseItem;
    }

    @Override
    public String toString() {
        return "TVSZ#"+ID+" remaining uses: "+health;
    }

}
