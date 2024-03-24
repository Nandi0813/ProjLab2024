package com.bucikft.Items;
import com.bucikft.Person.Student;

import java.util.Scanner;

public class Hammer extends Item{

    public void effect(Student user){
        Scanner scanner = new Scanner(System.in);

        // test if room big enough for splitting
        // todo: implement test, meanwhile ask tester
        System.out.print("A szoba elég nagy ahhoz, hogy kettéosztható legyen? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        if (!choice) throw new IllegalStateException("A szoba nem osztható ketté");

        // split room
        // todo: implement room splitting
        System.out.println("*A szoba ketté lett osztva*");

        // break item
        this.setBroken(true);
    }
}
