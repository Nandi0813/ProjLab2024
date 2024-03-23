package com.bucikft.Person;

import com.bucikft.Items.Item;
import com.bucikft.Room;

public class Student extends Person {

    private boolean alive;

    public void use(Item item) {
        item.effect(this);
    }

    public void drop(Item item) {

    }

    public boolean isKillable() {
        return false;
    }

    @Override
    public void move(Room room) {

    }

    @Override
    public void pickUp(Item item) {

    }

    public boolean isAlive() { return this.alive; }
    public void setAlive(final boolean alive) { this.alive = alive; }

}
