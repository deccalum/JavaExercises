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
            System.out.printf("%n[r] Repeat this exercise  |  [m] Return to menu: ");
            String choice = SCANNER.nextLine().trim().toLowerCase();
            if (choice.equals("r")) return true;
            if (choice.equals("m")) return false;
            System.out.printf("%n[r] Repeat this exercise  |  [m] Return to menu: .%n");
        }
    }

    static void getUsername() {
        System.out.printf("Enter username: ");
        usernameInput = SCANNER.nextLine();
        System.out.printf("Your Username is %s%n", usernameInput);
    }
    static void runExercise(int exerciseNumber) {
        boolean repeat;
        do {
            System.out.printf("%nExercise %d - ", exerciseNumber);
            switch (exerciseNumber) {
                case 1 -> {
                    System.out.printf("'What is my name?'%n");
                    System.out.printf("Hello!%n");
                    System.out.printf("Your name is Dennis%n");
                }
                case 2 -> {
                    System.out.printf("Leap year check%n");
                    System.out.printf("Enter a year: ");
                    int inputYear = SCANNER.nextInt();
                    SCANNER.nextLine();
                    if ((inputYear % 4 == 0 && inputYear % 100 != 0) || (inputYear % 400 == 0)) {
                        System.out.printf("%nYear %d is a leap year.%n", inputYear);
                    } else {
                        System.out.printf("%nYear %d is not a leap year.%n", inputYear);
                    }

                    System.out.printf(
                    "Leap year rules use these conditions:%n%n" +
                    "\"It is divisible by 4 AND not divisible by 100.%n" +
                    "OR it is evenly divisible by 400.\"%n"
                    );
                    System.out.printf("%d / 4 = %.2f%n",   inputYear, inputYear / 4f);
                    System.out.printf("%d / 100 = %.2f%n", inputYear, inputYear / 100f);
                    System.out.printf("%d / 400 = %.2f%n", inputYear, inputYear / 400f);
                }
                case 3 -> {
                    System.out.printf("Simple calculations%n%n");
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
                    System.out.printf("Average of 3 numbers.%n");

                    int[] numbs = new int[3];
                    int count = 0;

                    while (count < 3) {
                        System.out.printf("%nEnter number %d: ", (count + 1));
                        String line = SCANNER.nextLine();
                        numbs[count] = Integer.parseInt(line);
                        count++;
                    }
                    int sum = numbs[0] + numbs[1] + numbs[2];
                    double average = (double) sum / count;
                    double avgRounded = Math.round(average * 100.0) / 100.0;
                    System.out.printf("%nThe average of %d, %d, and %d is: %.2f%n", numbs[0], numbs[1], numbs[2], avgRounded);
                }
                case 5 -> {
                    System.out.printf("Username Input%n");
                    if (usernameInput == null || usernameInput.isBlank()) {
                        getUsername();
                    }
                    System.out.printf("Hello %s%n%n", usernameInput);
                }
                case 6 -> {
                    System.out.printf("subtraction, addition, multiplication, division.%n");

                    System.out.printf("Enter first number: ");
                    int number1 = SCANNER.nextInt();

                    System.out.printf("Enter second number: ");
                    int number2 = SCANNER.nextInt();
                    SCANNER.nextLine();

                    int subtraction = number1 - number2;
                    int sum = number1 + number2;
                    int multiplication = number1 * number2;
                    double division = (double) number1 / (double) number2;
                    double divRounded = Math.round(division * 100.0) / 100.0;

                    System.out.printf("%d - %d = %d%n", number1, number2, subtraction);
                    System.out.printf("%d + %d = %d%n", number1, number2, sum);
                    System.out.printf("%d * %d = %d%n", number1, number2, multiplication);
                    System.out.printf("%d / %d = %.2f%n%n", number1, number2, divRounded);
                }
                case 7 -> {
                    System.out.printf("Convert seconds to hours, minutes, and seconds.%n");
                    System.out.printf("Enter total seconds: ");

                    long totalSeconds = SCANNER.nextLong();
                    SCANNER.nextLine();

                    long hours = (totalSeconds / 3600);
                    long remainingSeconds = (totalSeconds % 3600);
                    long minutes = remainingSeconds / 60;
                    long seconds = remainingSeconds % 60;
                    System.out.printf("%n%d seconds is equal to:%n", totalSeconds);
                    System.out.printf("%dh %dm %ds%n", hours, minutes, seconds);
                }
                case 8 -> {
                    System.out.printf("Random Guesser.%n");
                    Random random = new Random();
                    int randomNumber = random.nextInt(501);

                    int attempts = 0;
                    boolean hintShown = false;

                    while (true) {
                        System.out.printf("Guess a number between 0 and 500: ");

                        int guess = SCANNER.nextInt();
                        attempts++;

                        if (guess == randomNumber) {
                            System.out.printf("Correct! The number was: %d. Attempts: %d%n", randomNumber, attempts);
                            break;
                        }

                        if (guess < randomNumber) {
                            System.out.printf("Higher%n");
                        } else {
                            System.out.printf("Lower%n");
                        }

                        if (attempts >= 3 && !hintShown) {
                            System.out.printf("Hint: %d is close%n", (randomNumber - 1));
                            hintShown = true;
                        }
                    }
                    System.out.printf("%n");
                    SCANNER.nextLine();

                }
                default -> System.out.printf("Exercise not implemented.%n");
            }
            repeat = MenuPrompt();
        } while (repeat);
    }
    static void main() {
        boolean running = true;
        while (running) {
            System.out.printf("%nAvailable Exercises%n");
            for (int i = 1; i <= EXERCISE_COUNT; i++) {
                System.out.printf("%d - Exercise %d%n", i, i);
            }
            System.out.printf("0 - Exit%n");
            System.out.printf("Choose an exercise to run: ");

            String input = SCANNER.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.printf("Please enter a valid number.%n");
                continue;
            }

            if (choice == 0) {
                running = false;
            } else if (choice >= 1 && choice <= EXERCISE_COUNT) {
                runExercise(choice);
            } else {
                System.out.printf("Invalid selection: %d%n", choice);
            }
        }
        System.out.printf("Goodbye!%n");
    }
}
    

