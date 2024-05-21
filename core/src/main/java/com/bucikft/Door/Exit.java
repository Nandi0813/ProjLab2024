package com.bucikft.Door;
import com.bucikft.Room;

/**
 * Represents the emergency exit, a special type of door typically used for exiting the labyrinth.
 */
public class Exit extends Door {

    private boolean open; // Indicates whether the exit door is currently open or closed.

    /**
     * The constructor of the Exit class.
     * @param roomFrom The room from which the exit door leads.
     * @param roomTo The room to which the exit door leads.
     */
    public Exit(Room roomFrom, Room roomTo, DoorLocation location) {
        super(roomFrom, roomTo, location);
        this.locationTo = null;
        open = false;
    }

    /**
     * Gets the status of the exit door (open or closed).
     *
     * @return True if the exit door is open, false otherwise.
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Opens the exit door.
     */
    public void open() {
        this.open = true;
        System.out.println("The exit is open!");
    }

}
