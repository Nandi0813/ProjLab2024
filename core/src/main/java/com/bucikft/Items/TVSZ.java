package com.bucikft.Items;
import com.bucikft.Person.Student;

public class TVSZ extends Item {

    private int health;

    public void effect(Student user) {
        // test if broken
        if (getBroken() || health <0) throw new IllegalStateException("A TVSZ már el lett használva!");

        // protect user from professor
        // todo: implement protection
        System.out.print("*A TVSZ megvédi a felhasználóját a professzoroktól*");

        // decrease health and break item
        health--;
        if (health == 0) setBroken(true);

    }

    public void setHealth(int health) { this.health = health; }

    public int getHealth() { return health; }

}