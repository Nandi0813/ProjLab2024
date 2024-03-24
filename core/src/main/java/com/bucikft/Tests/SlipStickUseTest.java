package com.bucikft.Tests;

import com.bucikft.Items.SlipStick;

public class SlipStickUseTest extends ItemTest {
    private SlipStick TestSlipStick = new SlipStick();
    public void slipStickUseTest() {
        System.out.println("\nLogarléc használatának tesztelése.");
        System.out.print("A szoba rendelkezik vészkijárattal? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (choice) TestRoom.hasExit = true;
        TestStudent.pickUp(TestSlipStick);
        try {
            TestStudent.use(TestSlipStick);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }

    }
}
