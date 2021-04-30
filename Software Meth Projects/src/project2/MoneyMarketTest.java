package project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for JUnit testing of MoneyMarket.monthlyInterest() and MoneyMarket.monthlyFee().
 * @author Martin Colucci and Pujan Patel
 *
 */
class MoneyMarketTest {

	MoneyMarket c1 = new MoneyMarket("Martin", "Colucci", 2500, "10/8/2020"); //$2500 in balance. Should waive due to <= 6 withdrawals.
	MoneyMarket c2 = new MoneyMarket("Pujan", "Patel", 2500, "10/8/2020"); //$2500 in balance. Will withdraw 7 times. Should not waive due to withdrawals.
	MoneyMarket c3 = new MoneyMarket("Yah", "Yeet", 1000, "10/8/2020"); //$1000 in balance. No withdrawals. Should not waive due to low balance.
	
	double actualInterest = 2500 * (0.0065/12); 
	
	double actualFeeWaived = 0;
	double actualFeeUnwaived = 12;
	
	/**
	 * JUnit test method for MoneyMarket.monthlyInterest().
	 */
	@Test
	void testMonthlyInterest() {
		assertEquals(actualInterest, c1.monthlyInterest());
		assertEquals(actualInterest, c2.monthlyInterest());
	}

	/**
	 * JUnit test method for MoneyMarket.monthlyFee().
	 */
	@Test
	void testMonthlyFee() {
		assertEquals(actualFeeWaived, c1.monthlyFee());
		
		for(int i = 1; i <= 7; i++)
		{
			c2.incWithdrawal();
		}
		
		assertEquals(actualFeeUnwaived, c2.monthlyFee());
		
		assertEquals(actualFeeUnwaived, c3.monthlyFee());
	}

}
