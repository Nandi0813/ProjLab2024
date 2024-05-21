package com.bucikft.Door;

import com.bucikft.Room;

import java.io.Serializable;

/**
 * The Door class represents a door connecting two rooms.
 */
public class Door implements Serializable {

    /**
     * The Room from.
     */
    protected Room roomFrom; // The room from which the door leads.
    /**
     * The Room to.
     */
    protected Room roomTo; // The room to which the door leads.

    /**
     * The Location from.
     */
    protected DoorLocation locationFrom; // The location of the door in the room.
    /**
     * The Location to.
     */
    protected DoorLocation locationTo; // The location of the door in the room.

    /**
     * The Disappeared.
     */
    protected int disappeared = 0;

    /**
     * Sets disappeared.
     *
     * @param n the n
     */
    public void setDisappeared(int n) {
        disappeared = n;
    }

    /**
     * Gets disappeared.
     *
     * @return the disappeared
     */
    public int getDisappeared() {
        return disappeared;
    }

    /**
     * Instantiates a new Door.
     *
     * @param roomFrom the room from
     * @param roomTo   the room to
     * @param location the location
     */
    public Door(Room roomFrom, Room roomTo, DoorLocation location) {
        this.roomFrom = roomFrom;
        this.roomTo = roomTo;
        this.locationFrom = location;
        this.locationTo = DoorLocation.getOpposite(location);
    }

    /**
     * Gets the location of the door in the room.
     *
     * @return The location of the door in the room.
     */
    public DoorLocation getLocationFrom() {
        return locationFrom;
    }

    /**
     * Gets the location of the door in the room.
     *
     * @return The location of the door in the room.
     */
    public DoorLocation getLocationTo() {
        return locationTo;
    }

    /**
     * Sets the room from which the door leads.
     *
     * @param roomFrom The room from which the door leads.
     */
    public void setRoomFrom(Room roomFrom) { this.roomFrom = roomFrom; }

    /**
     * Gets the room from which the door leads.
     *
     * @return The room from which the door leads.
     */
    public Room getRoomFrom() {
        return roomFrom;
    }

    /**
     * Sets the room to which the door leads.
     *
     * @param roomTo The room to which the door leads.
     */
    public void setRoomTo(Room roomTo) { this.roomTo = roomTo; }

    /**
     * Gets the room to which the door leads.
     *
     * @return The room to which the door leads.
     */
    public Room getRoomTo() {
        return this.roomTo;
    }

    /**
     * Returns the room to which the door leads from the given room.
     *
     * @param roomFrom The room from which the door leads.
     * @return The room to which the door leads.
     */
    public Room getWhereTo(Room roomFrom)
    {
        if (this.roomFrom == roomFrom)
            return this.roomTo;
        return this.roomFrom;
    }

    /**
     * Prints the door.
     *
     * @param room The room from which the door leads.
     */
    public void printDoor(Room room) {
        if (room == roomFrom) {
            System.out.println("Door from " + roomFrom + " to " + roomTo);
        } else {
            System.out.println("Door from " + roomTo + " to " + roomFrom);
        }
    }

    /**
     * Returns the string representation of the door.
     * @return The string representation of the door.
     */
    @Override
    public String toString() {
        return "Door from " + roomFrom + " to " + roomTo;
    }
}
