package com.bucikft.Items;

import com.bucikft.Door.Door;
import com.bucikft.Door.Exit;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/**
 * Represents a SlipStick item, which can open the Emergency Exit.
 */
public class SlipStick extends Item {

    public SlipStick(String ID, final boolean isFalseItem) {
        super(ID, isFalseItem);
        this.falseItem = isFalseItem;
    }

    /**
     * Applies the effect of the SlipStick item on the user (a student).
     *
     * @param user The student who uses the SlipStick item.
     * @throws IllegalStateException If the room does not have an emergency exit or if the SlipStick item is already broken.
     */
    public void effect(Student user) throws IllegalStateException {
        if (this.isFalse())
            throw new IllegalStateException("This item is a false item. No result.");

        // Check if the room has an emergency exit
        boolean hasEmergencyExit = false;
        Exit exit = null;
        for (Door door : user.getCurrentRoom().getDoorList()) {
            if (door instanceof Exit) {
                hasEmergencyExit = true;
                exit = (Exit) door;
                break;
            }
        }
        if (!hasEmergencyExit) throw new IllegalStateException("The room does not have an emergency exit.");

        // Open the exit
        exit.open();

        // Break the item
        this.setBroken(true);
    }

    @Override
    public String toString() {
        return "SlipStick#" + ID;
    }

}
