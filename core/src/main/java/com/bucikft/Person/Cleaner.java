package com.bucikft.Person;

import com.bucikft.Room;

public class Cleaner extends Person {

    public Cleaner(String name) {
        super(name);
    }
    @Override
    public void move(Room room) {
        super.move(room);
        // remove all other people from the room
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public String toString() {
        return "Cleaner#" + this.getName();
    }

}
