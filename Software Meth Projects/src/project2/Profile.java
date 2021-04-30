package project2;

/**
 * The Profile class holds the first and last names of potential account holders.
 * @author Martin Colucci and Pujan Patel
 */
public class Profile {
	private String fname;
	private String lname;
	
	/**
	 * Constructor for the profile object.
	 * Initializes the first and last name fields of the object using the input strings.
	 * @param first The first name.
	 * @param last The last name.
	 */
	public Profile(String first, String last)
	{
		fname = first;
		lname = last;
	}
	
	/**
	 * Gets the full name on the profile.
	 * @return String of the full name.
	 */
	public String getName() 
	{
		return (fname + " " + lname);
	}
	
	/**
	 * Gets the first name on profile.
	 * @return String of the first name.
	 */
	public String getFName() 
	{
		return (fname);
	}
	
	/**
	 * Gets the last name of the profile.
	 * @return String of the last name.
	 */
	public String getLName() 
	{
		return (lname);
	}

	/**
	 * Used to input a new first and last name for the profile.
	 * @param f The new first name.
	 * @param l The new last name.
	 */
	public void inFirstLast(String f, String l) {
		fname = f;
		lname = l;
	}
}