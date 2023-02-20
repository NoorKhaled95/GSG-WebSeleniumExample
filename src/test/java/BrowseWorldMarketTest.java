import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowseWorldMarketTest {
    public static ChromeDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        // Set up the driver and navigate to the website
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.worldmarket.com/");
        driver.manage().window().setSize(new Dimension(428, 926));
        wait = new WebDriverWait(driver, 60);
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void verifyThatTheHomepageLoadsSuccessfully() {
        String expectedTitle = "Furniture, Home Decor, Rugs, Unique Gifts | World Market";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 1)
    public void verifyThePopUpCloseIconIsClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button")));
        WebElement popUpCloseIcon = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
        popUpCloseIcon.click();
    }

    @Test(priority = 2)
    public void verifyMenuIconIsClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-body-container\"]/header/div[1]/div[6]/div/div/div/div[2]/div[1]/div/div[1]/button")));
        WebElement menuButton = driver.findElement(By.xpath("//*[@id=\"ml-body-container\"]/header/div[1]/div[6]/div/div/div/div[2]/div[1]/div/div[1]/button"));
        menuButton.click();
    }

    @Test(priority = 3)
    public void verifyClickingMenuOpensTheMenu() {
        driver.manage().deleteAllCookies();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navbar-ul-secondary\"]")));
        WebElement popUpMenu = driver.findElement(By.xpath("//*[@id=\"navbar-ul-secondary\"]"));
        Assert.assertTrue(popUpMenu.isDisplayed());
    }

    @Test(priority = 4)
    public void verifyThatTheFurnitureLinkInNavigationBarIsClickable() {
        WebElement furnitureLink = driver.findElement(By.xpath("//*[@id=\"navbar-ul-secondary\"]/li[1]/a"));
        furnitureLink.click();
    }

    @Test(priority = 3)
    public void verifyThatTheFurniturePageLoadsSuccessfully() {
        String expectedFurnitureTitle = "Furniture - Affordable & Unique Home Sets | World Market";
        String actualFurnitureTitle = driver.getTitle();
        Assert.assertEquals(actualFurnitureTitle, expectedFurnitureTitle);
    }

    @Test(priority = 4)
    public void verifyThatTheFurnitureBestSellersLinkIsDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-body-container\"]/main/div[3]/div/div[1]/div[2]/div[2]/div[6]/ul/li[3]/a")));
        WebElement furnitureBestSellers = driver.findElement(By.xpath("//*[@id=\"ml-body-container\"]/main/div[3]/div/div[1]/div[2]/div[2]/div[6]/ul/li[3]/a"));
        Assert.assertTrue(furnitureBestSellers.isDisplayed());
    }

    @Test(priority = 5)
    public void verifyThatTheFurnitureBestSellersIsClickable() {
        WebElement furnitureBestSellers = driver.findElement(By.xpath("//*[@id=\"ml-body-container\"]/main/div[3]/div/div[1]/div[2]/div[2]/div[6]/ul/li[3]/a"));
        furnitureBestSellers.click();
    }

    @Test(priority = 6)
    public void verifyThatTheFurnitureBestSellersPageLoadsSuccessfully() {
        String expectedFurnitureBestSellersTitle = "Furniture Best Sellers | World Market";
        String actualFurnitureBestSellersTitle = driver.getTitle();
        Assert.assertEquals(actualFurnitureBestSellersTitle, expectedFurnitureBestSellersTitle);
    }

    @Test(priority = 7)
    public void verifyBrynnFeatherFilledSeatingProductISDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[2]/div/div[1]/div[2]/div")));
        WebElement productName = driver.findElement(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[2]/div/div[1]/div[2]/div"));
        Assert.assertTrue(productName.isDisplayed());
    }
}
