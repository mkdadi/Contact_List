install: src/makefile install/install.java
	javac install/install.java
	@echo "Proceeding to installation!"
	@sleep 5
	java install.install
	cd src;make
clean:
	cd src;make clean
