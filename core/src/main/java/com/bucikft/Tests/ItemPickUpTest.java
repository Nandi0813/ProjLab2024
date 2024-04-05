package com.bucikft.Tests;

import com.bucikft.Items.DKC;
import com.bucikft.Items.Interface.Item;
import com.bucikft.Person.Student;

/**
 * Class for testing the picking up of items by students.
 */
public class ItemPickUpTest {
    private Item TestItem = new DKC();
    private Student TestStudent = new Student();

    /**
     * Method to perform the item pick-up test.
     */
    public void itemPickUpTest() {
        System.out.println("\nTesting item pick-up.");
        try {
            TestStudent.pickUp(TestItem);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to pick up the item.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
