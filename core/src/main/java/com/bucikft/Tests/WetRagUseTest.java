package com.bucikft.Tests;

import com.bucikft.Items.WetRag;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of WetRag.
 */
public class WetRagUseTest {
    private WetRag TestWetRag = new WetRag();
    private Student TestStudent = new Student();

    /**
     * Method to perform the WetRag use test.
     */
    public void wetRagUseTest() {
        try {
            TestStudent.use(TestWetRag);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }
    }
}
