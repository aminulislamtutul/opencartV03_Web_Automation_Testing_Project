package pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountLoginPage extends BasePage {
	public AccountLoginPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmailAddress;
	
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;
    
    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;
    
    public void setEmail(String email) {
        try {
        	// Wait for email field to be visible
            wait.until(ExpectedConditions.visibilityOf(txtEmailAddress)); 
            // Clear the field before entering text
            txtEmailAddress.clear(); 
            txtEmailAddress.sendKeys(email);
        } catch (TimeoutException e) {
            System.out.println("Email field not visible: " + e.getMessage());
        }
    }
    public void setPassword(String pwd) {
        try {
        	// Wait for password field to be visible
            wait.until(ExpectedConditions.visibilityOf(txtPassword));
            // Clear the field before entering text
            txtPassword.clear(); 
            txtPassword.sendKeys(pwd);
        } catch (TimeoutException e) {
            System.out.println("Password field not visible: " + e.getMessage());
        }
    }
    public void clickLogin() {
        try {
        	// Wait for the login button to be click able
            wait.until(ExpectedConditions.elementToBeClickable(btnLogin)); 
            btnLogin.click();
        } catch (TimeoutException e) {
            System.out.println("Login button not clickable: " + e.getMessage());
        }
    }

}
