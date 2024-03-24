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
        System.out.println("*Személy átmozgatva*");

        // decrement movesLeft
        // todo decrement moves left
    }

    public void pickUp(Item item) {
        Scanner scanner = new Scanner(System.in);

        // test if player has moves left
        // todo
        System.out.println("Van még lépése hátra a játékosnak? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A játékosnak nincs több lépése.");

        // test if item is in the same room
        // todo
        System.out.println("A tárgy a játékos szobájában van? y/n: ");
        choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A tárgy nem a játékos szobájában van.");

        // test if inventory full
        // todo
        System.out.println("A játékos eszköztárja tele van? y/n: ");
        choice = scanner.next().equals("y");
        if (choice) throw new IllegalStateException("A játékos táskája tele van.");

        // pick up item
        // todo implement picking up item
        System.out.println("*A játékos felvette a tárgyat*");

        // decrement usesLeft
        // todo decrement uses left

    }

    public Room getCurrentRoom() { return this.currentRoom; }
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    public int getMovesLeft() { return this.movesLeft; }
    public void setMovesLeft(int movesLeft) { this.movesLeft = movesLeft; }

}
