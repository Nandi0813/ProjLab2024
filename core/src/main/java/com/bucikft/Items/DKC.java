package com.bucikft.Items;
import com.bucikft.Person.Student;


public class DKC extends Item {

    public void effect(Student user) throws IllegalStateException {
        // test if room gassed or item broken
        if(user.getCurrentRoom().isGassed()) throw new IllegalStateException("A szoba már gázzal teli");
        if( this.getBroken()) throw new IllegalStateException("A DKC már el lett használva");

        // gas room
        user.getCurrentRoom().setIsGassed(true);
        System.out.println("*A szoba gázzal lett feltöltve*");

        // break item
        this.setBroken(true);
    }
}
