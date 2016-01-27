import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * This class extends Contact class and is meant to
 * Save Contacts of Relatives
 * 
 * @author Madhu Kumar Dadi
 * @version 22.1.2016
 */

public class Relative extends Contact{
	public LocalDate birth_day;
	public LocalDate last_meet;

	/**
	 * Default constructor for Relative class
	 * 
	 * @param void
	 */
	
	public Relative()
	{
		birth_day=LocalDate.now();
		last_meet=LocalDate.now();
	}
	
	/**
	 * This method prompts user for details of a new user
	 * 
	 * @param input Scanner to scan input from user
	 * @return void
	 */
	
	public 
	boolean addContact(Scanner input)
	{
		System.out.print("Name? ");
		this.name=input.nextLine();
		this.mobile=ContactList.getNumber(input);
		if(this.mobile==null) return false;
		this.email=ContactList.getEmail(input);
		this.birth_day=ContactList.getDate(input,"Birth Day ");
		this.last_meet=ContactList.getDate(input,"Last Meet ");
		return true;
	}
	
	/**
	 * This method saves the Relative object to a file
	 * 
	 * @param void
	 * @return void
	 */
	
	public 
	void save() {
		try {

			BufferedWriter writer=new BufferedWriter(new FileWriter("./Data/Relative/"
			+this.mobile+".dat"));
			writer.write("0\n");
			writer.write(this.name+"\n");
			writer.write(this.email+"\n");
			writer.write(this.birth_day.toString()+"\n");
			writer.write(this.last_meet.toString()+"\n");
			writer.close();	
			writer=new BufferedWriter(new FileWriter("./Data/Relative/relative.dat",true));
			writer.write(this.mobile+"\n");
			writer.close();
		} catch (IOException ioe) {
			System.out.print(ioe+"\nCan't save the data Returning..\n");
		}
		System.out.print("Saved file..\n");
	}
	
	/**
	 * This program lists the name of the contacts of this Category
	 * 
	 * @param i starting number to start indexing from
	 * @param string For handling Substring matching
	 * @return count of number of contacts in Relative Contacts Category
	 */
	
	public static
	int list(int i,String string)
	{
		int count=i;
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("./Data/Relative/relative.dat"));
			String number=null;
			bReader.readLine();
			number=bReader.readLine();
			if(number!=null){
				BufferedReader reader=null;
				String name=null;
				while(number!=null)
				{
					reader=new BufferedReader(new FileReader("./Data/Relative/"+number+".dat"));
					reader.readLine();
					name=reader.readLine();
					if(string==null)
					{
						System.out.print(count+"."+name+"\n");
						count++;
					}
					else
					{
						if(name.toLowerCase().contains(string))
						{
							System.out.print("Relative \nName: "+name+"\n");
							count++;
							print(reader, number,0);
							System.out.print("************************************\n\n");
						}
					}
					reader.close();
					number=bReader.readLine();
				}
				bReader.close();
			}
		}
		catch(IOException ioe){
			System.out.print("Data has been manipulated! Make a fresh Install\n");
		}
		return count-1;
	}
	
	/**
	 * This method reads and prints details of the Contact
	 * 
	 * @param bReader BufferedReader pointed to the Contact to be printed
	 * @param number Contact number as String
	 * @param i To check if we have to print name or not
	 * @return void
	 */
	
	public static
	void print(BufferedReader bReader,String number,int i)
	{
		try{
			if(i==1)System.out.print("Name: "+bReader.readLine()+"\n");
			System.out.print("Number: "+number+"\n");
			System.out.print("Email Id: "+bReader.readLine()+"\n");
			System.out.print("Date of Birth: "+bReader.readLine()+"\n");
			System.out.print("Last met: "+bReader.readLine()+"\n");
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
			return;
		}
	}
}