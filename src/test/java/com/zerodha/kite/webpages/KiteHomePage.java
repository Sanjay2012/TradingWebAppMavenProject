package com.zerodha.kite.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class KiteHomePage {
	
	//SoftAssert soft=new SoftAssert();
	// declaration
				@FindBy(xpath = "//*[@class=\"avatar\"]") 
					private WebElement profileName;
				
				@FindBy(xpath = "//*[@class=\"user-id\"]")
				private WebElement menuButton;
				
				@FindBy(xpath = "//*[@class=\"icon icon-exit\"]")
				private WebElement logoutButton;

				WebDriver driver;

				
				// initilization
				
				public KiteHomePage (WebDriver driver) {
					
					PageFactory.initElements(driver, this);
					
					
				}
				
				public String
				veryfyKiteHomePageProfileName( ) {
					String actual = profileName.getText();
					return actual;
					
				}
				
				public boolean 
				verifyProfileMenuButton() {
					boolean status = menuButton.isEnabled();
					return status;
					
				}
				
				public void
				clickOnProfileMenuButton() {
					menuButton.click();
				}
				
				public boolean
				verifyLogoutButton() {
					boolean status = logoutButton.isEnabled();
					return status;

				}
				
				public void
				clickOnLogoutButton() {
					logoutButton.click();
				}

}
