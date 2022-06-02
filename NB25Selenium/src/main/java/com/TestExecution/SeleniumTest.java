package com.TestExecution;

import java.io.IOException;

import com.GenericLibrary.BaseLogin;

public class SeleniumTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		BaseLogin bl = new BaseLogin();
		bl.setup();
		bl.getloginPage();
		bl.signIn();
//		bl.tearDown();
	}

}
