package com.bucikft.Tests;
import com.bucikft.Items.*;
import com.bucikft.Person.Student;

public class EnergyDrinkTest {
    private EnergyDrink TestEnergyDrink = new EnergyDrink();
    private Student TestStudent = new Student();

    public void energyDrinkTest() {
        System.out.println("\nEndzsó használatának tesztelése.");
        try {
            TestStudent.use(TestEnergyDrink);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
