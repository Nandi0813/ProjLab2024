package com.bucikft.Tests;

import com.bucikft.Items.EnergyDrink;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of Energy Drink item.
 */
public class EnergyDrinkTest {
    private EnergyDrink TestEnergyDrink = new EnergyDrink();
    private Student TestStudent = new Student();

    /**
     * Method to perform the Energy Drink item test.
     */
    public void energyDrinkTest() {
        System.out.println("\nTesting the use of Energy Drink.");
        try {
            TestStudent.use(TestEnergyDrink);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
