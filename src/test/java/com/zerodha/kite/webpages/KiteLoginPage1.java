package com.zerodha.kite.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage1 {
	
	// declaration
		@FindBy(xpath = "//*[@id=\"userid\"]") 
			private WebElement UN;
		@FindBy(xpath = "//*[@id=\"password\"]")
		private WebElement PWD;
		
		@FindBy(xpath = "//*[@class=\"button-orange wide\"]")
		private WebElement login;
		
		@FindBy(xpath = "//*[@class=\"error text-center\"]")
		private WebElement errorMessage;

		// initilization
		
		public KiteLoginPage1 (WebDriver driver) {
			PageFactory.initElements(driver, this);
			
			
		}
		
		public void
		setKiteLoginPage1Username(String userName) {
			UN.sendKeys(userName);
		}
		
		public void
		setKiteLoginPage1Password(String password) {
			PWD.sendKeys(password);
		}
		
		public void
		clickKiteLoginPage1LoginButton() {
			login.click();
		}
		
		public boolean
		validateErrorMessage() {
			boolean status = errorMessage.isDisplayed();
			return status;
			
			
		}
		

}
