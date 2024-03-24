package com.bucikft.Person;
import com.bucikft.Items.Item;
import com.bucikft.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    protected String name;
    protected int movesLeft;
    protected int usesLeft; // added so we can track moves and uses separately
    protected List<Item> itemList;
    protected Room currentRoom;

    public Person() {
        this.itemList = new ArrayList<>();
    }

    public void move(Room room) {
        // test if person has moves left
        if (this.movesLeft < 0) throw new IllegalStateException("A játékosnak nincs több lépése.");
        // test if rooms are neighbors
        // todo

        // move person to room
        // todo
        System.out.println();
        // decrement movesLeft
        this.movesLeft--;
    }
    public abstract void pickUp(Item item);

    public Room getCurrentRoom() { return this.currentRoom; }
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    public int getMovesLeft() { return this.movesLeft; }
    public void setMovesLeft(int movesLeft) { this.movesLeft = movesLeft; }

}
