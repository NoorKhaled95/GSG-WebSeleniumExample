import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchAndFilterTest {
    
    @Test(priority = 1)
    public void VerifySubmittingSearchField() {
        SignUpTest.driver.manage().deleteAllCookies();
        SearchAndFilterPOM.getSearchField().sendKeys("sofa");
        SearchAndFilterPOM.getSearchField().sendKeys(Keys.ENTER);
    }

    @Test(priority = 2)
    public void verifyThatTheSearchResultsAreDisplayed() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[1]")));
        String expectedSearchTitle = "You searched for: \"sofa\"";
        String actualSearchTitle = SearchAndFilterPOM.getSearchResultsTitle().getText();
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle);
    }

    @Test(priority = 3)
    public void verifyMoreFiltersIsDisplaying() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"wmCustomDirOpts-filters\"]")));
        Assert.assertTrue(SearchAndFilterPOM.getMoreFilters().isDisplayed());
    }

    @Test(priority = 3)
    public void verifyMoreFiltersIsClickable() {
        SearchAndFilterPOM.getMoreFilters().click();
    }

    @Test(priority = 4)
    public void verifyClickingMoreFiltersDisplaysFilters() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"facetedNavContainer\"]/ul/li[5]/div[1]/button")));
        Assert.assertTrue(SearchAndFilterPOM.getPriceItem().isDisplayed());
    }

    @Test(priority = 5)
    public void verifyPriceItemIsClickable() {
        SearchAndFilterPOM.getPriceItem().click();
    }

    @Test(priority = 6)
    public void verifyClickingPriceItemOpensPriceFilters() {
        Assert.assertTrue(SearchAndFilterPOM.getFirstPriceFiltersListItem().isDisplayed());
    }

    @Test(priority = 7)
    public void verifyThatTheAppliedPriceFilteredResultsAreDisplayed() {
        SignUpTest.driver.manage().deleteAllCookies();
        Actions act= new Actions(SignUpTest.driver);
        act.moveToElement(SearchAndFilterPOM.getFirstPriceFilterCheckBox()).click().build().perform();
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[2]/div/div[2]/div/div[5]/span[1]/a")));
        String expectedPriceRange = "unfilter Price\n" +
                "$250 - $500";
        System.out.println(SearchAndFilterPOM.getPriceRange().getText());
        String actualPriceRange = SearchAndFilterPOM.getPriceRange().getText();
        Assert.assertEquals(actualPriceRange, expectedPriceRange);
    }
}

