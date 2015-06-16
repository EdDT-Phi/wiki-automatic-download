import java.util.*;
import java.io.*;
public class seperate{
	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new FileReader("output.html"));){
			
			int count = 0;
			boolean newPage = true;
			String line = "";
			String title = "";
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("temp/Main Page.html")));
			while((line = reader.readLine())!= null) { //&& i --> 0){
				// expect <doc at start
				if(newPage){
					if (line.substring(0, 4).equals("<doc")) {
						title = line.substring(line.indexOf("\" title=\"" ) + 9, line.indexOf("\">"));
						//System.out.println(title);
						newPage = false;
						bw.close();
						bw = new BufferedWriter(new FileWriter(new File("temp/" + title.replaceAll("\\/","") + ".html")));
					} else {
						System.out.println("Expected <doc but found " + line.substring(0, 4));
						break;
					}
				}

				bw.write(line + "\n");

				// end of doc
				if(line.equals("</doc>")){
					// Output new file
					newPage = true;
					count++;
				}
			}

			System.out.println(count);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}