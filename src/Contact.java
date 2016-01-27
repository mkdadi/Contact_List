
/**
 * This Class is defined for making Contact Objects
 * 
 * @author Madhu Kumar Dadi
 * @version 22.1.2016
 */

public class Contact {
	public int type;
	public String name;
	public String mobile;
	public String email;
	
	/**
	 * This is constructor for  Contact class
	 * 
	 * @param name Name of the Contact
	 * @param mobile Phone Number of Contact
	 * @param email Email-Id of the contact
	 * 
	 */
	
	public Contact(String name,String mobile,String email)
	{
		this.type=1;
		this.name=name;
		this.mobile=mobile;
		this.email=email;
	}
	
	/**
	 * This is default constructor for  Contact class
	 * 
	 * @param Void
	 */
	
	public Contact()
	{
		this.type=1;
		this.name=null;
		this.mobile=null;
		this.email=null;
	}
}
