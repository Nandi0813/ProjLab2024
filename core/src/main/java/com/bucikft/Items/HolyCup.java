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

        // display path to SlipStick
        // todo implement path display
        System.out.println("*Logarléchez vezető út megjelent*");

        // break item
        this.setBroken(true);


    }
}
