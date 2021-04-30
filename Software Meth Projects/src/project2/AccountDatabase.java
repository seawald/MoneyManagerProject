package project2;

/**
 * The AccountDatabase class stores accounts in an array and provides methods to access and manipulate those accounts.
 * @author Martin Colucci and Pujan Patel
 */
public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	/**
	 * Constructor for the AccountDatabase class.
	 * Initializes account storage array to hold 5 accounts and have current size of 0 entries.
	 */
    public AccountDatabase()
    {
    	accounts = new Account[5];
    	size = 0;
    }
	
    /**
     * Finds the specified account in the array based on the account holder's full name and the account type.
     * @param account The account to search for.
     * @return The index in the array of the account if found, -1 if not found.
     */
	private int find(Account account) 
	{
		for (int i = 0; i < this.size; i++)
        {
            if (accounts[i].isEqual(account))
            {
                return i;
            }
        }
        return -1;
	}
	
	/**
	 * Grows the accounts array by 5 indexes.
	 */
	private void grow() 
	{
		Account[] tempAcc = new Account[accounts.length+5];
        for (int i = 0; i < size; i++)
        {
            tempAcc[i] = accounts[i];
        }
        accounts = tempAcc;
	}
	
	/**
	 * Adds the input account into the array. Grows the array size if necessary.
	 * @param account The account to add to the array.
	 * @return Boolean true if the account is added successfully, false if the account is already in the array.
	 */
	public boolean add(Account account) //return false if account exists
	{
		if(find(account) >= 0)
		{
			System.out.println("Account is already in the database.");
			return false;
		}
		
		if (size+1 > accounts.length)
        {
            grow();
        }
        accounts[size] = account;
        size += 1;
        System.out.println("Account opened and added to the database.");
        return true;
	} 
	
	/**
	 * Removes the input account from the array.
	 * @param account The account to be removed.
	 * @return Boolean true if the account is removed successfully, false if the account is not found.
	 */
	public boolean remove(Account account) //return false if account doesn’t exist
	{
		int index = find(account);
        if (index < 0)
        {
            System.out.println("Account does not exist.");
            return false;
        }
        else
        {
            size--;
            accounts[index] = accounts[size];
            accounts[size] = null;
        }
        System.out.println("Account closed and removed from the database.");
        return true;
	} 
	
	/**
	 * Deposits the input amount of money into the input account.
	 * @param account The account to be deposited into.
	 * @param amount The amount of money to deposit.
	 * @return Boolean true if deposit is successful, false if account is not found.
	 */
	public boolean deposit(Account account, double amount) 
	{
		if(!(find(account) >= 0))
		{
			System.out.println("Account does not exist.");
            return false;
		}
		
		int index = find(account);
		
		System.out.println(String.format("%.02f", amount) + " deposited to account.");
		accounts[index].credit(amount);
		return true;
	}
	
	/**
	 * Withdraws the input amount of money from the input account.
	 * @param account The account to be withdrawn from.
	 * @param amount The amount of money to withdraw.
	 * @return 0 if withdrawal was successful, 1 if the account had insufficient funds, -1 if the account is not found.
	 */
	public int withdrawal(Account account, double amount) //return 0: withdrawal successful, 1: insufficient funds, -1 account doesn’t exist
	{
		if(!(find(account) >= 0))
		{
			System.out.println("Account does not exist.");
            return -1;
		}
		
		int index = find(account);
		
		if(accounts[index].getBalance() < amount)
		{
			System.out.println("Insufficient Funds.");
            return 1;
		}
		
		if(accounts[index] instanceof MoneyMarket)
		{
			((MoneyMarket)accounts[index]).incWithdrawal();
		}
		
		System.out.println(String.format("%.02f", amount) + " withdrawn from account.");
		accounts[index].debit(amount);
		return 0;
	}
	
	/**
	 * Sorts the array by opening date of the accounts in ascending order using selection sort.
	 */
	private void sortByDateOpen() //sort in ascending order
	{
        for (int i = 0; i < size-1; i++) 
        { 
            int min = i; 
            for (int j = i+1; j < size; j++) 
            {
                if (accounts[min].getDate().compareTo(accounts[j].getDate()) > 0)
                    min = j; 
            }
            
            Account temp = accounts[min]; 
            accounts[min] = accounts[i]; 
            accounts[i] = temp; 
        } 
	}
	
	/**
	 * Sorts the array by last name of the account's holder in ascending order using selection sort.
	 */
	private void sortByLastName()  //sort in ascending order
	{
		for (int i = 0; i < size-1; i++) 
        { 
            int min = i; 
            for (int j = i+1; j < size; j++) 
            {
                if (accounts[j].getHolderName('l').compareTo(accounts[min].getHolderName('l')) < 0)
                    min = j; 
            }
            
            Account temp = accounts[min]; 
            accounts[min] = accounts[i]; 
            accounts[i] = temp; 
        } 
	}
	
	/**
	 * Prints each account in the array in ascending order by date open.
	 * Includes extra unique information about interest and fees, and applies those to the account.
	 */
	public void printByDateOpen() 
	{
		sortByDateOpen();
		
		System.out.println('\n' + "--Printing statements by date opened--");
		
		for(int i = 0; i < size; i++)
			System.out.println('\n' + accounts[i].toString() + accounts[i].printHelper());
		
		System.out.println("--end of printing--" + '\n');
	}
	
	/**
	 * Prints each account in the array in ascending order by last name.
	 * Includes extra unique information about interest and fees, and applies those to the account.
	 */
	public void printByLastName() 
	{
		sortByLastName();
		
		System.out.println('\n' + "--Printing statements by last name--");
		
		for(int i = 0; i < size; i++)
			System.out.println('\n' + accounts[i].toString() + accounts[i].printHelper());
		
		System.out.println("--end of printing--");
	}
	
	/**
	 * Lists the accounts in the array.
	 */
	public void printAccounts() 
	{
		System.out.println("--Listing accounts in the database--");
		
		for(int i = 0; i < size; i++)
			System.out.println(accounts[i].toString());
		
		System.out.println("--end of listing--");
	}
	
	/**
	 * Gets the current number of accounts in the array.
	 * @return The current number of accounts in the array.
	 */
	public int getSize()
	{
		return size;
	}
}