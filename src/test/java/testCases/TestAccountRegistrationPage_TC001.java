package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TestAccountRegistrationPage_TC001 extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public void verifyAccountRegistration() {
		logger.info("****Starting TestAccountRegistrationPageTC001****");
		
		HomePage homePage = new HomePage(driver);
		logger.info("Clicking on My Account Link..");
		homePage.clickMyAccount();
		logger.info("Clicking on Register Link..");
		homePage.clickRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details..");
		regPage.setFirstName(generateString().toUpperCase());
		
		regPage.setLastName(generateString().toUpperCase());
		
		String userEmail = generateString() + "@gmail.com";
		regPage.setEmail(userEmail);
		
		String userPhoneNumber = generateNumber();
		regPage.setTelephone(userPhoneNumber);
		
		String userPassword = generateAlphaNumeric();
		
		regPage.setPassword(userPassword);
		regPage.setConfirmPassword(userPassword);
		
		regPage.setPrivacyPolicy();
		
		regPage.clickContinue();
		
		logger.info("Validating Expected Massage..");
		String confirmationMessage = regPage.getConfirmationMsg();
		Assert.assertEquals(confirmationMessage, "Your Account Has Been Created!","Registration failed: Confirmation message mismatch.");
		
		logger.info("****Ending TestAccountRegistrationPageTC001****");
	}
	
}
