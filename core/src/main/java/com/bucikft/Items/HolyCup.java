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

    public void effect(Student user){
        if(!this.getBroken()) {
            this.setBroken(true);
        } else {
            System.out.println("A Szent Söröspohár már el lett használva.");
        }
    }

}
