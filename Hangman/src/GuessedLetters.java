import java.util.ArrayList;

public class GuessedLetters {

	ArrayList<Character> guessedLetters;

	public GuessedLetters() {
		guessedLetters = new ArrayList<Character>();
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < guessedLetters.size(); i++) {
			result += guessedLetters.get(i) + " ";
		}
		return result;
	}
	
	public void addLetter(char letter) {
		boolean alreadyGuessed = false;
		for(int i = 0; i<guessedLetters.size();i++) {
			if(guessedLetters.get(i)==letter) {
				alreadyGuessed = true;
			}
		}
		if(alreadyGuessed==false) {
			guessedLetters.add(letter);
		}
	}

}
