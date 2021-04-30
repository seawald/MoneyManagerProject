package project2;

/**
 * The Date class stores information about dates.
 * @author Martin Colucci and Pujan Patel
 */
public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;
	
	/**
	 * Constructor for the Date object.
	 * Converts the input string of the date into integer form for storage.
	 * @param inDate The date as a string of format MM/DD/YYYY.
	 */
	public Date (String inDate)
	{
		String[] splitDate = inDate.split("/");
		
		month = Integer.parseInt(splitDate[0]);
		day = Integer.parseInt(splitDate[1]);
		year = Integer.parseInt(splitDate[2]);
	}
	
	/**
	 * Compares the date in frame to the date input.
	 * @param date The date being compared to.
	 * @return 1 if the date in frame is greater than the input date, 0 if equal, -1 if less than.
	 */
	public int compareTo(Date date) //return 0, 1, or -1
	{
		if(this.year > date.year)
			return 1;
		else if(this.year < date.year)
			return -1;
		
		if(this.month > date.month)
			return 1;
		else if(this.month < date.month)
			return -1;
		
		if(this.day > date.day)
			return 1;
		else if(this.day < date.day)
			return -1;
		
		return 0;
	} 
	
	/**
	 * Formats the date to a string.
	 * @return String of the date of format  MM/DD/YYYY.
	 */
	public String toString() //in the format mm/dd/yyyy
	{
		return (month + "/" + day + "/" + year);
	} 
	
	/**
	 * Checks if the date currently stored in the object is a real, possible date.
	 * @return Boolean true if it is a valid date, false if invalid.
	 */
	public boolean isValid()
	{
		boolean out = true;
		int monthDays = 30;
		
		//We don't check for a negative year because this could be used to track/simulate B.C. era accounts
		
		if(month == 4 || month == 6 || month == 9|| month == 11)
		{
			monthDays = 30;
		}
		else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
			monthDays = 31;
		}
		else if(month == 2)
		{
			if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) //Special case testing for leap years
				monthDays = 29;
			else
				monthDays = 28;
		}
		else
		{
			out = false;
		}
		
		if(day > monthDays || day < 1)
		{
			out = false;
		}
		
		return out;
	}
}