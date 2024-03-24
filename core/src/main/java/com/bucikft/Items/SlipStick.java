package com.bucikft.Items;
import com.bucikft.Person.Student;
import java.util.Scanner;

public class SlipStick extends Item{

    public void effect(Student user){
        Scanner scanner = new Scanner(System.in);

        // check if room has emergency exit
        // TODO implement checking if room has emergency exit
        System.out.print("A szoba rendelkezik vészkijárattal? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (!choice) throw new IllegalStateException("A szoba nem rendelkezik vészkijárattal.");

        // open exit
        // TODO implement exit opening
        System.out.println("*A vészkijárat kinyílt*");

        // break item
        this.setBroken(true);
    }
}
