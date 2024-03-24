package com.bucikft.Tests;

import com.bucikft.Items.HolyCup;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of the HolyCup item.
 */
public class HolyCupTest {
    private HolyCup TestHolyCup = new HolyCup();
    private Student TestStudent = new Student();

    /**
     * Method to perform the HolyCup item test.
     */
    public void holyCupTest() {
        try {
            TestStudent.use(TestHolyCup);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
