package com.SeleniumHacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {
	
	public static void main(String[] args) throws IOException {
		
		String path = "C:\\Users\\Urmi\\Desktop\\NB25.xlsx";
		File file = new File(path);	
		FileInputStream fi = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(fi);
		Sheet sht = wb.getSheet("Sheet1");
		System.out.println(sht.getLastRowNum());
		for(int i=1; i<=sht.getLastRowNum(); i++) {
			System.out.println(sht.getRow(i).getCell(0).getStringCellValue());
		}
	}

}
