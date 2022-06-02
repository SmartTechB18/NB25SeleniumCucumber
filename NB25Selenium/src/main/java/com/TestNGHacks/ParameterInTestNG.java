package com.TestNGHacks;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterInTestNG {
	
	@Parameters("name")
	@Test
	public void getName(String name) {
		System.out.println("My name is "+name);
	}
	@Test(invocationCount = 10)
	public void getAdd() {
		System.out.println("Something");
	}
	

}
