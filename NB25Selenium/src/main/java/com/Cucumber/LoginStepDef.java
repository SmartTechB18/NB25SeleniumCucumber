package com.Cucumber;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ConfigLibrary.Credentials;
import com.PageFactory.LoginPageFactory;
import com.Utility.Highlight;
import com.Utility.ScreenShot;
import com.Utility.Synchronization;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	WebDriver driver;
	LoginPageFactory lpf;
	
	@Given("^User opens the application in chrome browser$")
	public void user_opens_the_application_in_chrome_browser() throws IOException {
	  System.setProperty("webdriver.chrome.driver", 
				"./Drivers/chromedriver.exe");
	  driver = new ChromeDriver();
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

	@When("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {	
	Highlight.getcolor(driver, lpf.getSignInBtn());
	lpf.getSignInBtn().click();
	System.out.println("This is the login page");
	ScreenShot.captureScreenShot(driver, "SignInPage");
	}

	@When("Enter valid credentials and click Sign in button")
	public void enter_valid_credentials_and_click_sign_in_button() throws IOException, InterruptedException {
		Highlight.getcolor(driver, lpf.getEmailBox(), "red");
		System.out.println("Checkpoint");
	lpf.getEmailBox().sendKeys(Credentials.getCredential("userName"));
	Highlight.getcolor(driver, lpf.getPassBox(), "yellow");
	Thread.sleep(2000);
	lpf.getPassBox().sendKeys(Credentials.getCredential("password"));
	lpf.getSignInBtn2().click();
	}

	@Then("User is successfully logged in to my account home page")
	public void user_is_successfully_logged_in_to_my_account_home_page() {
		String so = lpf.getSignOut().getText();
		if(so.equalsIgnoreCase("Sign out")) {
			System.out.println("Login Successful");
			ScreenShot.captureScreenShot(driver, "LoginSuccess");
		}
		else {
			System.out.println("Something wrong");
		ScreenShot.captureScreenShot(driver, "LoginFail");
		}		
		driver.quit();
	}
	
	@When("Click sign in button")
	public void click_sign_in_button() {
		lpf.getSignInBtn2().click();
	}

	@Then("Verify the user is given error")
	public void verify_the_user_is_given_error() {
	   String SignInError = lpf.getErrorSignIn().getText();
	   if(SignInError.contains("1 error")) {
		   System.out.print("User is not logged in due to invalid credentials.");
	   }
	   else {System.out.println("Check issue with invalid log in.");}
	   driver.quit();
	}

	@When("Enter invalid userName<{string}> and password <{string}>")
	public void enter_invalid_user_name_and_password(String string, String string2) throws InterruptedException {
		Highlight.getcolor(driver, lpf.getEmailBox(), "red");
		System.out.println("Checkpoint");
	lpf.getEmailBox().sendKeys(string);
	Highlight.getcolor(driver, lpf.getPassBox(), "yellow");
	Thread.sleep(2000);
	lpf.getPassBox().sendKeys(string2);
	}
}
