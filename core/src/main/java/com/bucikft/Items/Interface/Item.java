package com.bucikft.Items.Interface;

import com.bucikft.Person.Student;
import com.bucikft.Controllers.TileType;

import java.io.Serializable;

/**
 * Represents an abstract Item.
 */
public abstract class Item implements Serializable {

    /**
     * The False item.
     */
    protected boolean falseItem; // Indicates whether the item is a false item or not.
    /**
     * The Broken.
     */
    protected boolean broken; // Indicates whether the item is broken or not.
    /**
     * The Id.
     */
    protected String ID; // The unique identifier of the item.
    /**
     * The Type.
     */
    protected TileType type;

    /**
     * The constructor of the Item class.
     *
     * @param ID        The unique identifier of the item.
     * @param falseItem Indicates whether the item is a false item or not.
     * @param type      the type
     */
    protected Item(String ID, boolean falseItem, TileType type) {
        this.falseItem = falseItem;
        this.broken = false;
        this.ID = ID;
        this.type = type;
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
     * Gets the status of the item (broken or not).
     *
     * @return True if the item is broken, false otherwise.
     */
    public boolean isBroken() {
        return broken;
    }

    /**
     * Applies the effect of the item on the user (a student).
     *
     * @param user The student who uses the item.
     */
    public abstract void effect(Student user);

    /**
     * Indicates whether the item is a false item or not.
     *
     * @return True if the item is a false item, false otherwise.
     */
    public boolean isFalse() {
        return this.falseItem;
    }

    /**
     * Gets the unique identifier of the item.
     *
     * @return The unique identifier of the item.
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the string representation of the item.
     * @return The string representation of the item.
     */
    @Override
    public String toString() {
        return this.ID;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TileType getType() {return type;}

}