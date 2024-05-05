package com.bucikft.commands.ObserverModel;

import com.bucikft.Door.Door;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Person;
import com.bucikft.Room;

import java.util.List;

public class RoomClickedEvent {
    private Room room;
    public RoomClickedEvent(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public List<Person> getPersonList() {
        return room.getPersonList();
    }

    public List<Door> getDoorList() {
        return room.getDoorList();
    }

    public List<Item> getItemsList() {
        return room.getItemsList();
    }

}
