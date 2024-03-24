package com.bucikft.Items;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;

public class Zyn extends Item{

    public void effect(Student user) {
        // test if broken
        if (this.getBroken()) throw new IllegalStateException("A Snüci már el lett használva.");

        // Revive the first dead student in the room
        for (Person student : user.getCurrentRoom().getPersonList()) {
            if (student instanceof Student) {
                if (!((Student) student).isAlive()) {
                    ((Student) student).setAlive(true);
                    System.out.println("A Snüci hatására a hallgató újra életre kelt.");

                    // break item
                    this.setBroken(true);
                    return;
                }
            }
        }
    }
}
