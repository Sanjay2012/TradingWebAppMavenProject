package com.zerodha.kite.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	static Sheet sh;
	
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//testData/testdata.xlsx");
		try {
			sh = WorkbookFactory.create(file).getSheet("DDF");
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	public static void captureScreenshot(WebDriver driver, String testName) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		File destFile=new File("./Screenshots/"+testName+".png");
		FileHandler.copy(scrFile, destFile);
	}

}
