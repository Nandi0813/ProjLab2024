package com.bucikft.Tests;

import com.bucikft.Items.SlipStick;
import com.bucikft.Person.Student;

public class ItemDropTest {
    private Student TestStudent = new Student();
    private SlipStick TestSlipStick = new SlipStick();
    public void itemDropTest() {
        try {
            TestStudent.drop(TestSlipStick);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A teszt sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }

    }
}
