package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/**
 * Represents an Energy Drink item, which increases the remaining steps of a Student when used by said Student.
 */
public class EnergyDrink extends Item {

    /**
     * The constructor of the EnergyDrink class.
     * @param ID The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public EnergyDrink(String ID, boolean isFalseItem) {
        super(ID, isFalseItem);
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

}
