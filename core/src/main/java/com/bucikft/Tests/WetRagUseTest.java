package com.bucikft.Tests;

import com.bucikft.Items.WetRag;

public class WetRagUseTest extends ItemTest {
    private WetRag TestWetRag = new WetRag();

    public void wetRagUseTest() {
        TestStudent.pickUp(TestWetRag);
        try {
            TestWetRag.effect(TestStudent);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
