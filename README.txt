------------------------------------------------------------------------------------------
                                      CONTACT LIST
------------------------------------------------------------------------------------------

PROJECT TITLE: Contact List for different types of Acquaintances

VERSION or DATE: 22/1/2016

HOW TO START THIS PROJECT: linux/mac users can install the program by running 'make' provided 
	in current directory and then run 'java src.ContactList' from this directory

For Windows: First install the project directories and files by running 
	'javac install.java' followed by 'java install'
	In cmd run 'javac Casual.java ContactList.java Contact.java PersonalFriend.java 
	ProfessionalFriend.java Relative.java' in current directory and then run the program 
	by the command 'java src.ContactList'

AUTHOR: Madhu Kumar Dadi

USER INSTRUCTIONS: Program should be run from this folder, it can't be run directly because 
	a package named src is being used.So, to run the file type 'java src.ContactList'.
	"And Strictly dont move the files among directories."

IDEA: Whenever a new contact is saved. It is saved to the folders 'Data/Relative/' ,
	'Data/Personal/', 'Data/Professional/' and 'Data/Casual/' depending on its category
	Whenever a contact is accessed, It is read from the file not stored in the local 
	variable, so that less memory is used,i.e, if we store all the contacts available 
	in local variables it uses more memory, so this program reads the contact only when
	it is accessed.Program may lead to errors if the installation file is not run.