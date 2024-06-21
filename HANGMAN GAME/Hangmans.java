import java.util.Random;
import java.util.Scanner;

public class Hangman {
    // List of words to choose from
    private static final String[] WORDS = {
        "elephant", "tiger", "penguin", "giraffe", "dolphin"
    };

    // Hangman figures for incorrect guesses
    private static final String[] HANGMAN = {
        "",
        " O ",
        " O \n | ",
        " O \n/| ",
        " O \n/|\\ ",
        " O \n/|\\ \n/  ",
        " O \n/|\\ \n/ \\ "
    };

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Select a random word
        String word = WORDS[random.nextInt(WORDS.length)];
        char[] wordArray = word.toCharArray();
        char[] displayArray = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            displayArray[i] = '_';
        }

        int incorrectGuesses = 0;
        boolean wordGuessed = false;

        // Game loop
        while (incorrectGuesses < HANGMAN.length - 1 && !wordGuessed) {
            System.out.println("Current word: " + new String(displayArray));
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < wordArray.length; i++) {
                if (wordArray[i] == guess) {
                    displayArray[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                incorrectGuesses++;
            }

            System.out.println("Incorrect guesses: " + incorrectGuesses);
            System.out.println(HANGMAN[incorrectGuesses]);

            // Check if the word is completely guessed
            wordGuessed = true;
            for (char c : displayArray) {
                if (c == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Sorry, you lost. The word was: " + word);
        }

        scanner.close();
    }
}
