package com.bucikft.Items;
import com.bucikft.Person.Student;


public class Transistor extends Item {
    public Transistor pair = null;
    public boolean putDown = false; // only for testing purposes
    public void effect(Student user) {
        // test if broken or unpaired or pair not put down
        if (this.getBroken() || this.pair.getBroken()) throw new IllegalStateException("A tranzisztor már el lett használva");
        if (pair == null) throw new IllegalStateException("A tranzisztornak nincs párja");
        if (!pair.putDown) throw new IllegalStateException("A tranzisztor párja nincs letéve");


        // if has pair, teleport
        // TODO implement teleportation
        System.out.println("*A játékos a másik tranzisztorhoz teleportált*");

        // break items
        this.setBroken(true);
        this.pair.setBroken(true);

    }
}
