import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AcademyPageTest {

    ChromeDriver chromeDriver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://academy.famcare.app/");
        wait = new WebDriverWait(chromeDriver, 10);
    }

    @Test
    public void verifyThatClickingAcademyButtonOpenArchive(){
        WebElement psychologicalAspect = chromeDriver.findElement(By.xpath("//div[@data-id='a28c3ce']"));
        wait.until(ExpectedConditions.elementToBeClickable(psychologicalAspect));
        psychologicalAspect.click();
    }

    @AfterClass
    public void tearDown(){
        chromeDriver.quit();
    }
}
