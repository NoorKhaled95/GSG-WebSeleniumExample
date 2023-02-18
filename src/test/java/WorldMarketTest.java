import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorldMarketTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the driver and navigate to the website
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.worldmarket.com/");
    }

    @Test
    public void homepageNavigationTest() {
        // Verify that the homepage loads successfully
        String expectedTitle = "Unique, Handmade Global Furniture & Decor | World Market";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        // Click on the "Furniture" link in the navigation bar
        WebElement furnitureLink = driver.findElement(By.linkText("Furniture"));
        furnitureLink.click();

        // Verify that the "Furniture" page loads successfully
        String expectedFurnitureTitle = "Unique & Affordable Furniture Collections | World Market";
        String actualFurnitureTitle = driver.getTitle();
        Assert.assertEquals(actualFurnitureTitle, expectedFurnitureTitle);

        // Click on the "Living Room" link in the sidebar
        WebElement livingRoomLink = driver.findElement(By.xpath("//a[@href='/category/furniture/living-room.do']"));
        livingRoomLink.click();

        // Verify that the "Living Room" page loads successfully
        String expectedLivingRoomTitle = "Living Room Furniture - Affordable Sets | World Market";
        String actualLivingRoomTitle = driver.getTitle();
        Assert.assertEquals(actualLivingRoomTitle, expectedLivingRoomTitle);
    }

    @Test
    public void productSearchTest() {
        // Search for a product
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("coffee");
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();

        // Verify that the search results page loads successfully
        String expectedSearchTitle = "Search Results - Coffee | World Market";
        String actualSearchTitle = driver.getTitle();
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle);

        // Click on the first product in the search results
        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='product-title']/a"));
        firstProduct.click();

        // Verify that the product page loads successfully
        String expectedProductTitle = "Ground Coffee | World Market";
        String actualProductTitle = driver.getTitle();
        Assert.assertEquals(actualProductTitle, expectedProductTitle);
    }

    @AfterTest
    public void tearDown() {
        // Close the driver
        driver.quit();
    }
}
