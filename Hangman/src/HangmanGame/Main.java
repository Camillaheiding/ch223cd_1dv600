package HangmanGame;
import java.util.Scanner;

/**
 * This class present a menu with choices to play hangman. User is able to
 * initiate new games, return to previous and play a multiplayer version.
 * 
 * @author Camilla
 *
 */

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static boolean continueProgram = true;
	private static Game game = new Game();

	public static void main(String[] args) {

		while (continueProgram == true) {

			printEmptyLines();

			System.out.println("1. Play new game");
			System.out.println("2. Return to previous game");
			System.out.println("3. Play multiplayer version");
			System.out.println("4. Terminate Program");
			System.out.println("\nChoose one of the above");

			checkIntInput(sc);
			int input = getMenuChoice();

			switch (input) {
			case 1:
				if (Main.confirmPlayNewGame() == true) {
					game = new Game();
					game.playGame();
				}
				break;
			case 2:
				game.playGame();
				break;
			case 3:
				MultiplayerGame mult = new MultiplayerGame();
				mult.playGame();
				break;
			case 4:
				terminateProgram();
				break;
			default:
				System.out.println("Invalid input");
			}
		}
		sc.close();
	}

	/**
	 * Method ask the user for confirmation to terminate the program. Terminates
	 * program if user confirms, otherwise do nothing.
	 */
	public static void terminateProgram() {
		Scanner sc = new Scanner(System.in);
		printEmptyLines();
		System.out.print("Terminating the program means all previous games will be lost");
		System.out.println("\nAre you sure you want to terminate the program?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		checkIntInput(sc);
		int confirmation = sc.nextInt();
		while (!(confirmation == 1 | confirmation == 2)) {
			System.out.print("Invalid input enter 1 or 2: ");
			checkIntInput(sc);
			confirmation = sc.nextInt();
		}
		printEmptyLines();
		if (confirmation == 1) {
			Main.continueProgram = false;
		}
	}

	/**
	 * Makes sure the input is an integer
	 * 
	 * @param sc
	 *            Scanner which receive input
	 */
	public static void checkIntInput(Scanner sc) {
		while (!sc.hasNextInt()) {
			System.out.print("Invalid input, enter a number: ");
			sc.next();
		}
	}

	/**
	 * Ask if the user want to play a new game.
	 * 
	 * @return True if player wants to play a new game, otherwise false
	 */
	private static boolean confirmPlayNewGame() {
		printEmptyLines();
		System.out.println("Initiating a new game will erase any previous game.");
		System.out.println("Are you sure you want to initiate a new game?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		Scanner sc = new Scanner(System.in);
		Main.checkIntInput(sc);
		int confirmation = sc.nextInt();
		while (!(confirmation == 1 | confirmation == 2)) {
			System.out.print("Invalid input enter 1 or 2: ");
			Main.checkIntInput(sc);
			confirmation = sc.nextInt();
		}
		if (confirmation == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Print 100 empty lines to imitate that the page is updated
	 */
	public static void printEmptyLines() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	/**
	 * Check if the variable coninueProgram is true
	 * 
	 * @return true if variable continueProgram is true
	 */
	public static boolean continueProgram() {
		return continueProgram;
	}

	/**
	 * Return an integer from 1-4 entered by the user
	 * 
	 * @return an integer from 1-4
	 */
	private static int getMenuChoice() {
		int input = sc.nextInt();
		while (!(input == 1 | input == 2 | input == 3 | input == 4)) {
			System.out.print("Invalid input enter a menu choice: ");
			checkIntInput(sc);
			input = sc.nextInt();
		}
		return input;
	}
}
