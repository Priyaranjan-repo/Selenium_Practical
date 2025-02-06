package javaDemo;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileDemo {

	public static void main(String[] args) throws Exception {

		FileReader file = new FileReader("C:\\Users\\priya\\OneDrive\\Desktop\\Filenametest1.txt");

		BufferedReader br = new BufferedReader(file);

		String str;

		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}

		br.close();

	}
}
