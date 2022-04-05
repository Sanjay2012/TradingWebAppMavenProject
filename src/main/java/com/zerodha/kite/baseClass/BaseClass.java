package com.zerodha.kite.baseClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.zerodha.kite.utilities.Utility;


public class BaseClass {
	public WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setupApplication(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notification");
			Reporter.log("=====Chrome Browser Session Started=====", true);
			driver = new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers/geckodriver.exe");
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notification");
			Reporter.log("=====Firefox Browser Session Started=====", true);
			driver=new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//drivers/msedgedriver.exe");
			Reporter.log("=====Edge Browser Session Started=====", true);
			driver=new EdgeDriver();
		}

		driver.get("https://kite.zerodha.com/");
		Reporter.log("=====Application Started=====", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
		Reporter.log("=====Browser Session End=====", true);
		
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure (ITestResult testResult) throws IOException  {
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			Utility.captureScreenshot(driver,testResult.getName());
			
}

}
}
