package com.ConfigLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Credentials {
	public static String getCredential(String key) throws IOException {
		Properties pr = new Properties();
		String path = "./config.Properties";
		FileInputStream fis = new FileInputStream(path);
		
		pr.load(fis);
		String value =pr.get(key).toString();
		
		return value;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(Credentials.getCredential("url"));
	}
}
