package com.bucikft.Door;

import com.bucikft.Room;

public class Door {

    private Room roomFrom;
    private Room roomTo;

    public Room getRoomFrom() {
        return roomFrom;
    }
    public void setRoomFrom(Room newRoomFrom) {
        roomFrom = newRoomFrom;
    }

    public Room getRoomTo() { return this.roomTo; }
    public void setRoomTo(Room newRoomTo) { this.roomTo = newRoomTo; }

}
