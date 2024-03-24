package com.bucikft.Door;

import com.bucikft.Room;

/**
 * The Door class represents a door connecting two rooms.
 */
public class Door {

    private Room roomFrom; // The room from which the door leads.
    private Room roomTo; // The room to which the door leads.

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

    /**
     * Sets the room to which the door leads.
     *
     * @param newRoomTo The new room to which the door leads.
     */
    public void setRoomTo(Room newRoomTo) {
        this.roomTo = newRoomTo;
    }
}
