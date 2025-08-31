package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountLogoutPage extends BasePage {
	public AccountLogoutPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnContinue;
	
	public HomePage clickContinue() {
		try {
			// Wait for the login button to be
			wait.until(ExpectedConditions.elementToBeClickable(btnContinue)); 
			// click able																	
			btnContinue.click();
			return new HomePage(driver);
		} catch (TimeoutException e) {
			System.out.println("Continue button not clickable: " + e.getMessage());
			return null;
		}
	}

}
