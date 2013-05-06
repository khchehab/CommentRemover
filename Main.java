import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		File f = new File (args[0]);
		
		if (!f.exists()) {
			System.err.println("File does not exist.");
			System.exit(1);
		}
		
		// f exists
		Scanner in = null;
		PrintStream out = null;
		try {
			String result = "";
			in = new Scanner (f);
			
			while (in.hasNextLine()) {
				String line = in.nextLine();
				
				if (line.matches("((.)*)(\\s*)(//)((\\s)*)((.)*)"))
					continue;
				else
					result += line + "\n";
			}
			
			out = new PrintStream(f);
			out.print(result);
		} catch (FileNotFoundException e) {
			System.err.println("File was not found.");
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}