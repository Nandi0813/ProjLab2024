package com.bucikft;

import com.bucikft.Views.*;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Game game; // Added to keep track of the game

    private static int bigChoice = 0; // Added to keep track of the menu choice

    /**
     * The path to the map file.
     */
    public static String mapPath = System.getProperty("user.dir") + File.separator +
            "src" + File.separator +
            "main" + File.separator +
            "java" + File.separator +
            "com" + File.separator +
            "bucikft" + File.separator +
            "map.txt";

    /**
     * Retrieves the game object.
     * @return The game object.
     */
    public static Game getGame() {
        return game;
    }

    /**
     * The main method of the game.
     * @param args The arguments of the game.
     */
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        Scanner scanner = new Scanner(System.in);

        while (bigChoice != 3) {
            System.out.println("Skeleton test");
            System.out.println("1. Free play");
            System.out.println("2. Tests");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            try {
                bigChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid menu option (1, 2, 3)");
                scanner.next();
                continue;
            }
            game = new Game();

            switch (bigChoice) {
                case 1:
                    while(!game.isStarted()) {
                        try {
                            System.out.println("welcome to the game!");
                            System.out.println("Enter a map file:");
                            game.getProtoTest().MapLoad(mapPath, false, null);
                            System.out.println(game.isStarted());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    handleTests(scanner);
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

    /**
     * Handles the tests.
     * @param scanner The scanner object to read user input.
     */
    private static void handleTests(Scanner scanner) {
        int choice = 0;
        while (choice != 16) {
            TestClass tc = new TestClass();
            game = new Game();
            System.out.println("Student interactions:");
            System.out.println("1. DKC Use Test");
            System.out.println("2. Air Freshener Use Test");
            System.out.println("3. Energy Drink Use Test");
            System.out.println("4. Holy Cup Use Test");
            System.out.println("5. Hammer Use Test");
            System.out.println("6. SlipStick Use Test");
            System.out.println("7. Transistor Use Test");
            System.out.println("8. TVSZ Use Test");
            System.out.println("9. Wetrag Use Test");
            System.out.println("10. Student Move Test");
            System.out.println("11. Student Kill Test");
            System.out.println("12. Kill Defend Test");
            System.out.println("13. Move Cleaner");
            System.out.println("14. Air Test");
            System.out.println("15. Zyn Test");
            System.out.println("16. Back");
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
                    try {
                        System.out.println("Test One");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input1.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Test Two");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input2.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    try {
                        System.out.println("Test Three");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input3.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Test Four");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input4.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Test Five");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input5.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Test Six");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input6.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Test Seven");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input7.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println("Test Eight");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input8.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        System.out.println("Test Nine");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input9.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 10:
                    try {
                        System.out.println("Test Ten");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input10.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 11:
                    try {
                        System.out.println("Test Eleven");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input11.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 12:
                    try {
                        System.out.println("Test Twelve");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input12.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 13:
                    try {
                        System.out.println("Test Thirteen");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input13.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 14:
                    try {
                        System.out.println("Test Fourteen");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input14.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 15:
                    try {
                        System.out.println("Test Fifteen");
                        String currentDirectory = System.getProperty("user.dir");
                        String inputRelativePath = currentDirectory + File.separator +
                                "src" + File.separator +
                                "main" + File.separator +
                                "java" + File.separator +
                                "com" + File.separator + "bucikft" + File.separator +
                                "Tests" + File.separator + "input15.txt";
                        tc.MakeTest(mapPath, inputRelativePath, game);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 16:
                    bigChoice = 0;
                    break;
                default:
                    System.out.println("Please enter a valid menu option!");
                    break;
            }
        }
    }
}





