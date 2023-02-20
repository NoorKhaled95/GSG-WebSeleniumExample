import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchAndFilterTest {

    @Test(priority = 1)
    public void VerifySubmittingSearchField() {
        SignUpTest.driver.manage().deleteAllCookies();

        WebElement searchField = SignUpTest.driver.findElement(By.xpath("//*[@id=\"navsearchbox\"]"));
        searchField.sendKeys("sofa");
        searchField.sendKeys(Keys.ENTER);
    }

    @Test(priority = 2)
    public void verifyThatTheSearchResultsAreDisplayed() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[1]")));

        WebElement searchResultsTitle = SignUpTest.driver.findElement(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[1]"));
        String expectedSearchTitle = "You searched for: \"sofa\"";
        String actualSearchTitle = searchResultsTitle.getText();
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle);
    }

    @Test(priority = 3)
    public void verifyMoreFiltersIsDisplaying() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"wmCustomDirOpts-filters\"]")));

        WebElement moreFilters = SignUpTest.driver.findElement(By.xpath("//*[@id=\"wmCustomDirOpts-filters\"]"));
        Assert.assertTrue(moreFilters.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyMoreFiltersIsClickable() {
        WebElement moreFilters = SignUpTest.driver.findElement(By.xpath("//*[@id=\"wmCustomDirOpts-filters\"]"));
        moreFilters.click();
    }

    @Test(priority = 4)
    public void verifyClickingMoreFiltersDisplaysFilters() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"facetedNavContainer\"]/ul/li[5]/div[1]/button")));

        WebElement priceItem = SignUpTest.driver.findElement(By.xpath("//*[@id=\"facetedNavContainer\"]/ul/li[5]/div[1]/button"));
        Assert.assertTrue(priceItem.isDisplayed());
    }

    @Test(priority = 5)
    public void verifyPriceItemIsClickable() {
        WebElement priceItem = SignUpTest.driver.findElement(By.xpath("//*[@id=\"facetedNavContainer\"]/ul/li[5]/div[1]/button"));
        priceItem.click();
    }

    @Test(priority = 6)
    public void verifyClickingPriceItemOpensPriceFilters() {
        WebElement firstPriceFiltersListItem = SignUpTest.driver.findElement(By.xpath("//*[@id=\"price_0\"]"));
        Assert.assertTrue(firstPriceFiltersListItem.isDisplayed());
    }

    @Test(priority = 7)
    public void verifyThatTheAppliedPriceFilteredResultsAreDisplayed() {
        SignUpTest.driver.manage().deleteAllCookies();

        WebElement firstPriceFilterCheckBox = SignUpTest.driver.findElement(By.xpath("//*[@id=\"price_%24250+-+%24500\"]"));
        Actions act= new Actions(SignUpTest.driver);
        act.moveToElement(firstPriceFilterCheckBox).click().build().perform();

        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[2]/div/div[2]/div/div[5]/span[1]/a")));

        WebElement priceRange = SignUpTest.driver.findElement(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[2]/div/div[2]/div/div[5]/span[1]/a"));
        String expectedPriceRange = "unfilter Price\n" +
                "$250 - $500";
        System.out.println(priceRange.getText());
        String actualPriceRange = priceRange.getText();
        Assert.assertEquals(actualPriceRange, expectedPriceRange);
    }
}

