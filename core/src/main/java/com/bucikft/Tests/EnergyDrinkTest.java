package com.bucikft.Tests;
import com.bucikft.Person.Student;
import com.bucikft.Items.*;

public class EnergyDrinkTest {
    private Student Test1Student = new Student();
    private EnergyDrink Test1EnergyDrink = new EnergyDrink();

    public void EnergyDrinkTest() {
        Test1Student.setMovesLeft(0);
        if (Test1Student.getMovesLeft() == 0) {
            System.out.println("Test1Student-nek nincs több lépése.");
            Test1EnergyDrink.effect(Test1Student);
            System.out.println("Test1Student Endzsót használt.");
            if(Test1Student.getMovesLeft() == 1) {
                System.out.println("Test1Student-nek egy lépése van.\nSikeres teszt");
            }
            else {
                System.out.println("Sikertelen teszt");
            }
        }
        else {
            System.out.println("Sikertelen teszt");
        }
    }
}
