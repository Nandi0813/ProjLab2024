package com.bucikft.Items;

import com.bucikft.Items.Interface.FalseItem;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

import java.util.Scanner;

/**
 * Represents a Mask item, which can be equipped and used to defend a Student from poison gas.
 */
public class Mask extends Item implements FalseItem {

    public Mask(final boolean isFalseItem) {
        this.falseItem = isFalseItem;
    }

    /**
     * Applies the effect of the Mask item on the user (a student).
     *
     * @param user The student who uses the Mask item.
     * @throws IllegalStateException If the student is already wearing a mask.
     */
    public void effect(Student user) throws IllegalStateException {
        Scanner scanner = new Scanner(System.in);
        // Test if user is already wearing a mask
        if (user.isMasked()) throw new IllegalStateException("The student is already wearing a mask");

        // Put on mask
        user.setMasked(true);

        // Break item
        this.setBroken(true);
    }

    @Override
    public boolean isFalse() {
        return this.falseItem;
    }

    @Override
    public String toString() {
        return "Mask#" + ID;
    }

}
