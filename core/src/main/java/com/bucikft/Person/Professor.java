package com.bucikft.Person;

import com.bucikft.Items.Item;
import com.bucikft.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Professor extends Person {

    private List<Student> killedStudents;

    public Professor() {
        this.killedStudents = new ArrayList<>();
    }
    private int stunned = 0;
    public void stun(int n) {
        stunned = n;
    }
    public int isStunned() {
        return stunned;
    }


    public void addKilledStudent(Student killedStudent) {
        killedStudents.add(killedStudent);
    }

    public void removeKilledStudent(Student killedStudent) {
        killedStudents.remove(killedStudent);
    }

    public void killStudent(Student student) {
        Scanner scanner = new Scanner(System.in);

        //check if student is in the same room
        // todo
        System.out.println("A hallgató és a professzor egy szobában vannak? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A hallgató és a professzor nem egy szobában vannak.");

        // check if student is alive
        // todo
        System.out.println("A hallgató él? y/n: ");
        choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A hallgató már halott.");

        // check if student is protected
        // todo
        System.out.println("A hallgató védve van? y/n: ");
        choice = scanner.next().equals("y");
        if (choice) throw new IllegalStateException("A hallgató védve van.");

        // check if prof has moves left in his turn
        // todo
        System.out.println("Van még lépése hátra a professzornak? y/n: ");
        choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A professzornak nincs több lépése.");


        // kill student
        // todo
        System.out.println("*A hallgató meghalt*");

        // todo:
        // decrease moves of professor
        // add to killed students
    }


    @Override
    public void pickUp(Item item) {

    }

}
