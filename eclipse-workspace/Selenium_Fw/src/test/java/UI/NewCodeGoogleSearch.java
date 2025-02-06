package UI;

import java.io.File;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewCodeGoogleSearch {
	public static WebDriver driver;
	public static String url = "https://google.com";
	public static String amazonUrl = "https://www.amazon.in/";
	public static String flipkartUrl = "https://www.flipkart.com/";
	public static String searchProductOnGoogle = "iphone";

	public static void main(String[] args) {

		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys(searchProductOnGoogle + " ");
			Thread.sleep(3000);
			getScreenshot("googleSearch");
			List<WebElement> searchlight = driver.findElements(By.xpath("//*[@class='wM6W7d']/span"));
			PrintWriter writer = new PrintWriter("googleSearch.txt", "UTF-8");
			System.out.println("Google search result");
			for (int i = 0; i < searchlight.size(); i++) {
				String product = searchlight.get(i).getText().trim();
				if (product != "") {
					System.out.println(i + ". " + searchlight.get(i).getText().trim());
					writer.println(searchlight.get(i).getText().trim());
				}
			}
			writer.close();
			File file = new File("googleSearch.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String product = sc.nextLine();
				System.out.println("searching product on amazon: " + product);
				searchProductOnAmazon(product);
				System.out.println("searching product on flipkart: " + product);
				searchProductOnFlipkart(product);
			}
			/*
			 * List<String> products = Files.readAllLines(Paths.get("googleSearch.txt"));
			 * for (int i = 0; i < products.size(); i++) {
			 * searchProductOnAmazon(products.get(i)); }
			 */
			driver.quit();
		} catch (Exception e) {
		}
	}

	private static void searchProductOnAmazon(String product) {
		try {
			driver.navigate().to(amazonUrl);
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(product + Keys.ENTER);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
			Thread.sleep(1200);
			getScreenshot("amazon/" + product);
		} catch (Exception e) {
		}
	}

	private static void searchProductOnFlipkart(String product) {
		try {
			driver.navigate().to(flipkartUrl);
			driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"))
					.sendKeys(product + Keys.ENTER);
			Thread.sleep(1200);
			getScreenshot("flipkart/" + product);
		} catch (Exception e) {
		}
	}

	private static void getScreenshot(String fileName) {
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("./screenshot/" + fileName + ".png"));
		} catch (Exception e) {
		}
	}
}
