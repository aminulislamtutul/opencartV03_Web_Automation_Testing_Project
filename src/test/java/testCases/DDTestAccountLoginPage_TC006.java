package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class DDTestAccountLoginPage_TC006 extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="datadriven")
	public void verifyDDTestLoginPage(String email, String pwd, String exp) {
		logger.info  ("****Starting DDTestAccountLoginPage_TC006****");	
		try {
			//Home Page
			HomePage hp = new HomePage(driver);
			 logger.info("Clicking on My Account Link..");
			hp.clickMyAccount();
			 logger.info("Clicking on Login Link..");
			hp.clickLogin();
			
			//Login Page
			AccountLoginPage lp = new AccountLoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//My Account Page
			MyAccountPage macp = new MyAccountPage(driver);
			boolean targetpage = macp.isMyAccountPageExists();
			
			/*Data is valid  - login success - test pass  - logout
				login failed - test fail

	          Data is invalid - login success - test fail  - logout
				login failed - test pass
	        */
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(targetpage==true) {
					macp.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetpage==true) {
					macp.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
		 }
			catch(Exception e) {
				Assert.assertTrue(false);
			}	
		logger.info("End DDTestAccountLoginPage_TC006");
			
		}
		
	}


