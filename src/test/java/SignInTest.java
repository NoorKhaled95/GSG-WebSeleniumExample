import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

        SignInPOM.getEmailField().sendKeys("noor@mailna.co");
        SignInPOM.getPasswordField().sendKeys("password123456");
        SignInPOM.getSignInButton().click();
    }

    @Test(priority = 2)
    public void verifyClickingSignInButtonSignInSuccessfully() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navsearchbox\"]")));
        Assert.assertTrue(SignInPOM.getSearchField().isDisplayed());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

