package com.bucikft.Items;
import com.bucikft.Person.Student;

public class HolyCup extends Item{

    private int turns;

    public int getTurns() {
        return turns;
    }

    public void setTurns(int newTurns) {
        turns = newTurns;
    }

    public void effect(Student user) throws IllegalStateException {
        // test if item broken
        if(this.getBroken()) throw new IllegalStateException("A Szent Söröspohár már el lett használva!");

        // display path to SlipStick
        // todo implement path display
        System.out.println("*Logarléchez vezető út megjelent*");

        // break item
        this.setBroken(true);


    }
}
