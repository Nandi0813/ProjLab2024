package com.bucikft;
import java.util.Scanner;

public class Menu {

    private static Game game;

    private static int bigChoice = 0;

    public static Game getGame() {
        return game;
    }

    public static void main(String[] args) {

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

            switch (bigChoice) {
                case 1:
                    while(!game.isStarted()) {
                        try {
                            System.out.println("Enter a map file:");
                            scanner.nextLine();
                            game.getProtoTest().MapLoad("C:\\Users\\Dani\\Desktop\\Projlab\\ProjLab2024\\core\\src\\main\\java\\com\\bucikft\\map.txt");
                            System.out.println(game.isStarted());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
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
        game = new Game();
        System.out.println("welcome to the game!");
        while(!game.isStarted()) {
            try {
                game.getProtoTest().MapLoad("C:\\Users\\Dani\\Desktop\\Projlab\\ProjLab2024\\core\\src\\main\\java\\com\\bucikft\\map.txt");
                System.out.println(game.isStarted());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
}





