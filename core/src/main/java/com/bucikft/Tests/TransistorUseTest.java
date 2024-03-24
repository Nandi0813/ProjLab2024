package com.bucikft.Tests;

import com.bucikft.Items.Transistor;
import com.bucikft.Person.Student;

public class TransistorUseTest {
    private Transistor TestTransistor1 = new Transistor();
    private Transistor TestTransistor2 = new Transistor();
    private Student TestStudent = new Student();

    public void transistorUseTest() {
        System.out.println("\nTranzisztor használatának tesztelése.");
        System.out.println("A tranzisztorok párosítása.");
        try {
            TestStudent.join(TestTransistor1, TestTransistor2);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tranzisztorok párosítása sikertelen.");
        }
        System.out.println("A tranzisztorok használata.");
        try {
            TestStudent.use(TestTransistor1);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }

    }
}
