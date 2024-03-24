package com.bucikft.Tests;
import com.bucikft.Person.Student;
import com.bucikft.Items.Zyn;

public class ZynUseTest {
    private Zyn TestZyn = new Zyn();
    private Student TestStudent2 = new Student();
    private Student TestStudent = new Student();

    public void zynUseTest() {
        System.out.println("\nSnüci használatának tesztelése.");
        try {
            TestStudent.use(TestZyn);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }


}
