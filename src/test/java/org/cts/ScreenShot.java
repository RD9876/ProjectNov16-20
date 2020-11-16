package org.cts;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Greens\\SeleniumOnePM\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		WebElement txtSearch = driver.findElement(By.id("inputValEnter"));
		txtSearch.sendKeys("Sanitizers");

		WebElement btnSearch = driver.findElement(By.xpath("//span[text()='Search']"));
		btnSearch.click();

		Thread.sleep(3000);

		WebElement product = driver.findElement(By.xpath(
				"//img[@title='9lives 70%(v/v) Alcohol Based Hand Sanitizer | 500 ml_Pack of 5 | Kills 99.9% Germs | with Tea Tree Oil & Organic Glycerine']"));
		product.click();

		// Windows handling

		// To get the parent Window Id
		String parId = driver.getWindowHandle();
		System.out.println(parId);

		// To get all the windows Id
		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println(allWindowsId);

		for (String x : allWindowsId) {

			if (!parId.equals(x)) {

				driver.switchTo().window(x);
			}

		}

		WebElement btnCart = driver.findElement(By.xpath("(//span[text()='ADD TO CART'])[1]"));
		btnCart.click();

	}
}
