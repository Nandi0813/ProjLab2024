package com.bucikft.Items;
import com.bucikft.Person.Person;
import com.bucikft.Person.Student;

import java.util.Scanner;

public class Zyn extends Item{

    public void effect(Student user) {
        Scanner scanner = new Scanner(System.in);

        // test if room has dead student
        // todo: implement check, for now ask tester
        System.out.println("Van a szobában halott hallgató? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A szobában nincs halott hallgató.");

        // Revive the first dead student in the room
        // todo: implement reviving
        System.out.println("*A Snüci életre kelti az első halott hallgatót a szobában*");

        // break item
        setBroken(true);
    }
}
