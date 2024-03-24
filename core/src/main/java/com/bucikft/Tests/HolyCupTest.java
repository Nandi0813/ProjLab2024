package com.bucikft.Tests;

import com.bucikft.Items.HolyCup;

public class HolyCupTest extends ItemTest{
    private HolyCup TestHolyCup = new HolyCup();

    public void holyCupTest() {
        TestStudent.pickUp(TestHolyCup);
        try {
            TestStudent.use(TestHolyCup);
            System.out.println("A Szent Söröspohár használata sikeres volt.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A Szent Söröspohár használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
