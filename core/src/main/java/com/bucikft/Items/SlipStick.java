package com.bucikft.Items;
import com.bucikft.Person.Student;

public class SlipStick extends Item{

    public void effect(Student user){
        // test if broken
        if (this.getBroken()) throw new IllegalStateException("A Logarléc már el lett használva");
        // check if room has emergency exit - TODO
        // for now: (only for testing purposes, attribute will be removed)
        if (!user.getCurrentRoom().hasExit) throw new IllegalStateException("A szoba nem rendelkezik vészkijárattal");

        // open exit
        // TODO implement exit opening
        System.out.println("*A vészkijárat kinyílt*");

        // break item
        this.setBroken(true);
    }
}
