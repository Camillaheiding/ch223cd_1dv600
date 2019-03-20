package HangmanGame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Before tests are run the code in Words.java should be changed so it uses
 * test.txt instead of the ordinary noun-list.
 * 
 * @author Camilla
 *
 */
public class TestGame {

	private Game sut;

	@Before
	public void setUp() {
		sut = new Game();
	}

	// getWord()
	// Word is always "Test" in current textfile
	@Test
	public void testGetWord() {
		String expected = "Test";

		String actual = sut.getWord();

		assertEquals(expected, actual);
	}

	// setWord(String newWord)
	@Test
	public void testSetWord() {
		String expected = "Expected";
		sut.setWord(expected);

		String actual = sut.getWord();

		assertEquals(expected, actual);
	}

	@Test
	public void testSetWordWithDash() {
		String expected = "Grand-parent";
		sut.setWord(expected);

		String actual = sut.getWord();

		assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSetWordInvalidWord() {
		String invalidWord = "*";

		sut.setWord(invalidWord); // this should throw an IllegalArgumentException
	}

	// guessLetter(String letter)

	@Test
	public void testRightGuess() {
		sut.guessLetter("t");
		String expected = " T _ _ t";

		String actual = sut.underscoresToString();

		assertEquals(expected, actual);

		sut.guessLetter("e");
		expected = " T e _ t";

		actual = sut.underscoresToString();

		assertEquals(expected, actual);
	}

	@Test
	public void testWrongGuess() {
		sut.guessLetter("q");
		sut.guessLetter("w");
		sut.guessLetter("r");
		sut.guessLetter("y");
		sut.guessLetter("u");
		sut.guessLetter("i");
		sut.guessLetter("o");
		sut.guessLetter("p");
		sut.guessLetter("z");
		String expected = " _ _ _ _";

		String actual = sut.underscoresToString();

		assertEquals(expected, actual);
	}

	// gameSucceded()

	@Test
	public void testGameSuccededFalse() {
		boolean expected = false;
		sut.guessLetter("t");
		sut.guessLetter("e");
		sut.guessLetter("q");

		boolean actual = sut.gameSucceded();

		assertEquals(expected, actual);
	}

	@Test
	public void testGameSuccededTrue() {
		boolean expected = true;
		sut.guessLetter("t");
		sut.guessLetter("e");
		sut.guessLetter("s");

		boolean actual = sut.gameSucceded();

		assertEquals(expected, actual);
	}

	// gameLost()

	@Test
	public void testGameLostfalse() {
		boolean expected = false;
		sut.guessLetter("d");
		sut.guessLetter("d"); // same letter second time
		sut.guessLetter("q");
		sut.guessLetter("r");
		sut.guessLetter("y");
		sut.guessLetter("u");
		sut.guessLetter("o");
		sut.guessLetter("p");
		sut.guessLetter("m"); // eight different quesses

		boolean actual = sut.gameLost();

		assertEquals(expected, actual);

		sut.guessLetter("t");
		sut.guessLetter("e");
		sut.guessLetter("s"); // won game

		actual = sut.gameLost();

		assertEquals(expected, actual);
	}

	@Test
	public void testGameLostTrue() {
		boolean expected = true;
		sut.guessLetter("z");
		sut.guessLetter("x");
		sut.guessLetter("c");
		sut.guessLetter("v");
		sut.guessLetter("b");
		sut.guessLetter("n");
		sut.guessLetter("m");
		sut.guessLetter("q");
		sut.guessLetter("w");// nine different quesses = out of guesses

		boolean actual = sut.gameLost();

		assertEquals(expected, actual);
	}

	// underscoresToString()

	@Test
	public void testUnderscoresToString() {
		String expected = " _ _ _ _";

		String actual = sut.underscoresToString();

		assertEquals(expected, actual);
	}

	@Test
	public void testUnderScoresToStringWithDash() {
		sut.setWord("Grand-parent");
		String expected = " _ _ _ _ _ - _ _ _ _ _ _";

		String actual = sut.underscoresToString();

		assertEquals(expected, actual);
	}

	// checkWord()

	@Test
	public void testCheckWordValidWord() {
		boolean expected = true;

		boolean actual = sut.checkWord("Example");

		assertEquals(expected, actual);
	}

	@Test
	public void testCheckWordValidWordWithDash() {
		boolean expected = true;

		boolean actual = sut.checkWord("Grand-parent");

		assertEquals(expected, actual);
	}

	@Test
	public void testCheckWordInvalidWord() {
		boolean expected = false;

		boolean actual = sut.checkWord("*,*");

		assertEquals(expected, actual);
	}

}
