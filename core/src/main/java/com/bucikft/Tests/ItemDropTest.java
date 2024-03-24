package com.bucikft.Tests;

import com.bucikft.Items.SlipStick;
import com.bucikft.Person.Student;

/**
 * Class for testing the dropping of items by students.
 */
public class ItemDropTest {
    private Student TestStudent = new Student();
    private SlipStick TestSlipStick = new SlipStick();

    /**
     * Method to perform the item drop test.
     */
    public void itemDropTest() {
        try {
            TestStudent.drop(TestSlipStick);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("The test failed.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
