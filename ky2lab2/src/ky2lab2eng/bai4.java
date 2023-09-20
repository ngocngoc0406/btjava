package ky2lab2eng;
import java.util.Random;
import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secretNumber = (int) (Math.random() * 100) + 1; // generate a random number between 1 and 100
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt(); // get the player's guess
        GuessThread thread1 = new GuessThread("Thread 1", secretNumber, guess);
        GuessThread thread2 = new GuessThread("Thread 2", secretNumber, guess);
        thread1.start();
        thread2.start();
    }
}

class GuessThread extends Thread {
    private int secretNumber;
    private int guess;

    public GuessThread(String name, int secretNumber, int guess) {
        super(name);
        this.secretNumber = secretNumber;
        this.guess = guess;
    }

    public void run() {
        int numGuesses = 0;
        Random rand = new Random();
        while (true) {
            int randomGuess = rand.nextInt(100) + 1; // generate a random guess
            numGuesses++;
            System.out.println(Thread.currentThread().getName() + " guessed " + randomGuess);
            if (randomGuess == secretNumber) { // if the guess matches the secret number, stop the thread
                System.out.println(Thread.currentThread().getName() + " wins! It took " + numGuesses + " guesses.");
                System.exit(0);
            }
        }
    }
}
