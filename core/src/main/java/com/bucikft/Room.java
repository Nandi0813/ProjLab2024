package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Door.DoorLocation;
import com.bucikft.Door.Exit;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Represents a room in the game.
 */
public class Room implements Serializable {

    private static final Random random = new Random();

    private int personCapacity = 5; // Added to track the capacity of the room
    private int itemCapacity = 5; // Added to track how many items can be in the room

    private boolean gassed; // Added to track if the room is gassed
    private boolean cursed;



    // Attributes related to cleaning
    public static final int STICKY_AT = 6;
    private int visitorsSinceLastCleaning;
    private boolean sticky;

    private final List<Item> itemList; // Added to track the items in the room
    private final List<Door> doorList; // Added to track the doors in the room
    private final List<Person> personList; // Added to track the persons in the room

    private final String ID; // Added to track the ID of the room


    private final int x;
    private final int y;

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    /**
     * Initializes a new room.
     */
    public Room(int x, int y) {
        this.gassed = false;
        this.sticky = false;
        this.itemList = new ArrayList<>();
        this.doorList = new ArrayList<>();
        this.personList = new ArrayList<>();
        this.ID = "Room#"+x+y;
        this.x = x;
        this.y = y;
        this.cursed = random.nextInt(6) % 6 == 0;
    }

    public Room getRandomNeighbourRoom() {
        for (Door door : this.getDoorList()) {
            if (door instanceof Exit) {
                continue;
            }

            Room room = door.getWhereTo(this);
            if (!room.isMaxPersonCapacity()) {
                return room;
            }
        }
        
        return null;
    }

    /**
     * @return The capacity of the room.
     */
    public int getPersonCapacity() {
        return this.personCapacity;
    }

    /**
     * Sets the capacity of the room.
     *
     * @param personCapacity The capacity to set.
     */
    public void setPersonCapacity(int personCapacity) {
        this.personCapacity = personCapacity;
    }

    /**
     * @return Whether the room is at maximum person capacity or not
     */
    public boolean isMaxPersonCapacity() {
        return this.getPersonCapacity() < this.personList.size();
    }

    /**
     *
     * @param room
     * @return
     */
    public boolean isNeighbour(Room room) {
        for (Door door : this.getDoorList())
            if (room == door.getRoomTo() || room == door.getRoomFrom())
                return true;
        return false;
    }

    public Room getRoom(DoorLocation doorLocation) {
        for (Door door : doorList) {
            if (door.getRoomFrom() == this && door.getLocationTo().equals(doorLocation))
                return door.getRoomTo();
            else if (door.getRoomTo() == this && door.getLocationFrom().equals(doorLocation))
                return door.getRoomFrom();
        }
        return null;
    }

    public boolean isCursed() {
        return this.cursed;
    }

    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }


    /**
     * Checks if the room is gassed.
     * @return True if the room is gassed, false otherwise.
     */
    public boolean isGassed() {
        return this.gassed;
    }

    /**
     * Sets the gassed status of the room.
     * @param gassed The gassed status to set.
     */
    public void setGassed(boolean gassed) {
        this.gassed = gassed;
    }

    /**
     * @return The number of visitors since the last cleaning happened by a cleaner.
     */
    public int getVisitorsSinceLastCleaning() { return this.visitorsSinceLastCleaning; }

    /**
     * @param visitorsSinceLastCleaning The number of visitors since the last cleaning.
     */
    public void setVisitorsSinceLastCleaning(int visitorsSinceLastCleaning) { this.visitorsSinceLastCleaning = visitorsSinceLastCleaning; }

    /**
     * Checks if the room is sticky.
     * @return True if the room is sticky, false otherwise.
     */
    public boolean isSticky() {
        return this.sticky;
    }

    /**
     * Sets the sticky status of the room.
     */
    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }

    /**
     *
     */
    public void clean() {
        this.visitorsSinceLastCleaning = 0;

        this.gassed = false;
        this.sticky = false;
    }

    /**
     * Retrieves the list of items in the room.
     * @return The list of items.
     */
    public List<Item> getItemList() {
        return this.itemList;
    }

    /**
     * @return Whether the room is at maximum item capacity or not
     */
    public boolean isMaxItemCapacity() {
        return this.getItemCapacity() < this.itemList.size();
    }

    /**
     * Gets the item with the specified ID.
     * @param id The ID of the item to get.
     * @return The item with the specified ID.
     */
    public Item getItem(String id) {
        for (Item item : this.itemList)
            if (item.getID().equals(id))
                return item;
        return null;
    }

    /**
     * Retrieves the list of doors in the room.
     * @return The list of doors.
     */
    public List<Door> getDoorList() {
        return this.doorList;
    }

    /**
     * Retrieves the list of persons in the room.
     *
     * @return The list of persons.
     */
    public List<Person> getPersonList() {
        return this.personList;
    }

    /**
     *
     * @return
     */
    public boolean containsStudent() {
        for (Person person : this.personList)
            if (person instanceof Student)
                return true;
        return false;
    }

    /**
     *
     * @return
     */
    public boolean containsProfessor() {
        for (Person person : this.personList)
            if (person instanceof Professor)
                return true;
        return false;
    }

    /**
     * Retrieves the capacity of the room.
     * @return The capacity of the room.
     */
    public int getItemCapacity() {
        return this.itemCapacity;
    }

    /**
     * Retrieves the ID of the room.
     * @return The ID of the room.
     */
    public String getID() {
        return this.ID;
    }

    /**
     * Sets the item capacity of the room.
     * @param i The item capacity to set.
     */
    public void setItemCapacity(int i) {
        this.itemCapacity = i;
    }

    public DoorLocation emptyDoor() {
        List<DoorLocation> locations = new ArrayList<>(Arrays.asList(DoorLocation.values()));
        for (Door door : doorList) {
            if (door.getRoomFrom() == this){
                locations.remove(door.getLocationFrom());
            }
            else{
                locations.remove(door.getLocationTo());
            }
        }
        return locations.get(0);
    }

    @Override
    public String toString() {
        return this.ID;
    }

}
