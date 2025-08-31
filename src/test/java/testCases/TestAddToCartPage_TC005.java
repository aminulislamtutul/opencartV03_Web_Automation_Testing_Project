package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TestAddToCartPage_TC005 extends BaseClass {
	@Test(groups = {"Regression","Master"})
	public void verifyAddToCart() {
		logger.info  ("****Starting TestAddToCartPage_TC005****");
		HomePage homePage = new HomePage(driver);
		String productName = properties.getProperty("searchProductName");
		
		 homePage.enterProductName(productName);
		 
		 SearchResultsPage searchResultsPage = homePage.clickSearch();
		 
		 if (searchResultsPage.isProductExist(productName)) {

	            // Step 5: Select the product from the search results
	            ProductPage productPage = searchResultsPage.selectProduct(productName);
	            
	            // Step 6: Set the desired quantity
	            productPage.setQuantity(properties.getProperty("productQuantity"));
	           

	            // Step 7: Add the product to the cart
	            productPage.addToCart();
	           
	            // Step 8: Verify the success message
	            boolean isSuccessMessageDisplayed = productPage.checkConfMsg();
	            Assert.assertTrue(isSuccessMessageDisplayed, "Success message not displayed!");
	        } else {
	            Assert.fail("Product not found in search results.");
	        }
		 logger.info  ("****End TestAddToCartPage_TC005****");
		
	}

}
