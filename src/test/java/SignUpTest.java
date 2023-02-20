import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        WebElement signUpPopUp = driver.findElement(By.xpath("//*[@id=\"cpwm-additionaldisclaimer3\"]"));
        Assert.assertTrue(signUpPopUp.isDisplayed());
    }

    @Test(priority = 2)
    public void verifySignUpPopUpEmailFieldIsDisplayed() {
        driver.switchTo().frame("handleFrameResp"); //now you have switched into the frame

        WebElement SignUpPopUpEmailField = driver.findElement(By.xpath("//*[@id=\"EMAIL_ADDRESS_\"]"));
        Assert.assertTrue(SignUpPopUpEmailField.isDisplayed());
    }

    @Test(priority = 2)
    public void verifySignUpPopUpSignUpButtonIsDisplayed() {
        WebElement popUpSignUpButton = driver.findElement(By.cssSelector("[onclick=\"return validateForm();\"]"));
        Assert.assertTrue(popUpSignUpButton.isDisplayed());
    }

    @Test(priority = 3)
    public void verifySignUpPopUpEmailFieldAcceptEmail() {
        WebElement SignUpPopUpEmailField = driver.findElement(By.xpath("//*[@id=\"EMAIL_ADDRESS_\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(SignUpPopUpEmailField));
        SignUpPopUpEmailField.sendKeys("nooor@mailna.co");
    }

    @Test(priority = 4)
    public void verifyPopUpSignUpButtonIsClickable() {
        WebElement popUpSignUpButton = driver.findElement(By.cssSelector("[onclick=\"return validateForm();\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(popUpSignUpButton));
        popUpSignUpButton.click();
    }

    @Test(priority = 5)
    public void verifyPopUpSignUpButtonIsShowsSuccessImage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"formsg\"]/div[2]/h1/img[2]")));
        WebElement popUpSuccessImage = driver.findElement(By.xpath(" //*[@id=\"formsg\"]/div[2]/h1/img[2]"));
        Assert.assertTrue(popUpSuccessImage.isDisplayed());
    }

    @Test(priority = 5)
    public void verifyPopUpJoinButtonIsDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gotoCreate\"]")));
        WebElement popUpJoinNowButton = driver.findElement(By.xpath("//*[@id=\"gotoCreate\"]"));
        Assert.assertTrue(popUpJoinNowButton.isDisplayed());
    }

    @Test(priority = 6)
    public void verifyPopUpJoinButtonIsClickable() {
        WebElement popUpJoinNowButton = driver.findElement(By.xpath("//*[@id=\"gotoCreate\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(popUpJoinNowButton));
        driver.manage().deleteAllCookies();
        popUpJoinNowButton.click();
    }

    @Test(priority = 7)
    public void verifyClickingPopUpJoinButtonOpensForm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ml-body-container\"]/main/div/div/div/div/div[2]/ul/li[2]/a")));
        WebElement joinTabButton = driver.findElement(By.xpath("//*[@id=\"ml-body-container\"]/main/div/div/div/div/div[2]/ul/li[2]/a"));
        Assert.assertTrue(joinTabButton.isDisplayed());
    }

    @Test(priority = 8)
    public void verifyJoinNowButtonIsClickable() {
        WebElement firstNameField = driver.findElement(By.xpath("//*[@id=\"create_firstName\"]"));
        firstNameField.sendKeys("noor");

        WebElement lastNameField = driver.findElement(By.xpath("//*[@id=\"create_lastName\"]"));
        lastNameField.sendKeys("noor");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"userPasswordCreate\"]"));
        passwordField.sendKeys("password123456");

        WebElement idField = driver.findElement(By.xpath("//*[@id=\"memberIdInputCreateAccount\"]"));
        idField.sendKeys("0105222220");

        WebElement zipCodeField = driver.findElement(By.xpath("//*[@id=\"postalCodeCreate\"]"));
        zipCodeField.sendKeys("02108");

        WebElement acceptCheckBox = driver.findElement(By.xpath("//*[@id=\"label_create_tc\"]/span"));
        acceptCheckBox.click();

        driver.manage().deleteAllCookies();

        WebElement createAccountButton = driver.findElement(By.xpath("//*[@id=\"createAccountButton\"]"));
        createAccountButton.click();
    }

    @Test(priority = 9)
    public void verifyClickingJoinNowButtonCreateAccountAndLoggedIn() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"navsearchbox\"]")));
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"navsearchbox\"]"));
        Assert.assertTrue(searchField.isDisplayed());
    }
}
