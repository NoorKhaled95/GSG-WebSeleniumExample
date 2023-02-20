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

//    @Test(priority = 1)
//    public void verifyThePopUpCloseIconIsClickable(){
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button")));
//        WebElement popUpCloseIcon = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]/button"));
//        popUpCloseIcon.click();
//    }

//    @Test(priority = 2)
//    public void verifyAuthButtonIsDisplaying() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-topnav-identity-link\"]")));
//        WebElement authButton = driver.findElement(By.xpath("//*[@id=\"ml-topnav-identity-link\"]"));
//        Assert.assertTrue(authButton.isDisplayed());
//    }

//    @Test(priority = 3)
//    public void verifyAuthButtonIsClickable() {
//        WebElement authButton = driver.findElement(By.xpath("//*[@id=\"ml-topnav-identity-link\"]"));
//        authButton.click();
//    }

//    @Test(priority = 4)
//    public void verifyClickingAuthButtonOpensPopUp(){
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loggedin_panel\"]/div/div/div[2]/button[1]")));
//        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"loggedin_panel\"]/div/div/div[2]/button[1]"));
//        Assert.assertTrue(signInButton.isDisplayed());
//    }

//    @Test(priority = 5)
//    public void verifySignInButtonIsClickable(){
//        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"loggedin_panel\"]/div/div/div[2]/button[1]"));
//        signInButton.click();
//    }

//    @Test(priority = 6)
//    public void verifyClickingSignInButtonOpensSignInPage(){
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginEmail\"]")));
//        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"loginEmail\"]"));
//        Assert.assertTrue(emailField.isDisplayed());
//    }

    @Test(priority = 7)
    public void verifyClickingSignInButtonSignIsClickable(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginEmail\"]")));
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"loginEmail\"]"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginPassword\"]"));
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"checkoutLoginButton\"]"));

        emailField.sendKeys("noor@mailna.co");
        passwordField.sendKeys("password123456");
        signInButton.click();
    }

    @Test(priority = 8)
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

