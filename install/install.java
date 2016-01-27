import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Madhu Kumar Dadi
 *
 */
public class install {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File personal_dir=new File("./Data/Personal/");
		File professional_dir=new File("./Data/Professional/");
		File relative_dir=new File("./Data/Relative/");
		File casual_dir=new File("./Data/Casual/");
		try{
			personal_dir.mkdirs();
			System.out.print("Created Directories Data/ and Data/Personal/ \n");
			professional_dir.mkdirs();
			System.out.print("Created Directory Data/Professional/ \n");
			relative_dir.mkdirs();
			System.out.print("Created Directory Data/Relative/ \n");
			casual_dir.mkdirs();
			System.out.print("Created Directory Data/Casual/ \n");
			File course=new File("./Data/Personal/personal.dat");
			course.createNewFile();
			System.out.print("Created File Data/Personal/personal.dat \n");
			BufferedWriter writer=new BufferedWriter(new FileWriter("./Data/Personal/personal.dat"));
			writer.write("personal\n");
			writer.close();
			course=new File("./Data/professional/professional.dat");
			course.createNewFile();
			System.out.print("Created File Data/professional/professional.dat \n");
			writer=new BufferedWriter(new FileWriter("./Data/professional/professional.dat"));
			writer.write("professional\n");
			writer.close();
			course=new File("./Data/Relative/relative.dat");
			course.createNewFile();
			System.out.print("Created File Data/Relative/relative.dat \n");
			writer=new BufferedWriter(new FileWriter("./Data/Relative/relative.dat"));
			writer.write("relative\n");
			writer.close();
			course=new File("./Data/Casual/casual.dat");
			course.createNewFile();
			System.out.print("Created File Data/Casual/casual.dat \n");
			writer=new BufferedWriter(new FileWriter("./Data/Casual/casual.dat"));
			writer.write("casual\n");
			writer.close();
		}
		catch(SecurityException se){
			System.out.println(se+"\nExiting...");
			return;
		}
		catch (IOException ioe) {
			System.out.println(ioe+"\nExiting...");
		}
	}
}

