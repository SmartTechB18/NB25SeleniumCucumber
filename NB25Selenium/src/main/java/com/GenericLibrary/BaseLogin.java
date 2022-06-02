package com.GenericLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ConfigLibrary.Credentials;
import com.PageFactory.LoginPageFactory;
import com.Utility.Highlight;
import com.Utility.ScreenShot;
import com.Utility.Synchronization;

public class BaseLogin {

		WebDriver driver;
		LoginPageFactory lpf;
		
		public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", 
				"./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			lpf = new LoginPageFactory(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Credentials.getCredential("url"));
		ScreenShot.captureScreenShot(driver, "AppHomePage");
		System.out.println("Opened Application");
		}
		
		public void getloginPage() throws InterruptedException {	
		Synchronization.getExplicitWaitClicable(driver, lpf.getSignInBtn());
			Highlight.getcolor(driver, lpf.getSignInBtn());
		lpf.getSignInBtn().click();
		System.out.println("This is the login page");
		ScreenShot.captureScreenShot(driver, "SignInPage");
		}
		
		public void signIn() throws InterruptedException, IOException {
		Wait<WebDriver>	fw = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(4, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class);	
		Highlight.getcolor(driver, lpf.getEmailBox(), "red");
			System.out.println("Checkpoint");
		lpf.getEmailBox().sendKeys(Credentials.getCredential("userName"));
		Highlight.getcolor(driver, lpf.getPassBox(), "yellow");
		Thread.sleep(5000);
		lpf.getPassBox().sendKeys(Credentials.getCredential("password"));
		lpf.getSignInBtn2().click();
		String so = lpf.getSignOut().getText();
		if(so.equalsIgnoreCase("Sign out")) {
			System.out.println("Login Successful");
			ScreenShot.captureScreenShot(driver, "LoginSuccess");
		}
		else {
			System.out.println("Something wrong");
		ScreenShot.captureScreenShot(driver, "LoginFail");
		}
		}
		
		public void tearDown() {
			driver.close();
		}
		
}
