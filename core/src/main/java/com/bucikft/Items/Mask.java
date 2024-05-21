package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;
import com.bucikft.Controllers.TileType;

/**
 * Represents a Mask item, which can be equipped and used to defend a Student from poison gas.
 */
public class Mask extends Item {

    /**
     * The constructor of the Mask class.
     *
     * @param ID          The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public Mask(String ID, final boolean isFalseItem) {
        super(ID, isFalseItem, TileType.Mask);
        this.falseItem = isFalseItem;
    }

    /**
     * Applies the effect of the Mask item on the user (a student).
     *
     * @param user The student who uses the Mask item.
     * @throws IllegalStateException If the student is already wearing a mask.
     */
    public void effect(Student user) throws IllegalStateException {
        // Test if user is already wearing a mask
        if (user.isMasked()) {
            throw new IllegalStateException("The student is already wearing a mask");
        }
        
        if (this.isFalse()) {
            throw new IllegalStateException("This item is a false item. No result.");
        }

        // Put on mask
        user.setMasked(true);

        // Break item
        this.setBroken(true);
    }

}
