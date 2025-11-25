package se.lexicon;

import java.util.Scanner;
import java.util.Random;

public class Main {

    // Shared Scanner and simple state
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int EXERCISE_COUNT = 8;
    private static String usernameInput;

    private static boolean MenuPrompt() {
        while (true) {
            System.out.print("\n[r] Repeat this exercise  |  [m] Return to menu: ");
            String choice = SCANNER.nextLine().trim().toLowerCase();
            if (choice.equals("r")) return true;   // repeat
            if (choice.equals("m")) return false;  // back to menu
            System.out.println("Press R to repeat exercise, or M for main menu");
        }
    }

    static void getUsername() {
        System.out.println("Enter your name");
        usernameInput = SCANNER.nextLine();
        System.out.println("Your name is Dennis " + usernameInput);
    }
    static void runExercise(int exerciseNumber) {
        boolean repeat;
        do {
            System.out.println("\nExercise " + exerciseNumber + " ");
            switch (exerciseNumber) {
                case 1 -> {
                    System.out.println("What is my name?");
                    System.out.println("Your name is Dennis");
                }
                case 2 -> {
                    System.out.println("Leap year check");
                    System.out.print("Enter a year: ");
                    int inputYear = SCANNER.nextInt();
                    SCANNER.nextLine();
                    if ((inputYear % 4 == 0 && inputYear % 100 != 0) || (inputYear % 400 == 0)) {
                        System.out.println("\n " + inputYear + " + is a leap year.");
                    } else {
                        System.out.println("\n " + inputYear + " is not a leap year.");
                    }
                    System.out.println("\nSummary of Rules:\r\n" + //
                            "A year is a leap year if it meets the following condition: \r\n" + //
                            "\r\n" + //
                            ">It is divisible by 4 AND not divisible by 100\r\n" + //
                            ">OR it is divisible by 400.");
                }
                case 3 -> {
                    System.out.println("calc print");
                    int result1 = 45 + 11;
                    System.out.printf("45 + 11 = %d%n", result1);
                    int result2 = 12 * 4;
                    System.out.printf("12 * 4 = %d%n", result2);
                    int result3 = 24 / 6;
                    System.out.printf("24 / 6 = %d%n", result3);
                    int result4 = 10 - 3;
                    System.out.printf("10 - 3 = %d%n", result4);
                }
                case 4 -> {
                    System.out.println("Average of 3 numbers.");
                    System.out.print("Enter first number: ");
                    int num1 = SCANNER.nextInt();
                    System.out.print("Enter second number: ");
                    int num2 = SCANNER.nextInt();
                    System.out.print("Enter third number: ");
                    int num3 = SCANNER.nextInt();
                    SCANNER.nextLine();

                    double average = (num1 + num2 + num3) / 3.0;
                    System.out.println("Average: " + average);
                }
                case 5 -> {
                    System.out.println("Username Input");
                    if (usernameInput == null || usernameInput.isBlank()) {
                        getUsername();
                    }
                    System.out.println("Hello, " + usernameInput + "!");
                }
                case 6 -> {
                    System.out.println("Sum, mult., div., sub.");

                    System.out.print("Enter first number: ");
                    int number1 = SCANNER.nextInt();

                    System.out.print("Enter second number: ");
                    int number2 = SCANNER.nextInt();
                    SCANNER.nextLine();

                    int subtraction = number1 - number2;
                    int sum = number1 + number2;
                    int multiplication = number1 * number2;
                    float division = (float) number1 / (float) number2;

                    System.out.printf(
                            "sub = " + subtraction + ", " + "sum = " + sum + ", " + "mult = " + multiplication + ", " + "div = " + division
                    );
                }
                case 7 -> {
                    System.out.println("Convert seconds to hours, minutes, and seconds.");
                    System.out.print("Enter total seconds: ");

                    long totalSeconds = SCANNER.nextLong();
                    SCANNER.nextLine();

                    long hours = (totalSeconds / 3600);
                    long remainingSeconds = (totalSeconds % 3600);
                    long minutes = remainingSeconds / 60;
                    long seconds = remainingSeconds % 60;

                    System.out.printf("%d:%02d:%02d%n", hours, minutes, seconds);
                }
                case 8 -> {
                    System.out.println("Rand guesser.");
                    Random random = new Random();
                    int randomNumber = random.nextInt(501);
                    int hint = randomNumber - 1;
                    System.out.println("hint: its close to " + hint + " ");
                    int guess = SCANNER.nextInt();
                    SCANNER.nextLine();
                    while (guess != randomNumber) {
                        System.out.println("Wrong guess, try again:");
                        guess = SCANNER.nextInt();
                    }
                    System.out.println("Correct! The number was: " + randomNumber);
                }
                default -> System.out.println("Exercise not implemented.");
            }
            repeat = MenuPrompt();
        } while (repeat);
    }
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nAvailable Exercises");
            for (int i = 1; i <= EXERCISE_COUNT; i++) {
                System.out.println(i + " - Exercise " + i);
            }
            System.out.println("0 - Exit");
            System.out.print("Choose an exercise to run: ");

            String input = SCANNER.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 0) {
                running = false;
            } else if (choice >= 1 && choice <= EXERCISE_COUNT) {
                runExercise(choice);
            } else {
                System.out.println("Invalid selection: " + choice);
            }
        }
        System.out.println("Goodbye!");
    }
}
    

