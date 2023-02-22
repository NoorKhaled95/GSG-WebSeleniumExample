import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WishListTest {
    @Test(priority = 1)
    public void verifyAddToWishLisButtonIsClickable() {
        BrowseWorldMarketTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pr-reviewsnippet\"]/div[3]/section/div/div[1]/div/div[2]/a[1]")));
        WebElement addToWishlistButton = BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/div[2]/div[8]/div[2]/div/div[1]/span[1]"));
        addToWishlistButton.click();
        BrowseWorldMarketTest.driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void tearDown() {
        BrowseWorldMarketTest.driver.quit();
    }
}

