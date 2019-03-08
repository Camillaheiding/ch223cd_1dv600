package HangmanGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Class reads a text file from scr file with a list of nouns. File must only
 * consist of nouns and no signs.
 * 
 * 
 * @author Camilla
 *
 */
public class Words {

	ArrayList<String> words;

	public Words() {

		try{
			//File file = new File("src\\nounlist.txt"); //Comment out during testing
			File file = new File("src\\test.txt"); //Use during testing
			Scanner fileScan = new Scanner(file);

			words = new ArrayList<String>();

			while (fileScan.hasNext()) {
				words.add(fileScan.next());
			}
			fileScan.close();

		}catch(FileNotFoundException e) {
			System.err.println("Textfile with list of nouns not found");
		}
		
	}

	/**
	 * Returns a randomly picked word from the textfile. 
	 * 
	 * @return String with a randomly picked word.
	 */
	public String getRandomWord() {
		Random rand = new Random();
		String theWord = words.get(rand.nextInt(words.size()));
		return theWord;
	}

}
