import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int guess = 0;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100");

        while (guess != numberToGuess) {

            System.out.print("Enter your guess: ");
            guess = sc.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Too Low!");
            }
            else if (guess > numberToGuess) {
                System.out.println("Too High!");
            }
            else {
                System.out.println("Correct! You guessed the number.");
            }
        }

        sc.close();
    }
}
