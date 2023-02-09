import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class MainTest {
    ChromeDriver chromeDriver;
    WebDriverWait wait;

//    String famCareLogoImageXpath = "/html/body/header/div/div/nav/a/img";
//    String famCareListItemXpath = "//*[@id=\"menu-item-6\"]/a";
//    String specialistsListItemXpath = "//*[@id=\"menu-item-1026\"]/a";
//    String blogListItemXpath = "//*[@id=\"menu-item-2633\"]/a";
//    String academyListItemXpath = "//*[@id=\"menu-item-1227\"]/a";
//    String organizationsListItemXpath = "//*[@id=\"menu-item-2831\"]/a";
//    String aboutListItemXpath = "//*[@id=\"menu-item-188\"]/a";
//    String joinAsSpecialistButtonXpath = "//*[@id=\'navbarContent\']/button";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://famcare.app/");
        wait = new WebDriverWait(chromeDriver, 10);
    }

    @Test(priority = 1)
    public void verifyThatHomeScreenIsOpenedSuccessfully(){
        WebElement famCareHeroSection = chromeDriver.findElement(By.id("heroSection"));
        assertTrue(famCareHeroSection.isDisplayed());
    }

    @Test(priority = 2)
    public void verifyThatAcademyButtonIsDisplayed(){
        WebElement famCareAcademyButton = chromeDriver.findElement(By.xpath("//a[@title='الأكاديمية']"));
        assertTrue(famCareAcademyButton.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyThatClickingAcademyButtonOpenAcademyPage(){
        WebElement famCareAcademyButton = chromeDriver.findElement(By.xpath("//a[@title='الأكاديمية']"));
        famCareAcademyButton.click();
        WebElement psychologicalAspect = chromeDriver.findElement(By.xpath("//div[@data-id='a28c3ce']"));
        assertTrue(psychologicalAspect.isDisplayed());
    }

    @Test(priority = 4)
    public void verifyThatClickingAcademyButtonOpenArchive(){
        WebElement psychologicalAspect = chromeDriver.findElement(By.xpath("//div[@data-id='a28c3ce']"));
        wait.until(ExpectedConditions.elementToBeClickable(psychologicalAspect));
        psychologicalAspect.click();
    }

//
//    @Test
//    public void verifyFamCareLogoImageDisplayed(){
//        WebElement famCareLogoImage = chromeDriver.findElement(By.xpath(famCareLogoImageXpath));
//        assertTrue(famCareLogoImage.isDisplayed());
//    }
//
//    @Test
//    public void verifyFamCareListItemDisplayed(){
//        WebElement famCareListItem = chromeDriver.findElement(By.xpath(famCareListItemXpath));
//        assertTrue(famCareListItem.isDisplayed());
//    }
//
//    @Test
//    public void verifySpecialistsListItemDisplayed(){
//        WebElement specialistsListItem = chromeDriver.findElement(By.xpath(specialistsListItemXpath));
//        assertTrue(specialistsListItem.isDisplayed());
//    }
//
//    @Test
//    public void verifyBlogListItemDisplayed(){
//        WebElement blogListItem = chromeDriver.findElement(By.xpath(blogListItemXpath));
//        assertTrue(blogListItem.isDisplayed());
//    }
//
//    @Test
//    public void verifyAcademyListItemDisplayed(){
//        WebElement academyListItem = chromeDriver.findElement(By.xpath(academyListItemXpath));
//        assertTrue(academyListItem.isDisplayed());
//    }
//
//    @Test
//    public void verifyOrganizationsListItemDisplayed(){
//        WebElement organizationsListItem = chromeDriver.findElement(By.xpath(organizationsListItemXpath));
//        assertTrue(organizationsListItem.isDisplayed());
//    }
//
//    @Test
//    public void verifyAboutListItemDisplayed(){
//        WebElement aboutListItem = chromeDriver.findElement(By.xpath(aboutListItemXpath));
//        assertTrue(aboutListItem.isDisplayed());
//    }
//
//    @Test
//    public void verifyJoinAsSpecialistButtonDisplayed(){
//        WebElement joinAsSpecialistButton = chromeDriver.findElement(By.xpath(joinAsSpecialistButtonXpath));
//        assertTrue(joinAsSpecialistButton.isDisplayed());
//    }
//
//    @Test
//    public void verifyFamCareLogoImageLinkIsCorrect(){
//        String expectedLink = "https://famcare.app/wp-content/uploads/2022/06/logo-ar.svg";
//        String famCareLogoImageLink = chromeDriver.findElement(By.xpath(famCareLogoImageXpath)).getAttribute("src");
//        assertTrue(expectedLink.equalsIgnoreCase(famCareLogoImageLink));
//    }
//
//    @Test
//    public void verifyFamCareListItemTitleIsCorrect(){
//        String expectedTitle = "فامكير";
//        String famCareListItemTitle = chromeDriver.findElement(By.xpath(famCareListItemXpath)).getText();
//        assertTrue(expectedTitle.equalsIgnoreCase(famCareListItemTitle));
//    }
//
//    @Test
//    public void verifySpecialistsListItemTitleIsCorrect(){
//        String expectedTitle = "الأخصائيين";
//        String specialistsListItemTitle = chromeDriver.findElement(By.xpath(specialistsListItemXpath)).getText();
//        assertTrue(expectedTitle.equalsIgnoreCase(specialistsListItemTitle));
//    }
//
//    @Test
//    public void verifyBlogListItemTitleIsCorrect(){
//        String expectedTitle = "المدونة";
//        String blogListItemTitle = chromeDriver.findElement(By.xpath(blogListItemXpath)).getText();
//        assertTrue(expectedTitle.equalsIgnoreCase(blogListItemTitle));
//    }
//
//    @Test
//    public void verifyAcademyListItemTitleIsCorrect(){
//        String expectedTitle = "الأكاديمية";
//        String academyListItemTitle = chromeDriver.findElement(By.xpath(academyListItemXpath)).getText();
//        assertTrue(expectedTitle.equalsIgnoreCase(academyListItemTitle));
//    }
//
//    @Test
//    public void verifyOrganizationsListItemTitleIsCorrect(){
//        String expectedTitle = "المنظمات";
//        String organizationsListItemTitle = chromeDriver.findElement(By.xpath(organizationsListItemXpath)).getText();
//        assertTrue(expectedTitle.equalsIgnoreCase(organizationsListItemTitle));
//    }
//
//    @Test
//    public void verifyAboutListItemTitleIsCorrect(){
//        String expectedTitle = "من نحن";
//        String aboutListItemTitle = chromeDriver.findElement(By.xpath(aboutListItemXpath)).getText();
//        assertTrue(expectedTitle.equalsIgnoreCase(aboutListItemTitle));
//    }
//
//    @Test
//    public void verifyJoinAsSpecialistButtonTextIsCorrect(){
//        String expectedTitle = "انضم كأخصائي";
//        String joinAsSpecialistButtonText = chromeDriver.findElement(By.xpath(joinAsSpecialistButtonXpath)).getText();
//        assertTrue(expectedTitle.equalsIgnoreCase(joinAsSpecialistButtonText));
//    }

    @AfterClass
    public void tearDown(){
        chromeDriver.quit();
    }
}
