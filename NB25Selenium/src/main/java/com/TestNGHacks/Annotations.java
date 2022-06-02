package com.TestNGHacks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	WebDriver driver;
	
	@AfterTest
	public void getA() {
		System.out.println("I am A");
	}
	@Test
	public void getD() {
		System.out.println("I am D");
	}
	@Test
	public void getC() {
		System.out.println("I am C");
	}
	@BeforeTest
	public void getSetup() {
		
	}
	
}
