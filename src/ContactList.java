import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class implements the Contact classes and its child classes
 * 
 * @author Madhu Kumar Dadi
 * @version 22.1.2016
 *
 */

public class ContactList {

	/**
	 * @param args no arguments required
	 */
	public static void main(String[] args) {
		int option;
		while(true){
			System.out.print("\n****************************************"
					+ "\n------------- Contact List -------------\n"
					+ "****************************************\n"
					+ "1.Add a Contact\t2.Delete a Contact\n"
					+ "3.Display all\t4.Display by Category\n"
					+ "5.Search Name\t6.Exit\nEnter your option: ");
			Scanner input=new Scanner(System.in);
			option=getInt(input);
			input.nextLine();
			switch (option) {
			case 1:
				System.out.print("Type of Contact:\n1.Relative\t2.Personal\n3.Professional\t4.Casual\n"
						+ "5.Back\nEnter your option: ");
				option=getInt(input);
				input.nextLine();
				boolean check_add;
				switch(option){
				case 1:
				{
					Relative relative=new Relative();
					check_add=relative.addContact(input);
					if(!check_add) break;
					String check=null;
					while (true) {
						System.out.print("Do you want to save this contact(Y or N)? ");
						check=input.nextLine();
						if(check.equalsIgnoreCase("y")||check.equalsIgnoreCase("yes"))
						{
							relative.save();
							break;
						}
						else if(check.equalsIgnoreCase("n")||check.equalsIgnoreCase("no"))
						{
							break;
						}
						else{
							System.out.print("Invalid Answer!\n");
						}
					}
				}
					break;
				case 2:
				{
					PersonalFriend pFriend=new PersonalFriend();
					check_add=pFriend.addContact(input);
					if(!check_add) break;
					String check=null;
					while (true) {
						System.out.print("Do you want to save this contact(Y or N)? ");
						check=input.nextLine();
						if(check.equalsIgnoreCase("y")||check.equalsIgnoreCase("yes"))
						{
							pFriend.save();
							break;
						}
						else if(check.equalsIgnoreCase("n")||check.equalsIgnoreCase("no"))
						{
							break;
						}
						else{
							System.out.print("Invalid Answer!\n");
						}
					}
				}
					break;
				case 3:
				{
					ProfessionalFriend professionalFriend=new ProfessionalFriend();
					check_add=professionalFriend.addContact(input);
					if(!check_add) break;
					String check=null;
					while (true) {
						System.out.print("Do you want to save this contact(Y or N)? ");
						check=input.nextLine();
						if(check.equalsIgnoreCase("y")||check.equalsIgnoreCase("yes"))
						{
							professionalFriend.save();
							break;
						}
						else if(check.equalsIgnoreCase("n")||check.equalsIgnoreCase("no"))
						{
							break;
						}
						else{
							System.out.print("Invalid Answer!\n");
						}
					}
				}
				break;
				case 4:
				{
					Casual casual=new Casual();
					check_add=casual.addContact(input);
					if(!check_add) break;
					String check=null;
					while (true) {
						System.out.print("Do you want to save this contact(Y or N)? ");
						check=input.nextLine();
						if(check.equalsIgnoreCase("y")||check.equalsIgnoreCase("yes"))
						{
							casual.save();
							break;
						}
						else if(check.equalsIgnoreCase("n")||check.equalsIgnoreCase("no"))
						{
							break;
						}
						else{
							System.out.print("Invalid Answer!\n");
						}
					}
				}
					break;
				case 5:
					break;
				default:
					System.out.print("Invalid Option!\nGoing Back..\n");
					break;
				}
				break;
			case 2:
			{
				System.out.print("\nType of cantact: \n1.Relative\t"
						+ "2.Personal\n3.Professional\t4.Casual\n5.Back\nEnter index of contact: ");
				option=getInt(input);
				input.nextLine();
				int no=1;
				String dir=null,path=null;
				switch(option){
				case 1:
				{
					no=Relative.list(no, null);
					dir="Relative";
					path="relative";
					break;
				}
				case 2:
				{
					no=PersonalFriend.list(no, null);
					dir="Personal";
					path="personal";
					break;
				}
				case 3:
				{
					no=ProfessionalFriend.list(no, null);
					dir="Professional";
					path="professional";
					break;
				}
				case 4:
				{
					no=Casual.list(no, null);
					dir="Casual";
					path="casual";
					break;
				}
				case 5:
				{
					continue;
				}
				default:
				{
					System.out.print("\nGoing back...\nEnter a Valid Option next time!\n");
					continue;
				}
				}
				System.out.print("Enter the index of Contact you want to delete: ");
				option=getInt(input);
				input.nextLine();
				if(option<1||option>no) {
					System.out.print("\nGoing Back..\nEnter a Valid Option next time!\n");
					break;
				}
				String file=null;
				File tmp_file=new File("./Data/"+dir+"/"+path+".dat.bak");
				File del_file=new File("./Data/"+dir+"/"+path+".dat");
				rename(del_file, tmp_file);
				try{
					BufferedReader bReader=new BufferedReader(new FileReader("./Data/"+dir
							+ "/"+path+".dat.bak"));
					file=bReader.readLine();
					int i=0;
					BufferedWriter writer=new BufferedWriter(new FileWriter("./Data/"+dir
							+ "/"+path+".dat"));
					while(file!=null)
					{
						if(i!=option) writer.write(file+"\n");
						i++;
						file=bReader.readLine();
					}
					del_file=new File("./Data/"+dir+"/"+file+".dat");
					bReader.close();
					writer.close();
					tmp_file.delete();
					del_file.delete();
				}
				catch(IOException ioe)
				{
					System.out.print("Data is manipulated\nMake a fresh install\n");
				}
			}
				break;
			case 3:
			{
				System.out.print("\nContacts: \n");
				int no,no1,no2,no3;
				no=Relative.list(1,null);
				no1=PersonalFriend.list(no+1,null);
				no2=ProfessionalFriend.list(no1+1,null);
				no3=Casual.list(no2+1,null);
				String dir=null,type=null;
				try{
					System.out.print("Enter the Index of the Contact: ");
					int no4=getInt(input);
					input.nextLine();
					if(no4<=0||no4>no3){
						System.out.print("Out of Index\nGoing Back..\n");
						break;
					}
					if(no4<=no)
					{
						dir="Relative";
						type="relative";
						option=no4;
					}
					else if(no4<=no1)
					{
						dir="Personal";
						type="personal";
						option=no4-no;
					}
					else if (no4<=no2) {
						dir="Professional";
						type="professional";
						option=no4-no1;
					}
					else {
						dir="Casual";
						type="casual";
						option=no4-no2;
					}
					BufferedReader bReader=new BufferedReader(new FileReader("./Data/"
							+dir+"/"+type+".dat"));
					for(int i=0;i<=option;i++)
					{
						type=bReader.readLine();
					}
					bReader.close();
					bReader =new BufferedReader(new FileReader("./Data/"+dir+"/"+type+".dat"));
					option=Integer.parseInt(bReader.readLine());
					switch(option)
					{
						case 0:
							Relative.print(bReader,type,1);
							break;
						case 1:
							PersonalFriend.print(bReader,type,1);
							break;
						case 2:
							ProfessionalFriend.print(bReader,type,1);
							break;
						case 3:
							Casual.print(bReader,type,1);
							break;
					}
					bReader.close();
				}
				catch(IOException ioe)
				{
					System.out.println(ioe);
					break;
				}
				break;
			}
			case 4:
			{
				System.out.print("\nCategory: \n1.Relative\t"
						+ "2.Personal\n3.Professional\t4.Casual\n5.Back\nEnter your option: ");
				option=getInt(input);
				input.nextLine();
				if(option<1||option>5) {
					System.out.print("Invalid Option!\n\n");
					break;
				}
				String type=null,dir=null;
				switch(option)
				{
				case 1:
					System.out.print("Relatives: \n");
					option=Relative.list(1,null);
					dir="Relative";
					type="relative";
					break;
				case 2:
					System.out.print("Personal Friends: \n");
					option=PersonalFriend.list(1,null);
					dir="Personal";
					type="personal";
					break;
				case 3:
					System.out.print("Professional Friends: \n");
					option=ProfessionalFriend.list(1,null);
					dir="Professional";
					type="professional";
					break;
				case 4:
					System.out.print("Casual acquaintances: \n");
					option=Casual.list(1,null);
					dir="Casual";
					type="casual";
					break;
				case 5:
					continue;
				}
				try{
					BufferedReader bReader=new BufferedReader(new FileReader("./Data/"
							+dir+"/"+type+".dat"));
					System.out.print("Enter the Index of the Contact: ");
					int no=getInt(input);
					input.nextLine();
					if(no<=0||no>option){
						System.out.print("Out of Index\nGoing Back..\n");
						break;
					}
					for(int i=0;i<=no;i++)
					{
						type=bReader.readLine();
					}
					bReader.close();
					bReader =new BufferedReader(new FileReader("./Data/"+dir+"/"+type+".dat"));
					option=Integer.parseInt(bReader.readLine());
					switch(option)
					{
						case 0:
							Relative.print(bReader,type,1);
							break;
						case 1:
							PersonalFriend.print(bReader,type,1);
							break;
						case 2:
							ProfessionalFriend.print(bReader,type,1);
							break;
						case 3:
							Casual.print(bReader,type,1);
							break;
					}
					bReader.close();
				}
				catch(IOException ioe)
				{
					System.out.println(ioe);
					break;
				}
				
			}
			break;
			case 5:
			{
				System.out.print("Search: ");
				String name=null;
				name=input.nextLine();
				name=name.toLowerCase();
				if(name==null) 
				{
					System.out.print("You have to enter something to search\n"
							+ "Better luck next time\n");
					break;
				}
				Relative.list(1, name);
				PersonalFriend.list(1, name);
				ProfessionalFriend.list(1, name);
				Casual.list(1, name);
			}
			break;
			case 6:
				return;
			default:
				System.out.print("Enter a Valid option!\n");
				break;
			}
		}
	}
	
	
	/**
	 * This function is to take integer as input from user with
	 * all exceptions handled
	 * 
	 * @param input This is the Scanner that scans input from user
	 * @return integer scanned by the Scanner from the user
	 */
	
	public static
	int getInt(Scanner input){
		int i;
		while(true)
		{
			try{
				i=input.nextInt();
				break;
			}
			catch(InputMismatchException mm)
			{
				input.nextLine();
				System.out.print("Wrong Input!\nEnter a Valid Integer : ");
				continue;
			}
		}
		return i;
	}
	
	/**
	 * This function is to take LocalDate as input from user with
	 * all exceptions handled
	 * 
	 * @param input This is the Scanner that scans input from user
	 * @return LocalDate from integers scanned by the Scanner from the user
	 */
	
	public static
	LocalDate getDate(Scanner input,String prompt)
	{
		int day,month,year;
		LocalDate date=LocalDate.now();
		while(true)
		{
			System.out.print(prompt+"(dd mm yyyy format)? ");
			day=ContactList.getInt(input);
			month=ContactList.getInt(input);
			year=ContactList.getInt(input);
			input.nextLine();
			try{
				date=LocalDate.of(year, month, day);
				break;
			}
			catch(DateTimeException dte)
			{
				System.out.print("Not given in correct format\n");
			}
		}
		return date;
	}
	
	/**
	 * This function is to take String as input from user with
	 * all exceptions handled
	 * 
	 * @param input This is the Scanner that scans input from user
	 * @return String scanned by the Scanner from the user
	 */
	
	public static 
	String getEmail(Scanner input) {
		String email=null;
		int error=1;
		while(true){
			System.out.print("Email ID? ");
			email=input.nextLine();
			for(int i=1;i<email.length();i++)
			{
				if(email.charAt(i)=='@')
				{
					for(int j=i+2;j<email.length()-1;j++)
					{
						if(email.charAt(j)=='.')
						{
							error=0;
							break;
						}
					}
					break;
				}
			}
			if(error==1)
				{
					System.out.print("Invalid Email ID !\n");
					continue;
				}
			break;
		}
		return email;
	}
	
	/**
	 * This function is to take String as input from user with
	 * all exceptions handled
	 * 
	 * @param input This is the Scanner that scans input from user
	 * @return String scanned by the Scanner from the user
	 */
	
	public static
	String getNumber(Scanner input)
	{
		String number=null;
		while(true)
		{
			System.out.print("Phone Number? ");
			number=input.nextLine();
			if(number.length()>=10&&((number.charAt(0)>='0'&&number.charAt(0)<='9')
					||number.charAt(0)=='+'))
			{
				for(int i=1;i<number.length();i++)
				{
					if(number.charAt(i)>='0'&&number.charAt(i)<='9')
					{
						continue;
					}
					System.out.print("Invalid Phone Number!\n");
					break;
				}
				break;
			}
			else {
				System.out.print("Invalid Phone Number!\n");
			}
		}
		if(!phoneAvailable(number))
		{
			System.out.print("Number Can't be added Check in the above list"
					+ " if contact you want to add is printed\nAborting..\n");
			return null;
		}
		return number;
	}
	
	/**
	 * This method renames source to destination
	 * 
	 * @param source file to renamed
	 * @param dest file renamed to
	 * @return void
	 */
	
	public static
	void rename(File source,File dest)
	{
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter(dest));
			BufferedReader reader=new BufferedReader(new FileReader(source));
			String handle=reader.readLine();
			while(handle!=null)
			{
				writer.write(handle+"\n");
				handle=reader.readLine();
			}
			writer.close();
			reader.close();
			source.delete();
		}
		catch(IOException ioe)
		{
			System.out.println(ioe);
			return;
		}
	}
	
	/**
	 * this method checks if the phone number is already added
	 * 
	 * @param phone String containing phone number
	 * @return
	 */
	
	public static
	boolean	phoneAvailable(String phone) {
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("./Data/Relative/relative.dat"));
			String check=bReader.readLine();
			while(check!=null)
			{
				if(check.equals(phone))
				{
					bReader.close();
					bReader=new BufferedReader(new FileReader("./Data/Relative/"+phone+".dat"));
					bReader.readLine();
					Relative.print(bReader, phone, 1);
					bReader.close();
					return false;
				}
				check=bReader.readLine();
			}
			bReader.close();
			bReader=new BufferedReader(new FileReader("./Data/Personal/personal.dat"));
			check=bReader.readLine();
			while(check!=null)
			{
				if(check.equals(phone))
				{
					bReader.close();
					bReader=new BufferedReader(new FileReader("./Data/Personal/"+phone+".dat"));
					bReader.readLine();
					PersonalFriend.print(bReader, phone, 1);
					bReader.close();
					return false;
				}
				check=bReader.readLine();
			}
			bReader.close();
			bReader=new BufferedReader(new FileReader("./Data/Professional/professional.dat"));
			check=bReader.readLine();
			while(check!=null)
			{
				if(check.equals(phone))
				{
					bReader.close();
					bReader=new BufferedReader(new FileReader("./Data/Professional/"+phone+".dat"));
					bReader.readLine();
					ProfessionalFriend.print(bReader, phone, 1);
					bReader.close();
					return false;
				}
				check=bReader.readLine();
			}
			bReader.close();
			bReader=new BufferedReader(new FileReader("./Data/Casual/casual.dat"));
			check=bReader.readLine();
			while(check!=null)
			{
				if(check.equals(phone))
				{
					bReader.close();
					bReader=new BufferedReader(new FileReader("./Data/Casual/"+phone+".dat"));
					bReader.readLine();
					Casual.print(bReader, phone, 1);
					bReader.close();
					return false;
				}
				check=bReader.readLine();
			}
			bReader.close();
		}
		catch(IOException ioe)
		{
			return false;
		}
		return true;
	}
}
