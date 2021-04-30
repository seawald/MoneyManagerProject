package project2;

/**
* This class is an object class used to create a money market account that can then be added into the account database.
* The money market object has a fee, a different minimum balance for which the fee will be waived, a different interest rate, and an extra int variable which tracks how many withdrawals have been made.
* There are helper methods to determine how many withdrawals a customer has made.
* Monthly interest and fee is also calculated through 2 methods called monthlyInterest and monthlyFee.
* We have overridden the toString method to work specifically to money market object variables.
* There is a helper method to determine if the fee is waived if there are more than 7 withdrawals.
* @author Martin Colucci and Pujan Patel
*/
public class MoneyMarket extends Account 
{
	private static final double fee = 12.00;
	private static final double minFeeWave = 2500;
	private static final double interestRate = 0.0065/12;
	private static final double maxWithdrawals = 6;
	private int withdrawals;
	
	  /**
	   * This method is a constructor to take the elements from the input and set the variables of the money market object as needed.
	   * @param first This represents the  first name which is retrieved from the input string.
	   * @param last This represents the  last name which is retrieved from the input string.
	   * @param inBal This represents the starting balance of the money market account which is retrieved from the input string.
	   * @param date This represents when the money market account was created (date) which is also retrieved form the input string.
	   */
	public MoneyMarket(String first, String last, double inBal, String date)
	{
		Profile tempProfile = new Profile(first, last);
		setProfile(tempProfile);
		Date tempDate = new Date(date);
		setDate(tempDate);
		setBalance(inBal);
		withdrawals = 0;
	}
	
	  /**
	   * This will calculate the monthly interest rate.
	   * The interest rate is fixed for a money market account.
	   * @return Returns the calculated monthly interest.
	   */
	public double monthlyInterest()
	{
		return (getBalance() * (interestRate));
	}

	  /**
	   * This will calculate the monthly fee.
	   * The monthly fee will differ depending on if the fee is waived.
	   * The fee is waived if the balance is greater or equal to the minimum needed to get a fee waiver and the number of withdrawals is less than or equal to seven.
	   * @return Returns the calculated fee.
	   */
	public double monthlyFee()
	{
		if(getBalance() >= minFeeWave && withdrawals <= maxWithdrawals)
		{
			return 0;
		}
		else
		{
			return fee;
		}
	}
	
	  /**
	   * An override to the original toString() method which has been adjusted to use values and output for the money market class.
	   * @return Returns a string that used to output the information about a money market account.
	   */
	@Override
	public String toString() 
	{
			return ("*Money Market*" + getHolderName() + "* $" + String.format("%,.02f", getBalance()) + "*" + getDateString() + "*" + withdrawals + ((withdrawals == 1)? " withdrawal*" : " withdrawals*"));
	}
	
	  /**
	   * A helper method used to return a string that will be used to print out this money market account for print by last name or date.
	   * @return Returns a string to be output representing the money market account.
	   */
	public String printHelper()
	{
		setBalance(getBalance() + monthlyInterest() - monthlyFee());
		
		return ('\n' 
				+ "-interest: $ " + String.format("%.02f", monthlyInterest()) + '\n' 
				+ "-fee: $ " + String.format("%.02f", monthlyFee()) + '\n'
				+ "-new balance: $ " + String.format("%,.02f", getBalance()));
	}
	
	  /**
	   * A method that increments the amount of withdrawals by 1 whenever it is called.
	   */
	public void incWithdrawal() 
	{
		withdrawals++;
	}
}
