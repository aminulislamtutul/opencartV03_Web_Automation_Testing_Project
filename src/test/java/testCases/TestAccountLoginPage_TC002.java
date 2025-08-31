package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TestAccountLoginPage_TC002 extends BaseClass {
	@Test(groups = {"Regression","Master"})
	public void verifyLogin() {
		logger.info("****Starting TestAccountLoginPageTC002****");
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
			
			logger.info("****End TestAccountLoginPageTC002****");
	}
}
