import java.util.Random;

public class Words {
	
	String[] words;
	
	public Words() {
		words = new String[5];
		words[0] = "Katt";
		words[1] = "Hund";
		words[2] = "Gris";
		words[3] = "Häst";
		words[4] = "Ko";
	}
	
	public String getRandomWord() {
		Random rand = new Random();
		String theWord = words[rand.nextInt(words.length)];
		return theWord;
	}

}
