package com.bucikft.Items;
import com.bucikft.Person.Student;

public class EnergyDrink extends Item{

    public void effect(Student user) throws IllegalStateException{
        // test if broken
        if(this.getBroken()) throw new IllegalStateException("Az Endzsó már el lett használva");

        // increase moves left
        user.setMovesLeft(user.getMovesLeft() + 1);
        System.out.println("*Az Endzsó elfogyasztása után a hallgató még egy lépést tehet*");

        // break item
        this.setBroken(true);
    }
}
