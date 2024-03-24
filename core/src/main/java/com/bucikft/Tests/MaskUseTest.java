package com.bucikft.Tests;

import com.bucikft.Items.Mask;

public class MaskUseTest extends ItemTest{
    private Mask TestMask = new Mask();

    public void MaskTest() {
        System.out.println("\nMaszk használatának tesztelése.");
        System.out.print("A hallgató már maszkot visel? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        TestStudent.setMasked(choice);
        TestStudent.pickUp(TestMask);
        try {
            TestStudent.use(TestMask);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
