package com.SeleniumHacks;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		
		dr.navigate().to("https://cosmocode.io/automation-practice/");
		WebElement pop = dr.findElement(By.xpath("//a[contains(text(),'Click Me to open New Window')]"));
		pop.click();
		pop.click();
		
		Set<String> allChild = dr.getWindowHandles();
		System.out.println(allChild);
		Iterator<String> it = allChild.iterator();
		
		String parent = it.next();
		Thread.sleep(3000);
		System.out.println(parent);
		while(it.hasNext()) {
			String temp = it.next();
			if(temp!=parent) {
				dr.switchTo().window(temp);
				dr.close();
				Thread.sleep(4000);
			}
		}
		Thread.sleep(3000);
		dr.switchTo().window(parent);
		pop.click();
//		Alert al = dr.switchTo().alert();
//		System.out.println(al.getText());
//		al.accept();
		
//		dr.close();
	}

}
