package com.bucikft.Items.Interface;

import com.bucikft.Menu;
import com.bucikft.Person.Student;
import com.bucikft.Room;

/**
 * Represents an abstract Item.
 */
public abstract class Item {

    protected boolean falseItem;
    protected boolean broken; // Indicates whether the item is broken or not.
    protected boolean pickedUp; // Indicates whether the item has been picked up or not.
    protected String ID;

    protected Item(String ID, boolean falseItem) {
        this.falseItem = falseItem;
        this.broken = false;
        this.ID = ID;
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
     * Sets the status of the item (broken or not).
     *
     * @param newBroken The new status of the item.
     */
    public void setBroken(boolean newBroken) {
        broken = newBroken;
    }

    /**
     * Applies the effect of the item on the user (a student).
     *
     * @param user The student who uses the item.
     */
    public abstract void effect(Student user);

    public boolean isFalse() {
        return this.falseItem;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ "#" + ID;
    }
    public void setPickedUp(boolean pickedUp) {
        for (Room r : Menu.getGame().getMap().getRoomList()) {
            if (r.getItemsList().contains(this)) {
                if (r.isSticky()) {
                    return;
                }
            }
        }
        this.pickedUp = pickedUp;
    }
    public boolean isPickedUp() {
        return pickedUp;
    }

    public String getID() {
        return ID;
    }
}