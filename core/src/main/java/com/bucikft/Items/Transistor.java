package com.bucikft.Items;
import com.bucikft.Person.Student;

import java.util.Scanner;


public class Transistor extends Item {
    public Transistor pair = null;
    public boolean putDown = false; // only for testing purposes
    public void effect(Student user) {
        Scanner scanner = new Scanner(System.in);

        // test if transistor has pair
        if (pair == null) throw new IllegalStateException("A tranzisztornak nincs párja");

        // test if pair has been put down
        System.out.print("A tranzisztor párja le van téve? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A tranzisztor párja nincs letéve");


        // if has pair, teleport
        // TODO implement teleportation
        System.out.println("*A játékos a másik tranzisztorhoz teleportált*");

        // break items
        this.setBroken(true);
        this.pair.setBroken(true);

    }
}
