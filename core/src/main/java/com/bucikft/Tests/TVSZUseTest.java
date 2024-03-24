package com.bucikft.Tests;

import com.bucikft.Items.TVSZ;

public class TVSZUseTest extends ItemTest {
    private TVSZ TestTVSZ = new TVSZ();
    public void TVSZUseTest() {
        System.out.println("\nTVSZ használatának tesztelése.");
        TestStudent.pickUp(TestTVSZ);
        try {
            TestStudent.use(TestTVSZ);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }

    }
}
