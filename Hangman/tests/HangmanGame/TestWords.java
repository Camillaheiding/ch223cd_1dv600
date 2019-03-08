package HangmanGame; 

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestWords {
	
	@Test
	public void testGetRandomWord() {
		Words sut = new Words();
		String expected = "Test";
		
		String actual = sut.getRandomWord();
		
		assertEquals(expected, actual);
	}

}
