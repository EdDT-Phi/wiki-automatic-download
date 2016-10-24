import java.util.*;
import java.io.*;
public class Seperate{

	// Program to seperate several html pages in one file to unique files.

	public static void main(String[] args) {
		BufferedWriter bw = null;
		try (BufferedReader reader = new BufferedReader(new FileReader("output.html"));){
			int num_pages = 0;
			boolean newPage = true;
			String line = "";
			String title = "";
			bw = new BufferedWriter(new FileWriter(new File("temp/Main Page.html")));
			while((line = reader.readLine())!= null) {
				if(newPage){
					// expect <doc at start
					if (line.substring(0, 4).equals("<doc")) {
						title = line.substring(line.indexOf("\" title=\"" ) + 9, line.indexOf("\">"));
						newPage = false;
						bw.close();
						bw = new BufferedWriter(new FileWriter(new File("temp/" + title.replaceAll("\\/","") + ".html")));
					} else {
						System.out.println("Expected <doc but found " + line.substring(0, 4));
						break;
					}
				}

				bw.write(line + "\n");

				// end of page, start new page at next pass
				if(line.equals("</doc>")){
					newPage = true;
					num_pages++;
				}
			}

			System.out.println(num_pages);
			bw.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}