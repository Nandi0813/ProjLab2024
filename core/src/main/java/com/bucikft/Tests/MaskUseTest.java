package com.bucikft.Tests;

import com.bucikft.Items.Mask;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of masks by students.
 */
public class MaskUseTest {
    private Mask TestMask = new Mask();
    private Student TestStudent = new Student();

    /**
     * Method to perform the mask use test.
     */
    public void maskTest() {
        System.out.println("\nTesting the use of masks.");
        try {
            TestStudent.use(TestMask);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
