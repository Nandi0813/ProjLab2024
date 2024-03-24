package com.bucikft.Tests;

import com.bucikft.Items.SlipStick;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of SlipStick items by students.
 */
public class SlipStickUseTest {
    private SlipStick TestSlipStick = new SlipStick();
    private Student TestStudent = new Student();

    /**
     * Method to perform the SlipStick use test.
     */
    public void slipStickUseTest() {
        System.out.println("\nTesting the use of SlipStick.");
        try {
            TestStudent.use(TestSlipStick);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
