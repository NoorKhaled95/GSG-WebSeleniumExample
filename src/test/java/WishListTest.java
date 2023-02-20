import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WishListTest {
    @Test(priority = 1)
    public void verifyAddToWishLisButtonIsClickable() {
        WebElement addToWishlistButton = BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"ml-icon-heart_438620\"]"));
        addToWishlistButton.click();
    }
}

