import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WishListTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the driver and navigate to the website
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.worldmarket.com/");
    }

    @Test
    public void wishlistTest() throws InterruptedException {
        // Click on the Sign In link
        WebElement signInLink = driver.findElement(By.xpath("//a[@data-modal-id='signInModal']"));
        signInLink.click();

        // Enter the credentials and sign in
        WebElement emailField = driver.findElement(By.id("WC_AccountDisplay_FormInput_logonId_In_Logon_1"));
        WebElement passwordField = driver.findElement(By.id("WC_AccountDisplay_FormInput_logonPassword_In_Logon_1"));
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit'][contains(text(), 'Sign In')]"));
        emailField.sendKeys("testuser@example.com");
        passwordField.sendKeys("testpassword");
        signInButton.click();
        Thread.sleep(5000);

        // Navigate to a product page and add the product to the wish list
        driver.get("https://www.worldmarket.com/product/cognac+leather+lydia+dining+chairs+set+of+2.do");
        WebElement addToWishlistButton = driver.findElement(By.xpath("//a[contains(@class,'wishlist-btn')]"));
        addToWishlistButton.click();

        // Verify that the product is added to the wish list
        WebElement wishlistButton = driver.findElement(By.xpath("//a[@class='wishlist-counter']"));
        String expectedWishlistCount = "1";
        String actualWishlistCount = wishlistButton.getText();
        Assert.assertEquals(actualWishlistCount, expectedWishlistCount);

        // Navigate to the Wish List page
        WebElement wishlistLink = driver.findElement(By.xpath("//a[@class='wishlist-link']"));
        wishlistLink.click();

        // Verify that the product is displayed in the wish list
        WebElement wishListProductTitle = driver.findElement(By.xpath("//div[@class='product-title']/a[contains(text(),'Lydia Dining Chairs')]"));
        String expectedProductTitle = "Cognac Leather Lydia Dining Chairs Set of 2";
        String actualProductTitle = wishListProductTitle.getText();
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }

    @AfterTest
    public void tearDown() {
        // Close the driver and end the session
        driver.quit();
    }
}

