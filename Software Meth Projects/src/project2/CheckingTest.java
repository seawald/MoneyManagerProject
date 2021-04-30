package project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for JUnit testing of Checking.monthlyInterest() and Checking.monthlyFee().
 * @author Martin Colucci and Pujan Patel
 *
 */
class CheckingTest 
{
	Checking c1 = new Checking("Martin", "Colucci", 1000, "10/8/2020", true); //$1000 in balance, is direct deposit account. Should waive.
	Checking c2 = new Checking("Pujan", "Patel", 1000, "10/8/2020", false); //$1000 in balance, is not direct deposit account. Should not waive.
	Checking c3 = new Checking("Yah", "Yeet", 1500, "10/8/2020", false); //$1500 in balance, is not direct deposit. Should waive.
	
	double actualInterest = 1000 * (0.0005/12); 
	
	double actualFeeWaived = 0;
	double actualFeeUnwaived = 25;
	
	/**
	 * JUnit test method for Checking.monthlyInterest().
	 */
	@Test
	void testMonthlyInterest() 
	{
		assertEquals(actualInterest, c1.monthlyInterest());
		assertEquals(actualInterest, c2.monthlyInterest());
	}

	/**
	 * JUnit test method for Checking.monthlyFee().
	 */
	@Test
	void testMonthlyFee() 
	{
		assertEquals(actualFeeWaived, c1.monthlyFee());
		assertEquals(actualFeeUnwaived, c2.monthlyFee());
		assertEquals(actualFeeWaived, c3.monthlyFee());
	}

}
