package project2;

/**
* This class is an object class used to create a savings accounts that can then be added into the account data base.
* The savings object has a fee, a different minimum balance for which the fee will be waived, a different interest rate, and a different boolean for if a customer is loyal.
* There are helper methods to determine if a customer is loyal which then waives the fee.
* Monthly interest and fee is also calculated through 2 methods called monthlyInterest and monthlyFee.
* We have overrode the toString method to work specifically to Savings object variables.
* @author Martin Colucci and Pujan Patel
*/
public class Savings extends Account 
{
	private static final double fee = 5.00;
	private static final double minFeeWave = 300;
	private double interestRate;
	private boolean isLoyal;
	
	  /**
	   * This is a constructor to create a new savings object, set the balance for the account, set the date created, to check the loyalty and adjust the interestRate accordingly, and create a profile as well.
	   * @param first This is the first name that we will be setting from the input string.
	   * @param last This is the last name that we will be setting from the input string.
	   * @param inBal This is the balance that the savings account will have which we will be getting from the input string.
	   * @param date The date is specified in the input string and we will set the date to that value.
	   * @param loyalty Loyalty is a boolean that is in the input string and will determine the specific interest rate.
	   */
	public Savings(String first, String last, double inBal, String date, boolean loyalty)
	{
		Profile tempProfile = new Profile(first, last);
		setProfile(tempProfile);
		Date tempDate = new Date(date);
		setDate(tempDate);
		setBalance(inBal);
		isLoyal = loyalty;
		if(isLoyal)
			interestRate = 0.0035/12;
		else
			interestRate = 0.0025/12;
	}
	
	  /**
	   * This will calculate the monthly interest rate.
	   * The interest rate calculated differers depending on the loyalty status.
	   * @return Returns the calculated monthly interest.
	   */
	public double monthlyInterest()
	{
		return (getBalance() * (interestRate));
	}

	  /**
	   * This will calculate the monthly fee.
	   * The monthly fee will differ depending on if the fee is waived.
	   * The fee is only waived if the balance is greater or equal to the minimum needed to get a fee waiver.
	   * @return Returns the calculated fee.
	   */
	public double monthlyFee()
	{
		if(getBalance() >= minFeeWave)
		{
			return 0;
		}
		else
		{
			return fee;
		}
	}
	
	  /**
	   * An override to the original toString() method which has been adjusted to use values and output for the savings account class.
	   * @return Returns a string that used to output the information about a savings account.
	   */
	@Override
	public String toString() 
	{
		return ("*Savings*" + getHolderName() + "* $" + String.format("%,.02f", getBalance()) + "*" + getDateString() + ((isLoyal)? "*special Savings account*" : ""));
	}
	
	  /**
	   * A helper method used to return a string that will be used to print out this savings account for print by last name or date.
	   * @return Returns a string to be output representing the savings account.
	   */
	public String printHelper()
	{
		setBalance(getBalance() + monthlyInterest() - monthlyFee());
		
		return ('\n' 
				+ "-interest: $ " + String.format("%.02f", monthlyInterest()) + '\n' 
				+ "-fee: $ " + String.format("%.02f", monthlyFee()) + '\n'
				+ "-new balance: $ " + String.format("%,.02f", getBalance()));
	}
}