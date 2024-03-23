package com.bucikft.Tests;

import com.bucikft.Items.HolyCup;
import com.bucikft.Person.Student;

public class HolyCupTest {
    private Student Test3Student = new Student();
    private HolyCup Test3HolyCup = new HolyCup();

    public void HolyCupTest() {
        Test3HolyCup.effect(Test3Student);

        System.out.println("Az Logarléchez vezető út megjelent.");
    }
}
