package HangmanGame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestGame{

	private Game sut;
	
	@Before
	public void setUp() {
		sut = new Game(); 
	}
	
	//getWord()
	//Word is always "Test" in current textfile
	@Test
	public void testGetWord() {
		String expected = "Test";
		
		String actual = sut.getWord();
		
		assertEquals(expected, actual);
	}
	
	//setWord(String newWord)
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetWordInvalidWord() {
		String invalidWord = "*";
		
		sut.setWord(invalidWord); //this should throw an IllegalArgumentException
	}
	
	
	//gameSucceded()
	
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
	
	
	//underscoresToString()
	
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
	
	//guessLetter(String letter)
	
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
	
	
}
