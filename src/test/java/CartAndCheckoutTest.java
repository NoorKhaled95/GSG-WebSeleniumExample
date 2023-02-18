import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartAndCheckoutTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the driver and navigate to the website
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.worldmarket.com/");
    }

    @Test
    public void cartAndCheckoutTest() {
        // Click on the "Furniture" link in the navigation bar
        WebElement furnitureLink = driver.findElement(By.linkText("Furniture"));
        furnitureLink.click();

        // Click on the "Living Room" link in the sidebar
        WebElement livingRoomLink = driver.findElement(By.xpath("//a[@href='/category/furniture/living-room.do']"));
        livingRoomLink.click();

        // Click on the first product in the "Living Room" category
        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='product-tile']/a"));
        firstProduct.click();

        // Add the product to the cart
        WebElement addToCartButton = driver.findElement(By.id("addToCartButton"));
        addToCartButton.click();

        // Verify that the product is added to the cart
        WebElement cartLink = driver.findElement(By.xpath("//a[@href='/shopping-cart']"));
        String cartText = cartLink.getText();
        Assert.assertEquals(cartText, "Cart (1)");

        // Go to the cart
        cartLink.click();

        // Verify that the cart page loads successfully
        String expectedCartTitle = "Shopping Cart | World Market";
        String actualCartTitle = driver.getTitle();
        Assert.assertEquals(actualCartTitle, expectedCartTitle);

        // Proceed to checkout
        WebElement checkoutButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block btn-lg']"));
        checkoutButton.click();

        // Verify that the checkout page loads successfully
        String expectedCheckoutTitle = "Checkout | World Market";
        String actualCheckoutTitle = driver.getTitle();
        Assert.assertEquals(actualCheckoutTitle, expectedCheckoutTitle);

        // Fill out the shipping information
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys("John");
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Doe");
        WebElement address1Field = driver.findElement(By.id("address1"));
        address1Field.sendKeys("123 Main St");
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("Anytown");
        WebElement stateField = driver.findElement(By.id("state"));
        stateField.sendKeys("CA");
        WebElement zipField = driver.findElement(By.id("zip"));
        zipField.sendKeys("12345");

        // Click on the "Continue to Payment" button
        WebElement continueToPaymentButton = driver.findElement(By.xpath("//button[@name='dwfrm_shipping_submit']"));
        continueToPaymentButton.click();

        // Verify that the payment page loads successfully
        String expectedPaymentTitle = "Payment Information | World Market";
        String actualPaymentTitle = driver.getTitle();
        Assert.assertEquals(actualPaymentTitle, expectedPaymentTitle);

        // Fill out the payment information
        WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
        cardNumberField.sendKeys("4111111111111111");
        WebElement cardNameField = driver.findElement(By.id("cardName"));
        cardNameField.sendKeys("John Doe");


    }
}
