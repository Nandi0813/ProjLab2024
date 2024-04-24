package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/**
 * Represents an Energy Drink item, which increases the remaining steps of a Student when used by said Student.
 */
public class EnergyDrink extends Item {
    public EnergyDrink(String ID) {
        super(ID);
    }

    /**
     * Applies the effect of the Energy Drink item on the user (a student).
     *
     * @param user The student who uses the Energy Drink item.
     * @throws IllegalStateException If the Energy Drink item is already broken.
     */
    public void effect(Student user) throws IllegalStateException {

        // Increase moves left
        user.setMovesLeft(user.getMovesLeft() + 1);

        // Break item
        this.setBroken(true);
    }

    @Override
    public String toString() {
        return "EnergyDrink#" + ID;
    }
}
