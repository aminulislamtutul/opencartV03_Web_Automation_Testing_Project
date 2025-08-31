package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.AccountLogoutPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TestAccountLogoutPage_TC003 extends BaseClass {
	@Test(groups = {"Regression","Master"})
	public void verifyLogout() {
		logger.info  ("****Starting TestAccountLogoutPage_TC003****");	
		HomePage homePage = new HomePage(driver);
		 logger.info("Clicking on My Account Link..");
		homePage.clickMyAccount();
		 logger.info("Clicking on Login Link..");
		homePage.clickLogin();
		
		AccountLoginPage accountLoginPage = new AccountLoginPage(driver);
				
			String userEmail = properties.getProperty("emailAddress");
			accountLoginPage.setEmail(userEmail);
			
			String userPassword = properties.getProperty("loginPassword");
			accountLoginPage.setPassword(userPassword);
			
			accountLoginPage.clickLogin();
			
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			
			boolean isMyAccountPageDisplayed = myAccountPage.isMyAccountPageExists();
			Assert.assertTrue(isMyAccountPageDisplayed, "Login failed: MyAccount page not displayed");
			
			AccountLogoutPage logoutPage = myAccountPage.clickLogout();
				
			HomePage postLogoutHomePage = logoutPage.clickContinue();
			
			boolean isHomePageVisible = postLogoutHomePage.isHomePageExists();
		    softAssert.assertTrue(isHomePageVisible, "Logout failed: Home Page is not displayed.");
		     
		    // Assert all to validate all soft assertions
		    softAssert.assertAll();
		    
		    logger.info  ("****End TestAccountLogoutPage_TC003****");
	}

}
