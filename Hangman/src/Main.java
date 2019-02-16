import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numberOfGuessesLeft = 9;
		Words list = new Words();
		String theWord = list.getRandomWord();
		String[] underscores = new String[theWord.length()];
		GuessedLetters guessedLetters = new GuessedLetters();
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < theWord.length(); i++) {
			underscores[i] = " _";
		}

		//System.out.println(theWord);/////////////////////

		while (checkAnswer(underscores) == false & numberOfGuessesLeft > 0) {
			
			printUnderscores(underscores);

			System.out.println("\nNumber of guesses left: " + numberOfGuessesLeft);
			System.out.print("Guessed letters: " + guessedLetters.toString());
			System.out.println("\nGuess a letter:");

			String input = sc.next();
			while (input.length() != 1 | !Character.isLetter(input.charAt(0))) {
				System.out.println("Invalid character, enter a letter:");
				input = sc.next();
			}

			Boolean correct = false;
			char guess = Character.toLowerCase(input.charAt(0));
			for (int i = 0; i < theWord.length(); i++) {
				if (guess == Character.toLowerCase(theWord.charAt(i))) {
					underscores[i] = " " + theWord.charAt(i);
					correct = true;
				}
			}
			if (!correct) {
				guessedLetters.addLetter(guess);
				numberOfGuessesLeft--;
			}

			

			for (int i = 0; i < 100; i++) {
				System.out.println();
			}
		}

		if (checkAnswer(underscores) == true) {
			System.out.println("Yay, the man survived! Correct word: " + theWord);
		} else {
			System.out.println("Oh no, he died! Correct word: " + theWord);
		}
	}

	public static void printUnderscores(String[] underscores) {
		for (int i = 0; i < underscores.length; i++) {
			System.out.print(underscores[i]);
		}
	}

	public static boolean checkAnswer(String[] underscores) {
		for (int i = 0; i < underscores.length; i++) {
			if (underscores[i] == " _") {
				return false;
			}
			;
		}
		return true;
	}

	public static void checkInput() {

	}

}
