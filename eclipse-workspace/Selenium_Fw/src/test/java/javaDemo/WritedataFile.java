package javaDemo;

import java.io.FileWriter;
import java.io.IOException;

public class WritedataFile {

	public static void main(String[] args) throws IOException {

		try {

			for (int i = 0; i <= 15; i++) {
				String fileName = "Files/test" + i + ".txt";

				FileWriter fw = new FileWriter(fileName);
				fw.write("This dummy file with path name:" + fileName);

				fw.close();
				System.out.println(fileName + "created");
			}

		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());

		}
	}
}
