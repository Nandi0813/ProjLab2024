package com.bucikft.Person;

import com.bucikft.Items.Item;
import com.bucikft.Items.Transistor;

public class Student extends Person {

    private boolean alive;
    private boolean masked = false;

    public void use(Item item) {
        if (movesLeft>0) item.effect(this);
        else System.out.println("A játékosnak nincs több lépése, így nem használhat tárgyat.");
    }

    public void drop(Item item) {

    }

    public boolean isKillable() {
        return false;
    }



    @Override
    public void pickUp(Item item) throws IllegalStateException {
        if (itemList.size()>5) throw new IllegalStateException("A játékosnak nincs több helye a tárgyaknak.");
        itemList.add(item); // Only for testing, pickUp mechanism will be different
    }

    public void join(Transistor t1, Transistor t2) {
        if (t1.pair != null || t2.pair != null) throw new IllegalStateException("A tranzisztoroknak már van párjuk");
        t1.pair = t2;
        t2.pair = t1;
        System.out.println("A tranzisztorok párosítva lettek.");
    }

    public boolean isAlive() { return this.alive; }
    public void setAlive(final boolean alive) { this.alive = alive; }

    public boolean isMasked() { return this.masked; }
    public void setMasked(final boolean masked) { this.masked = masked; }

}
