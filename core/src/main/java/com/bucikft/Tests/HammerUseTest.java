package com.bucikft.Tests;

import com.bucikft.Items.Hammer;

public class HammerUseTest extends ItemTest {
    private Hammer TestHammer = new Hammer();

    public void HammerTest() {
        System.out.println("\nKalapács használatának tesztelése.");
        System.out.print("A szoba elég nagy ahhoz, hogy kettéosztható legyen? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        TestRoom.setCapacity(choice?2:1);
        TestStudent.pickUp(TestHammer);
        try {
            TestStudent.use(TestHammer);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }
}
