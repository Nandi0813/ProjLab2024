package com.bucikft;

import com.bucikft.Tests.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the menu for conducting skeleton tests in the game.
 */
public class SkeletonMenu {

    private static int bigChoice = 0;

    /**
     * The main method for running the skeleton menu.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (bigChoice != 3) {
            System.out.println("Skeleton test");
            System.out.println("1. Item interactions");
            System.out.println("2. Student interactions");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                bigChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid menu option (1, 2, 3)");
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
                    System.out.println("You have successfully exited. Goodbye!");
                    break;
                default:
                    System.out.println("Please enter a valid menu option (1, 2, 3)");
                    break;
            }
        }
        scanner.close();
    }

    private static void handleStudentInteractions(Scanner scanner) {
        int choice = 0;
        while (choice != 3) {
            System.out.println("Student interactions:");
            System.out.println("1. Move student");
            System.out.println("2. Kill student");
            System.out.println("3. Go back");
            System.out.print("Choose an interaction: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid menu option.");
                scanner.next();
                continue;
            }
            switch (choice) {
                case 1:
                    StudentMoveTest test1 = new StudentMoveTest();
                    test1.studentMoveTest();
                    break;
                case 2:
                    StudentKillTest test2 = new StudentKillTest();
                    test2.studentKillTest();
                    break;
                case 3:
                    choice = 3;
                    bigChoice = 0;
                    return;
                default:
                    System.out.println("Please enter a valid menu option!");
                    break;
            }
        }
    }

    private static void handleItemInteractions(Scanner scanner) {
        int choice = 0;

        while (choice != 11) {
            System.out.println("Item interactions:");
            System.out.println("1. Use DKC");
            System.out.println("2. Use Energy Drink");
            System.out.println("3. Use Holy Cup");
            System.out.println("4. Use Wet Rag");
            System.out.println("5. Use Zyn");
            System.out.println("6. Use TVSZ");
            System.out.println("7. Use Transistors");
            System.out.println("8. Drop Item");
            System.out.println("9. Use Mask");
            System.out.println("10. Use Hammer");
            System.out.println("11. Go back");
            System.out.print("Choose an interaction: ");

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid menu option.");
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
                    test2.energyDrinkTest();
                    break;
                case 3:
                    HolyCupTest test3 = new HolyCupTest();
                    test3.holyCupTest();
                    break;
                case 4:
                    WetRagUseTest test4 = new WetRagUseTest();
                    test4.wetRagUseTest();
                    break;
                case 5:
                    ZynUseTest test5 = new ZynUseTest();
                    test5.zynUseTest();
                    break;
                case 6:
                    TVSZUseTest test6 = new TVSZUseTest();
                    test6.TVSZUseTest();
                    break;
                case 7:
                    TransistorUseTest test7 = new TransistorUseTest();
                    test7.transistorUseTest();
                    break;
                case 8:
                    ItemDropTest test8 = new ItemDropTest();
                    test8.itemDropTest();
                    break;
                case 9:
                    MaskUseTest test9 = new MaskUseTest();
                    test9.maskTest();
                    break;
                case 10:
                    HammerUseTest test10 = new HammerUseTest();
                    test10.hammerTest();
                    break;
                case 11:
                    choice = 11;
                    bigChoice = 0;
                    return;
                default:
                    System.out.println("Please enter a valid menu option!");
                    break;
            }
        }
    }
}
