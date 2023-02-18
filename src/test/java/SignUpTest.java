//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.testng.AssertJUnit.assertTrue;
//
//public class SignUpTest {
//    ChromeDriver chromeDriver;
//    WebDriverWait wait;
//
//    @BeforeClass
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        chromeDriver = new ChromeDriver();
//        chromeDriver.get("https://famcare.app/");
//        wait = new WebDriverWait(chromeDriver, 10);
//    }
//
//    @Test(priority = 1)
//    public void verifyThatHomeScreenIsOpenedSuccessfully(){
//        WebElement famCareHeroSection = chromeDriver.findElement(By.id("heroSection"));
//        assertTrue(famCareHeroSection.isDisplayed());
//    }
//
//    @Test(priority = 2)
//    public void verifyThatAcademyButtonIsDisplayed(){
//        WebElement famCareAcademyButton = chromeDriver.findElement(By.xpath("//a[@title='الأكاديمية']"));
//        assertTrue(famCareAcademyButton.isDisplayed());
//    }
//
//    @Test(priority = 3)
//    public void verifyThatClickingAcademyButtonOpenAcademyPage(){
//        WebElement famCareAcademyButton = chromeDriver.findElement(By.xpath("//a[@title='الأكاديمية']"));
//        famCareAcademyButton.click();
//        WebElement psychologicalAspect = chromeDriver.findElement(By.xpath("//div[@data-id='a28c3ce']"));
//        assertTrue(psychologicalAspect.isDisplayed());
//    }
//
//    @AfterClass
//    public void tearDown(){
//        chromeDriver.quit();
//    }
//}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the driver and navigate to the website
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.worldmarket.com/");
    }

    @Test
    public void signUpTest() {
        // Click on the "Sign In / Sign Up" link in the navigation bar
        WebElement signInLink = driver.findElement(By.linkText("Sign In / Sign Up"));
        signInLink.click();

        // Click on the "Create Account" button
        WebElement createAccountButton = driver.findElement(By.xpath("//a[@href='/create-account']"));
        createAccountButton.click();

        // Fill out the sign up form
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys("John");
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Doe");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("john.doe@example.com");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");

        // Click on the "Create Account" button
        WebElement createAccountButton2 = driver.findElement(By.xpath("//button[@name='dwfrm_profile_confirm']"));
        createAccountButton2.click();

        // Verify that the account is created and the user is logged in
        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='welcome-message']"));
        String expectedWelcomeText = "Welcome, John!";
        String actualWelcomeText = welcomeMessage.getText();
        Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
    }

    @AfterTest
    public void tearDown() {
        // Close the driver and end the session
        driver.quit();
    }
}
