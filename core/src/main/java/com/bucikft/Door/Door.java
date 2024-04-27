package com.bucikft.Door;

import com.bucikft.Room;

/**
 * The Door class represents a door connecting two rooms.
 */
public class Door {

    protected Room roomFrom; // The room from which the door leads.
    protected Room roomTo; // The room to which the door leads.



    public Door(Room roomFrom, Room roomTo) {
        this.roomFrom = roomFrom;
        this.roomTo = roomTo;
    }


    /**
     * Gets the room from which the door leads.
     *
     * @return The room from which the door leads.
     */
    public Room getRoomFrom() {
        return roomFrom;
    }

    /**
     * Sets the room from which the door leads.
     *
     * @param newRoomFrom The new room from which the door leads.
     */
    public void setRoomFrom(Room newRoomFrom) {
        roomFrom = newRoomFrom;
    }

    /**
     * Gets the room to which the door leads.
     *
     * @return The room to which the door leads.
     */
    public Room getRoomTo() {
        return this.roomTo;
    }

    public Room getWhereTo(Room roomFrom)
    {
        if (this.roomFrom == roomFrom)
            return this.roomTo;
        return this.roomFrom;
    }

    /**
     * Sets the room to which the door leads.
     *
     * @param newRoomTo The new room to which the door leads.
     */
    public void setRoomTo(Room newRoomTo) {
        this.roomTo = newRoomTo;
    }

    public void printDoor(Room room) {
        if (room == roomFrom) System.out.println("Door from " + roomFrom + " to " + roomTo);
        else System.out.println("Door from " + roomTo + " to " + roomFrom);
    }

    @Override
    public String toString() {
        return "Door from " + roomFrom + " to " + roomTo;
    }
}
