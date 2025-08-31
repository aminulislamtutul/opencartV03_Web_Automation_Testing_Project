package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement textSearchBox;
	
	@FindBy(xpath = "//div[@id='search']//button[@type='button']")
	WebElement btnSearch;
	
	public void clickMyAccount() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lnkMyAccount)).click();
		}catch(Exception e) {
			System.out.println("Exception occurred while clicking 'My Account': " + e.getMessage());
		}
		
	}
	public AccountRegistrationPage clickRegister() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
			return new AccountRegistrationPage(driver);
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking 'Register': " + e.getMessage());
			return null;
		}
	}
	public AccountLoginPage clickLogin() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();
			return new AccountLoginPage(driver);
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking 'Login': " + e.getMessage());
			return null;
		}
		
	}
	public boolean isHomePageExists() {
		try {
			return driver.getTitle().equals("Your Store");

		} catch (Exception e) {
			return false;
		}
	}
	public void enterProductName(String pName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(textSearchBox)).sendKeys(pName);
		} catch (Exception e) {
			System.out.println("Exception occurred while entering product name: " + e.getMessage());
		}
	}
	public SearchResultsPage clickSearch() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
			return new SearchResultsPage(driver);
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking 'Search': " + e.getMessage());
			return null;
		}
	}

}
