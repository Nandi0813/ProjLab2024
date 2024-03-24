package com.bucikft.Tests;

import com.bucikft.Items.Hammer;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of the Hammer item.
 */
public class HammerUseTest {
    private Hammer TestHammer = new Hammer();
    private Student TestStudent = new Student();

    /**
     * Method to perform the Hammer item test.
     */
    public void hammerTest() {
        System.out.println("\nTesting the use of the Hammer.");
        try {
            TestStudent.use(TestHammer);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
