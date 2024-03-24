package com.bucikft.Tests;
import com.bucikft.Items.DKC;

public class DKCUseTest extends ItemTest {
    private DKC TestDKC = new DKC();

    public void DKCTest() {
        System.out.println("\nDKC használatának tesztelése.");
        System.out.print("A szoba már gázzal teli? y/n: ");
        boolean choice = scanner.next().charAt(0)=='y';
        TestRoom.setIsGassed(choice);
        TestStudent.pickUp(TestDKC);
        try {
            TestStudent.use(TestDKC);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }


    }
}
