package com.bucikft.Tests;

import com.bucikft.Items.DKC;
import com.bucikft.Items.Item;
import com.bucikft.Person.Student;

public class ItemPickUpTest {
    private Item TestItem = new DKC();
    private Student TestStudent = new Student();

    public void ItemPickUpTest() {
        System.out.println("\nTárgy felvétele tesztelése.");
        try {
            TestStudent.pickUp(TestItem);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy felvétele sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }

    }
}
