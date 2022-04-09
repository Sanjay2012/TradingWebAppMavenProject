package com.zerodha.kite.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_Down {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
       WebDriver driver=new ChromeDriver(options);
       
       JavascriptExecutor js = (JavascriptExecutor) driver;
	
	driver.get("https://www.covid19india.org/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	//JavascriptExecutor executor = (JavascriptExecutor)driver;
	
	WebElement activeCount = driver.findElement(By.xpath("//*[@class=\"table fadeInUp\"]//div[3]/div[3]"));
	js.executeScript("arguments[0].scrollIntoView();", activeCount);
	
	Thread.sleep(5000);
	
	String count = activeCount.getText();
	System.out.println(count);
	
	driver.quit();
	
	

	}

}
