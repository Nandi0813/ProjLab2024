package com.bucikft;

import com.bucikft.Door.Door;
import com.bucikft.Items.Item;
import com.bucikft.Person.Person;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private int capacity;
    private boolean gassed = false;
    private List<Item> itemsList;
    private List<Door> doorList;
    private List<Person> personList;

    public Room() {
        this.itemsList = new ArrayList<>();
        this.doorList = new ArrayList<>();
        this.personList = new ArrayList<>();
    }

    public Item popItem(int x, int y) {
        return null;
    }

    public Room getNeighbor(int x, int y) {
        return null;
    }

    public int getCapacity() {return this.capacity; }
    public void setCapacity(int capacity) {this.capacity = capacity; }

    public boolean isGassed() { return this.gassed; }
    public void setIsGassed(boolean gassed) { this.gassed = gassed; }

    public List<Item> getItemsList() { return this.itemsList; }
    public List<Door> getDoorList() { return this.doorList; }
    public List<Person> getPersonList() { return this.personList; }

}
