package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/**
 * Represents an Energy Drink item, which increases the remaining steps of a Student when used by said Student.
 */
public class EnergyDrink extends Item {

    /**
     * Applies the effect of the Energy Drink item on the user (a student).
     *
     * @param user The student who uses the Energy Drink item.
     * @throws IllegalStateException If the Energy Drink item is already broken.
     */
    public void effect(Student user) throws IllegalStateException {

        // Increase moves left
        // Todo: Implement increasing the remaining steps of the student
        System.out.println("*After consuming the Energy Drink, the student can take one more step*");

        // Break item
        this.setBroken(true);
    }
}
