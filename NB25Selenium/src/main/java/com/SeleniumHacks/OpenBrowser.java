package com.SeleniumHacks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpenBrowser {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();   //UpperCasting
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
		String ttl = driver.getTitle();
		System.out.println(ttl);

		WebElement womenTab = driver.findElement(By.xpath("//a[@title='Women']"));
		Actions ac = new Actions(driver);
		ac.moveToElement(womenTab).build().perform();
		
		WebElement summerDress = driver.findElement(By.linkText("Summer Dresses"));
		summerDress.click();
		driver.getTitle();
		
		List<WebElement> SumDr = new ArrayList<>();
		SumDr = driver.findElements(By.xpath("//div[@class='right-block']/div/span[@itemprop='price']"));
		
		ArrayList<Double> SumDrPrices = new ArrayList<Double>();
		
		for(int i=0; i<SumDr.size(); i++) {
			System.out.println(SumDr.get(i).getText());
			String price = SumDr.get(i).getText();
			String number = price.replace("$", "");
			System.out.println(number);
			Double td = Double.valueOf(number);
			SumDrPrices.add(td);
		}
		
		System.out.println(SumDrPrices);
		double max = SumDrPrices.get(0);
		for(int i=0; i<SumDrPrices.size(); i++) {
			if(max<SumDrPrices.get(i)) {
				max=SumDrPrices.get(i);
			}
		}
		System.out.println("Highest priced  dress: "+max);
		
		String HP = String.valueOf(max);
		
		String first = "//div[@class='right-block']/div/span[contains(text(),'";
		String second ="')]/parent::div/following-sibling::div//span[contains(text(),'More')]";
	
		String finalXpath = first+HP+second;
		WebElement HighestAddToCart = driver.findElement(By.xpath(finalXpath));
//		HighestAddToCart.click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", HighestAddToCart);

		WebElement size = driver.findElement(By.xpath("//select"));
		Select sl = new Select(size);
		sl.selectByIndex(1);
		sl.selectByVisibleText("L");
		//		driver.quit();
	}

}
