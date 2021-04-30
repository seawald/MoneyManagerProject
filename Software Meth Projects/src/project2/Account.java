package project2;

/**
 * The Account class is an abstract class that is used to create different types of bank account subclasses.
 * The majority of this class' methods are for getting and setting shared private fields for accounts.
 * An equals method that works for each of the three account subclasses is also included in this class.
 * @author Martin Colucci and Pujan Patel
 */
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * Deducts the input amount of money from the balance of the account.
	 * @param amount The amount of money to be deducted.
	 */
	public void debit(double amount) 
	{
		balance -= amount;
	}
	
	/**
	 * Adds the input amount of money to the balance of the account.
	 * @param amount The amount of money to be added.
	 */
	public void credit(double amount) 
	{
		balance += amount;
	} 
	
	/**
	 * Default toString method for Account. Outputs holder's full name, balance, and date opened.
	 * Each subclass of Account overrides this method, so it should only ever be called for bug testing.
	 */
	public String toString() 
	{
		return (holder.getName() + " " + balance + " " + dateOpen.toString());
	}
	
	/**
	 * Sets the account holder's profile to the input profile.
	 * @param prof The profile to set the account holder to.
	 */
	public void setProfile(Profile prof)
	{
		holder = prof;
	}
	
	/**
	 * Sets the name of the account holder using the input first and last names.
	 * @param f The first name of the person whose name is being set.
	 * @param l The last name of the person whose name is being set.
	 */
	public void setName(String f, String l)
	{
		holder.inFirstLast(f, l);
	}
	
	/**
	 * Sets the account's balance to the input balance.
	 * @param bal The new balance.
	 */
	public void setBalance(double bal)
	{
		balance = bal;
	}
	
	/**
	 * Sets the date the account was opened to the input date.
	 * @param inDate The new date.
	 */
	public void setDate(Date inDate)
	{
		dateOpen = inDate;
	}
	
	/**
	 * Gets the name of the account holder.
	 * @return The string of the account holder's full name.
	 */
	public String getHolderName()
	{
		return holder.getName();
	}
	
	/**
	 * Gets the name of the account holder.
	 * This can be either the first name, last name, or both.
	 * @param option 'f' for first name, 'l' for last name. Neither returns the full name.
	 * @return The string name of the account holder.
	 */
	public String getHolderName(char option)
	{
		if(option == 'f')
			return holder.getFName();
		
		if(option == 'l')
			return holder.getLName();
		
		return holder.getName();
	}
	
	/**
	 * Gets the account's balance.
	 * @return The account's balance.
	 */
	public double getBalance() 
	{
		return balance;
	}
	
	/**
	 * Gets the open date of the account.
	 * @return The account's open date.
	 */
	public Date getDate()
	{
		return dateOpen;
	}
	
	/**
	 * Gets the date as a string.
	 * @return The string of the date.
	 */
	public String getDateString()
	{
		return dateOpen.toString();
	}
	
	/**
	 * Checks if the input account is off the same subclass type and has the same holder name as the account in frame.
	 * @param account The account that is being tested.
	 * @return Boolean true if equal, false if not equal.
	 */
	public boolean isEqual(Account account)
	{
		if(((this instanceof Checking) && (account instanceof Checking)) || 
		   ((this instanceof Savings) && (account instanceof Savings)) || 
		   ((this instanceof MoneyMarket) && (account instanceof MoneyMarket)))
		{
			if(this.getHolderName().equals(account.getHolderName()))
				return true;
		}
			
		return false;
	}
	
	/**
	 * An abstract that prints out additional information unique to each respective subclass.
	 * @return String with unique subclass information.
	 */
	public abstract String printHelper();
	
	/**
	 * An abstract that calculates the monthly interest of an account, based account type.
	 * @return The amount of monthly interest on the account.
	 */
	public abstract double monthlyInterest();
	
	/**
	 * An abstract that calculates the monthly fees on an account, based on account type.
	 * @return The amount of monthly fees on the account.
	 */
	public abstract double monthlyFee();
	
}