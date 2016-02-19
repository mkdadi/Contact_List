package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a description of class ContactList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContactList
{
	
	public static
	void saveContacts()
	{
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter("relatives.txt"));
			for(int i=0;i<MainWindow.relatives.size();i++){
				writer.write(MainWindow.relatives.get(i).name+"\n");
				writer.write(MainWindow.relatives.get(i).mobile+"\n");
				writer.write(MainWindow.relatives.get(i).email+"\n");
				writer.write(MainWindow.relatives.get(i).birth_day.toString()+"\n");
				writer.write(MainWindow.relatives.get(i).last_meet.toString()+"\n");
			}
			writer.close();
		}
		catch(Exception e){}
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter("personals.txt"));
			for(int i=0;i<MainWindow.pFriends.size();i++){
				writer.write(MainWindow.pFriends.get(i).name+"\n");
				writer.write(MainWindow.pFriends.get(i).mobile+"\n");
				writer.write(MainWindow.pFriends.get(i).email+"\n");
				writer.write(MainWindow.pFriends.get(i).context+"\n");
				writer.write(MainWindow.pFriends.get(i).date_met.toString()+"\n");
				writer.write(MainWindow.pFriends.get(i).events+"\n");
			}
			writer.close();
		}
		catch(Exception e){}
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter("professionals.txt"));
			for(int i=0;i<MainWindow.prFriends.size();i++){
				writer.write(MainWindow.prFriends.get(i).name+"\n");
				writer.write(MainWindow.prFriends.get(i).mobile+"\n");
				writer.write(MainWindow.prFriends.get(i).email+"\n");
				writer.write(MainWindow.prFriends.get(i).interests+"\n");
			}
			writer.close();
		}
		catch(Exception e){}
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter("casuals.txt"));
			for(int i=0;i<MainWindow.casuals.size();i++){
				writer.write(MainWindow.casuals.get(i).name+"\n");
				writer.write(MainWindow.casuals.get(i).mobile+"\n");
				writer.write(MainWindow.casuals.get(i).email+"\n");
				writer.write(MainWindow.casuals.get(i).when.toString()+"\n");
				writer.write(MainWindow.casuals.get(i).where+"\n");
				writer.write(MainWindow.casuals.get(i).what+"\n");
				writer.write(MainWindow.casuals.get(i).info+"\n");
			}
			writer.close();
		}
		catch(Exception e){}
	}
	
	public static
	void getContacts()
	{
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("relatives.txt"));
			String temp=new String(bReader.readLine());
			while(temp!=null)
			{
				Relative relative=new Relative();
				relative.name=temp;
				relative.mobile=bReader.readLine();
				relative.email=bReader.readLine();
				String [] date=bReader.readLine().split("-");
				relative.birth_day=LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				date=bReader.readLine().split("-");
				relative.last_meet=LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				MainWindow.relatives.add(relative);
				temp=bReader.readLine();
			}
			bReader.close();
		}
		catch(Exception e)
		{}
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("personals.txt"));
			String temp=new String(bReader.readLine());
			while(temp!=null)
			{
				PersonalFriend pFriend=new PersonalFriend();
				pFriend.name=temp;
				pFriend.mobile=bReader.readLine();
				pFriend.email=bReader.readLine();
				pFriend.context=bReader.readLine();
				String [] date=bReader.readLine().split("-");
				pFriend.date_met=LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				pFriend.events=bReader.readLine();
				MainWindow.pFriends.add(pFriend);
				temp=bReader.readLine();
			}
			bReader.close();
		}
		catch(Exception e)
		{}
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("professionals.txt"));
			String temp=new String(bReader.readLine());
			while(temp!=null)
			{
				ProfessionalFriend prFriend=new ProfessionalFriend();
				prFriend.name=temp;
				prFriend.mobile=bReader.readLine();
				prFriend.email=bReader.readLine();
				prFriend.interests=bReader.readLine();
				MainWindow.prFriends.add(prFriend);
				temp=bReader.readLine();
			}
			bReader.close();
		}
		catch(Exception e)
		{}
		try{
			BufferedReader bReader=new BufferedReader(new FileReader("casuals.txt"));
			String temp=new String(bReader.readLine());
			while(temp!=null)
			{
				Casual casual=new Casual();
				casual.name=temp;
				casual.mobile=bReader.readLine();
				casual.email=bReader.readLine();
				String [] date=bReader.readLine().split("-");
				casual.when=LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
				casual.where=bReader.readLine();
				casual.what=bReader.readLine();
				casual.info=bReader.readLine();
				MainWindow.casuals.add(casual);
				temp=bReader.readLine();
			}
			bReader.close();
		}
		catch(Exception e)
		{}
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
		return number;
	}
}
