package com.bucikft.Person;
import com.bucikft.Items.Item;
import com.bucikft.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    protected String name;
    protected int movesLeft;
    protected List<Item> itemList;
    protected Room currentRoom;

    public Person() {
        this.itemList = new ArrayList<>();
    }

    public abstract void move(Room room);
    public abstract void pickUp(Item item);

    public Room getCurrentRoom() { return this.currentRoom; }
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    public int getMovesLeft() { return this.movesLeft; }
    public void setMovesLeft(int movesLeft) { this.movesLeft = movesLeft; }

}
