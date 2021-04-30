package project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test class for JUnit testing of Date.isValid().
 * @author Martin Colucci and Pujan Patel
 *
 */
class DateTest 
{

	/**
	 * JUnit test method for Date.isValid().
	 */
	@Test
	void testIsValid() 
	{
		Date d1 = new Date("10/31/2019"); //Valid 31st
		Date d2 = new Date("7/19/1999"); //Valid 1-digit month
		Date d3 = new Date("09/3/2020"); //Valid 2-digit month
		Date d4 = new Date("2/29/2016"); //Valid Leap Year
		
		Date d5 = new Date("9/31/2019"); //Invalid 31st
		Date d6 = new Date("8/32/2004"); //Invalid day
		Date d7 = new Date("2/29/2019"); //Invalid Leap Year
		Date d8 = new Date("13/02/2020"); //Invalid month
		
		assertTrue(d1.isValid());
		assertTrue(d2.isValid());
		assertTrue(d3.isValid());
		assertTrue(d4.isValid());
		
		assertFalse(d5.isValid());
		assertFalse(d6.isValid());
		assertFalse(d7.isValid());
		assertFalse(d8.isValid());
		
		assertEquals(true, d1.isValid());
		
		assertEquals(false, d5.isValid());
	}

}
