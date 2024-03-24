package com.bucikft.Items;
import com.bucikft.Person.Student;

public class Hammer extends Item{

    public void effect(Student user){
        // test if item broken or room unsplittable
        if( this.getBroken()) throw new IllegalStateException("A kalapács már el lett használva");
        // simplified for skeleton, will check more conditions
        if(user.getCurrentRoom().getCapacity()<2) throw new IllegalStateException("A szoba nem kettéosztható!");

        // split room
        // todo: implement room splitting
        System.out.println("*A szoba ketté lett osztva*");

        // break item
        this.setBroken(true);
    }
}
