import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SignInTest {

    @Test(priority = 1)
    public void verifyAddToWishListOpensSignInPage() {
        BrowseWorldMarketTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginEmail\"]")));
        WebElement emailField = BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"loginEmail\"]"));
        Assert.assertTrue(emailField.isDisplayed());
    }

    @Test(priority = 2)
    public void verifySignInButtonIsClickable() {
        WebElement signInButton = BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"checkoutLoginButton\"]"));

        WebElement emailField = BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"loginEmail\"]"));
        WebElement passwordField = BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"loginPassword\"]"));

        emailField.sendKeys("noor@mailna.co");
        passwordField.sendKeys("password123456");
        signInButton.click();
    }

    @Test(priority = 3)
    public void verifyClickingSignInButtonSignInSuccessfully() {
        WebElement selectWishListTitle = BrowseWorldMarketTest.driver.findElement(By.xpath("//*[@id=\"wishlistForm\"]/div/h2"));
        Assert.assertTrue(selectWishListTitle.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        BrowseWorldMarketTest.driver.quit();
    }
}

