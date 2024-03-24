package com.bucikft.Person;
import com.bucikft.Items.Item;
import com.bucikft.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        // test if player has moves left
        // todo
        System.out.println("Van még lépése hátra a játékosnak? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A játékosnak nincs több lépése.");

        // test if rooms are neighbors
        // todo
        System.out.println("A szobák szomszédosak? y/n: ");
        choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A szobák nem szomszédosak.");

        // move person to room
        // todo: implement movement
        System.out.println();

        // decrement movesLeft
        // todo decrement moves left
    }
    public abstract void pickUp(Item item);

    public Room getCurrentRoom() { return this.currentRoom; }
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    public int getMovesLeft() { return this.movesLeft; }
    public void setMovesLeft(int movesLeft) { this.movesLeft = movesLeft; }

}
