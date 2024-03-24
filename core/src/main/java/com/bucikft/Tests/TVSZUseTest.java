package com.bucikft.Tests;

import com.bucikft.Items.TVSZ;
import com.bucikft.Person.Student;

/**
 * Class for testing the use of TVSZ.
 */
public class TVSZUseTest {
    private TVSZ TestTVSZ = new TVSZ();
    private Student TestStudent = new Student();

    /**
     * Method to perform the TVSZ use test.
     */
    public void TVSZUseTest() {
        System.out.println("\nTesting the use of TVSZ.");
        try {
            TestStudent.use(TestTVSZ);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to use the item.");
        } finally {
            System.out.println("End of the test.\n");
        }

    }
}
