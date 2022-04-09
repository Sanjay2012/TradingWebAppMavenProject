package com.zerodha.kite.tests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.zerodha.kite.baseClass.BaseClass;
import com.zerodha.kite.utilities.ConfigFileReader;
import com.zerodha.kite.utilities.Utility;
import com.zerodha.kite.webpages.KiteHomePage;
import com.zerodha.kite.webpages.KiteLoginPage1;
import com.zerodha.kite.webpages.KiteLoginPage2;
import com.zerodha.kite.webpages.KitePageAfterLogout;

public class KiteLoginTest extends BaseClass {
	public KiteLoginPage1 login1;
	public KiteLoginPage2 login2;
	public KiteHomePage home;
	public KitePageAfterLogout logout;
	
	String validUsername = ConfigFileReader.getInstance().getValidUsername();
	String validPassword = ConfigFileReader.getInstance().getValidPassword();
	String validPIN = ConfigFileReader.getInstance().getValidPIN();
	String validPN = ConfigFileReader.getInstance().getValidProfileName();
	
	

	@BeforeMethod
	public void loginApp() throws EncryptedDocumentException, IOException {

		// calling methods from POM class -- KiteLoginPage1
		login1 = new KiteLoginPage1(driver);

//		login1.setKiteLoginPage1Username(Utility.getTestData(1, 0));
//		login1.setKiteLoginPage1Password(Utility.getTestData(1, 1));
		
		login1.setKiteLoginPage1Username(validUsername);
		login1.setKiteLoginPage1Password(validPassword);

		login1.clickKiteLoginPage1LoginButton();

		// cllaing methods from page2

		login2 = new KiteLoginPage2(driver);
		//login2.setKiteLoginPage2Pin(Utility.getTestData(1, 2));
		login2.setKiteLoginPage2Pin(validPIN);
		login2.clickKiteLoginPage2ContinueButton();

	}

	@Test(description = "This TC will verify Profile Name on dashboard")
	public void verifyProfileName() throws EncryptedDocumentException, IOException {
		// calling methods from home page class
		home = new KiteHomePage(driver);
		String actResult = home.veryfyKiteHomePageProfileName();
		//String expResult = Utility.getTestData(1, 3);
		String expResult = validPN;
		Assert.assertEquals(actResult, expResult);
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
		logout=new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		
	}
		
		@Test(description = "This TC will verify status of Profile Menu Button")
		public void verifyProfileMenuButton() {
			home = new KiteHomePage(driver);
		//assert profile menu button
		boolean menuButtonStatus = home.verifyProfileMenuButton();
		Assert.assertTrue(menuButtonStatus);
		home.clickOnProfileMenuButton();
		home.clickOnLogoutButton();
		logout=new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		
		}
		
		@Test(description = "This TC will verify status of logout Button")
		public void verifyLogoutButton() {
			home = new KiteHomePage(driver);
		// assert logout button
		home.clickOnProfileMenuButton();
		boolean logoutButtonStatus = home.verifyLogoutButton();
		Assert.assertTrue(logoutButtonStatus);
		home.clickOnLogoutButton();
		logout=new KitePageAfterLogout(driver);
		logout.clickOnChangeUser();
		
	}
	
	@AfterMethod
	public void takeScreenShotOnFailure (ITestResult testResult) throws IOException  {
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			Utility.captureScreenshot(driver,testResult.getName());
			
}
		
	}
	
	
}
		
		
