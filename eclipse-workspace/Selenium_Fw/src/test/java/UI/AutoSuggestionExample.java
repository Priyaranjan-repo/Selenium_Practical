package UI;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		List<WebElement> list = driver
				.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {

			String value = list.get(i).getText().trim();

			System.out.println(value);

		}

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
}
