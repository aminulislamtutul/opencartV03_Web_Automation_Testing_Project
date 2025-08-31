package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
	public ProductPage(WebDriver driver) {
        super(driver);
    }
	
	@FindBy(name = "quantity") 
	WebElement txtQuantity;
	
	@FindBy(xpath = "//button[@id='button-cart']") 
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]") 
	WebElement cnfMsg;
	
	@FindBy(xpath = "//div[@id='cart']") 
    WebElement btnItems;
	
	@FindBy(xpath = "//strong[normalize-space()='View Cart']") 
    WebElement lnkViewCart;
	
	public void setQuantity(String qty) {
		try {
			// Wait for quantity field to be visible
			wait.until(ExpectedConditions.visibilityOf(txtQuantity)); 
			txtQuantity.clear();
			txtQuantity.sendKeys(qty);
		} catch (Exception e) {
			System.out.println("Error setting quantity: " + e.getMessage());
		}
	}
	public void addToCart() {
		try {
			// Wait for add-to-cart button to be
			wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)); 
			// click able																	
			btnAddToCart.click();
		} catch (Exception e) {
			System.out.println("Error adding product to cart: " + e.getMessage());
		}
	}
	public boolean checkConfMsg() {
		try {
			// Wait for confirmation message to be visible
			wait.until(ExpectedConditions.visibilityOf(cnfMsg)); 
			return cnfMsg.isDisplayed();
		} catch (Exception e) {
			System.out.println("Confirmation message not found: " + e.getMessage());
			return false;
		}
	}
	public void clickItemsToNavigateToCart() {
        try {
        	// Wait for the Items button to be click able
            wait.until(ExpectedConditions.elementToBeClickable(btnItems)); 
            btnItems.click();
        } catch (Exception e) {
            System.out.println("Unable to click Items button: " + e.getMessage());
        }
    }
	public ShoppingCartPage clickViewCart() {
        try {
        	// Wait for the View Cart link to be click able
            wait.until(ExpectedConditions.elementToBeClickable(lnkViewCart)); 
            lnkViewCart.click();
            return new ShoppingCartPage(driver);
        } catch (Exception e) {
            System.out.println("Unable to click View Cart link: " + e.getMessage());
            return null;
        }
    }

}
