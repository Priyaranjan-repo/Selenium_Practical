package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrcatceDemo {

	public static String url = "https://automationteststore.com/";

	public static void main(String[] args) throws Exception {

		WebDriver dr = new EdgeDriver();
		dr.get(url);
		dr.manage().window().maximize();

		By filtertextLocator = By.id("filter_keyword");

		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(15L));

		WebElement filtertxtBox = wait.until(ExpectedConditions.visibilityOfElementLocated(filtertextLocator));
		filtertxtBox.sendKeys("Hello ");

		// performing cntrl+all
		Actions act = new Actions(dr);
//		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();// seelct
//		Thread.sleep(5000);
//		act.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();// cut
//
//		Thread.sleep(5000);
//		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();// paste
//		act.keyDown(Keys.SHIFT).sendKeys("ranjan").keyUp(Keys.SHIFT).perform();

		// Hover on mouse

		By navLocator = By.xpath("//ul[contains(@class,'nav-pills categorymenu')]//a[contains(text(),'Apparel')]");

		act.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(navLocator))).perform();

	}

}
