package com.bucikft.Items;
import com.bucikft.Person.Student;
import java.util.Scanner;

public class DKC extends Item {

    public void effect(Student user) throws IllegalStateException {
        // test if room gassed
        // todo: test if room is gas filled, meanwhile ask tester
        Scanner scanner = new Scanner(System.in);
        System.out.print("A szoba már gázzal teli? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        if(choice) throw new IllegalStateException("A szoba már gázzal teli.");

        // gas room
        // todo: implement filling room with gas
        System.out.println("*A szoba gázzal lett feltöltve*");

        // break item
        this.setBroken(true);
    }
}
