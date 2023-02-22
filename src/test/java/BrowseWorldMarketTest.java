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
        BrowseWorldMarketPOM.getPopUpCloseIcon().click();
    }

    @Test(priority = 2)
    public void verifyFirstCategoryClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"home_topnav_layout_15_fillslot-3\"]/a")));
        BrowseWorldMarketPOM.getFirstCategory().click();
    }

    @Test(priority = 3)
    public void verifyClickingFirstCategoryOpensTheCategoryProductsPage() {
        driver.manage().deleteAllCookies();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/h2/a")));
        Assert.assertTrue(BrowseWorldMarketPOM.getFirstProduct().isDisplayed());
    }

    @Test(priority = 4)
    public void verifyThatThePopUpCloseIconIsClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button")));
        BrowseWorldMarketPOM.getPopUpCloseIcon().click();
    }

    @Test(priority = 5)
    public void verifyThatTheFirstProductNameIsClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[1]/div/div[2]/div[1]/h2/a")));
        BrowseWorldMarketPOM.getFirstProduct().click();
    }

    @Test(priority = 6)
    public void verifyThatClickingFirstProductNameOpensProductDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/h1/div")));
        String actualFirstProductDetailsTitle = BrowseWorldMarketPOM.getFirstProductDetails().getText().toLowerCase();
        String expectedFirstProductDetailsTitle = driver.getTitle().substring(0, actualFirstProductDetailsTitle.length()).toLowerCase();
        Assert.assertEquals(actualFirstProductDetailsTitle, expectedFirstProductDetailsTitle);
        driver.manage().deleteAllCookies();
    }
}
