package com.bucikft.Items;
import com.bucikft.Person.Student;

public class EnergyDrink extends Item{

    public void effect(Student user){
        if(!this.getBroken()) {
            user.setMovesLeft(user.getMovesLeft() + 1);
            this.setBroken(true);
        }
        else
            System.out.println("Az Endzsó már el lett használva");
    }
}
