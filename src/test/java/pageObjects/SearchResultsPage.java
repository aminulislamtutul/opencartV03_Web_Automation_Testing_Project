package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage {
	public SearchResultsPage(WebDriver driver) {
        super(driver);
  }
	@FindBy(xpath = "//div[@id='content']/h1")
    private WebElement searchPageHeader;
	
	@FindBy(xpath = "//*[@id='content']/div[3]//img")
    private List<WebElement> searchProducts;
	
	 public boolean isSearchResultsPageExists() {
	        try {
	            return searchPageHeader.getText().contains("Search -");
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 public boolean isProductExist(String productName) {
	        try {
	        	// Wait for product list to be visible
	            wait.until(ExpectedConditions.visibilityOfAllElements(searchProducts)); 
	            // Loop through products to find a match by name
	            for (WebElement product : searchProducts) {
	                if (product.getAttribute("title").equals(productName)) {
	                    return true;
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error checking product existence: " + e.getMessage());
	        }
	        return false;
	    }
	 public ProductPage selectProduct(String productName) {
	        try {
	        	// Wait for product list to be visible
	            wait.until(ExpectedConditions.visibilityOfAllElements(searchProducts)); 
	            // Loop through products to find the matching product and click it
	            for (WebElement product : searchProducts) {
	                if (product.getAttribute("title").equals(productName)) {
	                	// Wait for the product to be click able
	                    wait.until(ExpectedConditions.elementToBeClickable(product)); 
	                    product.click();
	                    return new ProductPage(driver);
	                }
	            }
	            System.out.println("Product not found: " + productName);
	        } catch (Exception e) {
	            System.out.println("Error selecting product: " + e.getMessage());
	        }
	        return null;
	    }
}
