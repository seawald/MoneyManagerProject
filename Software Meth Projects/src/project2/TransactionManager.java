package project2;
import java.util.Scanner;

/**
 * The TransactionManager class is the I/O handler for manipulating data about the bank accounts.
 * @author Martin Colucci and Pujan Patel
 *
 */
public class TransactionManager {
	
	/**
	 * Starts the I/O loop for data manipulation.
	 */
	public void run()
	{
		Scanner in = new Scanner(System.in);
		AccountDatabase accDB = new AccountDatabase();
		
		String str;
		String command;
		String[] inputs;
		boolean active = true;
		
		System.out.println("Transaction processing starts.....");
		
		while(active)
		{
			str = in.nextLine();
			inputs = str.split(" ");
			command = inputs[0];
			double inputMoney;
			boolean inputConditional;
			
			switch (command)
			{
				case "OC": //Opens Checking account.
				{
					if(inputs.length != 6)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					if((inputs[5].toLowerCase()).equals("true") || (inputs[5].toLowerCase()).equals("false")) 
					{
						inputConditional = Boolean.parseBoolean(inputs[5].toLowerCase());
					} 
					else 
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					String[] splitDate = inputs[4].split("/");
					if(splitDate.length == 3)
					{
						Date tempDate = new Date(inputs[4]);
						if(!tempDate.isValid())
						{
							System.out.println(inputs[4] + " is not a valid date!");
							break;
						}
					}
					else
					{
						System.out.println(inputs[4] + " is not a valid date!");
						break;
					}
					
					Checking newCh = new Checking(inputs[1], inputs[2], inputMoney, inputs[4], inputConditional);
					accDB.add(newCh);				
					
					break;
				}
				
				case "OS": //Opens Savings account.
				{
					if(inputs.length != 6)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					if(inputs[5].toLowerCase().equals("true") || inputs[5].toLowerCase().equals("false")) 
					{
						inputConditional = Boolean.parseBoolean(inputs[5].toLowerCase());
					} 
					else 
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					String[] splitDate = inputs[4].split("/");
					if(splitDate.length == 3)
					{
						Date tempDate = new Date(inputs[4]);
						if(!tempDate.isValid())
						{
							System.out.println(inputs[4] + " is not a valid date!");
							break;
						}
					}
					else
					{
						System.out.println(inputs[4] + " is not a valid date!");
						break;
					}
					
					Savings newSav = new Savings(inputs[1], inputs[2], inputMoney, inputs[4], inputConditional);
					accDB.add(newSav);				
					
					break;
				}
				
				case "OM": //Opens Money Market account.
				{
					if(inputs.length != 5)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					String[] splitDate = inputs[4].split("/");
					if(splitDate.length == 3)
					{
						Date tempDate = new Date(inputs[4]);
						if(!tempDate.isValid())
						{
							System.out.println(inputs[4] + " is not a valid date!");
							break;
						}
					}
					else
					{
						System.out.println(inputs[4] + " is not a valid date!");
						break;
					}
					
					MoneyMarket newMM = new MoneyMarket(inputs[1], inputs[2], inputMoney, inputs[4]);
					accDB.add(newMM);				
					
					break;
				}
				
				case "CC": //Closes Checking account.
				{
					if(inputs.length != 3)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					Checking tempCh = new Checking(inputs[1], inputs[2], 0.0, "1/1/2020", false);
					
					accDB.remove(tempCh);
					break;
				}
				
				case "CS": //Closes Savings account.
				{
					if(inputs.length != 3)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					Savings tempSav = new Savings(inputs[1], inputs[2], 0.0, "1/1/2020", false);
					
					accDB.remove(tempSav);
					break;
				}
				
				case "CM": //Closes Money Market account.
				{
					if(inputs.length != 3)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					MoneyMarket tempMM = new MoneyMarket(inputs[1], inputs[2], 0.0, "1/1/2020");
					accDB.remove(tempMM);
					
					break;
				}
				
				case "DC": //Deposits into Checking account.
				{
					if(inputs.length != 4)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					Checking tempCh = new Checking(inputs[1], inputs[2], 0.0, "1/1/2020", false);
					accDB.deposit(tempCh, inputMoney);
					
					break;
				}
				
				case "DS": //Deposits into Savings account.
				{
					if(inputs.length != 4)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					Savings tempSav = new Savings(inputs[1], inputs[2], 0.0, "1/1/2020", false);
					accDB.deposit(tempSav, inputMoney);
					
					break;
				}
				
				case "DM": //Deposits into Money Market account.
				{
					if(inputs.length != 4)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					MoneyMarket tempMM = new MoneyMarket(inputs[1], inputs[2], 0.0, "1/1/2020");
					accDB.deposit(tempMM, inputMoney);
					
					break;
				}
				
				case "WC": //Withdraws from Checking account.
				{
					if(inputs.length != 4)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					Checking tempCh = new Checking(inputs[1], inputs[2], 0.0, "1/1/2020", false);
					accDB.withdrawal(tempCh, inputMoney);
					
					break;
				}
				
				case "WS": //Withdraws from Savings account.
				{
					if(inputs.length != 4)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					Savings tempSav = new Savings(inputs[1], inputs[2], 0.0, "1/1/2020", false);
					accDB.withdrawal(tempSav, inputMoney);
					
					break;
				}
				
				case "WM": //Withdraws from Money Market account.
				{
					if(inputs.length != 4)
					{
						System.out.println("Input data type mismatch.");
						break;
					}
					
					try {
						inputMoney = Double.parseDouble(inputs[3]);
					} catch (Exception NumberFOrmatException) {
						System.out.println("Input data type mismatch.");
						break;
					}
					
					MoneyMarket tempMM = new MoneyMarket(inputs[1], inputs[2], 0.0, "1/1/2020");
					accDB.withdrawal(tempMM, inputMoney);
					
					break;
				}
				
				case "PA": //Prints accounts in the database.
				{
					if(accDB.getSize() == 0)
						System.out.println("Database is empty.");
					else
						accDB.printAccounts();
					break;
				}
				
				case "PD": //Prints accounts in the database by date opened in ascending order.
				{
					if(accDB.getSize() == 0)
						System.out.println("Database is empty.");
					else
						accDB.printByDateOpen();
					break;
				}
				
				case "PN": //Prints accounts in the database by last name in ascending order.
				{
					if(accDB.getSize() == 0)
						System.out.println("Database is empty.");
					else
						accDB.printByLastName();
					break;
				}
				
				case "Q": //Cleans up and quits the program.
				{
					System.out.println('\n' + "Transaction processing completed.");
					in.close();
					active = false;
					break;
				}
				
				default: //Default case only happens when an unsupported command is entered.
				{
					System.out.println("Command '"+ command +"' not supported!");
					break;
				}
			}
		}
	}
}

