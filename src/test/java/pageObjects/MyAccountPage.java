package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
        super(driver);
    }
	 @FindBy(xpath = "//h2[normalize-space()='My Account']")
	 WebElement msgHeading;
	 
	 @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	 WebElement lnkLogout;
	 
	 public boolean isMyAccountPageExists() {
	        try {
	        	// Wait for heading to be visible
	            wait.until(ExpectedConditions.visibilityOf(msgHeading)); 
	            return msgHeading.isDisplayed();
	        } catch (Exception e) {
	            System.out.println("My Account page heading not found: " + e.getMessage());
	            return false;
	        }
	    }
	 public AccountLogoutPage clickLogout() {
	        try {
	        	// Wait for the logout link to be click able
	            wait.until(ExpectedConditions.elementToBeClickable(lnkLogout)); 
	            lnkLogout.click();
	            return new AccountLogoutPage(driver);
	        } catch (Exception e) {
	            System.out.println("Unable to click Logout link: " + e.getMessage());
	            return null;
	        }
	    }

}
