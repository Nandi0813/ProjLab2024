package com.bucikft.Items;
import com.bucikft.Person.Student;

import java.util.Scanner;

public class TVSZ extends Item {

    private int health;

    public void effect(Student user) throws IllegalStateException {

        // protect user from professor
        // todo: implement protection
        System.out.println("*A TVSZ megvédi a felhasználóját a professzoroktól*");

        // decrease health and break item
        health--;
        if (health == 0) setBroken(true);

    }

    public void setHealth(int health) { this.health = health; }

    public int getHealth() { return health; }

}