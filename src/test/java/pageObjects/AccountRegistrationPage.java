package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-firstname']")
    WebElement textFirstname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement textLastname;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement textEmail;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement textTelephone;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement textPassword;

    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement textConfirmPassword;

    @FindBy(xpath="//input[@name='agree']")
    WebElement chkPolicy;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConformation;
    
    public void setFirstName(String fname) {
        try {
            wait.until(ExpectedConditions.visibilityOf(textFirstname)).sendKeys(fname);
        } catch (Exception e) {
            System.out.println("Exception while setting first name: " + e.getMessage());
        }
    }
    public void setLastName(String lname) {
        try {
            wait.until(ExpectedConditions.visibilityOf(textLastname)).sendKeys(lname);
        } catch (Exception e) {
            System.out.println("Exception while setting last name: " + e.getMessage());
        }
    }
    public void setEmail(String email) {
        try {
            wait.until(ExpectedConditions.visibilityOf(textEmail)).sendKeys(email);
        } catch (Exception e) {
            System.out.println("Exception while setting email: " + e.getMessage());
        }
    }
    public void setTelephone(String tel) {
        try {
            wait.until(ExpectedConditions.visibilityOf(textTelephone)).sendKeys(tel);
        } catch (Exception e) {
            System.out.println("Exception while setting telephone: " + e.getMessage());
        }
    }
    public void setPassword(String pwd) {
        try {
            wait.until(ExpectedConditions.visibilityOf(textPassword)).sendKeys(pwd);
        } catch (Exception e) {
            System.out.println("Exception while setting password: " + e.getMessage());
        }
    }
    public void setConfirmPassword(String pwd) {
        try {
            wait.until(ExpectedConditions.visibilityOf(textConfirmPassword)).sendKeys(pwd);
        } catch (Exception e) {
            System.out.println("Exception while setting confirm password: " + e.getMessage());
        }
    }
    public void setPrivacyPolicy() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(chkPolicy)).click();
        } catch (Exception e) {
            System.out.println("Exception while setting privacy policy: " + e.getMessage());
        }
    }
    public void clickContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
            // Or use JavaScriptExecutorUtils.clickElement(btnContinue); if necessary
        } catch (Exception e) {
            System.out.println("Exception while clicking Continue: " + e.getMessage());
        }
    }
    public String getConfirmationMsg() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(msgConformation)).getText();
        } catch (Exception e) {
            System.out.println("Exception while getting confirmation message: " + e.getMessage());
            return e.getMessage();
        }
    }

}
