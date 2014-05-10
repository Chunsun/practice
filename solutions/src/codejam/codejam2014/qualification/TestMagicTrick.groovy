package codejam.codejam2014.qualification
import junit.framework.TestCase;

import org.junit.Before
import org.junit.Test
import org.junit.Assert

class TestMagicTrick{
	MagicTrick magicTrick
	@Before
	public void setUp() throws Exception {
		magicTrick = new MagicTrick()
		magicTrick.setInput()
	}
	
	@Test 
	void getInput() {
		def input = magicTrick.getInput()
		assert input != null
	}
	@Test
	void getTimes() {
		magicTrick.setScanner()
		magicTrick.setTotalTimes()
		assert magicTrick.getTotalTimes() > 0
	}
	
	@Test
	void getFirstRow() {
		magicTrick.setScanner()
		magicTrick.setTotalTimes()
		magicTrick.setAnswer()
		println magicTrick.getRow()
	}
	
	@Test
	void getSecondRow() {
		getFirstRow()
		magicTrick.setAnswer()
		println magicTrick.getRow()
	}
	
	@Test
	void testFirstResult() {
		magicTrick.setScanner()
		magicTrick.setTotalTimes()
		magicTrick.setAnswer()
		def firstRound = magicTrick.getRow()
		
		magicTrick.setAnswer()
		def secondRound = magicTrick.getRow()
		
		def result = magicTrick.checkAnswers(firstRound, secondRound)
		magicTrick.printResult()
	}
	
	@Test 
	void testStartNewMagic() {
		magicTrick.setScanner()
		magicTrick.setTotalTimes()
		magicTrick.startNewMagic()
	}
	
	@Test
	void testMagicTrick() {
		magicTrick.startMagicTrick()
		magicTrick.writeOutputResult()
	}
}
