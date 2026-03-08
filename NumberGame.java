import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        char playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {

            int number = rand.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessed = false;

            System.out.println("\nGuess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    guessed = true;
                    score++;
                    break;
                }
                else if (guess < number) {
                    System.out.println("Too low! Try again.");
                }
                else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("You lost! The correct number was: " + number);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nGame Over!");
        System.out.println("Total rounds won: " + score);

        sc.close();
    }
}