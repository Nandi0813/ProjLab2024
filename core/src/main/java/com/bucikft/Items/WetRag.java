package com.bucikft.Items;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

public class WetRag extends Item{

    public void effect(Student user){
        // test if broken
        if (getBroken()) throw new IllegalStateException("A Nedves Táblarörlő Rongy már el lett használva!");

        // stun all professors in room
        for (Person p : user.getCurrentRoom().getPersonList()){
            if (p instanceof Professor) ((Professor) p).stun(3);

        }
        System.out.print("*A Nedves Táblarörlő Rongy megbénítja a professzorokat*");


        // break item
        setBroken(true);
    }
}
