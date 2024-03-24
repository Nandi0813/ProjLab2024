package com.bucikft.Tests;

import com.bucikft.Items.Transistor;

public class TransistorUseTest extends ItemTest {
    private Transistor TestTransistor1 = new Transistor();
    private Transistor TestTransistor2 = new Transistor();
    public void transistorUseTest() {
        System.out.println("\nTranzisztor használatának tesztelése.");
        TestStudent.pickUp(TestTransistor1);
        TestStudent.pickUp(TestTransistor2);
        System.out.println("A tranzisztorok párosítása.");
        System.out.print("Párosítva lettek már? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (choice) {
            TestTransistor1.pair = TestTransistor2;
            TestTransistor2.pair = TestTransistor1;
        }
        try {
            TestStudent.join(TestTransistor1, TestTransistor2);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tranzisztorok párosítása sikertelen.");
        }
        System.out.println("A tranzisztorok használata.");
        System.out.print("A tranzisztor párja le van téve? y/n: ");
        choice = scanner.next().equals("y");
        if (choice) TestTransistor2.putDown = true;
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
