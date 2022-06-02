package com.TestNGHacks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDataProvider {
//	@Parameters({"userName","password"})
	@Test(dataProvider = "getData")
	public void getCreden(String userName, String password) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("https://www.zoopla.co.uk/");
		WebElement signIn = dr.findElement(By.xpath("(//p[contains(text(),'Sign in')])[2]"));
		signIn.click();
		WebElement emailBox = dr.findElement(By.id("input-email-address"));
		emailBox.clear();
		emailBox.sendKeys(userName);
		WebElement passBox = dr.findElement(By.id("input-password"));
		passBox.clear();
		passBox.sendKeys(password);
		WebElement signInBtn = dr.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		signInBtn.click();
//		WebElement invalidCredMsg = dr.findElement(By.xpath("//div[contains(text(),'Incorrect email or password')]"));
//		System.out.println(invalidCredMsg.getText());
		System.out.println(dr.getTitle());
		
		dr.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		data[0][0]="Morshed@test.com";
		data[0][1]="1234567890";
		
		data[1][0]="Amina@test.com";
		data[1][1]="111111111";
		
		data[2][0]="Jalal@test.com";
		data[2][1]="3434343434";
		
		return data;
	}
	

}
