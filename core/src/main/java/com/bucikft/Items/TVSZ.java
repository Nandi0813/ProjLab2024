package com.bucikft.Items;

import com.bucikft.Controllers.Tile;
import com.bucikft.Controllers.TileType;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;
import com.bucikft.Controllers.TileType;

/**
 * Represents a TVSZ item, which can protect a Student from professors.
 */
public class TVSZ extends Item {

    private int health; // The health points of the TVSZ item.

    private boolean tvszUsed = false; // Indicates whether the TVSZ item has been used.

    /**
     * The constructor of the TVSZ class.
     * @param ID The unique identifier of the item.
     * @param isFalseItem Indicates whether the item is a false item or not.
     */
    public TVSZ(String ID, final boolean isFalseItem) {
        super(ID, isFalseItem, TileType.TVSZ);
        this.falseItem = isFalseItem;
        this.health = 3;
    }

    /**
     * Applies the effect of the TVSZ item, protecting the user from professors.
     *
     * @param user The student who uses the TVSZ item.
     */
    @Override
    public void effect(Student user) throws IllegalStateException{
        if (this.isFalse()) {
            throw new IllegalStateException("This item is a false item. No result.");
        }

        // Protect the user from professors
        user.setProtected(true);

        // Decrease health and break the item if health reaches zero
        health--;
        tvszUsed = true;

        if (health < 0) {
            setBroken(true);
        }
    }

    /**
     * Returns a string representation of the TVSZ item.
     * @return The string representation of the TVSZ item.
     */
    @Override
    public String toString() {
        System.out.println(tvszUsed ? "The TVSZ has been used once." : "");
        tvszUsed = false;
        return "TVSZ#" + ID + " remaining uses: " + health + ".";
    }

}
