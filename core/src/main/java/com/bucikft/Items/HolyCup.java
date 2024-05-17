package com.bucikft.Items;

import com.bucikft.Items.Interface.Item;
import com.bucikft.Menu;
import com.bucikft.Person.Student;
import com.bucikft.Room;
import com.bucikft.Controllers.TileType;

/**
 * Represents a Holy Cup item, which shows the shortest path to the SlipStick when used by a Student.
 * When used, the student loses a random item from his/her inventory.
 */
public class HolyCup extends Item {

    public HolyCup(String ID, boolean isFalseItem) {
        super(ID, isFalseItem, TileType.HolyCup);
    }

    /**
     * Applies the effect of the Holy Cup item on the user (a student).
     *
     * @param user The student who uses the Holy Cup item.
     * @throws IllegalStateException If the item is already broken.
     */
    public void effect(Student user) throws IllegalStateException {
        Room slipRoom = null;
        for (Room r : Menu.getGame().getMap().getRoomList()) {
            for (Item item : r.getItemList()) {
                if (item instanceof SlipStick s && !s.isFalse())
                    slipRoom = r;
            }
        }

        System.out.println("The Slip Stick is in " + slipRoom + ".");

        this.setBroken(true);
    }

}
