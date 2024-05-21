package com.bucikft.Items;

import com.bucikft.Door.DoorLocation;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Menu;
import com.bucikft.Person.Student;
import com.bucikft.Room;
import com.bucikft.Controllers.TileType;
import com.bucikft.Utils.PathFinder;

import java.util.LinkedList;

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
        LinkedList<DoorLocation> shortestPath = PathFinder.findShortestPathToExit(user.getCurrentRoom());
        for (DoorLocation doorLocation : shortestPath) {
            System.out.println(doorLocation);
        }

        this.setBroken(true);
    }

}
