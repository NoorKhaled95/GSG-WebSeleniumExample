import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CartAndCheckoutTest {
    
    @Test(priority = 1)
    public void verifyCProductNameIsClickable() {
        SignUpTest.driver.manage().deleteAllCookies();
        CartAndCheckoutPOM.getFirstProduct().click();
    }

    @Test(priority = 2)
    public void verifyClickingProductNameOpensProductDetailsPage() {
        String expectedResult = "Espresso Wood Studio Day Sofa";
        SignUpTest.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/h1/div")));
        String actualResult = CartAndCheckoutPOM.getFirstProductDetails().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 3)
    public void verifyAddToCartButtonIsDisplayed() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"addToBasket120916\"]")));
        Assert.assertTrue(CartAndCheckoutPOM.getAddToCartButton().isDisplayed());
    }

    @Test(priority = 4)
    public void verifyAddToCartButtonIsClickable() {
        SignUpTest.driver.manage().deleteAllCookies();
        CartAndCheckoutPOM.getAddToCartButton().click();
    }

    @Test(priority = 5)
    public void verifyClickingAddToCartButtonAddingTheProductToCart() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sideCartRail\"]/div[3]/div/div[4]/div/button")));
        Assert.assertTrue(CartAndCheckoutPOM.getItemAddToCartText().isDisplayed());
    }

    @Test(priority = 6)
    public void verifyCheckoutButtonIsDisplayed() {
        Assert.assertTrue(CartAndCheckoutPOM.getCheckoutButton().isDisplayed());
    }

    @Test(priority = 7)
    public void verifyCheckoutButtonISClickable() {
        CartAndCheckoutPOM.getCheckoutButton().click();
    }

    @Test(priority = 8)
    public void verifyClickingCheckoutButtonOpensCartPage() {
        Assert.assertTrue(CartAndCheckoutPOM.getCartItemsNumText().isDisplayed());
    }

    @Test(priority = 9)
    public void verifyCartCheckoutButtonIsDisplayed() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-bpOrderCheckOut\"]/input")));
        Assert.assertTrue(CartAndCheckoutPOM.getSecondCheckoutButton().isDisplayed());
    }

    @Test(priority = 10)
    public void verifyCartCheckoutButtonISClickable() {
        for (Cookie element : SignUpTest.driver.manage().getCookies()) {
            if (!element.getName().equals("s_ppv")
                    && !element.getName().equals("s_cc")
                    && !element.getName().equals("s_ppvl")
                    && !element.getName().equals("AMCVS_BE4F210654F6058E0A4C98A7%40AdobeOrg")
                    && !element.getName().equals("OPSESSIONID")
                    && !element.getName().equals("JSESSIONID")
                    && !element.getName().equals("pvv")
                    && !element.getName().equals("s_sq")
                    && !element.getName().equals("c24"))
                SignUpTest.driver.manage().deleteCookie(element);
        }
        CartAndCheckoutPOM.getSecondCheckoutButton().click();
    }

    @Test(priority = 11)
    public void verifyClickingCheckoutButtonOpensSignInForm() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginEmail\"]")));
        Assert.assertTrue(CartAndCheckoutPOM.getFirstNameField().isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        SignUpTest.driver.quit();
    }
}
