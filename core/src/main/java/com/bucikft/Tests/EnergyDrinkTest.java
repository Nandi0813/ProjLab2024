package com.bucikft.Tests;
import com.bucikft.Items.*;

public class EnergyDrinkTest extends ItemTest {
    private EnergyDrink Test1EnergyDrink = new EnergyDrink();

    public void EnergyDrinkTest() {
        System.out.println("\nEndzsó használatának tesztelése.");
        TestStudent.pickUp(Test1EnergyDrink);
        try {
            TestStudent.use(Test1EnergyDrink);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
