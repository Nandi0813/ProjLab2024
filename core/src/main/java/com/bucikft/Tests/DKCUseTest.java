package com.bucikft.Tests;
import com.bucikft.Items.DKC;
import com.bucikft.Person.Student;


public class DKCUseTest {
    private DKC TestDKC = new DKC();
    private Student TestStudent = new Student();

    public void DKCTest() {
        System.out.println("\nDKC használatának tesztelése.");
        try {
            TestStudent.use(TestDKC);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }


    }
}
