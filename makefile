install:
	@echo 'Started Compiling files'
	@mkdir src
	@javac -d . Casual.java Contact.java ContactList.java \
	MainWindow.java PersonalFriend.java ProfessionalFriend.java \
	Relative.java
	@echo -e 'compiled files\nRun java src.MainWindow to start the program'
	@echo -e 'And make clean to remove all class files\nNote: Before running make again you have to use make clean'
clean:
	@rm -r src
