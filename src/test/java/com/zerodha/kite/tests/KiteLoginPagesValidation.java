package com.zerodha.kite.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.zerodha.kite.baseClass.BaseClass;
import com.zerodha.kite.utilities.Utility;
import com.zerodha.kite.webpages.KiteLoginPage1;
import com.zerodha.kite.webpages.KiteLoginPage2;


public class KiteLoginPagesValidation extends BaseClass {
	public KiteLoginPage1 login1;
	public KiteLoginPage2 login2;
	
	@Test(description = "This TC will verify invalid credentials")
	public void verifyInvalidCredentialsErrorMessage() throws EncryptedDocumentException, IOException {
				// calling methods from POM class -- KiteLoginPage1
				login1 = new KiteLoginPage1(driver);

				login1.setKiteLoginPage1Username(Utility.getTestData(2, 0));
				login1.setKiteLoginPage1Password(Utility.getTestData(2, 1));
				login1.clickKiteLoginPage1LoginButton();
				boolean errMessage = login1.validateErrorMessage();
				Assert.assertTrue(errMessage);
				
		
	}
	
	
/*	@Test(description = "This TC will verify invalid PIN")
	public void verifyInvalidPinErrorMessage() throws EncryptedDocumentException, IOException {
				// calling methods from POM class -- KiteLoginPage1
				login1 = new KiteLoginPage1(driver);

				login1.setKiteLoginPage1Username(Utility.getTestData(1, 0));
				login1.setKiteLoginPage1Password(Utility.getTestData(1, 1));
				login1.clickKiteLoginPage1LoginButton();
				
				login2= new KiteLoginPage2(driver);
				login2.setKiteLoginPage2Pin(Utility.getTestData(2, 2));
				login2.clickKiteLoginPage2ContinueButton();
				boolean errMessage = login2.validatePINErrorMessage();
				Assert.assertTrue(errMessage);
				
		
	}
	*/
		
	}

