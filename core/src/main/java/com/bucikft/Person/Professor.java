package com.bucikft.Person;

import com.bucikft.Items.Item;
import com.bucikft.Room;

import java.util.ArrayList;
import java.util.List;

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
        student.setAlive(false);
    }


    @Override
    public void pickUp(Item item) {

    }

}
