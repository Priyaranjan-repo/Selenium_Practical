package UI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionExample {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		String url = "https://www.amazon.in/";

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone ");
		Thread.sleep(3000);
		AutoSuggestionExample.get_Screenshot();

		AutoSuggestionExample.writeDataFile();

//		List<WebElement> list = driver
//				.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
//
//		System.out.println(list.size());
//
//		for (int i = 0; i < list.size(); i++) {
//
//			String value = list.get(i).getText().trim();
//
//			System.out.println(value);
//
//		}

	}

	static void get_Screenshot() {

		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File(".//Screenshot/test1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void readDataFile() throws IOException {
		FileReader file = new FileReader(".//readFile/fileTest.txt");

		BufferedReader br = new BufferedReader(file);

		String str;

		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}

		br.close();

	}

	static void writeDataFile() throws IOException {

		// FileWriter
		// bufferFileWriter

		FileWriter fw = null;

		String pathName = "filename.txt";

		try {
			File filewrite = new File(pathName);

			fw = new FileWriter(filewrite);
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());

		}

		fw.write("Hello World! This is java file write ");

		fw.close();

	}
}
