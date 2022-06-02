package com.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	public LoginPageFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy  (xpath = "//a[@class='login']")
	private WebElement signInBtn;
	@FindBy (id = "email")
	private WebElement emailBox;
	@FindBy(name = "passwd")
	private WebElement passBox;
	@FindBy(name = "SubmitLogin")
	private WebElement signInBtn2;
	@FindBy(xpath = "(//a[contains(text(),'Sign out')])[1]")
	private WebElement signOut;
	@FindBy(xpath="//p[contains(text(),'There is 1 error')]")
	private WebElement errorSignIn;
	
	public WebElement getErrorSignIn() {
		return errorSignIn;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}
	
	public WebElement getPassBox() {
		return passBox;
	}

	public WebElement getSignInBtn2() {
		return signInBtn2;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public WebElement getEmailBox() {
		return emailBox;
	}

	
}
