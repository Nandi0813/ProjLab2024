package com.bucikft;

import com.bucikft.Tests.DKCUseTest;
import com.bucikft.Tests.EnergyDrinkTest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SkeletonMenu {

    private static int bigChoice = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(bigChoice != 3) {
            System.out.println("Szkeleton teszt");
            System.out.println("1. Tárgy interakciók");
            System.out.println("2. Hallgató interakciók");
            System.out.println("3. Kilépés");
            System.out.print("Válasszon menüpontot: ");

            try {
                bigChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Adjon meg egy helyes menüpontot (1, 2, 3)");
                scanner.next();
                continue;
            }

            switch (bigChoice) {
                case 1:
                    handleItemInteractions(scanner);
                    break;
                case 2:
                    handleStudentInteractions(scanner);
                    break;
                case 3:
                    System.out.println("Ügyesen kiléptél. Szép munka barátom!");
                    break;
                default:
                    System.out.println("Adjon meg egy helyes menupontot (1, 2, 3)");
                    break;
            }
        }
        scanner.close();
    }

    private static void handleStudentInteractions(Scanner scanner){
        System.out.println("Hallgató interakciók:");
        System.out.println("1. Hallgató mozgatása");
        System.out.println("2. Hallgató megölése");
        System.out.println("3. Visszalépés");
        System.out.print("Válasszon interakciót: ");
        int choice = scanner.nextInt();
    }

    private static void handleItemInteractions(Scanner scanner){
        int choice = 0;

        while(choice != 11) {
            System.out.println("Tárgy interakciók:");
            System.out.println("1. DKC használata");
            System.out.println("2. Endzsó használata");
            System.out.println("3. Szent Söröspohár használata");
            System.out.println("4. Nedves táblatörlő rongy használata");
            System.out.println("5. Snüci használata");
            System.out.println("6. TVSZ használata");
            System.out.println("7. Tranzisztorok használata");
            System.out.println("8. Tárgy lehelyezése");
            System.out.println("9. Maszk használata");
            System.out.println("10. Martin Kalapácsának használata");
            System.out.println("11. Visszalépés");
            System.out.print("Válasszon interakciót: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Adjon meg egy helyes menüpontot.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    DKCUseTest test1 = new DKCUseTest();
                    test1.DKCTest();
                    break;
                case 2:
                    EnergyDrinkTest test2 = new EnergyDrinkTest();
                    test2.EnergyDrinkTest();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:
                    choice = 11;
                    bigChoice = 0;
                    return;
                default:
                    System.out.println("Adjon meg egy helyes menüpontot!");
                    break;
            }
        }
    }
}
