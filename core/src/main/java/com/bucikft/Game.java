package com.bucikft;

import com.bucikft.Person.Student;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Map map;
    private RoundManager roundManager;
    private List<Student> students;
    private List<Student> deadStudents;

    public Game() {
        this.map = new Map();
        this.roundManager = new RoundManager(this);
        this.students = new ArrayList<>();
        this.deadStudents = new ArrayList<>();
    }

    public void startGame() {

    }

    public void endGame() {

    }

    public Map getMap() { return this.map; }
    public List<Student> getStudents() { return this.students; }
    public List<Student> getDeadStudents() { return this.deadStudents; }

}
