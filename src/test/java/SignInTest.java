import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {

    public static ChromeDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        // Set up the driver and navigate to the website
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.worldmarket.com/account/login.do");
        driver.manage().window().setSize(new Dimension(428, 926));
        wait = new WebDriverWait(driver, 60);
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void verifyClickingSignInButtonSignIsClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginEmail\"]")));
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"loginEmail\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPassword\"]"));
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"checkoutLoginButton\"]"));

        emailField.sendKeys("noor@mailna.co");
        passwordField.sendKeys("password123456");
        signInButton.click();
    }

    @Test(priority = 2)
    public void verifyClickingSignInButtonSignInSuccessfully() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navsearchbox\"]")));
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"navsearchbox\"]"));
        Assert.assertTrue(searchField.isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

