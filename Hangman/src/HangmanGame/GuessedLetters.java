package HangmanGame;
import java.util.ArrayList;

/**
 * Class contain a list of letters.
 * 
 * @author Camilla
 *
 */
public class GuessedLetters {

	private ArrayList<Character> guessedLetters;

	public GuessedLetters() {
		guessedLetters = new ArrayList<Character>();
	}

	/**
	 * Prints a string representation of all letters in the list
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < guessedLetters.size(); i++) {
			result += guessedLetters.get(i) + " ";
		}
		return result;
	}

	/**
	 * Add a letter to the string
	 * 
	 * @param letter
	 *            Letter to be added
	 */
	public void addLetter(char letter) {
		boolean alreadyGuessed = false;
		for (int i = 0; i < guessedLetters.size(); i++) {
			if (guessedLetters.get(i) == letter) {
				alreadyGuessed = true;
			}
		}
		if (alreadyGuessed == false) {
			guessedLetters.add(letter);
		}
	}

	/**
	 * Check if the letters is part of the list
	 * 
	 * @param letter
	 *            letter to be checked
	 * @return true if list contain letter, otherwise false
	 */
	public boolean letterAlreadyGuessed(char letter) {
		for (int i = 0; i < guessedLetters.size(); i++) {
			if (guessedLetters.get(i) == letter) {
				return true;
			}
		}
		return false;
	}

}
