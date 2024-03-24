package com.bucikft.Items;
import com.bucikft.Person.Person;
import com.bucikft.Person.Professor;
import com.bucikft.Person.Student;

public class WetRag extends Item{

    public void effect(Student user){

        // stun all professors in room
        // todo: implement stunning professors
        System.out.print("*A Nedves Táblarörlő Rongy megbénítja a professzorokat*");


        // break item
        setBroken(true);
    }
}
