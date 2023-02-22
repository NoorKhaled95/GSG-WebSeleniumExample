import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest {
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
    public void verifySignUpPopUpIsDisplayed() {
        Assert.assertTrue(SignUpPOM.getSignUpPopUp().isDisplayed());
    }

    @Test(priority = 2)
    public void verifySignUpPopUpEmailFieldIsDisplayed() {
        driver.switchTo().frame("handleFrameResp"); //now you have switched into the frame
        Assert.assertTrue(SignUpPOM.getSignUpPopUpEmailField().isDisplayed());
    }

    @Test(priority = 2)
    public void verifySignUpPopUpSignUpButtonIsDisplayed() {
        Assert.assertTrue(SignUpPOM.getPopUpSignUpButton().isDisplayed());
    }

    @Test(priority = 3)
    public void verifySignUpPopUpEmailFieldAcceptEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(SignUpPOM.getSignUpPopUpEmailField()));
        SignUpPOM.getSignUpPopUpEmailField().sendKeys("noorkh@mailna.co");
    }

    @Test(priority = 4)
    public void verifyPopUpSignUpButtonIsClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(SignUpPOM.getPopUpSignUpButton()));
        SignUpPOM.getPopUpSignUpButton().click();
    }

    @Test(priority = 5)
    public void verifyPopUpSignUpButtonIsShowsSuccessImage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formsg\"]/div[2]/h1/img[2]")));
        Assert.assertTrue(SignUpPOM.getPopUpSuccessImage().isDisplayed());
    }

    @Test(priority = 5)//*[@id="gotoCreate"]
    public void verifyPopUpJoinButtonIsDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gotoCreate\"]")));
        Assert.assertTrue(SignUpPOM.getPopUpJoinNowButton().isDisplayed());
    }

    @Test(priority = 6)
    public void verifyPopUpJoinButtonIsClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(SignUpPOM.getPopUpJoinNowButton()));
        driver.manage().deleteAllCookies();
        SignUpPOM.getPopUpJoinNowButton().click();
    }

    @Test(priority = 7)
    public void verifyClickingPopUpJoinButtonOpensForm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-body-container\"]/main/div/div/div/div/div[2]/ul/li[2]/a")));
        Assert.assertTrue(SignUpPOM.getJoinTabButton().isDisplayed());
    }

    @Test(priority = 8)
    public void verifyJoinNowButtonIsClickable() {
        SignUpPOM.getFirstNameField().sendKeys("noor");
        SignUpPOM.getLastNameField().sendKeys("noor");
        SignUpPOM.getPasswordField().sendKeys("password123456");
        SignUpPOM.getIdField().sendKeys("0109222220");
        SignUpPOM.getZipCodeField().sendKeys("02108");
        SignUpPOM.getAcceptCheckBox().click();

        driver.manage().deleteAllCookies();
        SignUpPOM.getCreateAccountButton().click();
    }

    @Test(priority = 9)
    public void verifyClickingJoinNowButtonCreateAccountAndLoggedIn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navsearchbox\"]")));
        Assert.assertTrue(SignUpPOM.getSearchField().isDisplayed());
    }
}
