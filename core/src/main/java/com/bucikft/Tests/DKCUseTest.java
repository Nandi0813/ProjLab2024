package com.bucikft.Tests;
import com.bucikft.Room;
import com.bucikft.Person.Student;
import com.bucikft.Items.DKC;

public class DKCUseTest {
    private Room Test1Room = new Room();
    private Student Test1Student = new Student();
    private DKC Test1DKC = new DKC();

    public void DKCTest() {
        Test1Room.setIsGassed(false);
        Test1Student.setCurrentRoom(Test1Room);
        Test1DKC.effect(Test1Student);

        if (Test1Room.isGassed()) {
            System.out.println("Test1Room gassed: ");
            System.out.println(Test1Room.isGassed());
            System.out.println("Sikeres! ");
        } else {
            System.out.println("Sikertelen teszt");
        }
    }
}
