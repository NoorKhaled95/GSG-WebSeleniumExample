import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchAndFilterPOM {
    public static WebElement getSearchField() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"navsearchbox\"]"));
    }

    public static WebElement getSearchResultsTitle() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[1]"));
    }

    public static WebElement getMoreFilters() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"wmCustomDirOpts-filters\"]"));
    }

    public static WebElement getPriceItem() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"facetedNavContainer\"]/ul/li[5]/div[1]/button"));
    }

    public static WebElement getFirstPriceFiltersListItem() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"price_0\"]"));
    }

    public static WebElement getFirstPriceFilterCheckBox() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"price_%24250+-+%24500\"]"));
    }

    public static WebElement getPriceRange() {
        return SignUpTest.driver.findElement(By.xpath("//*[@id=\"catalogResult\"]/div[2]/div[2]/div/div[2]/div/div[5]/span[1]/a"));
    }
}
