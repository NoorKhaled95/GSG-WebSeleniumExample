import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchAndFilterTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set up the driver and navigate to the website
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.worldmarket.com/");
    }

    @Test
    public void searchAndFilterTest() {
        // Type the keyword in the search bar
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("chair");

        // Click on the search button
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-submit-button']"));
        searchButton.click();

        // Verify that the search results are displayed
        WebElement searchResultsTitle = driver.findElement(By.xpath("//h1[@class='search-title']"));
        String expectedSearchTitle = "Results for: chair";
        String actualSearchTitle = searchResultsTitle.getText();
        Assert.assertEquals(actualSearchTitle, expectedSearchTitle);

        // Apply the "Price: Under $100" filter
        WebElement priceFilter = driver.findElement(By.xpath("//a[@data-n-value='price_f%3aUnder+%24100']"));
        priceFilter.click();

        // Verify that the filtered results are displayed
        WebElement filteredResultsTitle = driver.findElement(By.xpath("//h1[@class='search-title']"));
        String expectedFilteredTitle = "Results for: chair";
        String actualFilteredTitle = filteredResultsTitle.getText();
        Assert.assertEquals(actualFilteredTitle, expectedFilteredTitle);
        WebElement priceRange = driver.findElement(By.xpath("//span[@class='refinement-text']"));
        String expectedPriceRange = "Price: Under $100";
        String actualPriceRange = priceRange.getText();
        Assert.assertEquals(actualPriceRange, expectedPriceRange);
    }

    @AfterTest
    public void tearDown() {
        // Close the driver and end the session
        driver.quit();
    }
}

