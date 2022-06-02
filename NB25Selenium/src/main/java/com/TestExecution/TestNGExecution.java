package com.TestExecution;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.GenericLibrary.BaseLogin;

public class TestNGExecution {
	
	BaseLogin bl = new BaseLogin();
	
	@BeforeTest
	public void setup() throws IOException {
		bl.setup();
	}
	@Test
	public void b() throws InterruptedException {
		bl.getloginPage();
	}
	@Test(dependsOnMethods = {"b"})
	public void a() throws InterruptedException, IOException {
		bl.signIn();
	}
	@AfterTest
	public void closeBrowser() {
		bl.tearDown();
	}

}
