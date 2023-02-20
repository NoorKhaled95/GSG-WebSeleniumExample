import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    public void verifyTablesCategoryClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"home_topnav_layout_15_fillslot-3\"]/a")));
        WebElement tablesItem = driver.findElement(By.xpath("//*[@id=\"home_topnav_layout_15_fillslot-3\"]/a"));
        tablesItem.click();
    }

    @Test(priority = 3)
    public void verifyClickingTablesCategoryOpensTheCategoryProductsPage() {
        driver.manage().deleteAllCookies();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/h2/a")));
        WebElement pascalProduct = driver.findElement(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/h2/a"));
        Assert.assertTrue(pascalProduct.isDisplayed());
    }

    @Test(priority = 4)
    public void verifyThatThePopUpCloseIconIsClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button")));
        WebElement popUpCloseIcon = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
        popUpCloseIcon.click();
    }

    @Test(priority = 5)
    public void verifyThatThePascalProductNameIsClickable() {
        WebElement pascalProduct = driver.findElement(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/h2/a"));
        pascalProduct.click();
    }

    @Test(priority = 6)
    public void verifyThatClickingPascalProductNameOpensProductDetails() {
        String expectedPascalProductDetailsTitle = "Rustic Brown Acacia Wood Pascal Coffee Table | World Market";
        String actualPascalProductDetailsTitle = driver.getTitle();
        Assert.assertEquals(actualPascalProductDetailsTitle, expectedPascalProductDetailsTitle);
        driver.manage().deleteAllCookies();
    }
}
