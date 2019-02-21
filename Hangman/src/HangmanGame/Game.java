package HangmanGame;
import java.util.Scanner;

public class Game {

	private int numberOfGuessesLeft;
	private Words list;
	private String theWord;
	private String[] underscores;
	private GuessedLetters guessedLetters;
	Stickman stickman;
	private Scanner sc;
	private boolean continueGame;

	public Game() {

		numberOfGuessesLeft = 9;
		stickman = new Stickman();
		list = new Words();
		setWord(list.getRandomWord());
		guessedLetters = new GuessedLetters();
		sc = new Scanner(System.in);
		continueGame = true;

	}

	/**
	 * Play a game of hangman. User is able to return to main menu or terminate the
	 * game.
	 */
	public void playGame() {
		continueGame = true;

		while (checkAnswer(underscores) == false & numberOfGuessesLeft > 0 & continueGame == true
				& Main.continueProgram() == true) {
			Main.printEmptyLines();

			System.out.println("Press 1 to return to the Menu");
			System.out.println("Press 2 to terminate program");

			printUnderscores(underscores);

			stickman.drawStickman();
			// System.out.println("\nNumber of guesses left: " + numberOfGuessesLeft);
			System.out.print("Guessed letters: " + guessedLetters.toString());
			System.out.print("\nGuess a letter:");

			String input = sc.next();
			while (input.length() != 1
					| !(Character.isLetter(input.charAt(0)) | input.charAt(0) == '1' | input.charAt(0) == '2')) {
				System.out.println("Invalid input, enter a letter or a menu choice:");
				input = sc.next();
			}

			if (input.charAt(0) == '1') {
				returnToMenu();
			} else if (input.charAt(0) == '2') {
				Main.terminateProgram();
			} else if (Character.isLetter(input.charAt(0))) {
				Boolean correct = false;
				char guess = Character.toLowerCase(input.charAt(0));
				for (int i = 0; i < theWord.length(); i++) {
					if (guess == Character.toLowerCase(theWord.charAt(i))) {
						underscores[i] = " " + theWord.charAt(i);
						correct = true;
					}
				}
				if (!correct) {
					if (guessedLetters.letterAlreadyGuessed(guess) == false) {
						guessedLetters.addLetter(guess);
						stickman.addPart();
						numberOfGuessesLeft--;
					}

				}

			}
		}

		Main.printEmptyLines();
		if (checkAnswer(underscores) == true) {
			stickman.drawHappyStickman();
			System.out.println("Yay, the man survived! Correct word: " + theWord);
			System.out.println("Enter any character to continue");
			sc.next();

		} else if (numberOfGuessesLeft == 0) {
			stickman.drawStickman();
			System.out.println("Oh no, he died! Correct word: " + theWord);
			System.out.println("Enter any character to continue");
			sc.next();
		}
	}

	/**
	 * Sets the correct word of this game
	 * 
	 * @param word
	 *            New solution to the game
	 */
	public void setWord(String word) {
		theWord = word;
		underscores = new String[theWord.length()];
		for (int i = 0; i < theWord.length(); i++) {
			if (theWord.charAt(i) == '-') {
				underscores[i] = " -";
			} else {
				underscores[i] = " _";
			}

		}
	};

	/**
	 * Return true if player have won this game.
	 * 
	 * @return true if player gave won this game, otherwise false
	 */
	public boolean gameSucceded() {
		if (checkAnswer(underscores) == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Print array of underscores/letters
	 * 
	 * @param underscores
	 *            Array to be printed
	 */
	private void printUnderscores(String[] underscores) {
		for (int i = 0; i < underscores.length; i++) {
			System.out.print(underscores[i]);
		}
	}

	/**
	 * Check if all underscores are replaced by the correct letter
	 * 
	 * @param underscores
	 *            Array whit underscores/letters
	 * @return true if all correct letters are guessed, otherwise false
	 */
	private boolean checkAnswer(String[] underscores) {
		for (int i = 0; i < underscores.length; i++) {
			if (underscores[i] == " _") {
				return false;
			}
		}
		return true;
	}

	/**
	 * Ask if user want to return to menu Ends this game of hangman if user chooses
	 * to, otherwise does nothing
	 */
	private void returnToMenu() {
		Main.printEmptyLines();
		System.out.println("Are you sure you want to go back to the menu?");
		System.out.println("Your game will be saved until a new game is initiated.");
		System.out.println("1. Yes");
		System.out.println("2. No");
		Main.checkIntInput(sc);
		int confirmation = sc.nextInt();
		while (!(confirmation == 1 | confirmation == 2)) {
			System.out.print("Invalid input enter 1 or 2: ");
			Main.checkIntInput(sc);
			confirmation = sc.nextInt();
		}
		if (confirmation == 1) {
			continueGame = false;
		}
	}
}
