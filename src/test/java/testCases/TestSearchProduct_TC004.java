package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TestSearchProduct_TC004 extends BaseClass {
	@Test(groups = {"Regression","Master"})
	public void verifySearch() {
		logger.info  ("****Starting TestSearchProduct_TC004****");
		HomePage homePage = new HomePage(driver);
		 // Could be parameterized as needed
		String productToSearch = "mac";
        homePage.enterProductName(productToSearch);
		
        SearchResultsPage searchResultsPage = homePage.clickSearch();
        
        Assert.assertTrue(searchResultsPage.isSearchResultsPageExists());
        
        String expectedProductName = "MacBook";
        boolean isProductDisplayed = searchResultsPage.isProductExist(expectedProductName);
        
        Assert.assertTrue(isProductDisplayed, "Product '" + expectedProductName + "' not found in search results.");
        
        logger.info  ("****End TestSearchProduct_TC004****");
	}

}
