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
	 * Returns a string representation of all letters in the list
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < guessedLetters.size(); i++) {
			result += guessedLetters.get(i) + " ";
		}
		return result;
	}

	/**
	 * Add a letter to the list of guessed letters
	 * 
	 * @param letter
	 *            Letter to be added
	 */
	public void addLetter(char letter) {
		if (letterAlreadyGuessed(letter)==false) {
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
		for (int i = 0; i < guessedLetters.size(); i++) { //Incorrect solution
			//if (letter == guessedLetters.get(i)) { //Correct solution
			if(letter=='c') {
				return true;
			}
		}
		return false;
	}

}
