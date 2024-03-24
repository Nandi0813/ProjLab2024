package com.bucikft.Items;

import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a TVSZ item, which can protect a Student from professors.
 */
public class TVSZ extends Item {

    private int health; // The health points of the TVSZ item.

    /**
     * Applies the effect of the TVSZ item, protecting the user from professors.
     *
     * @param user The student who uses the TVSZ item.
     */
    public void effect(Student user){

        // Protect the user from professors
        // Todo: Implement protection
        System.out.println("*The TVSZ protects the user from professors*");

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
}
