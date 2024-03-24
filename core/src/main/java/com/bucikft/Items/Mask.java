package com.bucikft.Items;
import com.bucikft.Person.Student;

import java.util.Scanner;

public class Mask extends Item{

    public void effect(Student user){
        Scanner scanner = new Scanner(System.in);
        // test if user already masked
        // todo: test if user already masked, meanwhile ask tester
        System.out.print("A hallgató már maszkot visel? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        if (choice) throw new IllegalStateException("A hallgató már maszkot visel");

        // put on mask
        // todo: implement putting on mask
        System.out.println("*A hallgató felvette a maszkot*");

        // break item
        this.setBroken(true);
    }
}
