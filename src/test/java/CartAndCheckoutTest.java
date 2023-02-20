import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CartAndCheckoutTest {

    @Test(priority = 1)
    public void verifyCProductNameIsClickable() {
        SignUpTest.driver.manage().deleteAllCookies();

        WebElement firstProduct = SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/a"));
        firstProduct.click();
    }

    @Test(priority = 2)
    public void verifyClickingProductNameOpensProductDetailsPage() {
        String expectedResult = "Espresso Wood Studio Day Sofa";

        SignUpTest.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/h1/div")));
        WebElement firstProductDetails = SignUpTest.driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/h1/div"));

        String actualResult = firstProductDetails.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(priority = 3)
    public void verifyAddToCartButtonIsDisplayed() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"addToBasket120916\"]")));
        WebElement addToCartButton = SignUpTest.driver.findElement(By.xpath("//*[@id=\"addToBasket120916\"]"));
        Assert.assertTrue(addToCartButton.isDisplayed());
    }

    @Test(priority = 4)
    public void verifyAddToCartButtonIsClickable() {
        SignUpTest.driver.manage().deleteAllCookies();
        WebElement addToCartButton = SignUpTest.driver.findElement(By.xpath("//*[@id=\"addToBasket120916\"]"));
        addToCartButton.click();
    }

    @Test(priority = 5)
    public void verifyClickingAddToCartButtonAddingTheProductToCart() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sideCartRail\"]/div[3]/div/div[4]/div/button")));
        WebElement itemAddToCartText = SignUpTest.driver.findElement(By.xpath("//*[@id=\"sideCartRail\"]/div[2]/div[2]/div/span"));
        Assert.assertTrue(itemAddToCartText.isDisplayed());
    }

    @Test(priority = 6)
    public void verifyCheckoutButtonIsDisplayed() {
        WebElement checkoutButton = SignUpTest.driver.findElement(By.xpath("//*[@id=\"sideCartRail\"]/div[3]/div/div[4]/div/button"));
        Assert.assertTrue(checkoutButton.isDisplayed());
    }

    @Test(priority = 7)
    public void verifyCheckoutButtonISClickable() {
//        SignUpTest.driver.manage().deleteAllCookies();
        WebElement checkoutButton = SignUpTest.driver.findElement(By.xpath("//*[@id=\"sideCartRail\"]/div[3]/div/div[4]/div/button"));
        checkoutButton.click();
    }

    @Test(priority = 8)
    public void verifyClickingCheckoutButtonOpensCartPage() {
//        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-bpMainHeading\"]/h1")));
        WebElement cartItemsNumText = SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-bpMainHeading\"]/h1"));
        Assert.assertTrue(cartItemsNumText.isDisplayed());
    }

    @Test(priority = 9)
    public void verifyCartCheckoutButtonIsDisplayed() {
        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-bpOrderCheckOut\"]/input")));
        WebElement checkoutButton = SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-bpOrderCheckOut\"]/input"));
        Assert.assertTrue(checkoutButton.isDisplayed());
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

        WebElement checkoutButton = SignUpTest.driver.findElement(By.xpath("//*[@id=\"ml-bpOrderCheckOut\"]/input"));
        checkoutButton.click();
    }

    @Test(priority = 11)
    public void verifyClickingCheckoutButtonOpensCheckoutForm() {
        WebElement firstNameField = SignUpTest.driver.findElement(By.id("firstName"));
        Assert.assertTrue(firstNameField.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        SignUpTest.driver.quit();
    }

//    @Test(priority = 12)
//    public void verifyClickingCheckoutButtonProceedCheckout() {
////        SignUpTest.driver.manage().deleteAllCookies();
//
//        WebElement firstNameField = SignUpTest.driver.findElement(By.id("firstName"));
//        firstNameField.sendKeys("Noor");
//        WebElement lastNameField = SignUpTest.driver.findElement(By.id("lastName"));
//        lastNameField.sendKeys("Noor");
//        WebElement phoneField = SignUpTest.driver.findElement(By.id("dayPhone"));
//        phoneField.sendKeys("0111222333");
//        WebElement address1Field = SignUpTest.driver.findElement(By.id("address1"));
//        address1Field.sendKeys("123 St");
//        WebElement cityField = SignUpTest.driver.findElement(By.id("city"));
//        cityField.sendKeys("Test City");
//        WebElement zipField = SignUpTest.driver.findElement(By.id("zip"));
//        zipField.sendKeys("02108");
//        zipField.sendKeys(Keys.ENTER);
//        WebElement stateField = SignUpTest.driver.findElement(By.id("state"));
//        SignUpTest.wait.until(ExpectedConditions.elementToBeSelected(stateField));
////        stateField.sendKeys("MA");
//
//        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='dwfrm_shipping_submit']")));
//        WebElement checkoutButton = SignUpTest.driver.findElement(By.xpath("//button[@name='dwfrm_shipping_submit']"));
//        checkoutButton.click();
//    }
//
//    @Test(priority = 13)
//    public void verifyThatThePaymentPageLoadsSuccessfully() {
//        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.id("creditCardName")));
//        WebElement paymentTitle = SignUpTest.driver.findElement(By.xpath("//*[@id=\"paymentmethodsradiogroup\"]"));
//        String expectedPaymentTitle = "Payment Method";
//        String actualPaymentTitle = paymentTitle.getText();
//        Assert.assertEquals(actualPaymentTitle, expectedPaymentTitle);
//    }
//
//    @Test(priority = 14)
//    public void verifyThePaymentFormIsDisplayed() {
//        WebElement creditCardNameField = SignUpTest.driver.findElement(By.id("creditCardName"));
//        creditCardNameField.sendKeys("Noor");
//        WebElement cardNumberField = SignUpTest.driver.findElement(By.id("cardNumber"));
//        cardNumberField.sendKeys("4111111111111111");
//        WebElement expirationDateField = SignUpTest.driver.findElement(By.id("expirationDate"));
//        expirationDateField.sendKeys("1223");
//        WebElement cardNameField = SignUpTest.driver.findElement(By.id("cvv2"));
//        cardNameField.sendKeys("123");
//    }
//
//    @Test(priority = 15)
//    public void verifyReviewOrderButtonIsClickable() {
////        SignUpTest.driver.manage().deleteAllCookies();
//
//        SignUpTest.wait.until(ExpectedConditions.elementToBeClickable(By.id("btnContinuePaymentForm")));
//        WebElement reviewOrderButton = SignUpTest.driver.findElement(By.id("btnContinuePaymentForm"));
//        reviewOrderButton.click();
//    }
}
