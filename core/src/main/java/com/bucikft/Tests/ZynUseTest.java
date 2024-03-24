package com.bucikft.Tests;
import com.bucikft.Person.Student;
import com.bucikft.Items.Zyn;

public class ZynUseTest extends ItemTest {
    private Zyn TestZyn = new Zyn();
    private Student TestStudent2 = new Student();

    public void zynUseTest() {
        System.out.println("\nSnüci használatának tesztelése.");
        TestStudent.pickUp(TestZyn);
        System.out.println("Van a szobában halott hallgató? y/n: ");
        boolean choice = scanner.next().equals("y");
        if (choice) {
            TestStudent2.setAlive(false);
        }
        TestStudent2.setCurrentRoom(TestRoom);
        try {
            TestStudent.use(TestZyn);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("A tárgy használata sikertelen.");
        } finally {
            System.out.println("A teszt véget ért.\n");
        }
    }


}
