package project2;

/**
* This class is an object class used to create a checkings accounts that can then be added into the account data base.
* The checkings object has a fee, a different minimum balance for which the fee will be waived, a different interest rate, and a different boolean for if the customer uses direct deposit.
* There are helper methods to determine if a customer is loyal which then waives the fee.
* Monthly interest and fee is also calculated through 2 methods called monthlyInterest and monthlyFee.
* We have overrode the toString method to work specifically to checkings object variables.
* @author Martin Colucci and Pujan Patel
*/
public class Checking extends Account 
{
	private static final double fee = 25.00;
	private static final double minFeeWave = 1500;
	private static final double interestRate = 0.0005/12;
	private boolean directDeposit;
	
	  /**
	   * This is a constructor to create a new checking object, set the balance for the account, set the date created, to check the direct deposit status and adjust the interestRate accordingly, and create a profile as well.
	   * @param first  This represents the  first name which is retrieved from the input string.
	   * @param last This represents the  last name which is retrieved from the input string.
	   * @param inBal This represents the starting balance of the checking account which is retrieved from the input string.
	   * @param date The date is specified in the input string and we will set the date to that value.
	   * @param dirDep This sets the dirDep boolean depending on if the user specifies that the account uses direct deposit
	   */
	public Checking(String first, String last, double inBal, String date, boolean dirDep)
	{
		Profile tempProfile = new Profile(first, last);
		setProfile(tempProfile);
		Date tempDate = new Date(date);
		setDate(tempDate);
		setBalance(inBal);
		directDeposit = dirDep;
	}
	
	  /**
	   * This will calculate the monthly interest rate.
	   * The interest rate calculated differs depending on the direct deposit status.
	   * @return Returns the calculated monthly interest.
	   */
	public double monthlyInterest()
	{
		return (getBalance() * (interestRate));
	}

	  /**
	   * This will calculate the monthly fee.
	   * The monthly fee will differ depending on if the fee is waived.
	   * The fee is only waived if the balance is greater or equal to the minimum needed to get a fee waiver or if the account uses direct deposit.
	   * @return Returns the calculated fee.
	   */
	public double monthlyFee()
	{
		if(getBalance() >= minFeeWave || directDeposit)
		{
			return 0;
		}
		else
		{
			return fee;
		}
	}
	
	  /**
	   * An override to the original toString() method which has been adjusted to use values and output for the checking account class.
	   * @return Returns a string that used to output the information about a checking account.
	   */
	@Override
	public String toString() 
	{
		return ("*Checking*" + getHolderName() + "* $" + String.format("%,.02f", getBalance()) + "*" + getDateString()  + ((directDeposit)? "*direct deposit account*" : ""));
	}
	
	  /**
	   * A helper method used to return a string that will be used to print out this checking account for print by last name or date.
	   * @return Returns a string to be output representing the checking account.
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