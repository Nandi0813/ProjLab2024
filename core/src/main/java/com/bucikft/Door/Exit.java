package com.bucikft.Door;
import com.bucikft.Room;
/**
 * Represents the emergency exit, a special type of door typically used for exiting the labyrinth.
 */
public class Exit extends Door {

    /**
     * The constructor of the Exit class.
     * @param roomFrom The room from which the exit door leads.
     * @param roomTo The room to which the exit door leads.
     */
    public Exit(Room roomFrom, Room roomTo) {
        super(roomFrom, roomTo);
        isOpen = false;
    }

    private boolean isOpen; // Indicates whether the exit door is currently open or closed.

    /**
     * Gets the status of the exit door (open or closed).
     *
     * @return True if the exit door is open, false otherwise.
     */
    public boolean getIsOpen() {
        return isOpen;
    }

    /**
     * Sets the status of the exit door (open or closed).
     *
     * @param newIsOpen The new status of the exit door.
     */
    public void setIsOpen(boolean newIsOpen) {
        isOpen = newIsOpen;
    }

    /**
     * Opens the exit door.
     */
    public void open() {
        System.out.println("The game is over you won!");
    }
}
