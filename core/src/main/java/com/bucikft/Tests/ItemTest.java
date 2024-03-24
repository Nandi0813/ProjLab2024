package com.bucikft.Tests;

import com.bucikft.Person.Student;
import com.bucikft.Room;

import java.util.Scanner;

public abstract class ItemTest {
    protected Room TestRoom = new Room();
    protected Student TestStudent = new Student();
    protected Scanner scanner = new Scanner(System.in);

    public ItemTest() {

        TestStudent.setCurrentRoom(TestRoom);
        System.out.print("A hallgató tud még tárgyat használni körében? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        if (choice) TestStudent.setMovesLeft(1);
        else TestStudent.setMovesLeft(0);

    }
}
