package com.bucikft.Person;

import com.bucikft.Items.Item;
import com.bucikft.Items.Transistor;

import java.util.Scanner;

public class Student extends Person {

    private boolean alive;
    private boolean masked = false;

    public void use(Item item) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("A hallgató tud még tárgyat használni körében? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        if (!choice) throw new IllegalStateException("A hallgató nem tud több tárgyat használni.");
        item.effect(this);
    }

    public void drop(Item item) {
        Scanner scanner = new Scanner(System.in);

        // test if room has enough room for the item
        // todo
        System.out.println("Van elég hely a szobában a tárgynak? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("Nincs elég hely a tárgynak a szobában.");

        // drop item
        // todo
        System.out.println("*A tárgy lehelyeződött a szobában*");

        // remove item from inventory
        // todo
        System.out.println("*A tárgy eltávolítva a játékos eszköztárjából*");


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
